package com.coderhouse.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coderhouse.modelos.Cliente;
import com.coderhouse.modelos.Compra;
import com.coderhouse.modelos.Comprobante;
import com.coderhouse.modelos.Producto;
import com.coderhouse.repositorios.ClienteRepositorio;
import com.coderhouse.repositorios.CompraRepositorio;
import com.coderhouse.repositorios.ProductoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompraServicio {

	// El servicio se conecta directamente con el repositorio
	@Autowired
	private CompraRepositorio compraRepository;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
	@Autowired
	private FechaServicio fechaServicio;
	
	// Declaramos métodos para realizar las operaciones CRUD en la base de datos
	public List<Compra> listarCompras() {
		return compraRepository.findAll();
	}
	
	public Compra listarCompraPorID(Integer compraId) {
		return compraRepository.findById(compraId).orElseThrow(() -> new EntityNotFoundException("No se encontró un compra con id " + compraId));
	}
	
	@Transactional // Anotación utilizada para garantizar la integridad de las operaciones en la bd
	public Compra agregarCompra(Compra compraNueva) {
		// Verificamos primero si existe un cliente para registrar la compra
		Cliente cliente = clienteRepositorio.findById(compraNueva.getCliente().getClienteID())
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
		// Se agrega el cliente verificado a la compra
		compraNueva.setCliente(cliente);

		// Se procesan los comprobantes de la compra, verificando la existencia de productos en el inventario
		BigDecimal total = BigDecimal.ZERO;
		int totalProductos = 0;

		// Por cada producto en la compra, se verifica la existencia en el inventario
		for (Comprobante comprobante : compraNueva.getComprobantes()) {
			Producto producto = productoRepositorio.findById(comprobante.getProducto().getProductoID())
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado."));
			if (producto.getExistencia() < comprobante.getCantidad()) {
				throw new IllegalArgumentException("Este producto no está disponible en el Stock.");
			}

			// Si existen productos en el inventario, la compra se realiza y se actualiza la existencia
			producto.setExistencia(producto.getExistencia() - comprobante.getCantidad());
			productoRepositorio.save(producto);

			// Cada compra realizada genera una entrada en la tabla de Comprobantes
			comprobante.setPrecio(producto.getPrecio());
			comprobante.setCompra(compraNueva);

			// Precio total
			total = total.add(producto.getPrecio().multiply(BigDecimal.valueOf(comprobante.getCantidad())));
			totalProductos += comprobante.getCantidad();
		}

		// Colocamos los detalles de la compra
		compraNueva.setTotal(total);
		compraNueva.setTotalProductos(totalProductos);

		// Colocamos la fecha de la compra a través del servicio externo
		try {
			compraNueva.setFechaCompra(fechaServicio.obtenerFechaDelServicioExterno());
		} catch (Exception e) {
			compraNueva.setFechaCompra(LocalDate.now());
		}

	   // Guardamos la compra
	   return compraRepository.save(compraNueva);
	}
	
	public boolean eliminarCompraPorId(Integer compraId) {
		try {
			if (compraRepository.existsById(compraId)) {
				compraRepository.deleteById(compraId);
				return true;
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el compra con id " + compraId);
		}
		return false;
	}
	
}

package com.coderhouse.servicios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderhouse.modelos.Cliente;
import com.coderhouse.modelos.Compra;
import com.coderhouse.modelos.DetalleDeCompra;
import com.coderhouse.modelos.Producto;
import com.coderhouse.repositorios.ClienteRepositorio;
import com.coderhouse.repositorios.CompraRepositorio;
import com.coderhouse.repositorios.DetalleDeCompraRepositorio;
import com.coderhouse.repositorios.ProductoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompraServicio {

	// El servicio se conecta directametne con el repositorio
	@Autowired
	private CompraRepositorio compraRepository; 
    @Autowired
    private DetalleDeCompraRepositorio detalleDeCompraRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
	
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
		// Se procesan los detalles de la compra, verificando la existencia de productos en el inventario
		compraNueva.getDetallesCompra().forEach(detalle -> {
			Producto producto = productoRepositorio.findById(detalle.getProducto().getProductoID())
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado."));
			// Validamos si la cantidad de productos en la compra es mayor que la existencia del producto
			if (producto.getExistencia() < detalle.getCantidad()) {
				throw new IllegalArgumentException("Este producto no está disponible. Se agotaron existencias en el Stock.");
			}
			
			// Si existen productos en el inventario, la compra se realiza y se actualiza la existencia
			producto.setExistencia(producto.getExistencia() - detalle.getCantidad());
            productoRepositorio.save(producto);
            // Cada compra realizada genera una entrada en la tabla de Detalles
            detalle.setCompra(compraNueva);
        	});

            compraNueva.setTotal(compraNueva.getDetallesCompra().stream()
                    .map(detalle -> detalle.getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

	   // Save the complete compra
	   return compraRepository.save(compraNueva);
	}
	
	@Transactional
	public Compra editarCompraPorID(Integer compraId, Compra compraModificada) {
		Compra compra = compraRepository.findById(compraId)
		        .orElseThrow(() -> new EntityNotFoundException("Compra no encontrada con ID: " + compraId));

			// Actualizamos el total de compra
		    compra.setTotal(compraModificada.getTotal()); 

		    // Tomamos los detalles de la compra actual
		    Map<Integer, DetalleDeCompra> existingDetails = compra.getDetallesCompra().stream()
		        .collect(Collectors.toMap(detail -> detail.getProducto().getProductoID(), detail -> detail));
		    
		    // Actualizamos cada entrada de los detalles de compra
		    for (DetalleDeCompra updatedDetail : compraModificada.getDetallesCompra()) {
		        if (existingDetails.containsKey(updatedDetail.getProducto().getProductoID())) {
		            // Se actualizan los detalles de la existencia y cantidad de productos en la compra
		            DetalleDeCompra existingDetail = existingDetails.get(updatedDetail.getProducto().getProductoID());
		            existingDetail.setCantidad(updatedDetail.getCantidad());
		            // En caso de que se modifique el precio
		            existingDetail.setPrecio(updatedDetail.getPrecio());  
		        } else {
	        		// Se agregan los nuevos productos
		        	updatedDetail.setCompra(compra);
		            compra.getDetallesCompra().add(updatedDetail);
		        }
		    }

		    // Se borran los productos si ya no existen en la compra
		    compra.getDetallesCompra().removeIf(detail ->
		        !compraModificada.getDetallesCompra().contains(detail.getProducto().getProductoID()));

		    // Se recalcula el total
		    compra.setTotal(compra.getDetallesCompra().stream()
		                     .map(detail -> detail.getPrecio().multiply(BigDecimal.valueOf(detail.getCantidad())))
		                     .reduce(BigDecimal.ZERO, BigDecimal::add));

		    // Se actualizan las compras y los detalles de comrpas
		    compraRepository.save(compra);
		    detalleDeCompraRepositorio.saveAll(compra.getDetallesCompra());

		    return compra;
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

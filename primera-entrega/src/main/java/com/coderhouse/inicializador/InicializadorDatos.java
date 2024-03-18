package com.coderhouse.inicializador;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coderhouse.entidades.Cliente;
import com.coderhouse.entidades.Compra;
import com.coderhouse.entidades.DetalleDeCompra;
import com.coderhouse.entidades.Producto;
import com.coderhouser.repositorios.ClienteRepositorio;
import com.coderhouser.repositorios.CompraRepositorio;
import com.coderhouser.repositorios.DetalleDeCompraRepositorio;
import com.coderhouser.repositorios.ProductoRepositorio;

// Es a través de esta clase que colocaremos datos en nuestra tabla. 
@Component
public class InicializadorDatos implements CommandLineRunner {
	
	@Autowired
	private ClienteRepositorio clienteRepo;
	@Autowired
	private ProductoRepositorio productoRepo;
	@Autowired
	private CompraRepositorio compraRepo;
	@Autowired
	private DetalleDeCompraRepositorio detalleCompraRepo;
	
	@Override
	public void run(String... args) {
		// Agregamos un cliente a la BD
		Cliente clienteUno = new Cliente(); 
		clienteUno.setNombre("Victor");
		clienteUno.setApellido("Bocanegra");
		clienteUno.setCorreoElectronico("victor.bocanegra.e@gmail.com");
		clienteUno.setTelefono(5564748037l);
		clienteUno.setDireccion("Ciudad de México, México");
		clienteRepo.save(clienteUno);
		
		// Agregamos un producto
		Producto productoUno = new Producto();
		productoUno.setNombreProducto("Master S3");
		productoUno.setMarca("Logitech");
		productoUno.setDescripcion("Mouse Bluetooth");
		productoUno.setPrecio(BigDecimal.valueOf(1800));
		productoRepo.save(productoUno);
		
		// Agregamos una compra
		Compra compraUno = new Compra();
		compraUno.setCliente(clienteUno);
		compraUno.setFechaCompra(LocalDate.now());
		compraRepo.save(compraUno);
		
		// Agregamos detalles de la compra
		DetalleDeCompra detalleCompraUno = new DetalleDeCompra();
		detalleCompraUno.setCantidad(1);
		detalleCompraUno.setProducto(productoUno);
		detalleCompraUno.setPrecio(productoUno.getPrecio());
		detalleCompraUno.setCompra(compraUno);
		detalleCompraRepo.save(detalleCompraUno);
				

		compraUno.setTotal(BigDecimal.valueOf(detalleCompraUno.getCantidad() * detalleCompraUno.getPrecio().intValue()));
		compraRepo.save(compraUno);
	
	
	}
	


}

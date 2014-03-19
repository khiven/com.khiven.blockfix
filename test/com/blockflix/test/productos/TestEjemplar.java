package com.blockflix.test.productos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.productos.Producto;
import com.blockflix.src.productos.*;

public class TestEjemplar {

	@Test
	public void testEjemplar() {
		String nombre = "King Kong";
		String categoria = "Accion";
		TipoProducto tipo = TipoProducto.PELICULA;
		Soporte soporte = Soporte.BLURAY;
		int id = 1;
		Producto producto = new Producto(nombre,categoria,tipo,soporte);
		Ejemplar ejemplar = new Ejemplar(id,producto);
		assertNotNull(ejemplar);
		assertEquals(ejemplar.getId(),id);
		assertEquals(ejemplar.getProducto(),producto);
	}
}

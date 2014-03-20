package com.blockflix.test.ejemplar;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.EstadoEjemplar;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.ejemplar.Ejemplar;
import com.blockflix.src.productos.Producto;

public class TestEjemplar {

	@Test
	public void testEjemplar() {
		int id = 1;
		int idProducto = 1;
		Ejemplar ejemplar = new Ejemplar(id,idProducto);
		assertNotNull(ejemplar);
		assertEquals(ejemplar.getId(),id);
		assertEquals(ejemplar.getProducto(),idProducto);
	}
	
	@Test
	public void testToString() {
		int id = 1;
		int idProducto = 1;
		Ejemplar ejemplar = new Ejemplar(id,idProducto);
		assertEquals(ejemplar.toString(),"\n Ejemplar de id: 1\n Del producto con id: 1");
	}

}

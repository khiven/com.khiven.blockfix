package com.blockflix.test.contratos;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.contratos.Contrato;

public class TestContrato {

	@Test
	public void testContrato() {
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		Contrato contrato = new Contrato(nSocio,tipoTarifa,extTiempo);
		assertNotNull(contrato);
		assertEquals(extTiempo,contrato.getExtTiempo());
		assertEquals(nSocio,contrato.getnSocio());
		assertEquals(tipoTarifa,contrato.getTarifa());
	}
	
	@Test
	public void testToString() {
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		Contrato contrato = new Contrato(nSocio,tipoTarifa,extTiempo);
		assertEquals("\nContrato del socio nº1\nFecha de contratacion:  "+ contrato.getFechaInicio().get(Calendar.DATE) + "/"
					 +contrato.getFechaInicio().get(Calendar.MONTH)+"/"		
					 +contrato.getFechaInicio().get(Calendar.YEAR)+"\n ¿Extension de tiempo contratada?: Si\nTarifa de Música",contrato.toString());
	}

}

package com.blockflix.test.cosntantes;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.gerente.Gerente;

public class TestConstantes {

	@Test
	public void testDoLogin() {
		Constantes constantes = new Constantes();
		Gerente gerente = constantes.doLogin("", "");
		assertNull(gerente);
		gerente = constantes.doLogin(Constantes.variables.USR_GERENTE, Constantes.variables.PW_GERENTE);
		assertNotNull(gerente);
	}

}

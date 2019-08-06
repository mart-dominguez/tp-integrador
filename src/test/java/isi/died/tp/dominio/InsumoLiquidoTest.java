package isi.died.tp.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InsumoLiquidoTest {
	private InsumoLiquido i1;
	private InsumoLiquido i2;

	
	@Before
	public void preTest() {
		i1 = new InsumoLiquido(); //oxigeno licuado
		i1.setDensidad(1141);
		i2 = new InsumoLiquido(); //alcohol
		i2.setDensidad(789);
	}

	@Test
	public void calcularPesoTest() {
		assertFalse(i1.calcularPeso()==1000);
		assertTrue(i1.calcularPeso()==1141);
		assertTrue(i2.calcularPeso()==789);
		assertFalse(i2.calcularPeso()==1800);
	}

}
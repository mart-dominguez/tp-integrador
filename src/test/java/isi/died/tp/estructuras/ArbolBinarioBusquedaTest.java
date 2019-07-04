package isi.died.tp.estructuras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArbolBinarioBusquedaTest {
	public ArbolBinarioBusqueda<Integer> lleno;
	public ArbolBinarioBusqueda<Integer> completo;
	public ArbolBinarioBusqueda<Integer> completoLleno;
	public ArbolBinarioBusqueda<Integer> noCompleto;
	public ArbolBinarioBusqueda<Integer> noLleno;
	public ArbolBinarioBusqueda<Integer> nollenoCompleto;
	public ArbolBinarioBusqueda<Integer> nodoSolo;

	@Before
	public void setUp() {
		completo = new ArbolBinarioBusqueda<Integer>(50); // Listo
		completoLleno = new ArbolBinarioBusqueda<Integer>(50); //Listo
		noLleno = new ArbolBinarioBusqueda<Integer>(50);//listo
		nollenoCompleto = new ArbolBinarioBusqueda<Integer>(50);//listo
		nodoSolo = new ArbolBinarioBusqueda<Integer>(50); //Listo 
		//completo
		completo.agregar(45);
		//completoLleno
		completoLleno.agregar(25);
		completoLleno.agregar(75);
		completoLleno.agregar(15);
		completoLleno.agregar(45);
		completoLleno.agregar(65);
		completoLleno.agregar(85);
		//nollenoCompleto
		nollenoCompleto.agregar(25);
		nollenoCompleto.agregar(45);
		nollenoCompleto.agregar(15);
		//nolleno
		noLleno.agregar(25);
		noLleno.agregar(45);
		noLleno.agregar(15);
		noLleno.agregar(75);
		System.out.println("------------------------------------");
	}

	@Test
	public void testContiene() {
		assertTrue(completoLleno.contiene(15));
		assertTrue(completoLleno.contiene(25));
		assertTrue(completoLleno.contiene(45));
		assertTrue(completoLleno.contiene(50));
		assertTrue(completoLleno.contiene(65));
		assertTrue(completoLleno.contiene(75));
		assertTrue(completoLleno.contiene(85));
		
	}

	@Test
	public void testEqualsArbolOfE() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregar() {
		noLleno.agregar(1);
		assertTrue(noLleno.contiene(1));
	}

	@Test
	public void testProfundidad() {
		System.out.println(nodoSolo.profundidad()==0);
		assertTrue(nodoSolo.profundidad()==0);
		System.out.println(completoLleno.profundidad() == 2);
		assertTrue(completoLleno.profundidad() == 2);
		System.out.println(nollenoCompleto.profundidad() == 2);
		assertTrue(nollenoCompleto.profundidad() == 2);
	}

	@Test
	public void testCuentaNodosDeNivel() {
		System.out.println(nodoSolo.cuentaNodosDeNivel(1)==1);
		assertTrue(nodoSolo.cuentaNodosDeNivel(1)==1);
		System.out.println(completoLleno.cuentaNodosDeNivel(2)==2);
		assertTrue(completoLleno.cuentaNodosDeNivel(2)==2);
		System.out.println(completoLleno.cuentaNodosDeNivel(3)==4);
		assertTrue(completoLleno.cuentaNodosDeNivel(3)==4);
	}

	@Test
	public void testEsCompleto() {
		assertTrue(completoLleno.esCompleto());
		assertFalse(nollenoCompleto.esCompleto());
		assertTrue(nodoSolo.esCompleto());
	}

	@Test
	public void testEsLleno() {
		assertTrue(completoLleno.esLleno());
		assertTrue(nodoSolo.esLleno());
		assertFalse(nollenoCompleto.esLleno());
	}

}

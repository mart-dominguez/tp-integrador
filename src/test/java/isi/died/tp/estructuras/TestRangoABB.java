package isi.died.tp.estructuras;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.estructuras.*;

public class TestRangoABB {
	private ArbolBinarioBusqueda<Insumo> arbolInsumo;
	private ArbolBinarioBusqueda<Insumo> arbolInsumo2;
	private List<Insumo> lista1;
	Insumo i1;
	Insumo i2;
	Insumo i3;
	Insumo i4;
	Insumo i5;
	Insumo ir1;
	Insumo ir2;
	@Before
	public void preTest() {
		 i1 = new Insumo();
		 i2 = new Insumo();
		 i3 = new Insumo();
		 i4 = new Insumo();
		 i5 = new Insumo();
		 ir1 = new Insumo();
		 ir2 = new Insumo();
		i1.setStock(10);
		i2.setStock(9);
		i3.setStock(15);
		i4.setStock(5);
		i5.setStock(8);
		ir1.setStock(7);
		ir2.setStock(16);
		
		arbolInsumo = new ArbolBinarioBusqueda<Insumo>(i1);
		arbolInsumo.agregar(i2);
		arbolInsumo.agregar(i3);
		arbolInsumo.agregar(i4);
		arbolInsumo.agregar(i5);
		
		lista1 = new ArrayList<Insumo>();
		lista1.add(i2);
		lista1.add(i5);
		lista1.add(i1);
		lista1.add(i3);
	}
	@Test
	public void test() {
		assertTrue(lista1.equals(arbolInsumo.rango(ir1, ir2)));
	}

}
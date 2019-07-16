package isi.died.tp.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;

public class MapaTest {
	public Insumo elQueBusco;
	public Insumo elQueNoBusco;
	public Mapa g1;
	public Planta pl1;
	public Planta pl2;
	public Planta pl3;
	public Planta pl4;
	public Planta pl5;
	public Planta pl6;
	public Planta pl7;
	@Before
	public void setUp() {
		elQueBusco = new Insumo();
		elQueNoBusco = new Insumo();
		elQueBusco.setId(214);
		elQueNoBusco.setId(6);
		g1 = new Mapa();
		Stock sto1 = new Stock();
		sto1.setInsumo(elQueNoBusco);
		//El de camino menor salto
		Stock sto2 = new Stock();
		sto2.setInsumo(elQueBusco);
		sto2.setCantidad(40);
		sto2.setPuntoPedido(50);
		//----------------------------------
		Stock sto3 = new Stock();
		sto3.setInsumo(elQueNoBusco);
		Stock sto4 = new Stock();
		sto4.setInsumo(elQueNoBusco);
		
		//el que mas necesita
		Stock sto5 = new Stock();
		sto5.setInsumo(elQueBusco);
		sto5.setCantidad(10);
		sto5.setPuntoPedido(100);
		//----------------------------------	
		//El de camino mas corto
		Stock sto6 = new Stock();
		sto6.setInsumo(elQueBusco);
		sto6.setCantidad(40);
		sto6.setPuntoPedido(50);
		
		//----------------------------------
		Stock sto7 = new Stock();
		sto7.setInsumo(elQueNoBusco);
		pl1 = new Planta(1,"Planta 1");
		pl1.addStock(sto1);
		
		pl2 = new Planta(2,"Planta 2");
		pl2.addStock(sto2);
		
		pl3 = new Planta(3,"Planta 3");
		pl3.addStock(sto3);
		
		pl4 = new Planta(4,"Planta 4");
		pl4.addStock(sto4);
		
		pl5 = new Planta(5,"Planta 5");
		pl5.addStock(sto5);
		
		pl6 = new Planta(6,"Planta 6");
		pl6.addStock(sto6);
		
		pl7 = new Planta(7,"Planta 7");
		pl7.addStock(sto7);
		
		g1.addNodo(pl1);
		g1.addNodo(pl2);
		g1.addNodo(pl3);
		g1.addNodo(pl4);
		g1.addNodo(pl5);
		g1.addNodo(pl6);
		g1.addNodo(pl7);
		g1.conectar(pl1, pl2,8);
		g1.conectar(pl1, pl3,7);
		g1.conectar(pl1, pl4,1);
		g1.conectar(pl2, pl5,9);
		g1.conectar(pl3, pl5,10);
		g1.conectar(pl3, pl6,3);
		g1.conectar(pl4, pl3,2);
		g1.conectar(pl6, pl7,6);
		System.out.println(pl1.getAlmacen().toString());
		System.out.println(pl1.getAlmacen().buscarInsumo(elQueBusco));
	}

	@Test
	public void testBuscarPlantaPlantaInsumoInteger() {
		Integer n = 2;
		assertTrue(g1.buscarPlanta(pl1,elQueBusco,n)== pl2);
	}

	@Test
	public void testBuscarPlantaPlantaInsumo() {
		assertTrue(g1.buscarPlanta(pl1,elQueBusco)== pl6);
	}

	@Test
	public void testBuscarPlantaInsumo() {
		assertTrue(g1.buscarPlanta(elQueBusco)== pl5);
	}

}

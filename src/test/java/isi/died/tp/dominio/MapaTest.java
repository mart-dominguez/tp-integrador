package isi.died.tp.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;

public class MapaTest {
	public Insumo elQueBusco;
	public Insumo elQueNoBusco;
	public Mapa g1;
	public Mapa g2;
	public Mapa g3;
	public Planta pl1;
	public Planta pl2;
	public Planta pl3;
	public Planta pl4;
	public Planta pl5;
	public Planta pl6;
	public Planta pl7;
	public Pedido pd1;
	public Pedido pd2;
	public Pedido pd3;
	public Pedido pd4;
	public List<Pedido> optimo;
	public List<Pedido> test;
	public Vehiculo v;

	@Before
	public void setUp() {
		elQueBusco = new Insumo();
		elQueNoBusco = new Insumo();
		elQueBusco.setNombre("A");
		elQueNoBusco.setNombre("B");
		elQueBusco.setCosto(50.0d);
		elQueNoBusco.setCosto(30.0d);
		elQueBusco.setStock(500);
		elQueNoBusco.setStock(30);
		elQueNoBusco.setPeso(2.0);
		elQueBusco.setPeso(5.0);
		g1 = new Mapa();
		Stock sto1 = new Stock();
		sto1.setInsumo(elQueNoBusco);
		// El de camino menor salto
		Stock sto2 = new Stock();
		sto2.setInsumo(elQueBusco);
		sto2.setCantidad(40);
		sto2.setPuntoPedido(50);
		// ----------------------------------
		Stock sto3 = new Stock();
		sto3.setInsumo(elQueNoBusco);
		Stock sto4 = new Stock();
		sto4.setInsumo(elQueNoBusco);

		// el que mas necesita
		Stock sto5 = new Stock();
		sto5.setInsumo(elQueBusco);
		sto5.setCantidad(10);
		sto5.setPuntoPedido(100);
		// ----------------------------------
		// El de camino mas corto
		Stock sto6 = new Stock();
		sto6.setInsumo(elQueBusco);
		sto6.setCantidad(40);
		sto6.setPuntoPedido(50);

		// ----------------------------------
		Stock sto7 = new Stock();
		sto7.setInsumo(elQueNoBusco);
		
		
		pl1 = new Planta("Planta 1");
		pl1.addStock(sto1);

		pl2 = new Planta("Planta 2");
		pl2.addStock(sto2);

		pl3 = new Planta("Planta 3");
		pl3.addStock(sto3);

		pl4 = new Planta("Planta 4");
		pl4.addStock(sto4);

		pl5 = new Planta("Planta 5");
		pl5.addStock(sto5);

		pl6 = new Planta("Planta 6");
		pl6.addStock(sto6);

		pl7 = new Planta("Planta 7");
		pl7.addStock(sto7);
		g1.agregarInsumo(elQueBusco);
		g1.agregarInsumo(elQueNoBusco);
		g1.addNodo(pl1);
		g1.addNodo(pl2);
		g1.addNodo(pl3);
		g1.addNodo(pl4);
		g1.addNodo(pl5);
		g1.addNodo(pl6);
		g1.addNodo(pl7);
		g1.conectar(pl1, pl2, 8);
		g1.conectar(pl1, pl3, 7);
		g1.conectar(pl1, pl4, 1);
		g1.conectar(pl2, pl5, 9);
		g1.conectar(pl3, pl5, 10);
		g1.conectar(pl3, pl6, 3);
		g1.conectar(pl4, pl3, 2);
		g1.conectar(pl6, pl7, 6);
		g2 = new Mapa();
		g2.addNodo(pl1);
		g2.addNodo(pl2);
		g2.addNodo(pl3);
		g2.addNodo(pl4);
		g2.addNodo(pl5);
		g2.conectar(pl1, pl2, 8);
		g2.conectar(pl1, pl3, 7);
		g2.conectar(pl1, pl5, 1);
		g2.conectar(pl5, pl3, 9);
		g2.conectar(pl3, pl4, 10);
		g2.conectar(pl4, pl2, 3);
		g3 = new Mapa();
		g3.addNodo(pl1);
		g3.addNodo(pl2);
		g3.addNodo(pl6);
		g3.addNodo(pl5);
		g3.addNodo(pl4);
		g3.nuevaRuta(pl1,pl2,6.0d,1.0d,2.0d);
		g3.nuevaRuta(pl1,pl4,1.0d,4.0d,18.0d);
		g3.nuevaRuta(pl2,pl6,2.0d,1.0d,6.0d);
		g3.nuevaRuta(pl6,pl5,1.0d,1.0d,8.0d);
		g3.nuevaRuta(pl4,pl2,2.0d,5.0d,7.0d);
		pd1 = new Pedido(elQueBusco,2,pl1,pl1);
		pd2 = new Pedido(elQueNoBusco,01,pl1,pl2);
		pd3 = new Pedido(elQueBusco,3,pl1,pl3);
		pd4 = new Pedido(elQueNoBusco,4,pl1,pl4);
		g1.agregarPedido(pd1);
		g1.agregarPedido(pd2);
		g1.agregarPedido(pd3);
		g1.agregarPedido(pd4);
		v = new Vehiculo("sda","asdg",55.0);
	    test = new ArrayList<Pedido>();
		test.add(pd1);
		test.add(pd2);
		test.add(pd3);
		test.add(pd4);
	}
	
	@Test
	public void pedidosOptimoTest() {
		System.out.println("---------------Opciones---------------");
		System.out.println("Peso 1 :"+pd1.getPeso());
		System.out.println("Precio 1 :"+pd1.getPrecio());
		System.out.println("Peso 2 :"+pd2.getPeso());
		System.out.println("Precio 2 :"+pd2.getPrecio());
		System.out.println("Peso 3 :"+pd3.getPeso());
		System.out.println("Precio 3 :"+pd3.getPrecio());
		System.out.println("Peso 4 :"+pd4.getPeso());
		System.out.println("Precio 4 :"+pd4.getPrecio());
		System.out.println("----------------Optimo-------------------");
		v.vehiculoOptimo(test);
		System.out.println(v.pedidos);
	}

	@Test
	public void listar() {
		System.out.println("------- Lista por nombres ---------");
		System.out.println(g1.listarXnombreAce());
		System.out.println(g1.listarXnombreDec());
		System.out.println("------- Lista por Precio ---------");
		System.out.println(g1.listarXprecioAce());
		System.out.println(g1.listarXprecioDec());
		System.out.println("------- Lista por Cant de Sock ---------");
		System.out.println(g1.listarXcantidadStockAce());
		System.out.println(g1.listarXcantidadStockDec());
		System.out.println("------- El menor Precio ---------");
		System.out.println(g1.costoMinimo());
		System.out.println("------- El Mayor Precio ---------");
		System.out.println(g1.costoMax());
		System.out.println("------- Caminos g2 --------");
		System.out.println(g2.camino(elQueBusco));
		System.out.println("------- Caminos g1 --------");
		System.out.println(g1.camino(elQueBusco));
		System.out.println("nADA");
		System.out.println("------- Caminos g3 --------");
		System.out.println(g3.camino(elQueBusco));
		System.out.println("------- Camino g3 con menor distancia --------");
		System.out.println(g3.caminoMenorDistancia(elQueBusco));
		System.out.println("PesoM: "+ g3.pesoCamino(g3.caminoMenorDistancia(elQueBusco)));
		System.out.println("Dist: "+ g3.distCamino(g3.caminoMenorDistancia(elQueBusco)));
		System.out.println("Dur: "+ g3.durCamino(g3.caminoMenorDistancia(elQueBusco)));
		System.out.println("------- Camino g3 con menor duracion --------");
		System.out.println(g3.caminoMenorDuracion(elQueBusco));
		System.out.println("PesoM: "+ g3.pesoCamino(g3.caminoMenorDuracion(elQueBusco)));
		System.out.println("Dist: "+ g3.distCamino(g3.caminoMenorDuracion(elQueBusco)));
		System.out.println("Dur: "+ g3.durCamino(g3.caminoMenorDuracion(elQueBusco)));
		System.out.println("------- Peso max soportado por el total --------");
		System.out.println(g3.capacidadMax());
		System.out.println("-------  Caminos en g1 entre p1 y p5 --------");
		System.out.println(g1.buscarCaminoEntre(pl1, pl5));
		System.out.println("   ");
		
	}

	@Test
	public void testBuscarPlantaPlantaInsumoInteger() {
		Integer n = 2;
		assertTrue(g1.buscarPlanta(pl1, elQueBusco, n) == pl2);
	}

	@Test
	public void testBuscarPlantaPlantaInsumo() {
		assertTrue(g1.buscarPlanta(pl1, elQueBusco) == pl6);
	}

	@Test
	public void testBuscarPlantaInsumo() {
		assertTrue(g1.buscarPlanta(elQueBusco) == pl5);
	}

}

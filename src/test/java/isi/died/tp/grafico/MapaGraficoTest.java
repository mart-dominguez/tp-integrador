package isi.died.tp.grafico;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Mapa;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;

public class MapaGraficoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Insumo elQueBusco;
		Insumo elQueNoBusco;
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
		Mapa g3;
		Planta pl1;
		Planta pl2;
		Planta pl3;
	    Planta pl4;
	    Planta pl5;
		g3 = new Mapa();
		g3.agregarInsumo(elQueBusco);
		g3.agregarInsumo(elQueNoBusco);
		pl1 = new Planta("Planta 1");
		pl2 = new Planta("Planta 2");
		pl3 = new Planta("Planta 3");
		pl4 = new Planta("Planta 4");
		pl5 = new Planta("Planta 5");
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
		sto4.setInsumo(elQueBusco);

		// el que mas necesita
		Stock sto5 = new Stock();
		sto5.setInsumo(elQueBusco);
		sto5.setCantidad(10);
		sto5.setPuntoPedido(100);
		g3.addNodo(pl1);
		g3.addNodo(pl2);
		g3.addNodo(pl3);
		g3.addNodo(pl4);
		g3.addNodo(pl5);
		g3.nuevaRuta(pl1,pl2,6.0d,1.0d,2.0d);
		g3.nuevaRuta(pl1,pl4,1.0d,4.0d,18.0d);
		g3.nuevaRuta(pl2,pl4,2.0d,1.0d,6.0d);
		g3.nuevaRuta(pl4,pl3,1.0d,1.0d,8.0d);
		g3.nuevaRuta(pl3,pl5,2.0d,5.0d,7.0d);
     	JFrame jframe = new JFrame("Mapa de Plantas");
     	MapaGrafico mcd = new MapaGrafico(g3);
     	List<Planta> lintaA = new ArrayList<Planta>();
     	lintaA.add(pl1);
     	lintaA.add(pl2);
     	lintaA.add(pl4);
     	mcd.remarcarNodos(lintaA);
     	mcd.remarcarRutas(lintaA);
		jframe.add(mcd);
		jframe.pack();
		jframe.setSize(1024,768);
     	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	jframe.setVisible(true);
	}

}

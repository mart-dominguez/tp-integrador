package isi.died.tp.datos;

import java.util.ArrayList;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Mapa;
import isi.died.tp.dominio.Pedido;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.dominio.Stock;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.dominio.Vehiculo;
import isi.died.tp.estructuras.Vertice;

public class Datos {
	public Mapa mapa;
	public ArrayList<Pedido> pedidos;
	public Planta planta1, planta2, planta3, planta4;
	private Stock stock1, stock2, stock3, stock4, stock5, stock6;
	private Insumo i1, i2, i3;
	
	public Datos() {
		pedidos = new ArrayList<Pedido>();	
		
		mapa = new Mapa();
		
		
		cargarInsumos();
		cargarVehiculos();
		cargarPlantas();
		cargarRutas();
		cargarPedidos();
	}


	private void cargarInsumos() {
		i1 = new Insumo("Insumo01", 25.0, UnidadMedida.KILO, 95.00, 102, false, "Descripcion del insumo 01");
		mapa.agregarInsumo(i1);
		i2 = new Insumo("Insumo02", 32.0, UnidadMedida.KILO, 52.99, 86, false, "Descripcion del insumo 02");
		mapa.agregarInsumo(i2);
		i3 = new Insumo("Insumo03", 95.0, UnidadMedida.LITRO, 101.00, 102, true, "Descripcion del insumo 03");
		mapa.agregarInsumo(i3);
		
	}
	
	private void cargarVehiculos() {
		mapa.agregarVehiculo(new Vehiculo("Marca1", "Modelo03", "AA894SS", 2017, 200.5, 5000.0, false));
		mapa.agregarVehiculo(new Vehiculo("Marca1", "Modelo02", "AC555DF", 2018, 190.0, 250.0, true));
		mapa.agregarVehiculo(new Vehiculo("Marca2", "Modelo01", "AB741WE", 2019, 235.0, 6000.0, false));
	}
	
	private void cargarPlantas() {
		stock1 =new Stock(16, 20, i2);
		stock2 = new Stock(26, 20, i3);
		stock3 = new Stock(16, 19, i2);
		stock4 = new Stock(26, 35, i3);
		stock5 = new Stock(23, 22, i1);
		stock6 = new Stock(26, 14, i1);
		
		planta1 = new Planta("Planta01");
		planta2 = new Planta("Planta02");
		planta3 = new Planta("Planta03");
		planta4 = new Planta("Planta04");
		
		planta1.addStock(stock1);
		planta1.addStock(stock4);
		planta1.addStock(stock6);
		planta2.addStock(stock2);
		planta2.addStock(stock1);
		planta3.addStock(stock3);
		planta3.addStock(stock5);
		planta3.addStock(stock2);
		planta4.addStock(stock6);
		planta4.addStock(stock4);
		planta4.addStock(stock3);
		planta4.addStock(stock5);
		
		mapa.addNodo(planta1);
		mapa.addNodo(planta2);
		mapa.addNodo(planta3);
		mapa.addNodo(planta4);
		
		
	}
	
	private void cargarRutas() {
		mapa.nuevaRuta(new Ruta(new Vertice<Planta>(planta1), new Vertice<Planta>(planta2), 250.5, 180.0, 7000.0));
		mapa.nuevaRuta(new Ruta(new Vertice<Planta>(planta2), new Vertice<Planta>(planta3), 190.0, 145.0, 6500.0));
		mapa.nuevaRuta(new Ruta(new Vertice<Planta>(planta4), new Vertice<Planta>(planta3), 105.0, 355.0, 8000.0));
	}
	
	private void cargarPedidos() {
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo01"), 14, planta1, planta3));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo02"), 36, planta3, planta4));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo01"), 27, planta4, planta2));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo02"), 10, planta1, planta4));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo03"), 34, planta3, planta4));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo02"), 24, planta2, planta3));
		
	}
	
}

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
	public ArrayList<Planta> plantas;
	private ArrayList<Stock> stocks1, stocks2, stocks3;
	private Insumo i1, i2, i3;
	
	public Datos() {
		pedidos = new ArrayList<Pedido>();
		plantas = new ArrayList<Planta>();
		stocks1 = new ArrayList<Stock>();
		stocks2 = new ArrayList<Stock>();
		stocks3 = new ArrayList<Stock>();
		
		
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
		mapa.agregarVehiculo(new Vehiculo("Marca1", "Modelo02", "AC555DF", 2018, 190.0, 5500.0, true));
		mapa.agregarVehiculo(new Vehiculo("Marca2", "Modelo01", "AB741WE", 2019, 235.0, 6000.0, false));
	}
	
	private void cargarPlantas() {
		stocks1.add(new Stock(16, 20, i2));
		stocks1.add(new Stock(26, 20, i3));
		stocks2.add(new Stock(16, 19, i2));
		stocks2.add(new Stock(26, 35, i3));
		stocks2.add(new Stock(23, 22, i1));
		stocks3.add(new Stock(26, 14, i1));
		
		plantas.add(new Planta("Planta01", stocks1));
		plantas.add(new Planta("Planta02", stocks2));
		plantas.add(new Planta("Planta03", stocks3));
		plantas.add(new Planta("Planta04", stocks3));
		for (Planta planta : plantas) {
			mapa.addNodo(planta);
		}
	}
	
	private void cargarRutas() {
		mapa.nuevaRuta(new Ruta(new Vertice<Planta>(plantas.get(0)), new Vertice<Planta>(plantas.get(1)), 250.5, 180.0, 7000.0));
		mapa.nuevaRuta(new Ruta(new Vertice<Planta>(plantas.get(1)), new Vertice<Planta>(plantas.get(2)), 190.0, 145.0, 6500.0));
		mapa.nuevaRuta(new Ruta(new Vertice<Planta>(plantas.get(3)), new Vertice<Planta>(plantas.get(2)), 105.0, 355.0, 8000.0));
	}
	
	private void cargarPedidos() {
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo01"), 14, plantas.get(0), plantas.get(2)));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo02"), 36, plantas.get(2), plantas.get(3)));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo01"), 27, plantas.get(3), plantas.get(1)));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo02"), 10, plantas.get(0), plantas.get(3)));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo03"), 34, plantas.get(2), plantas.get(3)));
		mapa.agregarPedido(new Pedido(mapa.buscarInsumoNombre("Insumo02"), 24, plantas.get(1), plantas.get(0)));
		
	}
	
}

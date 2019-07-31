package isi.died.tp.datos;

import java.util.ArrayList;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Pedido;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.dominio.Stock;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.dominio.Vehiculo;

public class Datos {
	public ArrayList<Insumo>  insumos;
	public ArrayList<Pedido> pedidos;
	public ArrayList<Planta> plantas;
	public ArrayList<Ruta> rutas;
	public ArrayList<Stock> stocks;
	public ArrayList<Vehiculo> vehiculos;
	
	public Datos() {
		insumos = new ArrayList<Insumo>();
		pedidos = new ArrayList<Pedido>();
		plantas = new ArrayList<Planta>();
		rutas = new ArrayList<Ruta>();
		stocks = new ArrayList<Stock>();
		vehiculos = new ArrayList<Vehiculo>();
		
		cargarInsumos();
		cargarVehiculos();
		cargarPlantas();
	}


	private void cargarInsumos() {
		Insumo i1 = new Insumo("Insumo01", 25.0, UnidadMedida.KILO, 95.00, 102, false, "Descripcion del insumo 01");
		insumos.add(i1);
		Insumo i2 = new Insumo("Insumo02", 32.0, UnidadMedida.KILO, 52.99, 86, false, "Descripcion del insumo 02");
		insumos.add(i2);
		Insumo i3 = new Insumo("Insumo03", 95.0, UnidadMedida.LITRO, 95.00, 102, true, "Descripcion del insumo 03");
		insumos.add(i3);
		
	}
	
	private void cargarVehiculos() {
		vehiculos.add(new Vehiculo("Marca1", "Modelo03", "AA894SS", 2017, 200.5, 1500.0, false));
	}
	
	private void cargarPlantas() {
		plantas.add(new Planta("Planta01"));
	}
}

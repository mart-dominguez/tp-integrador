package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
	public List<Pedido> pedidos;
	public double pesoMax;
	public Integer id;
	public String marca;
	public String modelo;
	public String dominio;
	public Integer anio;
	public Double costoKm;
	public boolean transportaLiquido;
	
	public Vehiculo() {
		this.pedidos = new ArrayList<Pedido>();
	}
	public Vehiculo(Integer id) {
		this();
		this.id = id;
	}
	public Vehiculo(Integer id, String marca, String modelo, String dominio, Integer anio, Double costokm, boolean transportaLiquido) {
		this(id);
		this.marca = marca;
		this.modelo = modelo;
		this.dominio = dominio;
		this.anio = anio;
		this.costoKm = costokm;
		this.transportaLiquido = transportaLiquido;
	}
	
	public void seleccionarInsumos(ArrayList<Insumo> insumos) {
		//TODO
		
	}
}

package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
	public List<Pedido> pedidos;
	public double pesoMax;
	public String nombre;
	public String marca;
	public Integer id;
<<<<<<< HEAD
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
		
=======

	public Vehiculo(String ma, String nom, Double pesoM) {
		this(pesoM);
		this.nombre = nom;
		this.marca = ma;
	}

	public Vehiculo(Double pesoM) {
		this.pedidos = new ArrayList<Pedido>();
		this.id = this.hashCode();
		this.pesoMax = pesoM;
		this.nombre = "";
		this.marca = "";
	}

	public boolean disponible() {
		if (pedidos.isEmpty()) {
			return true;
		}
		return false;
	}

	private Double precioLista(List<Pedido> p) {
		if (p.isEmpty() || p == null) {
			return Double.MIN_VALUE;
		}
		return p.stream().mapToDouble(q -> q.getPrecio()).sum();
	}

	private Double pesoLista(List<Pedido> p) {
		if (p.isEmpty() || p == null) {
			return 0.0;
		}
		return p.stream().mapToDouble(q -> q.getPeso()).sum();
	}

	public List<Pedido> vehiculoOptimo(List<Pedido> restantes) {
		List<Pedido> marcados = new ArrayList<Pedido>();
		this.vehiculoOptimoAux2(marcados, restantes, false);
		return this.pedidos;
	}

	private void vehiculoOptimoAux2(List<Pedido> marcados, List<Pedido> restantes, boolean lleno) {
		if (lleno) {
			if (this.precioLista(marcados) > this.precioLista(this.pedidos)) {
				this.pedidos = new ArrayList<Pedido>();
				this.pedidos.addAll(marcados);
			}
		} else {
			if (restantes.isEmpty()) {
				this.vehiculoOptimoAux2(marcados, restantes, true);
			} 
			else {
				List<Pedido> copiaMarcados =null;
				List<Pedido> copiaRestantes = null;
				for (Pedido pedidoS : restantes) {
					copiaMarcados = new ArrayList<Pedido>(marcados);
					copiaRestantes = new ArrayList<Pedido>(restantes);
					if (this.pesoLista(marcados) + pedidoS.getPeso() < this.pesoMax) {
						copiaMarcados.add(pedidoS);
						copiaRestantes.remove(pedidoS);
						this.vehiculoOptimoAux2(copiaMarcados, copiaRestantes, false);
					} 
					else {
						this.vehiculoOptimoAux2(marcados, restantes, true);
					}
				}
			}
		}
>>>>>>> 695526a5e907261ed0456e0b6f530f87e3c2562a
	}
}

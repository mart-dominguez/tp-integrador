package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
	public List<Pedido> pedidos;
	public Double pesoMax;
	public String nombre;
	public String marca;
	public Integer id;
	public String modelo;
	public String dominio;
	public Integer anio;
	public Double costoKm;
	public boolean transportaLiquido;
	
	public Vehiculo() {
		this.id = hashCode();
		this.pedidos = new ArrayList<Pedido>();
		this.marca = "";
		this.modelo = "";
		this.dominio = "";
		this.anio = 0;
		this.costoKm = 0.0;
		this.pesoMax = 0.0;
		this.transportaLiquido = false;
	}

	public Vehiculo(String marca, String modelo, String dominio, Integer anio, Double costokm, boolean transportaLiquido) {
		this.hashCode();
		this.marca = marca;
		this.modelo = modelo;
		this.dominio = dominio;
		this.anio = anio;
		this.costoKm = costokm;
		this.transportaLiquido = transportaLiquido;
	}

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
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(Double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getCostoKm() {
		return costoKm;
	}

	public void setCostoKm(Double costoKm) {
		this.costoKm = costoKm;
	}

	public boolean isTransportaLiquido() {
		return transportaLiquido;
	}

	public void setTransportaLiquido(boolean transportaLiquido) {
		this.transportaLiquido = transportaLiquido;
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
	}
}

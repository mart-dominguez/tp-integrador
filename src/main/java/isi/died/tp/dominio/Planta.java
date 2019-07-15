package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import isi.died.tp.estructuras.*;

public class Planta { 
	private int id;
	private String nombre;
	private Almacen almacen;
	public Planta(Integer i, String nomb) {
		this.setId(i);
		this.setNombre(nomb);
		this.almacen = new Almacen();
	}
	public Planta(Integer i, String nomb, Almacen cosas) {
		this.setId(i);
		this.setNombre(nomb);
		this.setAlmacen(cosas);
	}
	public Double costoTotal() {
		return this.almacen.posOrden().stream().mapToDouble((s) -> s.getCantidad() * s.getInsumo().getCosto()).sum();
	}


	public List<Insumo> stockEntre(Integer s1, Integer s2) {
		return this.almacen.posOrden().stream().filter((s) -> (s.getInsumo().getStock() >= s1 && s.getInsumo().getStock() <= s2)).map(Stock::getInsumo).collect(Collectors.toList());
	}

	public Boolean necesitaInsumo(Insumo i) {
		Stock buscado = this.almacen.buscarInsumo(i);
		if (buscado.getCantidad() < buscado.getPuntoPedido()) {
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Almacen getAlmacen() {
		return almacen;
	}
	public void setAlmacen(Almacen stock) {
		this.almacen = stock;
	}
	public void addStock(Stock o) {
		this.almacen.agregar(o);
	}
	@Override
	public String toString() {
		return this.nombre;
	}
}

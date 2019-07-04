package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import isi.died.tp.estructuras.*;

public class Planta { 
	private int id;
	private String nombre;
	private List<Stock> stock;
	public Planta(Integer i, String nomb) {
		this.setId(i);
		this.setNombre(nomb);
		this.stock = new ArrayList<Stock>();
	}
	public Planta(Integer i, String nomb, List<Stock> cosas) {
		this.setId(i);
		this.setNombre(nomb);
		this.setStock(cosas);
	}
	public Double costoTotal() {
		return this.stock.stream().mapToDouble((s) -> s.getCantidad() * s.getInsumo().getCosto()).sum();
	}


	public List<Insumo> stockEntre(Integer s1, Integer s2) {
		return this.stock.stream().filter((s) -> (s.getInsumo().getStock() >= s1 && s.getInsumo().getStock() <= s2)).map(Stock::getInsumo).collect(Collectors.toList());
	}

	public Boolean necesitaInsumo(Insumo i) {
		for (Stock stock2 : this.stock) {
			if (stock2.getInsumo().equals(i) && (stock2.getCantidad() < stock2.getPuntoPedido())) {
				return true;
			}
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


	public List<Stock> getStock() {
		return stock;
	}
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	public void addStock(Stock o) {
		if(!this.stock.contains(o)) {
			this.stock.add(o);
		}
	}
	@Override
	public String toString() {
		return this.nombre;
	}
	public String TodosStock() {
		String result ="";
		for (Stock stock2 : stock) {
			result+= '('+stock2.toString()+',';
		}
		result+= ')';
		return result;
	}
}

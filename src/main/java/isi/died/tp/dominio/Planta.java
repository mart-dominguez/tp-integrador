package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import isi.died.tp.estructuras.*;

public class Planta implements Comparable<Planta> {
	private Integer id;
	private String nombre;
	private List<Stock> almacen;
	public void borrarStock(Stock e) {
		this.almacen.remove(e);
	}
	public Planta(String nomb) {
		this.id = this.hashCode();
		this.setNombre(nomb);
		this.almacen = new ArrayList<Stock>();
	}

	public Planta(String nomb, List<Stock> cosas) {
		this.id = this.hashCode();
		this.setNombre(nomb);
		this.setAlmacen(cosas);
	}

	public Double costoTotal() {
		return this.almacen.stream()
				.mapToDouble((s) -> s.getCantidad() * s.getInsumo().getCosto())
				.sum();
	}

	public List<Insumo> stockEntre(Integer s1, Integer s2) {
		return this.almacen.stream()
				.filter((s) -> (s.getInsumo().getStock() >= s1 && s.getInsumo().getStock() <= s2))
				.map(Stock::getInsumo)
				.collect(Collectors.toList());
	}

	public Boolean necesitaInsumo(Insumo i) {
		List<Insumo> buscado = this.almacen.stream()
				.filter(s -> s.getInsumo().getId() == i.getId() && (s.getCantidad() < s.getPuntoPedido()))
				.map(Stock::getInsumo)
				.collect(Collectors.toList());
		if (!buscado.isEmpty()) {
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

	public List<Stock> getAlmacen() {
		return almacen;
	}

	public void setAlmacen(List<Stock> stock) {
		this.almacen = stock;
	}

	public void addStock(Stock o) {
		if(!this.almacen.contains(o)) {
			this.almacen.add(o);
		}
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	public void disminuirStock(Insumo i, Integer cant) {
		Stock buscado = this.buscarStock(i);
		buscado.disminuir(cant);
		i.disminuir(cant);
	}

	public void aumentarStock(Insumo i, Integer cant) {
		Stock buscado = this.buscarStock(i);
		buscado.aumentar(cant);
		i.aumentar(cant);
	}

	public Stock buscarStock(Insumo i) {
		Queue<Stock> sto = new LinkedList<Stock>(this.almacen);
		Stock actual;
		do {
			actual = sto.poll();
		} while (actual.getInsumo().compareTo(i) != 0);
		if (actual.getInsumo().compareTo(i) == 0) {
			return actual;
		}
		return null;
	}

	@Override
	public int compareTo(Planta o) {
		return this.id.compareTo(o.id);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Planta) {
			if(((Planta)obj).id.equals(this.id) && ((Planta)obj).nombre.equals(this.nombre) ) {
				return true;
			}
		}
		return false;
	}
	public Map<Insumo,Integer> nececidadStock(){
		Map<Insumo, Integer> nec = new HashMap<Insumo, Integer>();
		for (Stock stock : almacen) {
			Integer necesito = stock.getPuntoPedido()-stock.getCantidad();
			if(necesito>0) {
				nec.put(stock.getInsumo(),necesito);
			}
		}
		return nec;
	}
}

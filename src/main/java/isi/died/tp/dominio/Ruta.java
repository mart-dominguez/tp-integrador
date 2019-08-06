package isi.died.tp.dominio;

import isi.died.tp.estructuras.Arista;
import isi.died.tp.estructuras.Vertice;

public class Ruta extends Arista<Planta> {
	public Double distancia;
	public Double duracion;
	public Double pesoMax;

	public Ruta() {
		this.distancia = 0.0d;
		this.duracion = 0.0d;
		this.pesoMax = 0.0d;
	}

	public Ruta(Vertice<Planta> ini, Vertice<Planta> fin) {
		this();
		this.inicio = ini;
		this.fin = fin;
	}

	public Ruta(Vertice<Planta> ini, Vertice<Planta> fin, Double dist, Double dur, Double peso) {
		this(ini, fin);
		this.distancia = dist;
		this.duracion = dur;
		this.pesoMax = peso;

	}
	
	public Double getDistancia() {
		return distancia;
	}

	public Double getDuracion() {
		return duracion;
	}

	public Double getPesoMax() {
		return pesoMax;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public void setPesoMax(Double pesoMax) {
		this.pesoMax = pesoMax;
	}
	
}

package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	private double densidad;
	private double volumen;

	
	public double getDensidad() {
		return densidad;
	}
	
	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}
	
	public double getVolumen() {
		return volumen;
	}
	
	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
	
	public double calcularPeso() {
		this.peso = this.densidad * this.volumen;
		return this.peso;

	}

}
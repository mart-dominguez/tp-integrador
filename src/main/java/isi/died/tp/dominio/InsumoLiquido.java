package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	private double densidad;
	private double volumen;

	public InsumoLiquido() {
		super();
		this.densidad = 0.0d;
		this.volumen = 0.0d;
	};

	public InsumoLiquido(String nom, String desc, UnidadMedida un, Integer stok, boolean refri, double cs, double den,
			double vol) {
		super(nom, desc, un, stok, 0.0d, refri, cs);
		this.densidad = den;
		this.volumen = vol;
		this.peso = this.calcularPeso();
	}

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
package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	private Double densidad;

<<<<<<< HEAD
	public Double getDensidad() {
		return densidad;
	}

	public void setDensidad(Double densidad) {
		this.densidad = densidad;
	}
=======
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
>>>>>>> 695526a5e907261ed0456e0b6f530f87e3c2562a

	public Double getPeso() {
		this.peso = this.densidad * (super.peso / 1000);
		return this.peso;
	}

}
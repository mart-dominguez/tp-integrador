package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	private Double densidad;

	public InsumoLiquido() {
		super();
		this.densidad = 0.0d;
	};

	public InsumoLiquido(String nom, String desc, UnidadMedida un, Integer stok, boolean refri, double cs, double den) {
		super(nom, desc, un, stok, 0.0d, refri, cs);
		this.densidad = den;
		this.peso = this.calcularPeso();
	}

	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}

	public double calcularPeso() {
		this.peso = this.densidad * (super.peso / 1000);
		return this.peso;
	}

}
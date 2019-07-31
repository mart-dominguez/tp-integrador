package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	private Double densidad;

	public InsumoLiquido() {
		super();
		this.densidad = 0.0d;
	};

	public InsumoLiquido(String nombr, Double peso, UnidadMedida un, Double cs, Integer stock, boolean refri,  String desc, double den) {
		super(nombr, peso, un, cs, stock, refri, desc);
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
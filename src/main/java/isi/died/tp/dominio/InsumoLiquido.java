package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	private Double densidad;

	public Double getDensidad() {
		return densidad;
	}

	public void setDensidad(Double densidad) {
		this.densidad = densidad;
	}

	public Double getPeso() {
		this.peso = this.densidad * (super.peso / 1000);
		return this.peso;
	}

}
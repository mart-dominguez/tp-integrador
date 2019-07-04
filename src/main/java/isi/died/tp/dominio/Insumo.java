package isi.died.tp.dominio;

public class Insumo implements Comparable<Insumo>{
	private int id;
	private String descripcion;
	private UnidadMedida unidadDeMedida;
	private Integer stock;
	protected double peso;
	private boolean esRefrigerado;
	public double costo;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadMedida getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(UnidadMedida unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isEsRefrigerado() {
		return esRefrigerado;
	}

	public void setEsRefrigerado(boolean esRefrigerado) {
		this.esRefrigerado = esRefrigerado;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int compareTo(Insumo i) {
		return this.stock.compareTo(((Insumo)i).stock);
	}
	@Override
	public boolean equals(Object obj) {
		if(this.id == ((Insumo) obj).id) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		Integer n = this.id;
		return n.toString();
	}

}
package isi.died.tp.dominio;

public class Insumo implements Comparable<Insumo>{
	private Integer id;
	private String nombre;
	private String descripcion;
	private UnidadMedida unidadDeMedida;
	private Integer stock;
	protected Double peso;
	private boolean esRefrigerado;
	public Double costo;
	
	public Insumo() {
		this.id = 00;
		this.nombre = "";
		this.descripcion = "";
		this.unidadDeMedida = UnidadMedida.KILO;
		this.stock = 0;
		this.peso = 0.0;
		this.esRefrigerado = false;
		this.costo = 0.0;
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
	
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public boolean isEsRefrigerado() {
		return esRefrigerado;
	}

	public void setEsRefrigerado(boolean esRefrigerado) {
		this.esRefrigerado = esRefrigerado;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int compareTo(Insumo i) {
		return this.id.compareTo(((Insumo)i).id);
	}
	@Override
	public boolean equals(Object obj) {
		if(this.compareTo((Insumo)obj)== 0) {
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
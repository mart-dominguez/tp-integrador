package isi.died.tp.dominio;

public class Insumo implements Comparable<Insumo> {
	protected Integer id;
	protected String nombre;
	protected String descripcion;
	protected UnidadMedida unidadDeMedida;
	protected Integer stock;
	protected Double peso;
	protected boolean esRefrigerado;
	public Double costo;
	
	public Insumo() {
		this.id = this.hashCode();
		this.nombre = "";
		this.descripcion = "";
		this.stock = 0;
		this.unidadDeMedida = UnidadMedida.KILO;
		this.esRefrigerado = false;
		this.peso = 0.0d;
		this.costo = 0.0d;
	}

	public Insumo(String nombr, Double peso, UnidadMedida un, Double cs, Integer stock, boolean refri,  String desc) {
		this.id = this.hashCode();
		this.nombre = nombr;
		this.descripcion = desc;
		this.esRefrigerado = refri;
		this.costo = cs;
		this.unidadDeMedida = un;
		this.stock = stock;
		this.peso = peso;
	}
	
	public Double costoX(Integer c) {
		return this.costo*c;
	}

	public void disminuir(Integer i) {
		if (i >= 0) {
			this.stock -= i;
		}
	}

	public void aumentar(Integer i) {
		if (i >= 0) {
			this.stock += i;
		}
	}

//	public void setId(int id) {
//		this.id = id;
//	}

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
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public int compareTo(Insumo i) {
		return this.id.compareTo(((Insumo) i).id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.compareTo((Insumo) obj) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
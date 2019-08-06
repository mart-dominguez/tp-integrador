package isi.died.tp.dominio;


public class Pedido implements Comparable<Pedido>{
	private Integer id;
	private Insumo insumo;
	public Integer cantidad;
	private Double peso;
	private Planta origen;
	private Planta destino;
	private Double precio;
	
	public Pedido(Insumo insumo, Integer cant, Planta origen, Planta destino) {
		this.id = this.hashCode();
		this.insumo = insumo;
		this.cantidad= cant;
		this.peso= cant*insumo.peso;
		this.origen = origen;
		this.destino = destino;
		this.precio = insumo.costoX(cant);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pedido) {
			if(((Pedido)obj).id.equals(this.id)) {
				if(((Pedido)obj).origen.equals(this.origen)&& ((Pedido)obj).destino.equals(this.destino)) {
					if(((Pedido)obj).insumo.equals(this.insumo)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Pedido o) {
		return this.id.compareTo(o.id);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Insumo getInsumo() {
		return insumo;
	}
	
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Planta getOrigen() {
		return origen;
	}
	
	public void setOrigen(Planta origen) {
		this.origen = origen;
	}
	
	
	public Planta getDestino() {
		return destino;
	}
	
	public void setDestino(Planta destino) {
		this.destino = destino;
	}
	@Override
	public String toString() {
		return this.destino.toString();
	}

}
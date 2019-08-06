package isi.died.tp.dominio;

public class Stock implements Comparable<Stock> {
	private Integer id;
	private Integer cantidad;
	private Integer puntoPedido;
	private Insumo insumo;

	public Stock() {
		this.id = this.hashCode();
	}

	public Stock(Integer cant, Integer puntoP, Insumo i) {
		this.id = this.hashCode();
		this.cantidad = cant;
		this.puntoPedido = puntoP;
		this.insumo = i;

	}

	public void disminuir(Integer i) {
		if (i >= 0) {
			this.cantidad -= i;
		}
	}

	public void aumentar(Integer i) {
		if (i >= 0) {
			this.cantidad += i;
		}
	}

	public Integer getId() {
		return id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPuntoPedido() {
		return puntoPedido;
	}

	public void setPuntoPedido(Integer puntoPedido) {
		this.puntoPedido = puntoPedido;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public String toString() {
		return this.insumo.toString();
	}

	@Override
	public int compareTo(Stock o) {
		return this.id.compareTo(o.id);
	}
}
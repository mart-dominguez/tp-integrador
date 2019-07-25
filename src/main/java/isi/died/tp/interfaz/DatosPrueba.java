package isi.died.tp.interfaz;

import java.util.ArrayList;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.UnidadMedida;

public class DatosPrueba {
	//TODO Borrar esta clase
	private ArrayList<Insumo> insumos;
	
	public DatosPrueba() {
		insumos = new ArrayList<Insumo>();
		Insumo insumo1 = new Insumo();
		insumo1.setId(1);
		insumo1.setNombre("insumo1");
		insumo1.setCosto(25.67);
		insumo1.setStock(25);
		insumo1.setPeso(2.0);
		insumo1.setUnidadDeMedida(UnidadMedida.KILO);
		insumo1.setDescripcion("Descripcion del producto uno");
		
		Insumo insumo2 = new Insumo();
		insumo2.setId(2);
		insumo2.setNombre("insumo2");
		insumo2.setCosto(27.3);
		insumo2.setStock(21);
		insumo2.setPeso(1.1);
		insumo2.setEsRefrigerado(true);
		insumo2.setUnidadDeMedida(UnidadMedida.KILO);
		insumo2.setDescripcion("Descripcion del producto dos");
		
		Insumo insumo3 = new Insumo();
		insumo3.setId(3);
		insumo3.setNombre("insumo3");
		insumo3.setCosto(18.55);
		insumo3.setStock(32);
		insumo3.setPeso(3.2);
		insumo3.setUnidadDeMedida(UnidadMedida.KILO);
		insumo3.setDescripcion("Descripcion del producto tres");
		
		insumos.add(insumo1);
		insumos.add(insumo2);
		insumos.add(insumo3);
	}

	public ArrayList<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(ArrayList<Insumo> insumos) {
		this.insumos = insumos;
	}
}

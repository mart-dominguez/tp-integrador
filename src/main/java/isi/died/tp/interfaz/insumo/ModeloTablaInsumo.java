package isi.died.tp.interfaz.insumo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Insumo;

public class ModeloTablaInsumo extends DefaultTableModel {
	final String[] columnNames = { "ID", "Nombre", "Costo", "Stock", "Peso", "Unidad", "Refrigerado", "Descripción" };
	final Object[][] data;
	private int cantInsumos;

	public ModeloTablaInsumo(ArrayList<Insumo> insumos) {
		int cantColumnas = columnNames.length;
		cantInsumos = insumos.size();
		data = new Object[cantInsumos][cantColumnas];
		int i = 0;
		for (Insumo insumo : insumos) {
			data[i][0] = insumo.getId();
			data[i][1] = insumo.getNombre();
			data[i][2] = "$ " + insumo.getCosto();
			data[i][3] = insumo.getStock();
			data[i][4] = insumo.getPeso();
			data[i][5] = insumo.getUnidadDeMedida();
			data[i][6] = insumo.isEsRefrigerado();
			data[i][7] = insumo.getDescripcion();
			i++;
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return cantInsumos;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}

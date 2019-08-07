package isi.died.tp.interfaz.logistica;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Insumo;

public class ModeloTablaInsumoLogistica extends DefaultTableModel {
	final String[] columnNames = { "ID", "Nombre" };
	final Object[][] data;
	private int cantInsumos;

	public ModeloTablaInsumoLogistica(ArrayList<Insumo> insumos) {
		int cantColumnas = columnNames.length;
		cantInsumos = insumos.size();
		data = new Object[cantInsumos][cantColumnas];
		int i = 0;
		for (Insumo insumo : insumos) {
			data[i][0] = insumo.getId();
			data[i][1] = insumo.getNombre();
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

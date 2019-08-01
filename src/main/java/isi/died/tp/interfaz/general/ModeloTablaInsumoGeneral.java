package isi.died.tp.interfaz.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Mapa;
import isi.died.tp.dominio.Planta;

public class ModeloTablaInsumoGeneral extends DefaultTableModel {
	final String[] columnNames = { "ID", "Nombre", "Cant. faltante" };
	final Object[][] data;
	private int cantInsumos;

	public ModeloTablaInsumoGeneral(Map<Insumo, Integer> map) {
		int cantColumnas = columnNames.length;
		cantInsumos = map.size();
		data = new Object[cantInsumos][cantColumnas];
		int i = 0;
		for (Map.Entry<Insumo, Integer> entry : map.entrySet()) {
			data[i][0] = entry.getKey().getId();
			data[i][1] = entry.getKey().getNombre();
			data[i][2] = entry.getValue();
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

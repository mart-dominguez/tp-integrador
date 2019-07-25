package isi.died.tp.interfaz.Planta;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Planta;

public class ModeloBusquedaPlanta extends DefaultTableModel {
	final String[] columnNames = { "ID", "Nombre"};
	final Object[][] data;
	private int cantPlantas;

	public ModeloBusquedaPlanta(List<Planta> plantas) {
		int cantColumnas = columnNames.length;
		cantPlantas = plantas.size();
		data = new Object[cantPlantas][cantColumnas];
		int i = 0;
		for (Planta planta : plantas) {
			data[i][0] = planta.getId();
			data[i][1] = planta.getNombre();
			i++;
		}
	}


	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return cantPlantas;
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

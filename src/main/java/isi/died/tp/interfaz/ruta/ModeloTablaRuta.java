package isi.died.tp.interfaz.ruta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Ruta;

public class ModeloTablaRuta extends DefaultTableModel {
	final String[] columnNames = { "Planta I", "Planta F", "Distancia", "Duración", "Peso Máx."};
	final Object[][] data;
	private int cantRutas;

	public ModeloTablaRuta(ArrayList<Ruta> rutas) {
		int cantColumnas = columnNames.length;
		cantRutas = rutas.size();
		data = new Object[cantRutas][cantColumnas];
		int i = 0;
		for (Ruta ruta : rutas) {
			data[i][0] = ruta.getInicio().getValor().getNombre();
			data[i][1] = ruta.getFin().getValor().getNombre();
			data[i][2] = ruta.getDistancia();
			data[i][3] = ruta.getDuracion();
			data[i][4] = ruta.getPesoMax();
			i++;
		}
	}


	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return cantRutas;
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
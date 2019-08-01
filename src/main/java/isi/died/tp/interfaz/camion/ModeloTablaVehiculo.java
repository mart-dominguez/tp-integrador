package isi.died.tp.interfaz.camion;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Vehiculo;

public class ModeloTablaVehiculo extends DefaultTableModel{
	final String[] columnNames = { "ID", "Marca", "Modelo", "Dominio", "Año", "Costo/Km", "Líquido", "Capacidad" };
	final Object[][] data;
	private int cantVehiculos;

	public ModeloTablaVehiculo(ArrayList<Vehiculo> vehiculos) {
		int cantColumnas = columnNames.length;
		cantVehiculos = vehiculos.size();
		data = new Object[cantVehiculos][cantColumnas];
		int i = 0;
		for (Vehiculo vehiculo : vehiculos) {
			data[i][0] = vehiculo.getId();
			data[i][1] = vehiculo.getMarca();
			data[i][2] = vehiculo.getModelo();
			data[i][3] = vehiculo.getDominio();
			data[i][4] = vehiculo.getAnio().toString();
			data[i][5] = "$ " + vehiculo.getCostoKm();
			data[i][6] = vehiculo.isTransportaLiquido();
			data[i][7] = vehiculo.getPesoMax() + " Kg";
			i++;
		}
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return cantVehiculos;
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

package isi.died.tp.interfaz.general;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import isi.died.tp.dominio.Pedido;

public class ModeloTablaPedido extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	final String[] columnNames = { "ID", "Insumo", "Cantidad", "Peso (Kg)", "Origen", "Destino", "Precio" };
	final Object[][] data;
	private int cantInsumos;

	public ModeloTablaPedido(ArrayList<Pedido> pedidos) {
		int cantColumnas = columnNames.length;
		cantInsumos = pedidos.size();
		data = new Object[cantInsumos][cantColumnas];
		int i = 0;
		for (Pedido pedido : pedidos) {
			data[i][0] = pedido.getId();
			data[i][1] = pedido.getInsumo().getNombre();
			data[i][2] = pedido.getCantidad();
			data[i][3] = pedido.getPeso();
			data[i][4] = pedido.getOrigen().getNombre();
			data[i][5] = pedido.getDestino().getNombre();
			data[i][6] = "$ " + pedido.getPrecio();
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
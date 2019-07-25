package isi.died.tp.interfaz.insumo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderCeldasInsumos extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		this.setFont(new Font("Tahoma", 0, 12));
		if(column < 7) {
			this.setOpaque(true);
			this.setBackground(new Color(232, 232, 232));
			this.setForeground(Color.BLACK);
//		} else if (column == 7) {
//			this.setOpaque(true);
//			this.setBackground(new Color(161,221,112));
//			this.setForeground(Color.BLACK);
//		} else if (column == 8){
//			this.setOpaque(true);
//			this.setBackground(new Color(247,98,98));
//			this.setForeground(Color.BLACK);
		} else {
			this.setOpaque(true);
			this.setBackground(new Color(232, 232, 232));
			this.setForeground(Color.BLACK);
		}

		return this;
	}

}

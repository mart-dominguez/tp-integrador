package isi.died.tp.interfaz.insumo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.interfaz.DatosPrueba;

public class InterfazInsumo extends JFrame {
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lInsumos;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JButton bCrear;
	private JButton bEditar;
	private JButton bEliminar;
	private JButton bBuscar;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private ArrayList<Insumo> insumos;
	

	public InterfazInsumo() {
		
		DatosPrueba dp = new DatosPrueba();// TODO prueba
		insumos = dp.getInsumos();
		
//		insumos = new ArrayList<Insumo>();
		
		c0 = new Color(232, 232, 232);
		c1 = new Color(85, 136, 163);
		c2 = new Color(20, 83, 116);
		c3 = new Color(0, 51, 78);
		
		this.setBounds(0, 0, 700, 600);
//		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(c0);
		this.setTitle("Insumos - Gestion de Logística");

		pNombre = new JPanel();
		pNombre.setBounds(10, 20, 660, 100);
		pNombre.setBackground(c1);
		this.add(pNombre);

		lNombreEmpresa = new JLabel("   Nombre Empresa   ");
		lNombreEmpresa.setFont(new Font("Tahoma", 3, 45));
		lNombreEmpresa.setForeground(c0);
		pNombre.add(lNombreEmpresa);

		lTitulo = new JLabel("--- Gestión Logística ---");
		lTitulo.setFont(new Font("Tahoma", 0, 24));
		lTitulo.setForeground(c0);
		pNombre.add(lTitulo);
		
		pCuerpo = new JPanel();
		pCuerpo.setLayout(null);
		pCuerpo.setBounds(10, 130, 660, 415);
		pCuerpo.setBackground(c1);
		this.add(pCuerpo);
		
		lInsumos = new JLabel("Insumos: ");
		lInsumos.setFont(new Font("Tahoma", 1, 24));
		lInsumos.setForeground(c0);
		lInsumos.setBounds(20, 10, 150, 30);
		pCuerpo.add(lInsumos);
		
		//Tabla
		ModeloBusquedaInsumo mbi = new ModeloBusquedaInsumo(dp.getInsumos()); //
		tabla = new JTable(mbi);
//		TableColumn c = tabla.getColumn(identifier)
		tabla.getColumn("ID").setPreferredWidth(25);
		tabla.getColumn("Nombre").setPreferredWidth(100);
		tabla.getColumn("Costo").setPreferredWidth(70);
		tabla.getColumn("Stock").setPreferredWidth(50);
		tabla.getColumn("Peso").setPreferredWidth(50);
		tabla.getColumn("Unidad").setPreferredWidth(50);
		tabla.getColumn("Refrigerado").setPreferredWidth(50);
		tabla.getColumn("Descripción").setPreferredWidth(235);
		
//		tabla.setBounds(10, 50, 640, 350);
//		tabla.setPreferredScrollableViewportSize(new Dimension(640, 350));
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
//		tabla.setDefaultRenderer(Object.class, new RenderCeldasInsumos());
		tabla.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 50, 630, 350);
		scrollPane.setBackground(c0);
		scrollPane.setVisible(true);
		scrollPane.setViewportView(tabla);
		scrollPane.getViewport().setView(tabla);
		pCuerpo.add(scrollPane);
		
		
		bCrear = new JButton("Crear");
		bCrear.setBackground(c2);
		bCrear.setFont(new Font("Tahoma", 0, 14));
		bCrear.setForeground(c0);
		bCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Insumo insumo = new Insumo();
				EditarInsumo nuevoInsumo = new EditarInsumo(insumo);
				dispose();
			}
		});
		bCrear.setBounds(275, 10, 85, 35);
		pCuerpo.add(bCrear);
		
		bEditar = new JButton("Editar");
		bEditar.setBackground(c2);
		bEditar.setFont(new Font("Tahoma", 0, 14));
		bEditar.setForeground(c0);
		bEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione un insumo en la tabla para que pueda ser modificado.");
				} else {
					
					EditarInsumo nuevoInsumo = new EditarInsumo(insumos.get(tabla.getSelectedRow()));
					dispose();
				}
			}
		});
		bEditar.setBounds(365, 10, 85, 35);
		pCuerpo.add(bEditar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setBackground(c2);
		bEliminar.setFont(new Font("Tahoma", 0, 14));
		bEliminar.setForeground(c0);
		bEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione el insumo que desea eliminar.");
				} else {
					int mensaje = new JOptionPane().showConfirmDialog(null, "¿Estás seguro de que desea eliminar el producto?", "Mensaje", JOptionPane.YES_NO_OPTION);
					if(mensaje == JOptionPane.YES_OPTION) {
						//TODO Eliminar un producto
					}
				}
			}
		});
		bEliminar.setBounds(455, 10, 85, 35);
		pCuerpo.add(bEliminar);

		
		bBuscar = new JButton("Buscar");
		bBuscar.setBackground(c2);
		bBuscar.setFont(new Font("Tahoma", 0, 14));
		bBuscar.setForeground(c0);
		bBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		bBuscar.setBounds(545, 10, 100, 35);
		pCuerpo.add(bBuscar);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		InterfazInsumo interfazInsumo = new InterfazInsumo();
//		interfazInsumo.setBounds(0, 0, 700, 600);
//		interfazInsumo.setVisible(true);
//		interfazInsumo.setResizable(false);
//		interfazInsumo.setLocationRelativeTo(null);
	}
}
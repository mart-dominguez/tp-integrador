package isi.died.tp.logistica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.grafico.MapaGrafico;
import isi.died.tp.interfaz.Menu;

public class InterfazLogistica extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo, lMensaje, lVerInsumo;
	private JLabel lLogistica, lInsumos;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JButton bAtras, bVer;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private ArrayList<Insumo> insumos;

	public InterfazLogistica(Datos datos) {
			
		c0 = new Color(232, 232, 232);
		c1 = new Color(85, 136, 163);
		c2 = new Color(20, 83, 116);
		c3 = new Color(0, 51, 78);
		
		this.setBounds(0, 0, 900, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(c0);
		this.setTitle("Logistica - Gestion de Logística");
		

		pNombre = new JPanel();
		pNombre.setBounds(10, 10, 860, 100);
		pNombre.setBackground(c1);
		this.add(pNombre);

		
		lNombreEmpresa = new JLabel("         Nombre Empresa         ");
		lNombreEmpresa.setFont(new Font("Tahoma", 3, 45));
		lNombreEmpresa.setForeground(c0);
		pNombre.add(lNombreEmpresa);

		lTitulo = new JLabel("  --- Gestión Logística ---  ");
		lTitulo.setFont(new Font("Tahoma", 0, 24));
		lTitulo.setForeground(c0);
		pNombre.add(lTitulo);
		
		pCuerpo = new JPanel();
		pCuerpo.setLayout(null);
		pCuerpo.setBounds(10, 120, 860, 535);
		pCuerpo.setBackground(c1);
		this.add(pCuerpo);
		
		//Logistica
		lLogistica = new JLabel("Logistica: ");
		lLogistica.setFont(new Font("Tahoma", 1, 24));
		lLogistica.setForeground(c0);
		lLogistica.setBounds(20, 5, 150, 30);
		pCuerpo.add(lLogistica);
		
		//Mensaje
		lMensaje = new JLabel("* Mueva los nodos para una mejor visualización.");
		lMensaje.setFont(new Font("Tahoma", 0, 16));
		lMensaje.setForeground(c0);
		lMensaje.setBounds(20, 500, 400, 30);
		pCuerpo.add(lMensaje);
		
		//Grafico
		//TODO Corregir que los nodos no queden dibujados fuera del jpanel
		MapaGrafico mg = new MapaGrafico(datos.mapa);
		mg.setBackground(c0);
		pCuerpo.add(mg);
		
		//Insumos
		lInsumos = new JLabel("Insumos: ");
		lInsumos.setFont(new Font("Tahoma", 1, 24));
		lInsumos.setForeground(c0);
		lInsumos.setBounds(565, 10, 150, 30);
		pCuerpo.add(lInsumos);
		//Tabla
		insumos = new ArrayList<Insumo>(datos.mapa.getInsumos().inOrden());
		ModeloTablaInsumoLogistica mtil = new ModeloTablaInsumoLogistica(insumos);
		tabla = new JTable(mtil);
		tabla.setBackground(c0);
		tabla.getColumn("ID").setPreferredWidth(90);
		tabla.getColumn("Nombre").setPreferredWidth(200);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(560, 40, 290, 380);
		scrollPane.setBackground(c0);
		scrollPane.setVisible(true);
		scrollPane.setViewportView(tabla);
		pCuerpo.add(scrollPane);
		
		//Ver Insumo
		lVerInsumo = new JLabel("<html>Elija un insumo para ver que plantas necesitan de este.</html>");
		lVerInsumo.setFont(new Font("Tahoma", 0, 14));
		lVerInsumo.setForeground(c0);
		lVerInsumo.setBounds(565, 420, 180, 60);
		pCuerpo.add(lVerInsumo);
		//Boton Seleccionar
		bVer = new JButton("Ver");
		bVer.setBackground(c2);
		bVer.setFont(new Font("Tahoma", 0, 14));
		bVer.setForeground(c0);
		bVer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione un insumo en la tabla para poder visualizar las plantas que requieren stock del mismo.");
				} else {
					//TODO Error, Mostrar Plantas con insumo faltante y mejor camino desde acopio a puerto final
					
					mg.remarcarNodos(datos.mapa.necesitaInsumo(insumos.get(tabla.getSelectedRowCount())));
					mg.repaint();
				}
			}
		});
		bVer.setBounds(750, 430, 100, 35);
		pCuerpo.add(bVer);
				
		//Boton Atrás
		bAtras = new JButton("Atrás");
		bAtras.setBackground(c2);
		bAtras.setFont(new Font("Tahoma", 0, 14));
		bAtras.setForeground(c0);
		bAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu(datos);
				dispose();
			}
		});
		bAtras.setBounds(750, 490, 100, 35);
		pCuerpo.add(bAtras);
		
		
		
		this.setVisible(true);
	}
}

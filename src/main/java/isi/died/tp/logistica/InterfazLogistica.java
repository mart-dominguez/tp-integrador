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
import isi.died.tp.dominio.Planta;
import isi.died.tp.grafico.MapaGrafico;
import isi.died.tp.interfaz.Menu;
import isi.died.tp.interfaz.planta.ModeloTablaPlanta;

public class InterfazLogistica extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo, lMensaje, lVerInsumo, lVerPlanta;
	private JLabel lLogistica, lInsumos, lPlantas;
	private JTable tabla, tablaP;
	private JScrollPane scrollPane, scrollPaneP;
	private JButton bAtras, bVer, bVerP;
	private Color c0;
	private Color c1;
	private Color c2;
//	private Color c3;
	private ArrayList<Insumo> insumos;
	private ArrayList<Planta> plantas;

	public InterfazLogistica(Datos datos) {
			
		c0 = new Color(232, 232, 232);
		c1 = new Color(85, 136, 163);
		c2 = new Color(20, 83, 116);
//		c3 = new Color(0, 51, 78);
		
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
		scrollPane.setBounds(560, 40, 290, 180);
		scrollPane.setBackground(c0);
		scrollPane.setVisible(true);
		scrollPane.setViewportView(tabla);
		pCuerpo.add(scrollPane);
		
		//Ver Insumo
		lVerInsumo = new JLabel("<html>Elija un insumo para ver que plantas necesitan de este.</html>");
		lVerInsumo.setFont(new Font("Tahoma", 0, 14));
		lVerInsumo.setForeground(c0);
		lVerInsumo.setBounds(565, 210, 180, 60);
		pCuerpo.add(lVerInsumo);
		//Boton Ver
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
					//Mostrar Plantas con insumo faltante y mejor camino desde acopio a puerto final
					mg.remarcarNodos(datos.mapa.necesitaInsumo(insumos.get(tabla.getSelectedRow())));
					mg.repaint();
					pCuerpo.repaint();
				}
			}
		});
		bVer.setBounds(750, 225, 100, 35);
		pCuerpo.add(bVer);
			
		
		//Insumos
		lPlantas = new JLabel("Plantas: ");
		lPlantas.setFont(new Font("Tahoma", 1, 24));
		lPlantas.setForeground(c0);
		lPlantas.setBounds(565, 260, 150, 30);
		pCuerpo.add(lPlantas);
		//Tabla
		plantas = datos.mapa.getPlantas();
		ModeloTablaPlanta mtip = new ModeloTablaPlanta(plantas);
		tablaP = new JTable(mtip);
		tablaP.setBackground(c0);
//		tablaP.getColumn("ID").setPreferredWidth(90);
//		tablaP.getColumn("Nombre").setPreferredWidth(200);
		tablaP.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaP.setFillsViewportHeight(true);
		tablaP.setLayout(null);
		scrollPaneP = new JScrollPane();
		scrollPaneP.setBounds(560, 290, 290, 150);
		scrollPaneP.setBackground(c0);
		scrollPaneP.setVisible(true);
		scrollPaneP.setViewportView(tablaP);
		pCuerpo.add(scrollPaneP);
		
		//Ver Insumo
		lVerPlanta = new JLabel("<html>Elija una planta para ver el recorrido.</html>");
		lVerPlanta.setFont(new Font("Tahoma", 0, 14));
		lVerPlanta.setForeground(c0);
		lVerPlanta.setBounds(565, 430, 180, 60);
		pCuerpo.add(lVerPlanta);
		//Boton Ver
		bVerP = new JButton("Ver");
		bVerP.setBackground(c2);
		bVerP.setFont(new Font("Tahoma", 0, 14));
		bVerP.setForeground(c0);
		bVerP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tablaP.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione una planta en la tabla para poder visualizar el recorrido.");
				} else {
					//TODO Mostrar mejor camino desde acopio a puerto final
					//
//					mg.remarcarRutas();
					mg.repaint();
					pCuerpo.repaint();
				}
			}
		});
		bVerP.setBounds(750, 445, 100, 35);
		pCuerpo.add(bVerP);
		
		
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

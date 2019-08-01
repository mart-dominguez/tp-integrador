package isi.died.tp.interfaz.general;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.grafico.MapaGrafico;
import isi.died.tp.interfaz.Menu;
import isi.died.tp.interfaz.planta.ModeloTablaPlanta;
import isi.died.tp.logistica.ModeloTablaInsumoLogistica;

public class InterfazGeneral extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo, lMensajeP, lMensajeFM, lVerInsumo;
	private JLabel lPlantas, lFlujoM, lInsumos;
	private JTable tablaPlanta, tablaInsumos;
	private JScrollPane scrollPanePlanta, scrollPaneInsumos;
	private JButton bAtras, bVer;
	private JComboBox<Planta> cbPlanta1, cbPlanta2;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private ArrayList<Insumo> insumos;

	public InterfazGeneral(Datos datos) {
			
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
		
		//Gestión general
		lPlantas = new JLabel("Plantas: ");
		lPlantas.setFont(new Font("Tahoma", 1, 24));
		lPlantas.setForeground(c0);
		lPlantas.setBounds(20, 10, 120, 30);
		pCuerpo.add(lPlantas);
		
		ArrayList<Planta> plantas = new ArrayList<Planta>(datos.mapa.pageRank());
		//Tabla Plantas
		ModeloTablaPlanta mbp = new ModeloTablaPlanta(plantas);
		tablaPlanta = new JTable(mbp);
		tablaPlanta.getColumn("ID").setPreferredWidth(80);
		tablaPlanta.getColumn("Nombre").setPreferredWidth(250);
		tablaPlanta.getColumn("Costo total").setPreferredWidth(70);
		
		tablaPlanta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaPlanta.setFillsViewportHeight(true);
		tablaPlanta.setLayout(null);
		
		scrollPanePlanta = new JScrollPane();
		scrollPanePlanta.setBounds(15, 50, 400, 270);
		scrollPanePlanta.setBackground(c0);
		scrollPanePlanta.setVisible(true);
		scrollPanePlanta.setViewportView(tablaPlanta);
		scrollPanePlanta.getViewport().setView(tablaPlanta);
		pCuerpo.add(scrollPanePlanta);
		
		//Mensaje
		lMensajeP = new JLabel("* Se muestran por importancia (Page Rank).");
		lMensajeP.setFont(new Font("Tahoma", 0, 14));
		lMensajeP.setForeground(c0);
		lMensajeP.setBounds(25, 320, 300, 25);
		pCuerpo.add(lMensajeP);
		
		//Flujo maximo
		lFlujoM = new JLabel("<html>Flujo máximo permitdo entre las plantas de la red: " + datos.mapa.capacidadMax() + " Kg</html>");
		lFlujoM.setFont(new Font("Tahoma", 1, 16));
		lFlujoM.setForeground(c0);
		lFlujoM.setBounds(20, 340, 300, 80);
		pCuerpo.add(lFlujoM);
		
		//Insumos
		lInsumos = new JLabel("Insumos: ");
		lInsumos.setFont(new Font("Tahoma", 1, 24));
		lInsumos.setForeground(c0);
		lInsumos.setBounds(470, 10, 150, 30);
		pCuerpo.add(lInsumos);
		
		//Tabla Insumos
		scrollPaneInsumos = new JScrollPane();
		scrollPaneInsumos.setVisible(false);
		
		//Ver Insumo
		lVerInsumo = new JLabel("<html>Elija una planta para ver los insumos que necesita.</html>");
		lVerInsumo.setFont(new Font("Tahoma", 0, 14));
		lVerInsumo.setForeground(c0);
		lVerInsumo.setBounds(590, 45, 230, 60);
		pCuerpo.add(lVerInsumo);
		//Boton Seleccionar
		bVer = new JButton("Ver");
		bVer.setBackground(c2);
		bVer.setFont(new Font("Tahoma", 0, 14));
		bVer.setForeground(c0);
		bVer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tablaPlanta.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione un planta en la tabla de Plantas para poder visualizar insumos faltantes.");
				} else {
					ModeloTablaInsumoGeneral mtig = new ModeloTablaInsumoGeneral(plantas.get(tablaPlanta.getSelectedRow()).nececidadStock());
					tablaInsumos = new JTable(mtig);
					tablaInsumos.setBackground(c0);
					tablaInsumos.getColumn("ID").setPreferredWidth(100);
					tablaInsumos.getColumn("Nombre").setPreferredWidth(170);
					tablaInsumos.getColumn("Cant. faltante").setPreferredWidth(100);
					tablaInsumos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					tablaInsumos.setFillsViewportHeight(true);
					tablaInsumos.setLayout(null);
					scrollPaneInsumos.setBounds(470, 100, 370, 360);
					scrollPaneInsumos.setBackground(c0);
					scrollPaneInsumos.setVisible(true);
					scrollPaneInsumos.setViewportView(tablaInsumos);
					scrollPaneInsumos.getViewport().setView(tablaInsumos);
					pCuerpo.add(scrollPaneInsumos);
					scrollPaneInsumos.repaint();
					repaint();
				}
			}
		});
		bVer.setBounds(475, 50, 100, 35);
		pCuerpo.add(bVer);
		
		
//		lMensajeFM = new JLabel("Calcular flujo máximo entre plantas");
//		lMensajeFM.setFont(new Font("Tahoma", 0, 14));
//		lMensajeFM.setForeground(c0);
//		lMensajeFM.setBounds(25, 375, 300, 25);
//		pCuerpo.add(lMensajeFM);
		
//		//CombosBox de plantas
//		cbPlanta1 = new JComboBox<Planta>();
//		cbPlanta1.setBounds(25, 410, 170, 24);
//		cbPlanta1.setBackground(c0);
//		cbPlanta1.setFont(new Font("Tahoma", 0, 14));
//		cbPlanta1.setForeground(c3);
//		cbPlanta2 = new JComboBox<Planta>();
//		cbPlanta2.setBounds(25, 450, 170, 24);
//		cbPlanta2.setBackground(c0);
//		cbPlanta2.setFont(new Font("Tahoma", 0, 14));
//		cbPlanta2.setForeground(c3);
//		for (Planta planta : plantas) {
//			cbPlanta1.addItem(planta);
//			cbPlanta2.addItem(planta);
//		}
//		pCuerpo.add(cbPlanta1);
//		pCuerpo.add(cbPlanta2);
		


		
//		//Grafico
//		MapaGrafico mg = new MapaGrafico(datos.mapa);
//		mg.setBackground(c0);
//		pCuerpo.add(mg);
//		
				
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
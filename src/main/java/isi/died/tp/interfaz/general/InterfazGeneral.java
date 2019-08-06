package isi.died.tp.interfaz.general;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Pedido;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Vehiculo;
import isi.died.tp.interfaz.Menu;
import isi.died.tp.interfaz.camion.ModeloTablaVehiculo;
import isi.died.tp.interfaz.planta.ModeloTablaPlanta;

public class InterfazGeneral extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo, lMensajeP, lVerInsumo;
	private JLabel lPlantas, lFlujoM, lInsumos, lCamiones, lSolucion;
	private JTable tablaPlanta, tablaInsumos, tablaCamiones, tablaSoluccion;
	private JScrollPane scrollPanePlanta, scrollPaneInsumos, scrollPaneCamiones, scrollPaneSolucion;
	private JButton bAtras, bVer, bSolucion;
	private Color c0;
	private Color c1;
	private Color c2;
//	private Color c3;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Pedido> pedidos;

	public InterfazGeneral(Datos datos) {
			
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
		
		//Gestión general
		lPlantas = new JLabel("Plantas: ");
		lPlantas.setFont(new Font("Tahoma", 1, 24));
		lPlantas.setForeground(c0);
		lPlantas.setBounds(20, 10, 120, 30);
		pCuerpo.add(lPlantas);
		
		ArrayList<Planta> plantas = new ArrayList<Planta>(datos.mapa.pageRank());
		//Tabla Plantas
		ModeloTablaPlanta mtp = new ModeloTablaPlanta(plantas);
		tablaPlanta = new JTable(mtp);
		tablaPlanta.getColumn("ID").setPreferredWidth(80);
		tablaPlanta.getColumn("Nombre").setPreferredWidth(250);
		tablaPlanta.getColumn("Costo total").setPreferredWidth(70);
		
		tablaPlanta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaPlanta.setFillsViewportHeight(true);
		tablaPlanta.setLayout(null);
		
		scrollPanePlanta = new JScrollPane();
		scrollPanePlanta.setBounds(15, 50, 400, 170);
		scrollPanePlanta.setBackground(c0);
		scrollPanePlanta.setVisible(true);
		scrollPanePlanta.setViewportView(tablaPlanta);
		scrollPanePlanta.getViewport().setView(tablaPlanta);
		pCuerpo.add(scrollPanePlanta);
		
		//Mensaje
		lMensajeP = new JLabel("Se muestran por importancia (Page Rank).");
		lMensajeP.setFont(new Font("Tahoma", 0, 14));
		lMensajeP.setForeground(c0);
		lMensajeP.setBounds(140, 15, 300, 25);
		pCuerpo.add(lMensajeP);
		
		//Flujo maximo
		lFlujoM = new JLabel("<html>Flujo máximo permitdo entre las plantas de la red: " + datos.mapa.capacidadMax() + " Kg</html>");
		lFlujoM.setFont(new Font("Tahoma", 1, 14));
		lFlujoM.setForeground(c0);
		lFlujoM.setBounds(20, 200, 380, 80);
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
		lVerInsumo.setBounds(590, 40, 230, 60);
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
					try {
						ModeloTablaInsumoGeneral mtig = new ModeloTablaInsumoGeneral(plantas.get(tablaPlanta.getSelectedRow()).nececidadStock());
						tablaInsumos = new JTable(mtig);
						tablaInsumos.setBackground(c0);
						tablaInsumos.getColumn("ID").setPreferredWidth(100);
						tablaInsumos.getColumn("Nombre").setPreferredWidth(170);
						tablaInsumos.getColumn("Cant. faltante").setPreferredWidth(100);
						tablaInsumos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						tablaInsumos.setFillsViewportHeight(true);
						tablaInsumos.setLayout(null);
						scrollPaneInsumos.setBounds(470, 95, 370, 160);
						scrollPaneInsumos.setBackground(c0);
						scrollPaneInsumos.setVisible(true);
						scrollPaneInsumos.setViewportView(tablaInsumos);
						scrollPaneInsumos.getViewport().setView(tablaInsumos);
						pCuerpo.add(scrollPaneInsumos);
						scrollPaneInsumos.repaint();
						repaint();						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Error al cargar la tabla de camiones, cominiquese con servicio técnico");
					}
				}
			}
		});
		bVer.setBounds(475, 50, 100, 35);
		pCuerpo.add(bVer);
		
		lCamiones = new JLabel("Camiones: ");
		lCamiones.setFont(new Font("Tahoma", 1, 24));
		lCamiones.setForeground(c0);
		lCamiones.setBounds(20, 265, 150, 30);
		pCuerpo.add(lCamiones);
		
		//Tabla Camiones
		vehiculos = datos.mapa.getVehiculosAL();
		ModeloTablaVehiculo mtv = new ModeloTablaVehiculo(vehiculos);
		tablaCamiones = new JTable(mtv);
		tablaCamiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaCamiones.setFillsViewportHeight(true);
		tablaCamiones.setLayout(null);
		
		scrollPaneCamiones = new JScrollPane();
		scrollPaneCamiones.setBounds(15, 295, 400, 140);
		scrollPaneCamiones.setBackground(c0);
		scrollPaneCamiones.setVisible(true);
		scrollPaneCamiones.setViewportView(tablaCamiones);
		scrollPaneCamiones.getViewport().setView(tablaCamiones);
		pCuerpo.add(scrollPaneCamiones);
		
		
		//Solucion
		lSolucion = new JLabel("Pedidos: ");
		lSolucion.setFont(new Font("Tahoma", 1, 24));
		lSolucion.setForeground(c0);
		lSolucion.setBounds(470, 265, 150, 30);
		pCuerpo.add(lSolucion);
		
		//Tabla Solucion
		scrollPaneSolucion = new JScrollPane();
		scrollPaneSolucion.setVisible(false);
		
		//Boton Generar solución
		bSolucion = new JButton("Generar Pedidos");
		bSolucion.setBackground(c2);
		bSolucion.setFont(new Font("Tahoma", 0, 14));
		bSolucion.setForeground(c0);
		bSolucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( tablaCamiones.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione un camión para generar los pedidos.");
				} else {
					//Mostrar lista de pedidos
					if(JOptionPane.showConfirmDialog(null, "Al generar pedidos, los pedidos anteriores se eliminarán. ¿Desea continuar?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						try {
							vehiculos.get(tablaCamiones.getSelectedRow()).getPedidos().clear();
							pedidos = new ArrayList<Pedido>(datos.mapa.vehiculoOptimo(vehiculos.get(tablaCamiones.getSelectedRow())));
							ModeloTablaPedido mtp = new ModeloTablaPedido(pedidos);						
							tablaSoluccion = new JTable(mtp);
							tablaSoluccion.setBackground(c0);
							tablaSoluccion.getColumn("ID").setPreferredWidth(30);
							tablaSoluccion.getColumn("Insumo").setPreferredWidth(60);
							tablaSoluccion.getColumn("Cantidad").setPreferredWidth(25);
							tablaSoluccion.getColumn("Peso (Kg)").setPreferredWidth(40);
							tablaSoluccion.getColumn("Origen").setPreferredWidth(50);
							tablaSoluccion.getColumn("Destino").setPreferredWidth(50);
							tablaSoluccion.getColumn("Precio").setPreferredWidth(40);
							tablaSoluccion.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
							tablaSoluccion.setFillsViewportHeight(true);
							tablaSoluccion.setLayout(null);
							scrollPaneSolucion.setBounds(470, 295, 370, 140);
							scrollPaneSolucion.setBackground(c0);
							scrollPaneSolucion.setVisible(true);
							scrollPaneSolucion.setViewportView(tablaSoluccion);
							scrollPaneSolucion.getViewport().setView(tablaSoluccion);
							pCuerpo.add(scrollPaneSolucion);
							scrollPaneSolucion.repaint();
							repaint();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Error al cargar la tabla de pedidos, comuniquese con servicio técnico");
						}
					}
				}
			}
		});
		bSolucion.setBounds(245, 460, 160, 45);
		pCuerpo.add(bSolucion);
				
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
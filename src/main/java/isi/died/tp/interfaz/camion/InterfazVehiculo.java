package isi.died.tp.interfaz.camion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Vehiculo;
import isi.died.tp.interfaz.Menu;


public class InterfazVehiculo extends JFrame{
	
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JPanel pCuerpoBusqueda;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lCamiones, lBuscar;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JButton bCrear;
	private JButton bEditar;
	private JButton bEliminar;
	private JButton bAtras;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private ArrayList<Vehiculo> vehiculos;
	

	public InterfazVehiculo(Datos datos, ArrayList<Vehiculo> vs) {

		this.vehiculos = vs;
		
		c0 = new Color(232, 232, 232);
		c1 = new Color(85, 136, 163);
		c2 = new Color(20, 83, 116);
		c3 = new Color(0, 51, 78);
		
		this.setBounds(0, 0, 700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(c0);
		this.setTitle("Camiones - Gestion de Logística");

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
		
		lCamiones = new JLabel("Camiones: ");
		lCamiones.setFont(new Font("Tahoma", 1, 24));
		lCamiones.setForeground(c0);
		lCamiones.setBounds(20, 10, 150, 30);
		pCuerpo.add(lCamiones);
		
		
		//Tabla
		ModeloTablaVehiculo mtv = new ModeloTablaVehiculo(vehiculos);
		tabla = new JTable(mtv);
		tabla.getColumn("ID").setPreferredWidth(80);
		tabla.getColumn("Marca").setPreferredWidth(95);
		tabla.getColumn("Modelo").setPreferredWidth(95);
		tabla.getColumn("Dominio").setPreferredWidth(80);
		tabla.getColumn("Año").setPreferredWidth(50);
		tabla.getColumn("Costo/Km").setPreferredWidth(90);
		tabla.getColumn("Líquido").setPreferredWidth(50);
		tabla.getColumn("Capacidad").setPreferredWidth(90);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 50, 630, 310);
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
				Vehiculo vehiculo = new Vehiculo();
				new EditarVehiculo(datos, vehiculo, false);
				dispose();
			}
		});
		bCrear.setBounds(380, 10, 85, 35);
		pCuerpo.add(bCrear);
		
		bEditar = new JButton("Editar");
		bEditar.setBackground(c2);
		bEditar.setFont(new Font("Tahoma", 0, 14));
		bEditar.setForeground(c0);
		bEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione un vehículo en la tabla para que pueda ser modificado.");
				} else {
					new EditarVehiculo(datos, vehiculos.get(tabla.getSelectedRow()), true);
					dispose();
				}
			}
		});
		bEditar.setBounds(470, 10, 85, 35);
		pCuerpo.add(bEditar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setBackground(c2);
		bEliminar.setFont(new Font("Tahoma", 0, 14));
		bEliminar.setForeground(c0);
		bEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione el vehículo que desea eliminar.");
				} else {
					int mensaje = new JOptionPane().showConfirmDialog(null, "¿Estás seguro de que desea eliminar el vehículo?", "Mensaje", JOptionPane.YES_NO_OPTION);
					if(mensaje == JOptionPane.YES_OPTION) {
						datos.mapa.eliminarVehiculo(vehiculos.get(tabla.getSelectedRow()));
						new InterfazVehiculo(datos, new ArrayList<Vehiculo>(datos.mapa.getVehiculosAL()));
						dispose();
					}
				}
			}
		});
		bEliminar.setBounds(560, 10, 85, 35);
		pCuerpo.add(bEliminar);

		//Botón Atras
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
		bAtras.setBounds(545, 370, 100, 35);
		pCuerpo.add(bAtras);
		

		this.setVisible(true);
	}
	
}

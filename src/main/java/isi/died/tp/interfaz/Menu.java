package isi.died.tp.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Vehiculo;
import isi.died.tp.interfaz.camion.InterfazVehiculo;
import isi.died.tp.interfaz.general.InterfazGeneral;
import isi.died.tp.interfaz.insumo.InterfazInsumo;
import isi.died.tp.interfaz.planta.InterfazPlanta;
import isi.died.tp.logistica.InterfazLogistica;

public class Menu extends JFrame {
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JButton bLogistica, bGeneral, bPlanta, bCamiones, bInsumos, bRutas;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	

	public Menu(Datos datos) {
				
		c0 = new Color(232, 232, 232);
		c1 = new Color(85, 136, 163);
		c2 = new Color(20, 83, 116);
		c3 = new Color(0, 51, 78);
		
		this.setLayout(null);
		this.setBounds(0, 0, 700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(c0);
		this.setTitle("Menu - Gestion de Logística");

		pNombre = new JPanel();
		pNombre.setBounds(10, 20, 660, 100);
		pNombre.setBackground(c1);
		add(pNombre);

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
		pCuerpo.setBounds(10, 130, 660, 300);
		pCuerpo.setBackground(c1);
		add(pCuerpo);
		
		
		bLogistica = new JButton("Logística");
		bLogistica.setBackground(c2);
		bLogistica.setFont(new Font("Tahoma", 0, 35));
		bLogistica.setForeground(c0);
		bLogistica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazLogistica(datos);
				dispose();
			}
		});
		bLogistica.setBounds(30, 20, 300, 80);
		pCuerpo.add(bLogistica);
		
		bGeneral = new JButton("Gest. General");
		bGeneral.setBackground(c2);
		bGeneral.setFont(new Font("Tahoma", 0, 35));
		bGeneral.setForeground(c0);
		bGeneral.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazGeneral(datos);
				dispose();
			}
		});
		bGeneral.setBounds(340, 20, 300, 80);
		pCuerpo.add(bGeneral);



		bInsumos = new JButton("Insumos");
		bInsumos.setBackground(c2);
		bInsumos.setFont(new Font("Tahoma", 0, 35));
		bInsumos.setForeground(c0);
		bInsumos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				ArrayList insumos = (ArrayList) datos.mapa.getInsumos().inOrden();
				InterfazInsumo interfazInsumo = new InterfazInsumo(datos, new ArrayList<Insumo>(datos.mapa.getInsumos().inOrden()));
				dispose();
			}
		});
		bInsumos.setBounds(30, 110, 300, 80);
		pCuerpo.add(bInsumos);

		bCamiones = new JButton("Camiones");
		bCamiones.setBackground(c2);
		bCamiones.setFont(new Font("Tahoma", 0, 35));
		bCamiones.setForeground(c0);
		bCamiones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Vehiculo> vehiculos = datos.mapa.getVehiculosAL();
				new InterfazVehiculo(datos, vehiculos);
				dispose();
			}
		});
		bCamiones.setBounds(340, 110, 300, 80);
		pCuerpo.add(bCamiones);
		
		bPlanta = new JButton("Plantas");
		bPlanta.setBackground(c2);
		bPlanta.setFont(new Font("Tahoma", 0, 35));
		bPlanta.setForeground(c0);
		bPlanta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazPlanta(datos);
				dispose();
			}
		});
		bPlanta.setBounds(30, 200, 300, 80);
		pCuerpo.add(bPlanta);
		
		bRutas = new JButton("Rutas");
		bRutas.setBackground(c2);
		bRutas.setFont(new Font("Tahoma", 0, 35));
		bRutas.setForeground(c0);
		bRutas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		bRutas.setBounds(340, 200, 300, 80);
		pCuerpo.add(bRutas);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
//		Menu menu = new Menu(datos);
//		menu.setResizable(false);
	}
}

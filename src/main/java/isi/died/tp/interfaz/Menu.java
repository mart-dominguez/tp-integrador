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

import isi.died.tp.dominio.Insumo;
import isi.died.tp.interfaz.insumo.InterfazInsumo;

public class Menu extends JFrame {
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JButton bPlanta;
	private JButton bCamiones;
	private JButton bInsumos;
	private JButton bRutas;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	

	public Menu() {
				
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
		pCuerpo.setBounds(10, 130, 660, 190);
		pCuerpo.setBackground(c1);
		add(pCuerpo);

		bPlanta = new JButton("Plantas");
		bPlanta.setBackground(c2);
		bPlanta.setFont(new Font("Tahoma", 0, 35));
		bPlanta.setForeground(c0);
		bPlanta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		bPlanta.setBounds(20, 10, 300, 80);
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
		bRutas.setBounds(330, 10, 300, 80);
		pCuerpo.add(bRutas);

		bInsumos = new JButton("Insumos");
		bInsumos.setBackground(c2);
		bInsumos.setFont(new Font("Tahoma", 0, 35));
		bInsumos.setForeground(c0);
		bInsumos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazInsumo interfazInsumo = new InterfazInsumo();
				dispose();
			}
		});
		bInsumos.setBounds(20, 100, 300, 80);
		pCuerpo.add(bInsumos);

		bCamiones = new JButton("Camiones");
		bCamiones.setBackground(c2);
		bCamiones.setFont(new Font("Tahoma", 0, 35));
		bCamiones.setForeground(c0);
		bCamiones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		bCamiones.setBounds(330, 100, 300, 80);
		pCuerpo.add(bCamiones);
		
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
//		menu.setBounds(0, 0, 700, 600);
//		menu.setVisible(true);
		menu.setResizable(false);
//		menu.setLocationRelativeTo(null);
	}
}

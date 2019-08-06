package isi.died.tp.interfaz.ruta;

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
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.estructuras.Vertice;
import isi.died.tp.interfaz.planta.InterfazPlanta;

public class EditarRuta extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lPlanta;
	private JLabel lPlanta1, lPlanta2, lDistancia, lDuracion, lPesoMax;
	private JComboBox<Planta> cbPlanta1, cbPlanta2;
	private JTextField tfPlanta1, tfPlanta2, tfDuracion, tfDistancia, tfPesoMax;
	private JButton bGuardar, bCancelar;
	ArrayList<Planta> plantas;
	
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	
	public EditarRuta(Datos datos, Ruta ruta, boolean b) {
		
		
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
		this.setTitle("Planta - Gestion de Logística");

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

		lPlanta = new JLabel("Planta: ");
		lPlanta.setFont(new Font("Tahoma", 1, 24));
		lPlanta.setForeground(c0);
		lPlanta.setBounds(20, 10, 150, 30);
		pCuerpo.add(lPlanta);
		
		//Planta1
		lPlanta1 = new JLabel("Planta inicial: ");
		lPlanta1.setFont(new Font("Tahoma", 1, 16));
		lPlanta1.setForeground(c0);
		lPlanta1.setBounds(30, 50, 150, 30);
		pCuerpo.add(lPlanta1);
		
		//Planta2
		lPlanta2 = new JLabel("Planta final: ");
		lPlanta2.setFont(new Font("Tahoma", 1, 16));
		lPlanta2.setForeground(c0);
		lPlanta2.setBounds(30, 90, 150, 30);
		pCuerpo.add(lPlanta2);
		
		if (b) {
			tfPlanta1 = new JTextField(ruta.getInicio().toString());
			tfPlanta1.setBounds(190, 50, 200, 24);
			tfPlanta1.setEditable(false);
			tfPlanta1.setBackground(c0);
			tfPlanta1.setFont(new Font("Tahoma", 0, 14));
			tfPlanta1.setForeground(c3);
			tfPlanta1.setHorizontalAlignment(JTextField.RIGHT);
			pCuerpo.add(tfPlanta1);
			tfPlanta2 = new JTextField(ruta.getFin().toString());
			tfPlanta2.setBounds(190, 90, 200, 24);
			tfPlanta2.setEditable(false);
			tfPlanta2.setBackground(c0);
			tfPlanta2.setFont(new Font("Tahoma", 0, 14));
			tfPlanta2.setForeground(c3);
			tfPlanta2.setHorizontalAlignment(JTextField.RIGHT);
			pCuerpo.add(tfPlanta2);
		} else {
			try {
				cbPlanta1 = new JComboBox<Planta>();
				cbPlanta1.setBounds(190, 50, 200, 24);
				cbPlanta1.setBackground(c0);
				cbPlanta1.setFont(new Font("Tahoma", 0, 14));
				cbPlanta1.setForeground(c3);
				cbPlanta2 = new JComboBox<Planta>();
				cbPlanta2.setBounds(190, 90, 200, 24);
				cbPlanta2.setBackground(c0);
				cbPlanta2.setFont(new Font("Tahoma", 0, 14));
				cbPlanta2.setForeground(c3);
				plantas = new ArrayList<Planta>(datos.mapa.getPlantas());
				for (Planta planta : plantas) {
					if(planta.equals(ruta.getInicio())) cbPlanta1.setSelectedItem(planta);
					if(planta.equals(ruta.getFin())) cbPlanta2.setSelectedItem(planta);
					cbPlanta1.addItem(planta);
					cbPlanta2.addItem(planta);
				}
				pCuerpo.add(cbPlanta1);
				pCuerpo.add(cbPlanta2);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar las plantas");
			}
		}

		
		//Distancia
		lDistancia = new JLabel("Distancia: ");
		lDistancia.setFont(new Font("Tahoma", 1, 16));
		lDistancia.setForeground(c0);
		lDistancia.setBounds(30, 130, 150, 30);
		pCuerpo.add(lDistancia);
		
		tfDistancia = new JTextField(ruta.getDistancia().toString());
		tfDistancia.setBounds(190, 130, 200, 24);
		tfDistancia.setBackground(c0);
		tfDistancia.setFont(new Font("Tahoma", 0, 14));
		tfDistancia.setForeground(c3);
		tfDistancia.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfDistancia);
		
		//Duracion
		lDuracion = new JLabel("Duración: ");
		lDuracion.setFont(new Font("Tahoma", 1, 16));
		lDuracion.setForeground(c0);
		lDuracion.setBounds(30, 170, 150, 30);
		pCuerpo.add(lDuracion);
		
		tfDuracion = new JTextField(ruta.getDuracion().toString());
		tfDuracion.setBounds(190, 170, 200, 24);
		tfDuracion.setBackground(c0);
		tfDuracion.setFont(new Font("Tahoma", 0, 14));
		tfDuracion.setForeground(c3);
		tfDuracion.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfDuracion);
		
		//Duracion
		lPesoMax = new JLabel("Peso máximo: ");
		lPesoMax.setFont(new Font("Tahoma", 1, 16));
		lPesoMax.setForeground(c0);
		lPesoMax.setBounds(30, 210, 150, 30);
		pCuerpo.add(lPesoMax);
		
		tfPesoMax = new JTextField(ruta.getPesoMax().toString());
		tfPesoMax.setBounds(190, 210, 200, 24);
		tfPesoMax.setBackground(c0);
		tfPesoMax.setFont(new Font("Tahoma", 0, 14));
		tfPesoMax.setForeground(c3);
		tfPesoMax.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfPesoMax);
		
		//Cancelar
		bCancelar = new JButton("Cancelar");
		bCancelar.setBackground(c2);
		bCancelar.setFont(new Font("Tahoma", 0, 14));
		bCancelar.setForeground(c0);
		bCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazRuta(datos, datos.mapa.getRutas());
				dispose();
			}
		});
		bCancelar.setBounds(465, 360, 85, 35);
		pCuerpo.add(bCancelar);
		
		//Guardar
		bGuardar = new JButton("Guardar");
		bGuardar.setBackground(c2);
		bGuardar.setFont(new Font("Tahoma", 0, 14));
		bGuardar.setForeground(c0);
		bGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Guardo Planta
				if(JOptionPane.showConfirmDialog(null, "¿Desea cambiar los datos de la Ruta?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						if(!b) {
							ruta.setInicio(new Vertice<Planta>((Planta) cbPlanta1.getSelectedItem()));
							ruta.setFin(new Vertice<Planta>((Planta) cbPlanta2.getSelectedItem()));
						}
						ruta.setDistancia(Double.valueOf(tfDistancia.getText()));
						ruta.setDuracion(Double.valueOf((tfDuracion.getText())));
						ruta.setPesoMax(Double.valueOf(tfPesoMax.getText()));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Problema al cargar los datos, comuniquese con el servicio técnico.");
					}
					if (!b) {
						try {
							datos.mapa.nuevaRuta(ruta);							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Problema al agregar la ruta, comuniquese con el servicio técnico.");
						}
					}
					new InterfazRuta(datos, datos.mapa.getRutas());
					dispose();
				}
			}
		});
		bGuardar.setBounds(560, 360, 85, 35);
		pCuerpo.add(bGuardar);
		
		this.setVisible(true);
	}
}

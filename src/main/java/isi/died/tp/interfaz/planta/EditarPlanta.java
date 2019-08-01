package isi.died.tp.interfaz.planta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.dominio.Vehiculo;
import isi.died.tp.interfaz.camion.InterfazVehiculo;
import isi.died.tp.interfaz.insumo.EditarInsumo;
import isi.died.tp.interfaz.insumo.InterfazInsumo;

public class EditarPlanta extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lPlanta;
	private JLabel lId, lNombre;
//	private JComboBox<UnidadMedida> cbUnidadMedida;
//	private JCheckBox checkRefrigerado;
	private JTextField tfId, tfNombre;
//	private JScrollPane scrollDescripcion;
//	private JTextArea taDescripcion;
	private JButton bGuardar, bCancelar;
	
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;

	public EditarPlanta(Datos datos, Planta planta, boolean b) {
		
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
		
		//Id
		lId = new JLabel("ID: ");
		lId.setFont(new Font("Tahoma", 1, 16));
		lId.setForeground(c0);
		lId.setBounds(30, 50, 150, 30);
		pCuerpo.add(lId);
		
		tfId = new JTextField(planta.getId().toString());
		tfId.setEditable(false);
		tfId.setBounds(120, 50, 200, 24);
		tfId.setBackground(c0);
		tfId.setFont(new Font("Tahoma", 0, 14));
		tfId.setForeground(c3);
		tfId.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfId);
		
		//Nombre
		lNombre = new JLabel("Nombre: ");
		lNombre.setFont(new Font("Tahoma", 1, 16));
		lNombre.setForeground(c0);
		lNombre.setBounds(30, 90, 150, 30);
		pCuerpo.add(lNombre);
		
		tfNombre = new JTextField(planta.getNombre());
		tfNombre.setBounds(120, 90, 200, 24);
		tfNombre.setBackground(c0);
		tfNombre.setFont(new Font("Tahoma", 0, 14));
		tfNombre.setForeground(c3);
		tfNombre.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfNombre);
		
		
		
		//Cancelar
		bCancelar = new JButton("Cancelar");
		bCancelar.setBackground(c2);
		bCancelar.setFont(new Font("Tahoma", 0, 14));
		bCancelar.setForeground(c0);
		bCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazPlanta(datos);
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
				if(new JOptionPane().showConfirmDialog(null, "¿Desea cambiar los datos del insumo?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					planta.setNombre(tfNombre.getText());
					if (!b) {
						datos.mapa.addNodo(planta);
					}
					new InterfazPlanta(datos);
					dispose();
				}
			}
		});
		bGuardar.setBounds(560, 360, 85, 35);
		pCuerpo.add(bGuardar);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
	}
}
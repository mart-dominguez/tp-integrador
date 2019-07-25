package isi.died.tp.interfaz.insumo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.UnidadMedida;

public class BuscarInsumo extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lInsumos;
	private JLabel lId, lNombre, lCosto, lStock, lPeso, lUnidadMedida, lRefrigerado, lDescripcion;
	private JComboBox<UnidadMedida> cbUnidadMedida;
	private JCheckBox checkRefrigerado;
	private JTextField tfId, tfNombre, tfCosto, tfStock, tfPeso;
	private JScrollPane scrollDescripcion;
	private JTextArea taDescripcion;
	private JButton bGuardar, bCancelar;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private Insumo insumo;
	
	
	public BuscarInsumo(){
		//TODO Modificar todo, solo es una copia como plantilla
		
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
		this.setTitle("Buscar Insumo - Gestion de Logística");

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

		lInsumos = new JLabel("Buscar insumo: ");
		lInsumos.setFont(new Font("Tahoma", 1, 24));
		lInsumos.setForeground(c0);
		lInsumos.setBounds(20, 10, 150, 30);
		pCuerpo.add(lInsumos);
		
		//Id
		lId = new JLabel("ID: ");
		lId.setFont(new Font("Tahoma", 1, 16));
		lId.setForeground(c0);
		lId.setBounds(30, 50, 150, 30);
		pCuerpo.add(lId);
		
		tfId = new JTextField("");
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
		
		tfNombre = new JTextField("");
		tfNombre.setBounds(120, 90, 200, 24);
		tfNombre.setBackground(c0);
		tfNombre.setFont(new Font("Tahoma", 0, 14));
		tfNombre.setForeground(c3);
		tfNombre.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfNombre);
		
		//Costo
		lCosto = new JLabel("Costo: ");
		lCosto.setFont(new Font("Tahoma", 1, 16));
		lCosto.setForeground(c0);
		lCosto.setBounds(30, 130, 150, 30);
		pCuerpo.add(lCosto);
		
		tfCosto = new JTextField("");
		tfCosto.setBounds(120, 130, 200, 24);
		tfCosto.setBackground(c0);
		tfCosto.setFont(new Font("Tahoma", 0, 14));
		tfCosto.setForeground(c3);
		tfCosto.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfCosto);
		
		//Stock
		lStock = new JLabel("Stock: ");
		lStock.setFont(new Font("Tahoma", 1, 16));
		lStock.setForeground(c0);
		lStock.setBounds(30, 170, 150, 30);
		pCuerpo.add(lStock);
		
		tfStock = new JTextField("");
		tfStock.setBounds(120, 170, 200, 24);
		tfStock.setBackground(c0);
		tfStock.setFont(new Font("Tahoma", 0, 14));
		tfStock.setForeground(c3);
		tfStock.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfStock);
		
		//Peso
		lPeso = new JLabel("Peso: ");
		lPeso.setFont(new Font("Tahoma", 1, 16));
		lPeso.setForeground(c0);
		lPeso.setBounds(30, 210, 150, 30);
		pCuerpo.add(lPeso);
		
		tfPeso = new JTextField("");
		tfPeso.setBounds(120, 210, 200, 24);
		tfPeso.setBackground(c0);
		tfPeso.setFont(new Font("Tahoma", 0, 14));
		tfPeso.setForeground(c3);
		tfPeso.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfPeso);
		
		//Unidad de Medida
		cbUnidadMedida = new JComboBox<UnidadMedida>();
		cbUnidadMedida.setModel(new DefaultComboBoxModel(UnidadMedida.values()));
		cbUnidadMedida.setBounds(340, 210, 80, 24);
		cbUnidadMedida.setBackground(c0);
		cbUnidadMedida.setFont(new Font("Tahoma", 0, 14));
		cbUnidadMedida.setForeground(c3);
		pCuerpo.add(cbUnidadMedida);
		
		//Refrigerado
		lRefrigerado = new JLabel("Refrigerado: ");
		lRefrigerado.setFont(new Font("Tahoma", 1, 16));
		lRefrigerado.setForeground(c0);
		lRefrigerado.setBounds(30, 250, 150, 30);
		pCuerpo.add(lRefrigerado);
		
		checkRefrigerado = new JCheckBox("", true);
		checkRefrigerado.setBackground(null);
		checkRefrigerado.setBounds(145, 250, 30, 30);
		checkRefrigerado.setSelected(true);
		pCuerpo.add(checkRefrigerado);
		
		//Descripción
		lDescripcion = new JLabel("Descripción: ");
		lDescripcion.setFont(new Font("Tahoma", 1, 16));
		lDescripcion.setForeground(c0);
		lDescripcion.setBounds(30, 290, 150, 30);
		pCuerpo.add(lDescripcion);
		
		taDescripcion = new JTextArea("");
		scrollDescripcion = new JScrollPane(taDescripcion);
		scrollDescripcion.setBounds(150, 295, 270, 100);
		taDescripcion.setBackground(c0);
		taDescripcion.setFont(new Font("Tahoma", 0, 14));
		taDescripcion.setForeground(c3);
		taDescripcion.setLineWrap(true);
		taDescripcion.setWrapStyleWord(true);
		pCuerpo.add(scrollDescripcion);
		
		
		//Cancelar
		bCancelar = new JButton("Cancelar");
		bCancelar.setBackground(c2);
		bCancelar.setFont(new Font("Tahoma", 0, 14));
		bCancelar.setForeground(c0);
		bCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
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
				//
			}
		});
		bGuardar.setBounds(560, 360, 85, 35);
		pCuerpo.add(bGuardar);

		
		
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		BuscarInsumo buscarinsumo = new BuscarInsumo();
		
	}
}

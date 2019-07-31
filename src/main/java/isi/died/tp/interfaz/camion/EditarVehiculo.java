package isi.died.tp.interfaz.camion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Vehiculo;
import isi.died.tp.interfaz.insumo.InterfazInsumo;

public class EditarVehiculo extends JFrame {
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lCamiones;
	private JLabel lId, lMarca, lModelo, lDominio, lAnio, lCostoKm, lLiquido, lCapacidad;
	private JCheckBox cbLiquido;
	private JTextField tfId, tfMarca, tfModelo, tfDominio, tfAnio, tfCostoKm, tfCapacidad;
	private JButton bGuardar, bCancelar;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private Vehiculo vehiculo;

	public EditarVehiculo(Datos datos, Vehiculo vehiculo) {

		this.vehiculo = vehiculo;

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
		this.setTitle("Insumo - Gestion de Logística");

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

		// Id
		lId = new JLabel("ID: ");
		lId.setFont(new Font("Tahoma", 1, 16));
		lId.setForeground(c0);
		lId.setBounds(30, 50, 150, 30);
		pCuerpo.add(lId);

		tfId = new JTextField(vehiculo.getId().toString());
		tfId.setEditable(false);
		tfId.setBounds(180, 50, 200, 24);
		tfId.setBackground(c0);
		tfId.setFont(new Font("Tahoma", 0, 14));
		tfId.setForeground(c3);
		tfId.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfId);

		// Marca
		lMarca = new JLabel("Marca: ");
		lMarca.setFont(new Font("Tahoma", 1, 16));
		lMarca.setForeground(c0);
		lMarca.setBounds(30, 90, 150, 30);
		pCuerpo.add(lMarca);

		tfMarca = new JTextField(vehiculo.getMarca());
		tfMarca.setBounds(180, 90, 200, 24);
		tfMarca.setBackground(c0);
		tfMarca.setFont(new Font("Tahoma", 0, 14));
		tfMarca.setForeground(c3);
		tfMarca.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfMarca);

		// Modelo
		lModelo = new JLabel("Modelo: ");
		lModelo.setFont(new Font("Tahoma", 1, 16));
		lModelo.setForeground(c0);
		lModelo.setBounds(30, 130, 150, 30);
		pCuerpo.add(lModelo);

		tfModelo = new JTextField(vehiculo.getModelo());
		tfModelo.setBounds(180, 130, 200, 24);
		tfModelo.setBackground(c0);
		tfModelo.setFont(new Font("Tahoma", 0, 14));
		tfModelo.setForeground(c3);
		tfModelo.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfModelo);

		// Dominio
		lDominio = new JLabel("Dominio: ");
		lDominio.setFont(new Font("Tahoma", 1, 16));
		lDominio.setForeground(c0);
		lDominio.setBounds(30, 170, 150, 30);
		pCuerpo.add(lDominio);

		tfDominio = new JTextField(vehiculo.getDominio());
		tfDominio.setBounds(180, 170, 200, 24);
		tfDominio.setBackground(c0);
		tfDominio.setFont(new Font("Tahoma", 0, 14));
		tfDominio.setForeground(c3);
		tfDominio.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfDominio);

		// Año
		lAnio = new JLabel("Año: ");
		lAnio.setFont(new Font("Tahoma", 1, 16));
		lAnio.setForeground(c0);
		lAnio.setBounds(30, 210, 150, 30);
		pCuerpo.add(lAnio);

		tfAnio = new JTextField(vehiculo.getAnio().toString());
		tfAnio.setBounds(180, 210, 200, 24);
		tfAnio.setBackground(c0);
		tfAnio.setFont(new Font("Tahoma", 0, 14));
		tfAnio.setForeground(c3);
		tfAnio.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfAnio);

		// Costo/Km
		lCostoKm = new JLabel("Costo por kilómetro: ");
		lCostoKm.setFont(new Font("Tahoma", 1, 14));
		lCostoKm.setForeground(c0);
		lCostoKm.setBounds(30, 250, 150, 30);
		pCuerpo.add(lCostoKm);

		tfCostoKm = new JTextField(vehiculo.getCostoKm().toString());
		tfCostoKm.setBounds(180, 250, 200, 24);
		tfCostoKm.setBackground(c0);
		tfCostoKm.setFont(new Font("Tahoma", 0, 14));
		tfCostoKm.setForeground(c3);
		tfCostoKm.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfCostoKm);

		// Liquido
		lLiquido = new JLabel("Transporte líquido: ");
		lLiquido.setFont(new Font("Tahoma", 1, 14));
		lLiquido.setForeground(c0);
		lLiquido.setBounds(30, 290, 150, 30);
		pCuerpo.add(lLiquido);

		cbLiquido = new JCheckBox("", vehiculo.isTransportaLiquido());
		cbLiquido.setBackground(null);
		cbLiquido.setBounds(180, 290, 30, 30);
		cbLiquido.setSelected(vehiculo.isTransportaLiquido());
		pCuerpo.add(cbLiquido);

		// Capacidad en peso
		lCapacidad = new JLabel("Capasidad (Kg): ");
		lCapacidad.setFont(new Font("Tahoma", 1, 14));
		lCapacidad.setForeground(c0);
		lCapacidad.setBounds(30, 340, 150, 30);
		pCuerpo.add(lCapacidad);

		tfCapacidad = new JTextField(vehiculo.getPesoMax().toString());
		tfCapacidad.setBounds(180, 340, 200, 24);
		tfCapacidad.setBackground(c0);
		tfCapacidad.setFont(new Font("Tahoma", 0, 14));
		tfCapacidad.setForeground(c3);
		tfCapacidad.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfCapacidad);

		// Cancelar
		bCancelar = new JButton("Cancelar");
		bCancelar.setBackground(c2);
		bCancelar.setFont(new Font("Tahoma", 0, 14));
		bCancelar.setForeground(c0);
		bCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazVehiculo(datos, datos.vehiculos);
				dispose();
			}
		});
		bCancelar.setBounds(465, 360, 85, 35);
		pCuerpo.add(bCancelar);

		// Guardar
		bGuardar = new JButton("Guardar");
		bGuardar.setBackground(c2);
		bGuardar.setFont(new Font("Tahoma", 0, 14));
		bGuardar.setForeground(c0);
		bGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Guardar Vehiculo creado
			}
		});
		bGuardar.setBounds(560, 360, 85, 35);
		pCuerpo.add(bGuardar);

		this.setVisible(true);
	}


	public static void main(String[] args) {
//		Vehiculo camion = new Vehiculo();
//		camion.setMarca("Marca");
//		camion.setModelo("Modeloo");
//		camion.setDominio("AA555AA");
//		camion.setAnio(2018);
//		camion.setCostoKm(521.0);
//		camion.setTransportaLiquido(true);
//		camion.setPesoMax(4985.0);
//		new EditarVehiculo(camion);
	}
}

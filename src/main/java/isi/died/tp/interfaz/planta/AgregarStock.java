package isi.died.tp.interfaz.planta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;
import isi.died.tp.dominio.Insumo;

public class AgregarStock extends JFrame{
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lPlanta;
	private JLabel lId, lInsumo, lCantidad, lPuntoPedido;
	private JComboBox<Insumo> cbInsumo;
	private JTextField tfId, tfCantidad, tfPuntoPedido;
	private JButton bGuardar, bCancelar;
	private Stock stock;
	
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;

	public AgregarStock(Datos datos, Planta planta) {
		
		stock = new Stock();
		
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

		lPlanta = new JLabel("Planta: " + planta.getNombre());
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
		
		tfId = new JTextField(stock.getId().toString());
		tfId.setEditable(false);
		tfId.setBounds(190, 50, 200, 24);
		tfId.setBackground(c0);
		tfId.setFont(new Font("Tahoma", 0, 14));
		tfId.setForeground(c3);
		tfId.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfId);
		
		//Insumo
		lInsumo = new JLabel("Insumo: ");
		lInsumo.setFont(new Font("Tahoma", 1, 16));
		lInsumo.setForeground(c0);
		lInsumo.setBounds(30, 90, 150, 30);
		pCuerpo.add(lInsumo);
		
		try {
			cbInsumo = new JComboBox<Insumo>();
			cbInsumo.setBounds(190, 90, 200, 24);
			cbInsumo.setBackground(c0);
			cbInsumo.setFont(new Font("Tahoma", 0, 14));
			cbInsumo.setForeground(c3);
			ArrayList<Insumo> insumos = new ArrayList<Insumo>(datos.mapa.getInsumos().inOrden());
			for (Insumo insumo : insumos) {
				cbInsumo.addItem(insumo);
			}
			pCuerpo.add(cbInsumo);			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los insumos");
		}
		
		//Cantidad
		lCantidad = new JLabel("Cantidad: ");
		lCantidad.setFont(new Font("Tahoma", 1, 16));
		lCantidad.setForeground(c0);
		lCantidad.setBounds(30, 130, 150, 30);
		pCuerpo.add(lCantidad);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(190, 130, 200, 24);
		tfCantidad.setBackground(c0);
		tfCantidad.setFont(new Font("Tahoma", 0, 14));
		tfCantidad.setForeground(c3);
		tfCantidad.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfCantidad);
		
		//Punto de Pedido
		lPuntoPedido = new JLabel("Punto de pedido: ");
		lPuntoPedido.setFont(new Font("Tahoma", 1, 16));
		lPuntoPedido.setForeground(c0);
		lPuntoPedido.setBounds(30, 170, 150, 30);
		pCuerpo.add(lPuntoPedido);
		
		tfPuntoPedido = new JTextField();
		tfPuntoPedido.setBounds(190, 170, 200, 24);
		tfPuntoPedido.setBackground(c0);
		tfPuntoPedido.setFont(new Font("Tahoma", 0, 14));
		tfPuntoPedido.setForeground(c3);
		tfPuntoPedido.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfPuntoPedido);
		
		//Cancelar
		bCancelar = new JButton("Cancelar");
		bCancelar.setBackground(c2);
		bCancelar.setFont(new Font("Tahoma", 0, 14));
		bCancelar.setForeground(c0);
		bCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazPlanta(datos, datos.mapa.getPlantas());
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
				//Guardo Stock
				if(JOptionPane.showConfirmDialog(null, "¿Desea guardar el stock?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					stock.setInsumo(datos.mapa.buscarInsumoNombre(((Insumo) cbInsumo.getSelectedItem()).getNombre()));
					stock.setCantidad(Integer.valueOf(tfCantidad.getText()));
					stock.setPuntoPedido(Integer.valueOf(tfPuntoPedido.getText()));
					planta.addStock(stock);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Problema al agregar el stock a la planta, comuniquese con el servicio técnico.");
				}
				new InterfazPlanta(datos, datos.mapa.getPlantas());
				dispose();
				}
			}
		});
		bGuardar.setBounds(560, 360, 85, 35);
		pCuerpo.add(bGuardar);
		
		this.setVisible(true);
	}
}

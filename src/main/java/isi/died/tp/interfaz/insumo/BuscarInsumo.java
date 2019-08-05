package isi.died.tp.interfaz.insumo;

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
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.interfaz.TipoBusquedaInsumo;

public class BuscarInsumo extends JFrame{

	private JPanel pNombre;
	private JPanel pCuerpo;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo, lBuscar;;
	private JComboBox<TipoBusquedaInsumo> cbTipoBusqueda;
	private ButtonGroup grupoBotones;
	private JRadioButton rbAsc, rbDesc;
	private JLabel lNombre, lCostoMin, lCostoMax, lStockMin, lStockMax;
	private JTextField tfNombre, tfCostoMin, tfCostoMax, tfStockMin, tfStockMax;
	private JButton bBuscarPorTipo, bAtrasBusqueda;
	private Color c0;
	private Color c1;
	private Color c2;
	private Color c3;
	private ArrayList<Insumo> insumos;
	
	
	
	public BuscarInsumo(Datos datos){
		
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
		this.repaint();
		
		lBuscar = new JLabel("Buscar Insumo por:");
		lBuscar.setFont(new Font("Tahoma", 1, 24));
		lBuscar.setForeground(c0);
		lBuscar.setBounds(30, 20, 250, 30);
		pCuerpo.add(lBuscar);
		
		cbTipoBusqueda = new JComboBox<TipoBusquedaInsumo>();
		cbTipoBusqueda.setModel(new DefaultComboBoxModel(TipoBusquedaInsumo.values()));
		cbTipoBusqueda.setBounds(300, 25, 120, 25);
		cbTipoBusqueda.setBackground(c0);
		cbTipoBusqueda.setFont(new Font("Tahoma", 0, 16));
		cbTipoBusqueda.setForeground(c3);
		pCuerpo.add(cbTipoBusqueda);
		
		rbAsc = new JRadioButton("Ascendente");
		rbAsc.setBounds(450, 20, 120, 25);
		rbAsc.setBackground(c1);
		rbAsc.setFont(new Font("Tahoma", 1, 14));
		rbAsc.setForeground(c0);
		pCuerpo.add(rbAsc);
		
		rbDesc = new JRadioButton("Descendente");
		rbDesc.setBounds(450, 45, 130, 25);
		rbDesc.setBackground(c1);
		rbDesc.setFont(new Font("Tahoma", 1, 14));
		rbDesc.setForeground(c0);
		pCuerpo.add(rbDesc);
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rbAsc);
		grupoBotones.add(rbDesc);
		
		//Nombre
		lNombre = new JLabel("Nombre: ");
		lNombre.setVisible(true);
		lNombre.setFont(new Font("Tahoma", 1, 16));
		lNombre.setForeground(c0);
		lNombre.setBounds(60, 90, 150, 30);
		pCuerpo.add(lNombre);
		
		tfNombre = new JTextField();
		tfNombre.setVisible(true);
		tfNombre.setBounds(150, 92, 200, 24);
		tfNombre.setBackground(c0);
		tfNombre.setFont(new Font("Tahoma", 0, 14));
		tfNombre.setForeground(c3);
		tfNombre.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfNombre);
		
		//Costo
		lCostoMin = new JLabel("Costo mínimo: ");
		lCostoMin.setVisible(false);
		lCostoMin.setFont(new Font("Tahoma", 1, 16));
		lCostoMin.setForeground(c0);
		lCostoMin.setBounds(60, 90, 150, 30);
		pCuerpo.add(lCostoMin);
		
		tfCostoMin = new JTextField();
		tfCostoMin.setVisible(false);
		tfCostoMin.setBounds(200, 92, 200, 24);
		tfCostoMin.setBackground(c0);
		tfCostoMin.setFont(new Font("Tahoma", 0, 14));
		tfCostoMin.setForeground(c3);
		tfCostoMin.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfCostoMin);
		
		lCostoMax = new JLabel("Costo máximo: ");
		lCostoMax.setVisible(false);
		lCostoMax.setFont(new Font("Tahoma", 1, 16));
		lCostoMax.setForeground(c0);
		lCostoMax.setBounds(60, 140, 150, 30);
		pCuerpo.add(lCostoMax);
		
		tfCostoMax = new JTextField();
		tfCostoMax.setVisible(false);
		tfCostoMax.setBounds(200, 142, 200, 24);
		tfCostoMax.setBackground(c0);
		tfCostoMax.setFont(new Font("Tahoma", 0, 14));
		tfCostoMax.setForeground(c3);
		tfCostoMax.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfCostoMax);
		
		//Stock
		lStockMin = new JLabel("Stock mínimo: ");
		lStockMin.setVisible(false);
		lStockMin.setFont(new Font("Tahoma", 1, 16));
		lStockMin.setForeground(c0);
		lStockMin.setBounds(60, 90, 150, 30);
		pCuerpo.add(lStockMin);
		
		tfStockMin = new JTextField();
		tfStockMin.setVisible(false);
		tfStockMin.setBounds(200, 92, 200, 24);
		tfStockMin.setBackground(c0);
		tfStockMin.setFont(new Font("Tahoma", 0, 14));
		tfStockMin.setForeground(c3);
		tfStockMin.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfStockMin);
		
		lStockMax = new JLabel("Stock máximo: ");
		lStockMax.setVisible(false);
		lStockMax.setFont(new Font("Tahoma", 1, 16));
		lStockMax.setForeground(c0);
		lStockMax.setBounds(60, 140, 150, 30);
		pCuerpo.add(lStockMax);
		
		tfStockMax = new JTextField();
		tfStockMax.setVisible(false);
		tfStockMax.setBounds(200, 142, 200, 24);
		tfStockMax.setBackground(c0);
		tfStockMax.setFont(new Font("Tahoma", 0, 14));
		tfStockMax.setForeground(c3);
		tfStockMax.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpo.add(tfStockMax);
		
		cbTipoBusqueda.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {

				if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.NOMBRE) {
					
					lNombre.setVisible(true);
					tfNombre.setVisible(true);
					lCostoMax.setVisible(false);
					lCostoMin.setVisible(false);
					tfCostoMax.setVisible(false);
					tfCostoMin.setVisible(false);
					lStockMax.setVisible(false);
					lStockMin.setVisible(false);
					tfStockMax.setVisible(false);
					tfStockMin.setVisible(false);
					repaint();
					
				} else if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.COSTO){
						
					lNombre.setVisible(false);
					tfNombre.setVisible(false);
					lCostoMax.setVisible(true);
					lCostoMin.setVisible(true);
					tfCostoMax.setVisible(true);
					tfCostoMin.setVisible(true);
					lStockMax.setVisible(false);
					lStockMin.setVisible(false);
					tfStockMax.setVisible(false);
					tfStockMin.setVisible(false);
					
					repaint();
					
					
				} else if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.STOCK) {
					
					lNombre.setVisible(false);
					tfNombre.setVisible(false);
					lCostoMax.setVisible(false);
					lCostoMin.setVisible(false);
					tfCostoMax.setVisible(false);
					tfCostoMin.setVisible(false);
					lStockMax.setVisible(true);
					lStockMin.setVisible(true);
					tfStockMax.setVisible(true);
					tfStockMin.setVisible(true);
					repaint();
				}
			}
		});
		
		//Botón Buscar
		bBuscarPorTipo = new JButton("Buscar");
		bBuscarPorTipo.setBackground(c2);
		bBuscarPorTipo.setFont(new Font("Tahoma", 1, 22));
		bBuscarPorTipo.setForeground(c0);
		bBuscarPorTipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(rbAsc.isSelected() || rbDesc.isSelected())) {
					JOptionPane.showMessageDialog(null, "Seleccione si desea realizar la búsqueda ascendente o descendente.");
				} else {
					ArrayList<Insumo> lista = new ArrayList<Insumo>();
					ArrayList<Insumo> listaAux;
					if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.NOMBRE) {
						try {
							
							if (rbAsc.isSelected()) {
								//Busqueda por Nombre Ascendente
								listaAux = new ArrayList<Insumo>(datos.mapa.listarXnombreAce());
							} else {
								//Busqueda por Nombre Descendente
								listaAux = new ArrayList<Insumo>(datos.mapa.listarXnombreDec());
							}
							for (Insumo insumo : listaAux) {
								if (insumo.getNombre().contains(tfNombre.getText())) {
									lista.add(insumo);
								}
							}
							insumos = lista;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Error al realizar la busqueda");
						}
					} else if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.COSTO){
						try {
							Double costoMin = (tfCostoMin.getText().isEmpty()) ? Double.MIN_VALUE : Double.valueOf(tfCostoMin.getText());;
							Double costoMax = (tfCostoMax.getText().isEmpty()) ? Double.MAX_VALUE : Double.valueOf(tfCostoMax.getText());
							if (rbAsc.isSelected()) {
								//Busqueda por Costo Ascendente
								listaAux = new ArrayList<Insumo>(datos.mapa.listarXprecioAce());
							} else {
								//Busqueda por Costo Descendente
								listaAux = new ArrayList<Insumo>(datos.mapa.listarXprecioDec());
							}
							for (Insumo insumo : listaAux) {
								if(insumo.getCosto() >= costoMin && insumo.getCosto() <= costoMax) {
									lista.add(insumo);
								}
							}
							insumos = lista;							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda");
						}
					} else if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.STOCK) {
						try {
							Double stockMin = (tfStockMin.getText().isEmpty()) ? Double.MIN_VALUE : Double.valueOf(tfStockMin.getText());
							Double stockMax = (tfStockMax.getText().isEmpty()) ? Double.MAX_VALUE : Double.valueOf(tfStockMax.getText());
							if (rbAsc.isSelected()) {
								//Busqueda por Stock Ascendente
								listaAux = new ArrayList<Insumo>(datos.mapa.listarXcantidadStockAce());
							} else {
								//Busqueda por Stock Descendente
								listaAux = new ArrayList<Insumo>(datos.mapa.listarXcantidadStockDec());
							}
							for (Insumo insumo : listaAux) {
								if(insumo.getCosto() >= stockMin && insumo.getCosto() <= stockMax) {
									lista.add(insumo);
								}
							}
							insumos = lista;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Error al realizar la busqueda");
						}
					}
					new InterfazInsumo(datos, insumos);
					dispose();
				}
			}
		});
		bBuscarPorTipo.setBounds(250, 180, 155, 55);
		pCuerpo.add(bBuscarPorTipo);
		
		//Botón Atras de Busqueda
		bAtrasBusqueda = new JButton("Atrás");
		bAtrasBusqueda.setBackground(c2);
		bAtrasBusqueda.setFont(new Font("Tahoma", 0, 14));
		bAtrasBusqueda.setForeground(c0);
		bAtrasBusqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazInsumo(datos, new ArrayList<Insumo>(datos.mapa.getInsumos().inOrden()));
				dispose();
			}
		});
		bAtrasBusqueda.setBounds(545, 370, 100, 35);
		pCuerpo.add(bAtrasBusqueda);
		
		
		this.setVisible(true);
	}

}

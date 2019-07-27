package isi.died.tp.interfaz.insumo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.interfaz.DatosPrueba;
import isi.died.tp.interfaz.Menu;
import isi.died.tp.interfaz.TipoBusquedaInsumo;

public class InterfazInsumo extends JFrame {
	private JPanel pNombre;
	private JPanel pCuerpo;
	private JPanel pCuerpoBusqueda;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JLabel lInsumos, lBuscar;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JButton bCrear;
	private JButton bEditar;
	private JButton bEliminar;
	private JButton bBuscar;
	private JButton bAtras;
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
	

	public InterfazInsumo() {
		
		DatosPrueba dp = new DatosPrueba();// TODO prueba
		insumos = dp.getInsumos();
		
//		insumos = new ArrayList<Insumo>();
		
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
		this.setTitle("Insumos - Gestion de Logística");

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
		
		lInsumos = new JLabel("Insumos: ");
		lInsumos.setFont(new Font("Tahoma", 1, 24));
		lInsumos.setForeground(c0);
		lInsumos.setBounds(20, 10, 150, 30);
		pCuerpo.add(lInsumos);
		
		//Tabla
		ModeloTablaInsumo mbi = new ModeloTablaInsumo(dp.getInsumos()); //
		tabla = new JTable(mbi);
		tabla.getColumn("ID").setPreferredWidth(25);
		tabla.getColumn("Nombre").setPreferredWidth(100);
		tabla.getColumn("Costo").setPreferredWidth(70);
		tabla.getColumn("Stock").setPreferredWidth(50);
		tabla.getColumn("Peso").setPreferredWidth(50);
		tabla.getColumn("Unidad").setPreferredWidth(50);
		tabla.getColumn("Refrigerado").setPreferredWidth(50);
		tabla.getColumn("Descripción").setPreferredWidth(235);
		
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
				Insumo insumo = new Insumo();
				new EditarInsumo(insumo);
				dispose();
			}
		});
		bCrear.setBounds(275, 10, 85, 35);
		pCuerpo.add(bCrear);
		
		bEditar = new JButton("Editar");
		bEditar.setBackground(c2);
		bEditar.setFont(new Font("Tahoma", 0, 14));
		bEditar.setForeground(c0);
		bEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione un insumo en la tabla para que pueda ser modificado.");
				} else {
					new EditarInsumo(insumos.get(tabla.getSelectedRow()));
					dispose();
				}
			}
		});
		bEditar.setBounds(365, 10, 85, 35);
		pCuerpo.add(bEditar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setBackground(c2);
		bEliminar.setFont(new Font("Tahoma", 0, 14));
		bEliminar.setForeground(c0);
		bEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Seleccione el insumo que desea eliminar.");
				} else {
					int mensaje = new JOptionPane().showConfirmDialog(null, "¿Estás seguro de que desea eliminar el producto?", "Mensaje", JOptionPane.YES_NO_OPTION);
					if(mensaje == JOptionPane.YES_OPTION) {
						//TODO Eliminar un producto
					}
				}
			}
		});
		bEliminar.setBounds(455, 10, 85, 35);
		pCuerpo.add(bEliminar);

		
		bBuscar = new JButton("Buscar");
		bBuscar.setBackground(c2);
		bBuscar.setFont(new Font("Tahoma", 0, 14));
		bBuscar.setForeground(c0);
		bBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new BuscarInsumo();
				buscarInsumo();
				pCuerpo.setVisible(false);
			}
		});
		bBuscar.setBounds(545, 10, 100, 35);
		pCuerpo.add(bBuscar);
		
		bAtras = new JButton("Atrás");
		bAtras.setBackground(c2);
		bAtras.setFont(new Font("Tahoma", 0, 14));
		bAtras.setForeground(c0);
		bAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu();
				dispose();
			}
		});
		bAtras.setBounds(545, 370, 100, 35);
		pCuerpo.add(bAtras);
		
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		InterfazInsumo interfazInsumo = new InterfazInsumo();
//		interfazInsumo.setBounds(0, 0, 700, 600);
//		interfazInsumo.setVisible(true);
//		interfazInsumo.setResizable(false);
//		interfazInsumo.setLocationRelativeTo(null);
	}
	
	public void buscarInsumo() {
		
		pCuerpoBusqueda = new JPanel();
		pCuerpoBusqueda.setLayout(null);
		pCuerpoBusqueda.setBounds(10, 130, 660, 415);
		pCuerpoBusqueda.setBackground(c1);
		this.add(pCuerpoBusqueda);
		this.repaint();
		
		lBuscar = new JLabel("Buscar Insumo por:");
		lBuscar.setFont(new Font("Tahoma", 1, 24));
		lBuscar.setForeground(c0);
		lBuscar.setBounds(30, 20, 250, 30);
		pCuerpoBusqueda.add(lBuscar);
		
		cbTipoBusqueda = new JComboBox<TipoBusquedaInsumo>();
		cbTipoBusqueda.setModel(new DefaultComboBoxModel(TipoBusquedaInsumo.values()));
		cbTipoBusqueda.setBounds(300, 25, 120, 25);
		cbTipoBusqueda.setBackground(c0);
		cbTipoBusqueda.setFont(new Font("Tahoma", 0, 16));
		cbTipoBusqueda.setForeground(c3);
		pCuerpoBusqueda.add(cbTipoBusqueda);
		
		rbAsc = new JRadioButton("Ascendente");
		rbAsc.setBounds(450, 20, 120, 25);
		rbAsc.setBackground(c1);
		rbAsc.setFont(new Font("Tahoma", 1, 14));
		rbAsc.setForeground(c0);
		pCuerpoBusqueda.add(rbAsc);
		
		rbDesc = new JRadioButton("Descendente");
		rbDesc.setBounds(450, 45, 130, 25);
		rbDesc.setBackground(c1);
		rbDesc.setFont(new Font("Tahoma", 1, 14));
		rbDesc.setForeground(c0);
		pCuerpoBusqueda.add(rbDesc);
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rbAsc);
		grupoBotones.add(rbDesc);
		
		//Nombre
		lNombre = new JLabel("Nombre: ");
		lNombre.setVisible(true);
		lNombre.setFont(new Font("Tahoma", 1, 16));
		lNombre.setForeground(c0);
		lNombre.setBounds(60, 90, 150, 30);
		pCuerpoBusqueda.add(lNombre);
		
		tfNombre = new JTextField();
		tfNombre.setVisible(true);
		tfNombre.setBounds(150, 92, 200, 24);
		tfNombre.setBackground(c0);
		tfNombre.setFont(new Font("Tahoma", 0, 14));
		tfNombre.setForeground(c3);
		tfNombre.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpoBusqueda.add(tfNombre);
		
		//Costo
		lCostoMin = new JLabel("Costo mínimo: ");
		lCostoMin.setVisible(false);
		lCostoMin.setFont(new Font("Tahoma", 1, 16));
		lCostoMin.setForeground(c0);
		lCostoMin.setBounds(60, 90, 150, 30);
		pCuerpoBusqueda.add(lCostoMin);
		
		tfCostoMin = new JTextField();
		tfCostoMin.setVisible(false);
		tfCostoMin.setBounds(200, 92, 200, 24);
		tfCostoMin.setBackground(c0);
		tfCostoMin.setFont(new Font("Tahoma", 0, 14));
		tfCostoMin.setForeground(c3);
		tfCostoMin.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpoBusqueda.add(tfCostoMin);
		
		lCostoMax = new JLabel("Costo máximo: ");
		lCostoMax.setVisible(false);
		lCostoMax.setFont(new Font("Tahoma", 1, 16));
		lCostoMax.setForeground(c0);
		lCostoMax.setBounds(60, 140, 150, 30);
		pCuerpoBusqueda.add(lCostoMax);
		
		tfCostoMax = new JTextField();
		tfCostoMax.setVisible(false);
		tfCostoMax.setBounds(200, 142, 200, 24);
		tfCostoMax.setBackground(c0);
		tfCostoMax.setFont(new Font("Tahoma", 0, 14));
		tfCostoMax.setForeground(c3);
		tfCostoMax.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpoBusqueda.add(tfCostoMax);
		
		//Stock
		lStockMin = new JLabel("Stock mínimo: ");
		lStockMin.setVisible(false);
		lStockMin.setFont(new Font("Tahoma", 1, 16));
		lStockMin.setForeground(c0);
		lStockMin.setBounds(60, 90, 150, 30);
		pCuerpoBusqueda.add(lStockMin);
		
		tfStockMin = new JTextField();
		tfStockMin.setVisible(false);
		tfStockMin.setBounds(200, 92, 200, 24);
		tfStockMin.setBackground(c0);
		tfStockMin.setFont(new Font("Tahoma", 0, 14));
		tfStockMin.setForeground(c3);
		tfStockMin.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpoBusqueda.add(tfStockMin);
		
		lStockMax = new JLabel("Stock máximo: ");
		lStockMax.setVisible(false);
		lStockMax.setFont(new Font("Tahoma", 1, 16));
		lStockMax.setForeground(c0);
		lStockMax.setBounds(60, 140, 150, 30);
		pCuerpoBusqueda.add(lStockMax);
		
		tfStockMax = new JTextField();
		tfStockMax.setVisible(false);
		tfStockMax.setBounds(200, 142, 200, 24);
		tfStockMax.setBackground(c0);
		tfStockMax.setFont(new Font("Tahoma", 0, 14));
		tfStockMax.setForeground(c3);
		tfStockMax.setHorizontalAlignment(JTextField.RIGHT);
		pCuerpoBusqueda.add(tfStockMax);
		
		cbTipoBusqueda.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
					
					if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.NOMBRE) {
						
						if (rbAsc.isSelected()) {
							//TODO Busqueda por Nombre Ascendente
							
						} else if (rbDesc.isSelected()) {
							//TODO Busqueda por Nombre Descendente
							
						}
						
						pCuerpoBusqueda.setVisible(false);
						pCuerpo.setVisible(true);
					} else if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.COSTO){
							
						if (rbAsc.isSelected()) {
							//TODO Busqueda por Costo Ascendente
							
						} else if (rbDesc.isSelected()) {
							//TODO Busqueda por Costo Descendente
							
						}
						
						pCuerpoBusqueda.setVisible(false);
						pCuerpo.setVisible(true);
						
					} else if (cbTipoBusqueda.getSelectedItem() == TipoBusquedaInsumo.STOCK) {
						
						if (rbAsc.isSelected()) {
							//TODO Busqueda por Stock Ascendente
							
						} else if (rbDesc.isSelected()) {
							//TODO Busqueda por Stock Descendente
							
						}
						
						pCuerpoBusqueda.setVisible(false);
						pCuerpo.setVisible(true);
					}
				
				}

			}
		});
		bBuscarPorTipo.setBounds(250, 180, 155, 55);
		pCuerpoBusqueda.add(bBuscarPorTipo);
		
		//Botón Atras de Busqueda
		bAtrasBusqueda = new JButton("Atrás");
		bAtrasBusqueda.setBackground(c2);
		bAtrasBusqueda.setFont(new Font("Tahoma", 0, 14));
		bAtrasBusqueda.setForeground(c0);
		bAtrasBusqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pCuerpoBusqueda.setVisible(false);
				pCuerpo.setVisible(true);
			}
		});
		bAtrasBusqueda.setBounds(545, 370, 100, 35);
		pCuerpoBusqueda.add(bAtrasBusqueda);
		
	}
	
}

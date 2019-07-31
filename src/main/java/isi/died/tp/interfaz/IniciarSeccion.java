package isi.died.tp.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import isi.died.tp.datos.Datos;

public class IniciarSeccion extends JFrame{
	
	private JPanel pNombre;
	private JLabel lNombreEmpresa;
	private JLabel lTitulo;
	private JPanel pCuerpo;
	private JLabel lUsuario;
	private JTextField tfUsuario;
	private JLabel lPass;
	private JPasswordField pfPass;
	private JButton bAcceder;
	public static Datos datos;
	
	
	public IniciarSeccion() {
		
		this.datos = new Datos();
		
		Color c0 = new Color(232, 232, 232);
		Color c1 = new Color(85, 136, 163);
		Color c2 = new Color(20, 83, 116);
		Color c3 = new Color(0, 51, 78);
		
		setBounds(0, 0, 500, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(c0);
		setTitle("Iniciar Sección - Gestion de Logística");
		
		pNombre = new JPanel();
		pNombre.setBounds(10, 20, 460, 100);
		pNombre.setBackground(c1);
		add(pNombre);

		lNombreEmpresa = new JLabel(" Nombre Empresa ");
		lNombreEmpresa.setFont(new Font("Tahoma", 3, 45));
		lNombreEmpresa.setForeground(c0);
		pNombre.add(lNombreEmpresa);
		
		lTitulo = new JLabel("--- Gestión Logística ---");
		lTitulo.setFont(new Font("Tahoma", 0, 24));
		lTitulo.setForeground(c0);
		pNombre.add(lTitulo);
		
		pCuerpo = new JPanel();
		pCuerpo.setLayout(null);
		pCuerpo.setBounds(10, 130, 460, 425);
		pCuerpo.setBackground(c1);
		add(pCuerpo);
		
		lUsuario = new JLabel("Usuario:");
		lUsuario.setBounds(35, 20, 150, 35);
		lUsuario.setFont(new Font("Tahoma", 1, 14));
		lUsuario.setForeground(c0);
		pCuerpo.add(lUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(35, 55, 200, 25);
		tfUsuario.setFont(new Font("Tahoma", 0, 14));
		tfUsuario.setForeground(c3);
		pCuerpo.add(tfUsuario);
		
		lPass = new JLabel("Contraseña:");
		lPass.setBounds(35, 90, 150, 35);
		lPass.setFont(new Font("Tahoma", 1, 14));
		lPass.setForeground(c0);
		pCuerpo.add(lPass);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(35, 125, 200, 25);
		pfPass.setBackground(c0);
		pfPass.setFont(new Font("Tahoma", 0, 14));
		pfPass.setForeground(c3);
		pCuerpo.add(pfPass);
		
		bAcceder = new JButton("Acceder");
		bAcceder.setBackground(c2);
		bAcceder.setFont(new Font("Tahoma", 1, 16));
		bAcceder.setForeground(c0);
		bAcceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Modificar en caso de usar base de datos
				char clave[] = pfPass.getPassword();
				String sClave = new String(clave);
				if (tfUsuario.getText().equals("admin") && sClave.equals("admin")) {
					Menu menu = new Menu(datos);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta, intente con admin en ambos casos");
				}
			}
		});
		bAcceder.setBounds(35, 180, 200, 35);
		pCuerpo.add(bAcceder);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new IniciarSeccion();
//		iniciarSeccion.setBounds(0, 0, 500, 600);
//		iniciarSeccion.setVisible(true);
//		iniciarSeccion.setResizable(false);
//		iniciarSeccion.setLocationRelativeTo(null);
	}
}

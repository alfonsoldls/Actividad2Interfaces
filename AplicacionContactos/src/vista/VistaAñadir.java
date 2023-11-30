package vista;


import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorVistaAñadir;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;


public class VistaAñadir extends JDialog {

	 Vista vista;
	 JTextField cajaNombre, cajaTelefono;
	 JLabel etiqueta1, etiqueta2;
	 JButton botonOK, botonCancel;
	 ControladorVistaAñadir controlador;
	 
	public VistaAñadir(Vista vista) {
		this.vista = vista;
		Image icono = new ImageIcon("imagenes/añadir.png").getImage();
		setIconImage(icono);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Añadir Contacto");
		setLayout(null);
		inicializarVariables();
		setVisible(true);
		establecerListeners();
	}
		
	private void inicializarVariables() {
		
		getContentPane().setBackground(new Color(255, 245, 157));
		
		etiqueta1 = new JLabel("Nombre:");
		etiqueta1.setBounds(78, 82, 63, 13);
		add(etiqueta1);
		
		etiqueta2 = new JLabel("Telefono");
		etiqueta2.setBounds(78, 138, 63, 13);
		add(etiqueta2);
		
		cajaNombre = new JTextField("");
		cajaNombre.setBounds(170, 79, 116, 19);
		add(cajaNombre);
		
		
		cajaTelefono = new JTextField("");
		cajaTelefono.setBounds(170, 135, 116, 19);
		add(cajaTelefono);
		
		botonOK = new JButton ("OK");
		botonOK.setBounds(235, 205, 85, 21);
		add(botonOK);
		
		botonCancel = new JButton ("Cancel");
		botonCancel.setBounds(326, 205, 85, 21);
		add(botonCancel);
		
		}
	
	public void establecerListeners() {
		controlador = new ControladorVistaAñadir (vista,this);
		botonOK.addActionListener(controlador);
		botonCancel.addActionListener(controlador);
	}

	public JTextField getCajaNombre() {
		return cajaNombre;
	}

	public JTextField getCajaTelefono() {
		return cajaTelefono;
	}

	public JButton getBotonOK() {
		return botonOK;
	}

	public JButton getBotonCancel() {
		return botonCancel;
	}

	public void setCajaNombre(JTextField cajaNombre) {
		this.cajaNombre = cajaNombre;
	}

	public void setCajaTelefono(JTextField cajaTelefono) {
		this.cajaTelefono = cajaTelefono;
	}

	public void setBotonOK(JButton botonOK) {
		this.botonOK = botonOK;
	}

	public void setBotonCancel(JButton botonCancel) {
		this.botonCancel = botonCancel;
	}
}

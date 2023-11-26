package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaAgregar extends JDialog{
	
	private JLabel nombreTitulo, telefonoTitulo;
	private JTextField nombreBox, telefonoBox;
	private JButton aceptar, cancelar;
	
	public VentanaAgregar() {
		//Establecemos el tamaño de la ventana secundaria
		setSize(300, 375);
		//Establecemos la posición en pantalla donde aparecerá la ventana.
		//En este caso indicamos que aparezca ne el centro.
		setLocationRelativeTo(null);
		//Establecemos el comportamiento al cerrar la ventana
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Evitamos que el usuario redimensione la ventana
		setResizable(false);
		//Desactivamos el organizador ya que vamos a posicionar los elementos manualmente
		setLayout(null);
		//inicializamos los componentes de la ventana
		inicializarVariables();		
		//Hacemos visible la ventana
		setVisible(true);
	}
	
	public void inicializarVariables() {
		
		getContentPane().setBackground(new Color(255, 167, 129));
		
		nombreTitulo = new JLabel("Nombre");
		nombreTitulo.setFont(new Font("Helvetica", Font.BOLD, 16));
		nombreTitulo.setForeground(new Color(91, 14, 45));
		nombreTitulo.setBounds(115, 5, 100, 30);
		add(nombreTitulo);
		
		nombreBox = new JTextField();
		nombreBox.setBounds(50, 50, 200, 30);
		add(nombreBox);
		
		telefonoTitulo = new JLabel("Teléfono");
		telefonoTitulo.setFont(new Font("Helvetica", Font.BOLD, 16));
		telefonoTitulo.setForeground(new Color(91, 14, 45));
		telefonoTitulo.setBounds(115, 95, 100, 30);
		add(telefonoTitulo);
		
		telefonoBox = new JTextField();
		telefonoBox.setBounds(100, 140, 100, 30);
		add(telefonoBox);
		
		aceptar = new JButton("");
		ImageIcon iconoAceptar = new ImageIcon("src/img/aceptar.png");
		aceptar.setIcon(iconoAceptar);
		aceptar.setBackground(new Color(255, 167, 129));
		aceptar.setBorder(null);
		aceptar.setBounds(25, 230, 75, 75);
		add(aceptar);
		
		cancelar = new JButton("");
		ImageIcon iconoCancelar = new ImageIcon("src/img/cancelar.png");
		cancelar.setIcon(iconoCancelar);
		cancelar.setBackground(new Color(255, 167, 129));
		cancelar.setBorder(null);
		cancelar.setBounds(185, 230, 75, 75);
		add(cancelar);
	}

	public JLabel getNombreTitulo() {
		return nombreTitulo;
	}

	public void setNombreTitulo(JLabel nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}

	public JLabel getTelefonoTitulo() {
		return telefonoTitulo;
	}

	public void setTelefonoTitulo(JLabel telefonoTitulo) {
		this.telefonoTitulo = telefonoTitulo;
	}

	public JTextField getNombreBox() {
		return nombreBox;
	}

	public void setNombreBox(JTextField nombreBox) {
		this.nombreBox = nombreBox;
	}

	public JTextField getTelefonoBox() {
		return telefonoBox;
	}

	public void setTelefonoBox(JTextField telefonoBox) {
		this.telefonoBox = telefonoBox;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	
	
}

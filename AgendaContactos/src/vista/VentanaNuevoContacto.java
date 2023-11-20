package vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorNuevoContacto;

//VENTANA PARA NUEVO CONTACTO
public class VentanaNuevoContacto extends JDialog{
	Vista ventana1;
	JLabel background,titulo, nombre, telefono;
	JTextField campoNombre, campoTelefono;
	JButton ok, cancel;
	ControladorNuevoContacto controlador;
	
	public VentanaNuevoContacto(Vista ventana1) {	//Se le pasa como parametro la ventana principal
		
		this.ventana1 = ventana1;
		Image icono = new ImageIcon("imgs/adduser.png").getImage();
		setIconImage(icono);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null); 
		setLayout(null);
		setComponents();
		setModal(true); 	//Hace que no se pueda tocar otras ventanas de la app hasta que no se cierre.
		setControlador();
		
		
	}
	
	private void setComponents() {
		
		//Pone la imagen de la carpeta como background
		JLabel background = new JLabel(new ImageIcon("imgs/background.jpg"));
		background.setBounds(0, 0, 300, 300);
		background.setBackground(Color.cyan);
		
		//Set Title
		titulo = new JLabel("Nuevo Contacto");
		titulo.setBounds(35, 15, 250, 50);
		titulo.setFont(Vista.setMilkuFont(0, 34f));
		titulo.setForeground(Color.BLACK);
		add(titulo);
		
		//set etiqueta nombre
		nombre = new JLabel("Nombre:");
		nombre.setBounds(35, 75, 75, 25);
		nombre.setFont(Vista.setMilkuFont(0, 20f));
		nombre.setForeground(Color.BLACK);
		add(nombre);
		
		//Set campo nombre
		campoNombre = new JTextField();
		campoNombre.setBounds(125, 75, 125, 25);
		add(campoNombre);

		//set etiqueta telefono
		telefono = new JLabel("Telefono:");
		telefono.setBounds(35, 120, 75, 25);
		telefono.setFont(Vista.setMilkuFont(0, 20f));
		telefono.setForeground(Color.BLACK);
		add(telefono);

		//set campotelefono
		campoTelefono = new JTextField();
		campoTelefono.setBounds(125, 120, 125, 25);
		add(campoTelefono);
		
		//set boton cancel
		cancel = new JButton("Cancelar");
		cancel.setBounds(185, 222, 90, 30);
		add(cancel);
		
		//set boton ok
		ok = new JButton("OK");
		ok.setBounds(118, 222, 60, 30);
		add(ok);
		getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
		add(background);
	}
	
	
	//GETTERS Y SETTERS
	public void setControlador(){
		//Crea un nuevo controlador para la esta ventana y le pasa como parametro la ventana principal y la propia
		controlador = new ControladorNuevoContacto(ventana1,this);
		setListeners();
	}
	
	//pone a la escucha los botones de la ventana
	private void setListeners() {
		ok.addActionListener(controlador);
		cancel.addActionListener(controlador);
		
	}

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	public JTextField getCampoTelefono() {
		return campoTelefono;
	}

	public void setCampoTelefono(JTextField campoTelefono) {
		this.campoTelefono = campoTelefono;
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	
	
	
}

package vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorEditarContacto;


public class VentanaEditarContacto extends JDialog{
	Vista ventana1;
	JLabel titulo, background, nombre, telefono;
	JTextField campoNombre, campoTelefono;
	JButton ok, cancel;
	ControladorEditarContacto controlador;
	
	public VentanaEditarContacto(Vista ventana1) { //Se le pasa como parametro la ventana principal
		this.ventana1 = ventana1;
		Image icono = new ImageIcon("imgs/edituser.png").getImage();
		setIconImage(icono);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setTitle("Editar contacto");
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null); 
		setLayout(null);
		setComponents();
		setModal(true);							//Hace que no se pueda tocar otras ventanas de la app hasta que no se cierre.
		setControlador();
		
		
		
	}
	
	private void setComponents() {
		
		//Pone la imagen de la carpeta como background
		JLabel background = new JLabel(new ImageIcon("imgs/background.jpg"));
		background.setBounds(0, 0, 300, 300);
		background.setBackground(Color.cyan);
		
		//Set Title
		titulo = new JLabel("Editar Contacto");
		titulo.setBounds(35, 15, 250, 50);
		titulo.setFont(Vista.createFont(0, 34f,"fonts/Milku.otf"));
		titulo.setForeground(Color.BLACK);
		add(titulo);
		
		//Set etiqueta nombre
		nombre = new JLabel("Nombre:");
		nombre.setBounds(35, 75, 75, 25);
		nombre.setFont(Vista.createFont(0, 17f,"fonts/Roboto.ttf"));
		nombre.setForeground(Color.BLACK);
		add(nombre);
		
		//Set campo nombre
		campoNombre = new JTextField();
		campoNombre.setBounds(125, 75, 125, 25);
		add(campoNombre);

		//Set etiqueta telefono
		telefono = new JLabel("Telefono:");
		telefono.setBounds(35, 120, 75, 25);
		telefono.setFont(Vista.createFont(0, 17f,"fonts/Roboto.ttf"));
		telefono.setForeground(Color.BLACK);
		add(telefono);

		//Set campo telefono
		campoTelefono = new JTextField();
		campoTelefono.setBounds(125, 120, 125, 25);
		add(campoTelefono);
		
		//Set boton cancel
		cancel = new JButton("Cancelar");
		cancel.setBounds(185, 222, 90, 30);
		add(cancel);
		
		//set boton ok
		ok = new JButton("OK");
		ok.setBounds(118, 222, 60, 30);
		add(ok);
		
		//añade el background a la capa mas atras.
		getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
		add(background);
		
		//añade a los campos la fila seleccionada.
		getSelectedRowToFields();
		
	}
	
	//Este metodo se encarga de meter en los campos nombre y telefono la fila seleccionada a editar.
	private void getSelectedRowToFields() {
		String obtenerNombreSeleccionado = (String) ventana1.getTable().getValueAt(ventana1.getTable().getSelectedRow(), 0);
		String obtenerTelefonoSeleccionado = (String) ventana1.getTable().getValueAt(ventana1.getTable().getSelectedRow(), 1);
		campoNombre.setText(obtenerNombreSeleccionado);
		campoTelefono.setText(obtenerTelefonoSeleccionado);
		
	}
	
	//GETTERS Y SETTERS
	public void setControlador(){
		controlador = new ControladorEditarContacto(ventana1,this);
		setListeners();
	}
	
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

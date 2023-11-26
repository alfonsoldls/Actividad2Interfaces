package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import controlador.Eventos;

public class VentanaPrincipal extends JFrame{

	private JLabel titulo;
	private JTable contactos;
	private JButton agregar;
	private JButton eliminar;
	private JButton editar;
	
	DefaultTableModel model = new DefaultTableModel();
	
	
	public VentanaPrincipal() {
		//Establecemos el tamaño de la ventana principal
		setSize(500, 700);
		//Establecemos la posición en pantalla donde aparecerá la ventana.
		//En este caso indicamos que aparezca ne el centro.
		setLocationRelativeTo(null);
		//Establecemos el comportamiento al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Evitamos que el usuario redimensione la ventana
		setResizable(false);
		//Establecemos un título para la ventana
		setTitle("GESTIÓN DE CONTACTOS");
		//Establecemos una imagen para el logo de la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/icon.png"));
		//Desactivamos el organizador ya que vamos a posicionar los elementos manualmente
		setLayout(null);
		//inicializamos los componentes de la ventana
		inicializarComponentes();		
		//Hacemos visible la ventana
		setVisible(true);
		
	}
	
	private void inicializarComponentes() {
		
		getContentPane().setBackground(new Color(255, 167, 129));
		
		//Creamos el componente titulo
		titulo = new JLabel("GESTIÓN DE CONTACTOS");
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setForeground(new Color(91, 14, 45));
		//Posicionamos y damos tamano a título
		titulo.setBounds(120, 25, 300, 40);//x.setBounds(x,y,w,h);
		//Añadimos título a la ventana
		add(titulo);
		
		//Creamos el componente contactos
		contactos = new JTable();
		//Creamos la cabecera que tendrá la tabla y la tabla
	    String[] columnNames = {"Nombre", "Teléfono"};
	    model.setColumnIdentifiers(columnNames);
	    contactos.setModel(model);
		//Posicionamos y damos tamano a contactos
		contactos.setBounds(50, 100, 400, 400);//x.setBounds(x,y,w,h);
		//Añadimos contactos a la ventana
		add(contactos);
		
		//Envolvemos nuestro JTable en un JScrollPane para permitir el desplazamiento cuando hay más datos 
		//de los que pueden mostrarse en la pantalla a la vez
		JScrollPane scrollTable = new JScrollPane(contactos);
		scrollTable.setBounds(50, 100, 400, 400);
		add(scrollTable);
		
		//Creamos el componente agregar
		agregar = new JButton("");
		
		ImageIcon iconoAgregar = new ImageIcon("src/img/agregar.png");
		
		agregar.setIcon(iconoAgregar);
		agregar.setBackground(new Color(255, 167, 129));
		agregar.setBorder(null);
		//Posicionamos y damos tamano a agregar
		agregar.setBounds(50, 550, 75, 75);//x.setBounds(x,y,w,h);
		//Añadimos agregar a la ventana
		add(agregar);
		
		//Creamos el componente eliminar
		eliminar = new JButton("");
		ImageIcon iconoEliminar = new ImageIcon("src/img/eliminar.png");
		eliminar.setIcon(iconoEliminar);
		eliminar.setBackground(new Color(255, 167, 129));
		eliminar.setBorder(null);
		
		//Posicionamos y damos tamano a eliminar
		eliminar.setBounds(350, 550, 75, 75);//x.setBounds(x,y,w,h);
		//Añadimos eliminar a la ventana
		add(eliminar);
		
		//Creamos el componente editar
		editar = new JButton("");
		//Posicionamos y damos tamano a editar
		ImageIcon iconoEditar = new ImageIcon("src/img/editar.png");
		editar.setIcon(iconoEditar);
		editar.setBackground(new Color(255, 167, 129));
		editar.setBorder(null);
		
		editar.setBounds(200, 550, 75, 75);//x.setBounds(x,y,w,h);
		//Añadimos editar a la ventana
		add(editar);
	}
	
	public void establecerEventos(Eventos eventos) {
		agregar.addActionListener(eventos);
		eliminar.addActionListener(eventos);
		editar.addActionListener(eventos);
		//contactos.getSelectionModel().addListSelectionListener(eventos);
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JTable getContactos() {
		return contactos;
	}

	public void setContactos(JTable contactos) {
		this.contactos = contactos;
	}

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getEditar() {
		return editar;
	}

	public void setEditar(JButton editar) {
		this.editar = editar;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
}

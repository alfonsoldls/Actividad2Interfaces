package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import controlador.Controlador;
import modelo.Contacto;

//VENTANA PRINCIPAL DEL PROYECTO

public class Vista extends JFrame {
	private JLabel titulo, backgroundImage;
	private JButton botonAñadir, botonEditar, botonEliminar, botonBuscar;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel tableModel;
	private Controlador controlador;
	


	public Vista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = new ImageIcon("imgs/icon.png").getImage();
		setIconImage(icono);
		setSize(500, 760);
		setTitle("Contactos");
		setResizable(false);
		setLocationRelativeTo(null); 
		setLayout(null);
		inicializarComponentes();
		cargarDatos();
		setVisible(true);
		
	}
	
	//Carga todos los componentes de la ventana principal
	
	private void inicializarComponentes() {
		
		//SET BACKGROUND
		backgroundImage = new JLabel(new ImageIcon("imgs/agenda.jpeg"));
		backgroundImage.setBounds(0, 0, 500, 730);
		getLayeredPane().add(backgroundImage,Integer.valueOf(Integer.MIN_VALUE));
		JPanel panel = (JPanel)getContentPane();
		panel.setOpaque(false);
		
		//SET TITLE
		titulo = new JLabel("Mis Contactos");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(setMilkuFont(Font.BOLD,42f));
		titulo.setForeground(Color.BLACK);
		titulo.setBounds(102,87,325,157);
		add(titulo);
		
		//Crea y carga la tabla
		createTable();
		
		//SET BOTON AÑADIR
		botonAñadir = new JButton(new ImageIcon("imgs/adduser.png"));
        botonAñadir.setContentAreaFilled(false);
		botonAñadir.setBounds(101, 580, 50, 50);
		botonAñadir.setBorder(null);
		add(botonAñadir);
		
		//SET BOTON EDITAR
		botonEditar = new JButton((new ImageIcon("imgs/edituser.png")));
		botonEditar.setBounds(150, 580, 50, 50);
        botonEditar.setContentAreaFilled(false);
        botonEditar.setBorder(null);
		add(botonEditar);
		
		//SET BOTON ELIMINAR
		botonEliminar = new JButton((new ImageIcon("imgs/deleteuser.png")));
		botonEliminar.setBounds(201, 580, 50, 50);
		botonEliminar.setContentAreaFilled(false);
		botonEliminar.setBorder(null);
		add(botonEliminar);
		
		//SET BOTON BUSCAR
		botonBuscar = new JButton((new ImageIcon("imgs/searchuser.png")));
		botonBuscar.setBounds(370, 580, 50, 50);
		botonBuscar.setContentAreaFilled(false);
		botonBuscar.setBorder(null);
		add(botonBuscar);
		
	}
	
	//Metodo que crea la tabla.
	private void createTable() {
		String[] columnas = {"Nombre","Teléfono"};
		tableModel = new DefaultTableModel(columnas, 0);
		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null); //Hace la tabla que no sea editable desde la interfaz
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //permite seleccionar solo una fila a la vez
		
		
		//Configuracion estilo del Header
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		header.setFont(setMilkuFont(0,15f));
		MatteBorder headerBorder = new MatteBorder(0, 0, 2, 0, Color.BLACK);
		header.setBorder(headerBorder);
		header.setResizingAllowed(false);
		header.setBackground(new Color(0, 200, 255));
		
		
		//Estilos de la tabla
		 DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	     renderer.setHorizontalAlignment(SwingConstants.CENTER);
	     renderer.setBackground(new Color(255,255,255,200));
	     for (int i = 0; i < table.getColumnCount(); i++) {
	          table.getColumnModel().getColumn(i).setCellRenderer(renderer);
	          table.setFont(setMilkuFont(0, 12f));
	     }
	     
	     table.setShowHorizontalLines(false);
	     table.setBackground(Color.white);
	     
	     
		//Metemos la tabla en el JScrollPane
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(101, 275, 324, 300);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		scrollpane.setBorder(borde);
		add(scrollpane);
		
		
	}
	
	//Pone a la escucha los botones de la pantalla principal
	private void setListeners() {
		botonAñadir.addActionListener(controlador);
		botonEditar.addActionListener(controlador);
		botonEliminar.addActionListener(controlador);
		botonBuscar.addActionListener(controlador);
	}
	
	//Metodo que carga los datos del TXT y los pone en la tabla al arrancar la aplicacion
	private void cargarDatos() {
		for(Contacto c : Contacto.getContactos()) {
			String[] nuevoContacto = {c.getNombre(),c.getTelefono()};
			tableModel.addRow(nuevoContacto);
		}
			
	}
	
	//Metodo que devuelve la Fuente que se ha elegido como nueva fuente.
	public static Font setMilkuFont(int style ,float size) {
		try {
			Font titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Milku.otf"));
			titleFont = titleFont.deriveFont(style, size);
			
			return titleFont;
		} catch (FontFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	//GETTERS Y SETTERS
	
	public Controlador getControlador() {
		return controlador;
	}


	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		setListeners();
	}


	public JButton getBotonAñadir() {
		return botonAñadir;
	}


	public void setBotonAñadir(JButton botonAñadir) {
		this.botonAñadir = botonAñadir;
	}


	public JButton getBotonEditar() {
		return botonEditar;
	}


	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	
	public void setBotonEditar(JButton botonEditar) {
		this.botonEditar = botonEditar;
	}


	public JButton getBotonEliminar() {
		return botonEliminar;
	}


	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}


	public DefaultTableModel getTableModel() {
		return tableModel;
	}


	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	
}


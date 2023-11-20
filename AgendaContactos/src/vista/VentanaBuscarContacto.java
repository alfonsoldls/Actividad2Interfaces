package vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controlador.ControladorBuscarContacto;
import controlador.ControladorNuevoContacto;

//VENTANA BUSCAR CONTACTO
public class VentanaBuscarContacto extends JDialog {

	Vista ventana1;
	JLabel background,titulo, nombre, telefono;
	JTextField campoNombre, campoTelefono;
	JButton ok, cancel;
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane scrollpane;
	ControladorBuscarContacto controlador;
	
	public VentanaBuscarContacto(Vista ventana1) {
		
		this.ventana1 = ventana1;
		Image icono = new ImageIcon("imgs/adduser.png").getImage();
		setIconImage(icono);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null); 
		setLayout(null);
	
		setComponents();
		setModal(true);
		setControlador();
		
		
	}
	
	private void setComponents() {
		//SET BACKGROUND
		JLabel background = new JLabel(new ImageIcon("imgs/background.jpg"));
		background.setBounds(0, 0, 300, 300);
		background.setBackground(Color.cyan);
		
		//Set title
		titulo = new JLabel("Buscar Contacto");
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

		
		//set campo nombre
		campoNombre = new JTextField();
		campoNombre.setBounds(125, 75, 125, 25);
		add(campoNombre);

		//Crea una tabla para mostrar las coincidencias con la tabla original.
		String[] columnas = {"Nombre","Teléfono"};
		tableModel = new DefaultTableModel(columnas, 0);
		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null); //Hace la tabla que no sea editable desde la interfaz
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Configuracion estilo del Header
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		header.setFont(Vista.setMilkuFont(0,15f));
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
	          table.setFont(Vista.setMilkuFont(0, 12f));
	     }
	     table.setShowHorizontalLines(false);	//No muestra lineas horizontales
	     table.setBackground(Color.white);		//color de los values = blanco
	     
	     
		//Metemos la tabla en el JScrollPane
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(25, 120, 250, 85);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		scrollpane.setBorder(borde);
		add(scrollpane);
		
		
		
		cancel = new JButton("Cancelar");
		cancel.setBounds(185, 222, 90, 30);
		add(cancel);

		ok = new JButton("Buscar");
		ok.setBounds(80, 222, 90, 30);
		add(ok);
		getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
		add(background);
		
		
		
	}
	
	
	//GETTERS Y SETTERS
	public void setControlador(){
		controlador = new ControladorBuscarContacto(ventana1,this);
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

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	
}

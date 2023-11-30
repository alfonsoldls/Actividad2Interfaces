package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import controlador.Controlador;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;


public class Vista extends JFrame {
	
	private JLabel backgroundImage;
	private JButton botonAñadir, botonEliminar, botonEditar;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
		
			
	public Vista() {
		
		setBounds (100, 100, 600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = new ImageIcon("imagenes/contacto.png").getImage();
		setIconImage(icono);
		setTitle("Agenda de Contactos");
		setLayout(null);
		inicializarVariables();
		setVisible(true);
	}
		
	private void inicializarVariables() {	
			
		backgroundImage = new JLabel(new ImageIcon("imagenes/fondo.jpg"));
		backgroundImage.setBounds(0, 0, 600, 950);
		getLayeredPane().add(backgroundImage,Integer.valueOf(Integer.MIN_VALUE));
		JPanel panel = (JPanel)getContentPane();
		panel.setOpaque(false);
					
			botonAñadir = new JButton(new ImageIcon("imagenes/añadir.png"));
			botonAñadir.setBounds(50, 400, 130, 130);
			botonAñadir.setContentAreaFilled(false);
			botonAñadir.setBorder(null);
			add(botonAñadir);
			
			botonEditar = new JButton(new ImageIcon("imagenes/modificar.png"));
			botonEditar.setBounds(225, 400, 130, 130);
			botonEditar.setContentAreaFilled(false);
			botonEditar.setBorder(null);
			add(botonEditar);
			
			botonEliminar = new JButton(new ImageIcon("imagenes/borrar.png"));
			botonEliminar.setBounds(400, 400, 130, 130);
			botonEliminar.setContentAreaFilled(false);
			botonEliminar.setBorder(null);
			add(botonEliminar);
			
			
			String[] nombreColumnas = {"Nombre","Telefono"};
			tableModel = new DefaultTableModel(nombreColumnas,0);
			table = new JTable(tableModel);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
			scrollPane = new JScrollPane(table);
			scrollPane.setBounds(147, 61, 275, 280);
			add(scrollPane);
		}
	
	public void establecerListeners(Controlador controlador) {
		botonAñadir.addActionListener(controlador);
		botonEditar.addActionListener(controlador);
		botonEliminar.addActionListener(controlador);
		
}
	
	
	//GETTERS
	public JButton getBotonAñadir() {
		return botonAñadir;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public JButton getBotonEditar() {
		return botonEditar;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setBotonAñadir(JButton botonAñadir) {
		this.botonAñadir = botonAñadir;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public void setBotonEditar(JButton botonEditar) {
		this.botonEditar = botonEditar;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

}
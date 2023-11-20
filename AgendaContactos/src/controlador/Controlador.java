package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Contacto;
import vista.VentanaBuscarContacto;
import vista.VentanaEditarContacto;
import vista.VentanaNuevoContacto;
import vista.Vista;

public class Controlador implements ActionListener {

	private Vista ventana;
	
	public Controlador(Vista ventana) {
		this.ventana = ventana;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Boton añadir contacto
		if(e.getSource() == ventana.getBotonAñadir()) {
			//crea una nueva ventanaNuevoContacto y la pone visible
			VentanaNuevoContacto addContact = new VentanaNuevoContacto(ventana);
			addContact.setTitle("Nuevo contacto");
			addContact.setVisible(true);
		}
		
		if(e.getSource() == ventana.getBotonEditar()) {
			//Si esta seleccionada alguna de las filas crea la nueva VentanaEditarContacto y la hace visible
			if(ventana.getTable().getSelectedRow() != -1) {
				VentanaEditarContacto editContact = new VentanaEditarContacto(ventana);
				editContact.setVisible(true);
			//Sino se ha seleccionado ninguna fila, manda un aviso	
			}else
				JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		
		if(e.getSource()==ventana.getBotonEliminar()) {
			//Si esta seleccionada alguna de las filas la borra, tambien actualiza el contactos.txt
			if(ventana.getTable().getSelectedRow() != -1) {
				ventana.getTableModel().removeRow(ventana.getTable().getSelectedRow());
				Contacto.updateContactos(ventana.getTableModel());
			}else
				JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		
		//Crea la ventana para buscar contactos.
		if(e.getSource() == ventana.getBotonBuscar()) {
			VentanaBuscarContacto searchContact = new VentanaBuscarContacto(ventana);
			searchContact.setVisible(true);
		}
	}
}

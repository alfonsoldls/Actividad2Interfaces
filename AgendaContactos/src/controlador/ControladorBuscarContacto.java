package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Contacto;
import vista.VentanaBuscarContacto;
import vista.VentanaNuevoContacto;
import vista.Vista;

public class ControladorBuscarContacto implements ActionListener {

	private Vista ventana1;
	private VentanaBuscarContacto ventana2;
	
	public ControladorBuscarContacto(Vista ventana1, VentanaBuscarContacto ventana2) {
		this.ventana1 = ventana1;
		this.ventana2 = ventana2;
	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Si se pulsa ok, primero se asegura de borrar el contenido de la tabla, si hubiera
		//Y posteriormente llama a la funcion getContactosByName
		if(e.getSource() == ventana2.getOk()) {
			ventana2.getTableModel().setRowCount(0);
			getContactosByName();
			
		}
		
		if(e.getSource() == ventana2.getCancel()) {
			ventana2.dispose();
		}
		
	}
	
	//Funcion que se encarga de poner en la tabla de la ventanaBuscarContacto.
	//Los nombres y telefono del contacto segun lo que contenga en el campo del nombre a buscar.
	private void getContactosByName() {
		
			for(Contacto c : Contacto.getContactos()) {	//Recorre la lista de contactos que me devuelve el txt.
				//Pasamos a mayusculas el nombre y si el nombre contiene lo que haya en el campoNombre, Escribe el contacto en la tabla
				if(c.getNombre().toUpperCase().contains(ventana2.getCampoNombre().getText().toUpperCase())) {
					String[] nuevoContacto = {c.getNombre(),c.getTelefono()};
					ventana2.getTableModel().addRow(nuevoContacto);
				}
			}
				
		
		
	}

}

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Contacto;
import vista.VentanaEditarContacto;

import vista.Vista;


public class ControladorEditarContacto implements ActionListener{
		private Vista ventana1;
		private VentanaEditarContacto ventana2;
		
		public ControladorEditarContacto(Vista ventana1, VentanaEditarContacto ventana2) {
			this.ventana1 = ventana1;
			this.ventana2 = ventana2;
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//si se pulsa el boton ok, primero checkea los campos.
			//Luego cambia el contenido de la fila seleccionada en la tabla, segun lo que haya en los campos nombre y telefono.
			//Por ultimo actualiza el contactos.Txt
			if (e.getSource()== ventana2.getOk()) {
					if(checkCampos()) {
						ventana1.getTable().setValueAt(ventana2.getCampoNombre().getText(), ventana1.getTable().getSelectedRow(), 0);
						ventana1.getTable().setValueAt(ventana2.getCampoTelefono().getText(), ventana1.getTable().getSelectedRow(), 1);
						Contacto.updateContactos(ventana1.getTableModel());
						ventana2.dispose();
					}
			} 
			//cierra la ventana si se pulsa cancel
			if (e.getSource()== ventana2.getCancel())
				ventana2.dispose();
			}
		
		//Metodo que comprueba si los campos estan vacios y si el telefono introducido es valido. Devuelve true si esta todo OK

		private boolean checkCampos(){
			if(ventana2.getCampoNombre().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Inserta un Nombre","Aviso",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			if(ventana2.getCampoTelefono().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Inserta un telefono","Aviso",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			if(!comprobarTelefonoValido(ventana2.getCampoTelefono().getText())) {
				JOptionPane.showMessageDialog(null, "El numero de telefono debe tener 9 digitos","Aviso",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			return true;
		}
		
		//Metodo que se encarga de comprobar una cadena con una expresion regular si matchean, devuelve true. 
		//En este caso la expresion regular es "\\d{9}" es decir debe haber 9 digitos (NUMEROS)
		private boolean comprobarTelefonoValido(String telefono){
			Pattern patron = Pattern.compile("\\d{9}");
			Matcher matcher = patron.matcher(telefono);
			return matcher.matches();
			
		}
	}


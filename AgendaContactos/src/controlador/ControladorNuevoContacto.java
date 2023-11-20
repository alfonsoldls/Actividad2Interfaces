package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import modelo.Contacto;
import vista.VentanaNuevoContacto;
import vista.Vista;


public class ControladorNuevoContacto implements ActionListener{
		private Vista ventana1;
		private VentanaNuevoContacto ventana2;
		
		public ControladorNuevoContacto(Vista ventana1, VentanaNuevoContacto ventana2) {
			this.ventana1 = ventana1;
			this.ventana2 = ventana2;
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//si se pulsa el boton ok, primero checkea los campos y luego añade a la tabla la nueva fila. Tambien actualiza el contactos.txt
			if (e.getSource()== ventana2.getOk()) {
					if(checkCampos()) {
						ventana1.getTableModel().addRow(new String[] {ventana2.getCampoNombre().getText(), ventana2.getCampoTelefono().getText()});
						Contacto.updateContactos(ventana1.getTableModel());
						ventana2.dispose();
					}
			} 
			//Si se pulsa cancel la ventana se cierra
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


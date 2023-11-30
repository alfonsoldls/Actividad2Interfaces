package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import vista.Vista;
import vista.VistaModificar;

public class ControladorVistaModificar implements ActionListener{
	private Vista vista;
	private VistaModificar vistaModificar;
	
	public ControladorVistaModificar (Vista vista, VistaModificar vistaModificar) {
		this.vista = vista;
		this.vistaModificar = vistaModificar;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== vistaModificar.getBotonOK()) {
			if (checkCajas()) {
			vista.getTable().setValueAt(vistaModificar.getCajaNombre().getText(), vista.getTable().getSelectedRow(), 0);
			vista.getTable().setValueAt(vistaModificar.getCajaTelefono().getText(), vista.getTable().getSelectedRow(), 1);
			vista.getTableModel();
			vistaModificar.dispose();
			
			}
	}
	
		if (e.getSource()== vistaModificar.getBotonCancel()) {
			vistaModificar.dispose();
}
	}
		private boolean checkCajas(){
			if(vistaModificar.getCajaNombre().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Introduce un nombre","Aviso",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			if(vistaModificar.getCajaTelefono().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Introduce un telefono","Aviso",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			if(!comprobarTelefono(vistaModificar.getCajaTelefono().getText())) {
				JOptionPane.showMessageDialog(null, "El numero debe tener 9 digitos","Aviso",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			return true;
		
}
		private boolean comprobarTelefono(String telefono){
			Pattern patron = Pattern.compile("\\d{9}");
			Matcher matcher = patron.matcher(telefono);
			return matcher.matches();
}
}
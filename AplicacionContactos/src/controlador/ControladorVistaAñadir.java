package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import vista.Vista;
import vista.VistaAñadir;

public class ControladorVistaAñadir implements ActionListener {
	private Vista vista;
	private VistaAñadir vistaAñadir;

	public ControladorVistaAñadir(Vista vista, VistaAñadir vistaAñadir) {
		this.vista = vista;
		this.vistaAñadir = vistaAñadir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vistaAñadir.getBotonOK()){
			String nombre = vistaAñadir.getCajaNombre().getText();
			String telefono = vistaAñadir.getCajaTelefono().getText();
			
			if (checkCajas()) {
				vista.getTableModel().addRow(new String[] {nombre, telefono});
				vistaAñadir.dispose();
				}

		} else if (e.getSource() == vistaAñadir.getBotonCancel()) {
			vistaAñadir.dispose();
		}

	}

	private boolean checkCajas() {
		
		if (vistaAñadir.getCajaNombre().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un nombre", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (vistaAñadir.getCajaTelefono().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un telefono", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (!comprobarTelefono(vistaAñadir.getCajaTelefono().getText())) {
			JOptionPane.showMessageDialog(null, "El numero debe tener 9 digitos", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean comprobarTelefono(String telefono) {
		Pattern patron = Pattern.compile("\\d{9}");
		Matcher matcher = patron.matcher(telefono);
		return matcher.matches();
	}

}

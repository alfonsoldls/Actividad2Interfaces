package controlador;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista;
import vista.VistaAñadir;
import vista.VistaModificar;

public class Controlador implements ActionListener{
	Vista vista;
	
	public Controlador (Vista vista) {
		this.vista = vista;
		rellenarTablaConDatos();
	}

	
	public void rellenarTablaConDatos() {
		vista.getTableModel().addRow(new String[] {"Elena","633522411"});
		vista.getTableModel().addRow(new String[] {"Lucas","632766444"});
		vista.getTableModel().addRow(new String[] {"Hector","638963741"});
		vista.getTableModel().addRow(new String[] {"Esther","625467981"});
		vista.getTableModel().addRow(new String[] {"Clara","611347891"});
		
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== vista.getBotonAñadir()) {
			VistaAñadir vistaAñadir = new VistaAñadir(vista);	
			
		}
		
		if(e.getSource()== vista.getBotonEditar()) {
			int filaModificar = vista.getTable().getSelectedRow();
		
			if(filaModificar == -1) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila","Aviso",JOptionPane.WARNING_MESSAGE);
				
			}else {
				VistaModificar vistaModificar = new VistaModificar(vista);
				String nombre = vista.getTable().getValueAt(filaModificar, 0).toString();
				String telefono = vista.getTable().getValueAt(filaModificar, 1).toString();
				vistaModificar.modificarNombre(nombre);
				vistaModificar.modificarTelefono(telefono);
		}
	}		

		if(e.getSource()== vista.getBotonEliminar()){
			int filaSeleccionada = vista.getTable().getSelectedRow();
            if (filaSeleccionada >= 0) {
                vista.getTableModel().removeRow(filaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un contacto para poder eliminarlo","Aviso",JOptionPane.WARNING_MESSAGE);
            }
		}
	}       
	
}
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import vista.*;


public class Eventos implements ActionListener{

	private VentanaPrincipal ventana;
	VentanaAgregar ventana2;
	VentanaEditar ventana3;
	
	public Eventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == ventana.getAgregar()) {
	        ventana2 = new VentanaAgregar();
	        // Agregar listener para el botón aceptar de ventana2
	        ventana2.getAceptar().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                agregar();
	            }
	        });
	        ventana2.getCancelar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ventana2.setVisible(false);
				}
			});
	    } else if (e.getSource() == ventana.getEditar()) {
	    	
	    	int filaselect = ventana.getContactos().getSelectedRow();
	    	
	    	if (filaselect == -1) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
			}else {
				ventana3 = new VentanaEditar();
				String nombre = ventana.getModel().getValueAt(filaselect, 0).toString();
				String telefono = ventana.getModel().getValueAt(filaselect, 1).toString();
				ventana3.actualizarNombre(nombre);;
				ventana3.actualizarTelefono(telefono);
		        // Agregar listener para el botón aceptar de ventana2
		        ventana3.getAceptar().addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                editar();
		            }
		        });
		        ventana3.getCancelar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ventana3.setVisible(false);
					}
				});
			}
	    	
	    } else if (e.getSource() == ventana.getEliminar()) {
	    	eliminar();
	    }
	}
	
	public void agregar() {
		
		String nombre = ventana2.getNombreBox().getText();
		String telefono = ventana2.getTelefonoBox().getText();
		boolean pass = true;
		
        try {
            Integer.parseInt(telefono);
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(null, "El campo Teléfono solo admite caracteres numéricos");
			pass = false;
        }
        
        if (telefono.length()!=9) {
        	JOptionPane.showMessageDialog(null, "El número de teléfono debe ser de 9 dígitos");
			pass = false;
        }
		
		if (nombre.equalsIgnoreCase("") && telefono.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Debe rellenar los campos Nombre y Teléfono");
			pass = false;
		}else if (nombre.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Debe rellenar el campo Nombre");
			pass = false;
		}else if (telefono.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Debe rellenar el campo Teléfono");
			pass = false;
		}
		
		if (pass) {
			ventana.getModel().addRow(new Object[] {
					nombre, telefono
			});
			ventana2.setVisible(false);
		}
		
	}
	
	public void editar() {
		String nombre = ventana3.getNombreBox().getText();
		String telefono = ventana3.getTelefonoBox().getText();
		boolean pass = true;
			
		try {
	        Integer.parseInt(telefono);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "El campo Teléfono solo admite caracteres numéricos");
			pass = false;
	    }
	        
	    if (telefono.length()!=9) {
	        JOptionPane.showMessageDialog(null, "El número de teléfono debe ser de 9 dígitos");
			pass = false;
	    }
			
		if (nombre.equalsIgnoreCase("") && telefono.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Debe rellenar los campos Nombre y Teléfono");
			pass = false;
		}else if (nombre.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Debe rellenar el campo Nombre");
			pass = false;
		}else if (telefono.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Debe rellenar el campo Teléfono");
			pass = false;
		}
			
		if (pass) {
			int fila = ventana.getContactos().getSelectedRow();
			ventana.getModel().setValueAt(nombre, fila, 0);
			ventana.getModel().setValueAt(telefono, fila, 1);
			ventana3.setVisible(false);
		}
		
	}
	
	public void eliminar(){
		if (ventana.getContactos().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
		}else {
			int fila = ventana.getContactos().getSelectedRow();
			ventana.getModel().removeRow(fila);
		}
		
	}

}

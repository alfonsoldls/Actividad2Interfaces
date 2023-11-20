package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Contacto {

	private String nombre;
	private String telefono;
	


	
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	//Se encarga de obtener la lista de contactos de contactos.txt en formato arraylist spliteando por : cada linea.
	public static List<Contacto> getContactos(){
		List<Contacto> listaContactos = new ArrayList<>();
		Contacto aux;
		File contactos = new File("contactos.txt");
		if(contactos.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(contactos))) {
				String linea;
				//lee cada linea mientras sea distinta de null
				while ((linea = br.readLine()) != null) {
					//Crea un array de cada linea spliteando por ":" y Crea un nuevo contacto con los datos del array
					String [] datos = linea.split(":");
					aux = new Contacto(datos[0],datos[1]);
					listaContactos.add(aux);
				}
			} catch(IOException e){
				return null;
			}	
		}
		return listaContactos;
	}
	
	//Funcion que actualiza el contactos.txt segun lo que tenga en la tabla de la ventana principal
	//Se actualiza el txt de la siguiente forma en cada linea "nombre:telefono"
	public static void updateContactos(DefaultTableModel tabla) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("contactos.txt",false))){
			
			//Este for recorre la tabla entera en sus dos dimensiones, por cada valor de (y) escribe ":" y cada valor (x) un salto de linea 
			for (int x = 0 ; x < tabla.getRowCount(); x++) {
				for(int y = 0; y < tabla.getColumnCount(); y++) {
					bw.write((String)tabla.getValueAt(x, y));
					if(y==0)
						bw.write(":");
				}
				bw.write("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}



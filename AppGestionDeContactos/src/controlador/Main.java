package controlador;

import vista.*;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal miVentana = new VentanaPrincipal();
		Eventos eventos = new Eventos(miVentana);
		miVentana.establecerEventos(eventos);		
	}

}

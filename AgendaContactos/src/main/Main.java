package main;

import controlador.Controlador;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		Vista v = new Vista();
		Controlador controlador = new Controlador(v);
		v.setControlador(controlador);
		
		
	}

}

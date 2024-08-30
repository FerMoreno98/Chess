package com.logica;

import javax.swing.*;


public class Torre extends Piezas {

	public Torre(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas,imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		
		if(nuevaColumna==columnas) {
			return true;
		}
		
		if(nuevaFila==filas) {
			
			return true;
		}
	
		return false;
	}



}

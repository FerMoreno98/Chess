package com.logica;

import javax.swing.*;

public class Peon extends Piezas {

	public Peon(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas,imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		
		if(nuevaFila==filas-1 || nuevaFila==filas+2 && nuevaColumna!=columnas) {
			
			return false;
			
		}else {
			
			return true;
			
		}
		
	}



}

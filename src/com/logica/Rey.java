package com.logica;

import javax.swing.*;



public class Rey extends Piezas{

	public Rey(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas, imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		return Math.abs(filas - columnas) <=1 && Math.abs(nuevaFila - nuevaColumna) <=1;
	
	}

	


}

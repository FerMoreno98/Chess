package com.logica;

import javax.swing.*;


public class Caballo extends Piezas {

	
	
	public Caballo(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas,imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		return false;
	}



}

package com.logica;

import javax.swing.*;


public class Alfil extends Piezas {

	public Alfil(String color, int filas, int columnas,ImageIcon imagenPieza) {
		super(color, filas, columnas,imagenPieza);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		return false;
	}



}

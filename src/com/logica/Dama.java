package com.logica;

import javax.swing.*;

public class Dama extends Piezas {

	public Dama(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas, imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		return false;
	}


}

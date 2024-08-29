package com.logica;

import javax.swing.*;

public class Peon extends Piezas {

	public Peon(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas,imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
	    // Verificar si el peón se mueve en la misma columna
	    if (nuevaColumna != columnas) {
	        return false;
	    }

	    // Verificar si el peón se mueve hacia adelante
	    int diferenciaFila = nuevaFila - filas;

	    // Movimiento hacia adelante (sin capturar)
	    if (diferenciaFila == -1) {
	        return true;
	    }

	    // Movimiento de dos casillas hacia adelante en la primera jugada
	    if (diferenciaFila == -2 && filas == 6) {
	        return true;
	    }

	    return false;
	}



}

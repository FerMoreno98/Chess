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
		
		if(filas==nuevaFila+1 && columnas==nuevaColumna+1) {
			return true;
		}
		
		if(filas==nuevaFila-1 && columnas==nuevaColumna-1) {
			return true;
		}
		
		if(filas==nuevaFila-1 && columnas==nuevaColumna+1) {
			return true;
		}
		
		if(filas==nuevaFila+1 && columnas==nuevaColumna-1) {
			return true;
		}
		
		
		
		
		if(filas==nuevaFila+2 && columnas==nuevaColumna+2) {
			return true;
		}
		
		if(filas==nuevaFila-2 && columnas==nuevaColumna-2) {
			return true;
		}
		
		if(filas==nuevaFila-2 && columnas==nuevaColumna+2) {
			return true;
		}
		
		if(filas==nuevaFila+2 && columnas==nuevaColumna-2) {
			return true;
		}
		
		
		
		if(filas==nuevaFila+3 && columnas==nuevaColumna+3) {
			return true;
		}
		
		if(filas==nuevaFila-3 && columnas==nuevaColumna-3) {
			return true;
		}
		
		if(filas==nuevaFila-3 && columnas==nuevaColumna+3) {
			return true;
		}
		
		if(filas==nuevaFila+3 && columnas==nuevaColumna-3) {
			return true;
		}
		
		
		
		
		if(filas==nuevaFila+4 && columnas==nuevaColumna+4) {
			return true;
		}
		
		if(filas==nuevaFila-4 && columnas==nuevaColumna-4) {
			return true;
		}
		
		if(filas==nuevaFila-4 && columnas==nuevaColumna+4) {
			return true;
		}
		
		if(filas==nuevaFila+4 && columnas==nuevaColumna-4) {
			return true;
		}
		
		
		
		
		
		if(filas==nuevaFila+5 && columnas==nuevaColumna+5) {
			return true;
		}
		
		if(filas==nuevaFila-5 && columnas==nuevaColumna-5) {
			return true;
		}
		
		if(filas==nuevaFila-5 && columnas==nuevaColumna+5) {
			return true;
		}
		
		if(filas==nuevaFila+5 && columnas==nuevaColumna-5) {
			return true;
		}
		
		
		
		if(filas==nuevaFila+6 && columnas==nuevaColumna+6) {
			return true;
		}
		
		if(filas==nuevaFila-6 && columnas==nuevaColumna-6) {
			return true;
		}
		
		if(filas==nuevaFila-6 && columnas==nuevaColumna+6) {
			return true;
		}
		
		if(filas==nuevaFila+6 && columnas==nuevaColumna-6) {
			return true;
		}
		
		
		
		
		if(filas==nuevaFila+7 && columnas==nuevaColumna+7) {
			return true;
		}
		
		if(filas==nuevaFila-7 && columnas==nuevaColumna-7) {
			return true;
		}
		
		if(filas==nuevaFila-7 && columnas==nuevaColumna+7) {
			return true;
		}
		
		if(filas==nuevaFila+7 && columnas==nuevaColumna-7) {
			return true;
		}
		
		
		
		
		
		return false;
	}



}

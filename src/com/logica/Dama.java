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
		
		
		
		if(nuevaColumna==columnas) {
			return true;
		}
		
		if(nuevaFila==filas) {
			
			return true;
		}
		
		
		return false;
	}


}

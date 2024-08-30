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
		
		
		if(nuevaFila==filas+1 && nuevaColumna==columnas+1) {
			return true;
			
		}
		
		if(nuevaFila==filas-1 && nuevaColumna==columnas-1) {
			return true;
			
		}
		
		
		
		if(nuevaFila==filas+1 && nuevaColumna==columnas-1) {
			return true;
			
		}
		
		if(nuevaFila==filas-1 && nuevaColumna==columnas+1) {
			return true;
			
		}
		
		
		
		if(nuevaFila==filas && nuevaColumna==columnas+1) {
			
			return true;
		}
		
		if(nuevaFila==filas && nuevaColumna==columnas-1) {
			
			return true;
		}
		
		
		
		
		if(nuevaFila==filas+1 && nuevaColumna==columnas) {
			
			return true;
		}
		
		if(nuevaFila==filas-1 && nuevaColumna==columnas) {
			
			return true;
		}
		
		
		return false;
	
	}

	


}

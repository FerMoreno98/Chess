package com.logica;

import javax.swing.*;


public abstract class Piezas {
	
	
	protected String color;
	
	protected int filas;
	
	protected int columnas;
	
	//protected ImageIcon imagenPieza;
	
	

	public Piezas(String color, int filas, int columnas) {
		super();
		this.color = color;
		this.filas = filas;
		this.columnas = columnas;
		
	}
	
	public abstract boolean esMovimientoValido(int nuevaFila,int nuevaColumna,Tablero tablero);
	
	
	
	
	public void mover(int nuevaFila, int nuevaColumna) {
		
		this.filas=nuevaFila;
		this.columnas=nuevaColumna;
		
	}
	
	
	public abstract void colocarPieza(JPanel lamina);
	

}

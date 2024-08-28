package com.logica;

import javax.swing.*;


public abstract class Piezas {
	
	
	protected String color;
	
	protected int filas;
	
	protected int columnas;
	
	protected ImageIcon imagenPieza;
	
	


	
	public Piezas(String color, int filas, int columnas,ImageIcon imagenPieza) {
		super();
		this.color = color;
		this.filas = filas;
		this.columnas = columnas;
		this.imagenPieza=imagenPieza;
		
	}
	
	public abstract boolean esMovimientoValido(int nuevaFila,int nuevaColumna);
	
	
	
	
	public void mover(int nuevaFila, int nuevaColumna) {
		
		this.filas=nuevaFila;
		this.columnas=nuevaColumna;
		
	}
	
	
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}


	
	public ImageIcon getImagenPieza() {
		
		return imagenPieza;
	}
	
	

}

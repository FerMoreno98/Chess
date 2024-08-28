package com.logica;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Rey extends Piezas{

	public Rey(String color, int filas, int columnas) {
		super(color, filas, columnas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Tablero tablero) {
		// TODO Auto-generated method stub
		return Math.abs(filas - columnas) <=1 && Math.abs(nuevaFila - nuevaColumna) <=1;
	
	}

	@Override
	public void colocarPieza(JPanel lamina) {
		// TODO Auto-generated method stub
		
		JButton botonPeon=new JButton("Rey"+ color);
		
		lamina.add(botonPeon);
		
	}

}

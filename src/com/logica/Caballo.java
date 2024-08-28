package com.logica;

import javax.swing.*;


public class Caballo extends Piezas {

	
	
	public Caballo(String color, int filas, int columnas) {
		super(color, filas, columnas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Tablero tablero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void colocarPieza(JPanel lamina) {
		// TODO Auto-generated method stub
		
		JButton t=new JButton("Caballo"+ color);
		
		lamina.add(t);
		
	}

}

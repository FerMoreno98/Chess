package com.logica;

import javax.swing.*;

public class Peon extends Piezas {

	public Peon(String color, int filas, int columnas) {
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
		
		JButton botonPeon=new JButton("peon"+ color);
		
		lamina.add(botonPeon);
		
	}

}

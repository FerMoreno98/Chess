package com.logica;

import java.awt.Component;

import javax.swing.*;

public class Peon extends Piezas {
	
	boolean hayPieza=false;

	public Peon(String color, int filas, int columnas,ImageIcon imagen) {
		super(color, filas, columnas,imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
	    // Verificar si el peón se mueve en la misma columna
		
		
		
		if(containsLabel(casilla)&& !hayPieza) {
			hayPieza=true;
			return false;
		}
		
		if(color.equals("Blanco")) {
	    if (nuevaColumna != columnas) {
	        return false;
	    }

	    // Verificar si el peón se mueve hacia adelante
	    int diferenciaFila = nuevaFila - filas;

	    // Movimiento hacia adelante (sin capturar)
	    if (diferenciaFila == -1 && !hayPieza) {
	        return true;
	    }

	    // Movimiento de dos casillas hacia adelante en la primera jugada
	    if (diferenciaFila == -2 && filas == 6 && !hayPieza) {
	        return true;
	    }
		}else {
			
		    if (nuevaColumna != columnas) {
		        return false;
		    }

		    // Verificar si el peón se mueve hacia adelante
		    int diferenciaFila = nuevaFila - filas;

		    // Movimiento hacia adelante (sin capturar)
		    if (diferenciaFila == +1 && !hayPieza) {
		        return true;
		    }

		    // Movimiento de dos casillas hacia adelante en la primera jugada
		    if (diferenciaFila == +2 && filas == 1 && !hayPieza) {
		        return true;
		    }
			
			
			
		}

	    return false;
	}
	
	  public boolean containsLabel(JPanel casilla) {
	        for (Component comp : casilla.getComponents()) {
	        	JLabel label=(JLabel)comp;
	        	
	            if (comp instanceof JLabel ) { 
	            	
	            	if(label.getIcon().equals(getImagenPieza())) {
	            		
	            		return false;
	            	}
	            	
	            	//System.out.println(label.getIcon());
	            	
	           return true;
	            }
	        }
	        return false;
	    }
	    
	    
	    public void reset() {
	    
			hayPieza=false;
	    }



}

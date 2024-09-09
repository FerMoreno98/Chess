package com.logica;

import java.awt.Component;

import javax.swing.*;

public class Dama extends Piezas {
	
	boolean hayPieza=false;

	public Dama(String color, int filas, int columnas,ImageIcon imagen,JPanel panelTablero) {
		super(color, filas, columnas, imagen);
		// TODO Auto-generated constructor stub
		this.casilla=panelTablero;
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		
		if(containsLabel(casilla)&& !hayPieza) {
			hayPieza=true;
			return false;
		}
		
		if(filas==nuevaFila+1 && columnas==nuevaColumna+1 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-1 && columnas==nuevaColumna-1 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-1 && columnas==nuevaColumna+1 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+1 && columnas==nuevaColumna-1 && !hayPieza) {
			return true;
		}
		
		
		
		
		if(filas==nuevaFila+2 && columnas==nuevaColumna+2 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-2 && columnas==nuevaColumna-2 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-2 && columnas==nuevaColumna+2 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+2 && columnas==nuevaColumna-2 && !hayPieza) {
			return true;
		}
		
		
		
		if(filas==nuevaFila+3 && columnas==nuevaColumna+3 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-3 && columnas==nuevaColumna-3 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-3 && columnas==nuevaColumna+3 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+3 && columnas==nuevaColumna-3 && !hayPieza) {
			return true;
		}
		
		
		
		
		if(filas==nuevaFila+4 && columnas==nuevaColumna+4 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-4 && columnas==nuevaColumna-4 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-4 && columnas==nuevaColumna+4 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+4 && columnas==nuevaColumna-4 && !hayPieza) {
			return true;
		}
		
		
		
		
		
		if(filas==nuevaFila+5 && columnas==nuevaColumna+5 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-5 && columnas==nuevaColumna-5 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-5 && columnas==nuevaColumna+5 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+5 && columnas==nuevaColumna-5 && !hayPieza) {
			return true;
		}
		
		
		
		if(filas==nuevaFila+6 && columnas==nuevaColumna+6 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-6 && columnas==nuevaColumna-6 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-6 && columnas==nuevaColumna+6 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+6 && columnas==nuevaColumna-6 && !hayPieza) {
			return true;
		}
		
		
		
		
		if(filas==nuevaFila+7 && columnas==nuevaColumna+7 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-7 && columnas==nuevaColumna-7 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila-7 && columnas==nuevaColumna+7 && !hayPieza) {
			return true;
		}
		
		if(filas==nuevaFila+7 && columnas==nuevaColumna-7 && !hayPieza) {
			return true;
		}
		
		
		
		if(nuevaColumna==columnas && !hayPieza) {
			return true;
		}
		
		if(nuevaFila==filas && !hayPieza) {
			
			return true;
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

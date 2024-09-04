package com.logica;

import java.awt.Component;

import javax.swing.*;

public class Torre extends Piezas {
	
	boolean hayPiezaColumna;
	
	boolean hayPiezaFila;

	
    public Torre(String color, int filas, int columnas, ImageIcon imagen, JPanel panelTablero) {
        super(color, filas, columnas, imagen);
        this.casilla = panelTablero;
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
    	
  
    	

    	if(nuevaColumna==columnas && !hayPiezaColumna) {
    		
    		if(containsLabel(casilla)) {
    			
    			hayPiezaColumna=true;
    			return false;
    		}
    		
    	
    	
    	
			return true;
		}
		
		if(nuevaFila==filas && !hayPiezaFila ) {
			
			if(containsLabel(casilla)) {
				
				hayPiezaFila=true;
    			
    			return false;
    		}
			
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
            	
            	System.out.println(label.getIcon());
            	
           return true;
            }
        }
        return false;
    }
    
    
}


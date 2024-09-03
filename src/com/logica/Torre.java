package com.logica;

import java.awt.Component;

import javax.swing.*;

public class Torre extends Piezas {

   
    public Torre(String color, int filas, int columnas, ImageIcon imagen, JPanel panelTablero) {
        super(color, filas, columnas, imagen);
        this.casilla = panelTablero;
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        // Obtener la casilla destino
    	
    	
    	
    	if(nuevaColumna==columnas) {
    		
    		if(containsLabel(casilla)) {
    			
    			return false;
    		}
			return true;
		}
		
		if(nuevaFila==filas) {
			
			if(containsLabel(casilla)) {
    			
    			return false;
    		}
			
			return true;
		}
		
		return false;
    	
    }
    

    private boolean containsLabel(JPanel casilla) {
        for (Component comp : casilla.getComponents()) {
        	
        	
        	
            if (comp instanceof JLabel) {
           return true;
            }
        }
        return false;
    }
}


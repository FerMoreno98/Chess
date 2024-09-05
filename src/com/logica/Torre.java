package com.logica;

import java.awt.Component;

import javax.swing.*;

public class Torre extends Piezas {
	
	boolean hayPiezaColumna=false;
	
	boolean hayPiezaFila=false;

	
    public Torre(String color, int filas, int columnas, ImageIcon imagen, JPanel panelTablero) {
        super(color, filas, columnas, imagen);
        this.casilla = panelTablero;
    }
    
    public void reset() {
    	hayPiezaColumna=false;
		hayPiezaFila=false;
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
    	
  
    	System.out.println("el valor de hayPiezaColumna es: "+ hayPiezaColumna);
    	
    	System.out.println("el valor de hayPiezaFila es: "+ hayPiezaFila);

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
            	
            	//System.out.println(label.getIcon());
            	
           return true;
            }
        }
        return false;
    }
    
    
}


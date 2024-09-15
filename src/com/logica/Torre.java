package com.logica;

import java.awt.Component;

import javax.swing.*;

public class Torre extends Piezas {
	
	boolean hayPieza=false;

	
    public Torre(String color, int filas, int columnas, ImageIcon imagen, JPanel panelTablero) {
        super(color, filas, columnas, imagen);
        this.casilla = panelTablero;
    }
    
    public void reset() {
    	hayPieza=false;
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
    	
  
   
    	
    	if(containsLabel(casilla) && puedeCapturar(casilla,this) && !hayPieza) {
			
			hayPieza=true;
			return true;
			
			
		}

    	if(nuevaColumna==columnas && !hayPieza) {
    		
    		if(containsLabel(casilla)) {
    			
    			hayPieza=true;
    			return false;
    		}
    		
    	
    	
    	
			return true;
		}
		
		if(nuevaFila==filas && !hayPieza ) {
			
			if(containsLabel(casilla)) {
				
				hayPieza=true;
    			
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
    
    
    
   public boolean puedeCapturar(JPanel casillas,Piezas p) {
    	
    	String [] clavePiezas= {"torre","caballo","alfil","rey","dama","peon"};
    	
		Component[] componentes = casillas.getComponents();
		
		for (Component componente : componentes) {
			
		    if (componente instanceof JLabel) {
		    	
		        JLabel label = (JLabel) componente;
		        
		        for(String clave:clavePiezas) {
		        	
		        Piezas pieza = (Piezas) label.getClientProperty(clave);
		        
		        if (pieza != null && !pieza.getColor().equals(p.getColor())) {
		           
		           // System.out.println("Pieza encontrada en el JLabel: " + pieza);
		            
		            //casillas.setBackground(Color.orange);
		        	
		        	return true;
		        }
		    }
		        
		        }
		      
		}
		
		return false;
    }
    
    
}


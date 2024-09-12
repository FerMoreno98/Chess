package com.logica;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;


public class Caballo extends Piezas {

	boolean hayPieza= false;
	
	public Caballo(String color, int filas, int columnas,ImageIcon imagen,JPanel panelTablero) {
		super(color, filas, columnas,imagen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
		// TODO Auto-generated method stub
		
		
		if(containsLabel(casilla)&& !hayPieza && !puedeCapturar(casilla,this)) {
			hayPieza=true;
			return false;
		}
		
	
		
		if(nuevaFila==filas+2 && nuevaColumna==columnas+1 && !hayPieza) {
			
			return true;
		}
		
		if(nuevaFila==filas+2 && nuevaColumna==columnas-1 && !hayPieza) {
			
			return true;
		}
		
		if(nuevaFila==filas+1 && nuevaColumna==columnas-2 && !hayPieza) {
			
			return true;
			
		}
		
		if(nuevaFila==filas+1 && nuevaColumna==columnas+2 && !hayPieza) {
			
			return true;
			
		}
		
		
		
		if(nuevaFila==filas-2 && nuevaColumna==columnas-1 && !hayPieza) {
			
			return true;
		}
		
		if(nuevaFila==filas-2 && nuevaColumna==columnas+1 && !hayPieza) {
			
			return true;
		}
		
		if(nuevaFila==filas-1 && nuevaColumna==columnas+2 && !hayPieza) {
			
			return true;
			
		}
		
		if(nuevaFila==filas-1 && nuevaColumna==columnas-2 && !hayPieza) {
			
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

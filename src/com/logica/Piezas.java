package com.logica;

import java.awt.Component;

import javax.swing.*;


public abstract class Piezas {
	
	
	protected String color;
	
	protected int filas;
	
	protected int columnas;
	
	protected ImageIcon imagenPieza;
	
	protected JPanel casilla;
	
	protected boolean hayPiezaColumna=false;
	
	protected boolean hayPiezaFila=false;
	
	protected boolean hayPieza=false;
	
	


	
	public Piezas(String color, int filas, int columnas,ImageIcon imagenPieza) {
		super();
		this.color = color;
		this.filas = filas;
		this.columnas = columnas;
		this.imagenPieza=imagenPieza;
		
	}
	

	public Piezas(String color, int filas, int columnas,ImageIcon imagenPieza,JPanel casilla) {
		super();
		this.color = color;
		this.filas = filas;
		this.columnas = columnas;
		this.imagenPieza=imagenPieza;
		this.casilla=casilla;
		
	}
	
	public abstract boolean esMovimientoValido(int nuevaFila,int nuevaColumna);
	
	
	
	
	public void mover(int nuevaFila, int nuevaColumna) {
		
		this.filas=nuevaFila;
		this.columnas=nuevaColumna;
		
		
	}
	
	public void reset() {
		
		hayPiezaColumna=false;
		hayPiezaFila=false;
	}
	
	
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}


	
	public ImageIcon getImagenPieza() {
		
		return imagenPieza;
	}
	
	public JPanel getCasilla() {
		
		return casilla;
	}
	
	public void setCasilla(JPanel casilla) {
		
		this.casilla=casilla;
	}
	
	
	public void setHayPiezaColumna(boolean hayPiezaColumna){
		
		this.hayPiezaColumna=hayPiezaColumna;
	}
	
	public void setHayPiezaFila(boolean hayPiezaFila){
		
		this.hayPiezaColumna=hayPiezaFila;
	}
	
	
	
    public boolean containsLabel(JPanel casilla) {
        for (Component comp : casilla.getComponents()) {
        	JLabel label=(JLabel)comp;
        	
            if (comp instanceof JLabel ) {
            	
            	
            	System.out.println(label.getIcon());
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

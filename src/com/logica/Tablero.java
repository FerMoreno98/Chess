package com.logica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Tablero {
	
	public static void main(String [] args) {
		
		MarcoTablero m=new MarcoTablero();
		
		m.setVisible(true);
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	

}

class MarcoTablero extends JFrame{
	
	public MarcoTablero() {
		
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		
		Dimension tamano=miPantalla.getScreenSize();
		
		int ancho=tamano.width;
		
		int alto=tamano.height;
		
		setBounds(ancho/4,alto/4,ancho/2,alto/2);
		
		setTitle("Chess");
		
		setResizable(false);
		
		add(new LaminaTablero());
		
		
	}
	
	
}

class LaminaTablero extends JPanel{
	
	private JPanel laminaCasillas,casilla;
	
	private String [] [] nombreCasilla;
	
	private JLabel icono;
	
	private JPanel [][] casillasConNombre=new JPanel[8][8];
	
	private boolean peonActivado=false,caballoActivado=false,torreActivado=false,alfilActivado=false,damaActivado=false,reyActivado=false;
	
	private Piezas peonSelected, alfilSelected,torreSelected,caballoSelected,damaSelected,reySelected;
	
	
	
	public LaminaTablero(){
		
		setLayout(new BorderLayout());
		
		laminaCasillas=new JPanel();
		
		laminaCasillas.setLayout(new GridLayout(8,8));
		
		add(laminaCasillas, BorderLayout.CENTER);
		
		nombreCasilla=new String [8][8];
		
		creaCasillas();
		
		
		
		//----------------------------------------
		
		JPanel barraOpciones=new JPanel();
		
		barraOpciones.setLayout(new BorderLayout());
		
		Box cajaBarraLateral=Box.createVerticalBox();
		
		cajaBarraLateral.add(Box.createVerticalStrut(180));
		
		
		
		JLabel tiempo=new JLabel("Tiempo:");
		
		tiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		cajaBarraLateral.add(tiempo);
		
		cajaBarraLateral.add(Box.createVerticalStrut(20));
		
		
		
		
		JComboBox miCombo=new JComboBox();
		
		miCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		miCombo.setMaximumSize(new Dimension(100,20) );
		
		cajaBarraLateral.add(miCombo);
		
		cajaBarraLateral.add(Box.createVerticalStrut(20));
		
		
		
		
		JButton jugar=new JButton("Jugar");
		
		jugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		cajaBarraLateral.add(jugar);
		
		miCombo.addItem("1 min (Bullet)");
		
		miCombo.addItem("3 min (Blitz)");
		
		miCombo.addItem("10 min (Normal)");
		
		add(barraOpciones,BorderLayout.EAST);
		
		
		barraOpciones.add(cajaBarraLateral);
		
	
		
	}
	
	public void creaCasillas() {
		
		LineBorder borde=new LineBorder(Color.black, 1);
		
		
		
		char letra='a';
			
		for (int i = 0; i < 8; i++) {
			
			//Nos vamos a meter en el primer for cuando la fila tenga los blancos pares y los verdes impares
			
			if(i%2==0) {
				
				letra='a';
				
			for (int j = 0; j < 8; j++) {
				
				casilla=new JPanel();
				
				casilla.setBorder(borde);
				
				casilla.putClientProperty("fila",i);
				
				casilla.putClientProperty("columna", j);
				
				laminaCasillas.add(casilla);
				
				nombreCasilla[i][j]=letra+Integer.toString(8-i);
				
				//casilla.setName(nombreCasilla[i][j]);
				
				casillasConNombre[i][j]=casilla;//asociamos un array de JPanel para que cada casilla tenga una posicion y podamos llamar en el mouse listener a posiciones concretas
				
				//para colocar los peones blancos en su poscion inicial
				
				if(i==6) {
				
					Piezas p=new Peon("Blanco",i,j,new ImageIcon(getClass().getResource("/images/peonblanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("peon", p); //para asociar la pieza con la casilla
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				// para colocar las torres negras en su poscion inicial
				
				if(i==0 && j==0) {

					Piezas p=new Torre("Negro",i,j,new ImageIcon(getClass().getResource("/images/torre.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("torre", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				if(i==0 && j==7) {

					Piezas p=new Torre("Negro",i,j,new ImageIcon(getClass().getResource("/images/torre.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("torre", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				
				// para colocar las CABALLOS negros en su poscion inicial
				
				if(i==0 && j==1) {
					
					Piezas p=new Caballo("Negro",i,j,new ImageIcon(getClass().getResource("/images/caballo.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("caballo", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				if(i==0 && j==6) {
					
					Piezas p=new Caballo("Negro",i,j,new ImageIcon(getClass().getResource("/images/caballo.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("caballo", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				
	// para colocar las ALFILES negros en su poscion inicial
				
				if(i==0 && j==2) {
					
					Piezas p=new Alfil("Negro",i,j,new ImageIcon(getClass().getResource("/images/alfil.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("alfil", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
				}
				
				if(i==0 && j==5) {
					
					Piezas p=new Alfil("Negro",i,j,new ImageIcon(getClass().getResource("/images/alfil.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("alfil", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
					
				}
				
	// para colocar las DAMA Negro en su poscion inicial
				
				if(i==0 && j==3) {

					Piezas p=new Dama("Negro",i,j,new ImageIcon(getClass().getResource("/images/dama.gif")),casillasConNombre[i][j]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("dama", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
				}
				
				// para colocar las REY Negro en su poscion inicial
				
				if(i==0 && j==4) {
					
					
					
					Piezas p=new Rey("Negro",i,j,new ImageIcon(getClass().getResource("/images/rey.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("rey", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
				}
				
				
				
				
				
				if(j%2==0) {
					
					casilla.setBackground(Color.white);
					
				}else {
					
					casilla.setBackground(Color.green);
					
				}
				
				letra++;
				
			}
			
			
				}else {
					
				//Nos meteremos en el segundo for cuando la fila tenga los blancos impares y los verdes pares
					
					letra='a';
			
			for (int k = 0; k < 8; k++) {
				
				casilla=new JPanel();
				
				casilla.setBorder(borde);
				
				casilla.putClientProperty("fila",i);
				
				casilla.putClientProperty("columna", k);
				
				laminaCasillas.add(casilla);
				
				nombreCasilla[i][k]=letra+Integer.toString(8-i);
				
				//casilla.setName(nombreCasilla[i][k]);
				
				casillasConNombre [i][k]=casilla; //asociamos un array de JPanel para que cada casilla tenga una posicion y podamos llamar en el mouse listener a posiciones concretas
				
				
				//Para colocar los peones negros en su posicion inicial
				
				if(i==1) {
					
					Piezas p=new Peon("Negro",i,k,new ImageIcon(getClass().getResource("/images/peon.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("peon", p); //para asociar la pieza con la casilla
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
					
				}
				
				
		// para colocar las torres blancas en su poscion inicial
				
				if(i==7 && k==0) {
					
					Piezas p=new Torre("Blanco",i,k,new ImageIcon(getClass().getResource("/images/torreBlanca.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("torre", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				if(i==7 && k==7) {

					Piezas p=new Torre("Blanco",i,k,new ImageIcon(getClass().getResource("/images/torreBlanca.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("torre", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				// para colocar las CABALLOS blancos en su poscion inicial
				
				if(i==7 && k==6) {
					
					
					Piezas p=new Caballo("Blanco",i,k,new ImageIcon(getClass().getResource("/images/caballoblanco.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("caballo", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				if(i==7 && k==1) {

					Piezas p=new Caballo("Blanco",i,k,new ImageIcon(getClass().getResource("/images/caballoblanco.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("caballo", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
	// para colocar las ALFILES blancos en su poscion inicial
				
				if(i==7 && k==5) {
					
					Piezas p=new Alfil("Blanco",i,k,new ImageIcon(getClass().getResource("/images/alfilBlanco.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("alfil", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
				
					
				}
				
				if(i==7 && k==2) {
					
					
					
					Piezas p=new Alfil("Blanco",i,k,new ImageIcon(getClass().getResource("/images/alfilBlanco.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("alfil", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
					
				}
				
				
				// para colocar las DAMA Blanco en su poscion inicial
				
				if(i==7 && k==3) {
					
					
					
					Piezas p=new Dama("Blanco",i,k,new ImageIcon(getClass().getResource("/images/damablanca.gif")),casillasConNombre[i][k]);
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("dama", p);
					
					icono.addMouseListener(new ControladorMovimiento());
					
		
					
				}
				
				// para colocar las REY Blanco en su poscion inicial
				
				if(i==7 && k==4) {
					
					
					
					Piezas p=new Rey("Blanco",i,k,new ImageIcon(getClass().getResource("/images/reyblanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("rey", p);
					
					icono.addMouseListener(new ControladorMovimiento());
				}
				
				
				
				
				if(k%2!=0) {
					
					casilla.setBackground(Color.white);
					
				}else {
					
					casilla.setBackground(Color.green);
					
				}
				
				letra++;
				
			}
			
			
			
				}
			
		}
		
		
	
			
		
		
	}
	
	private class ControladorMovimiento extends MouseAdapter{
		

			
		
		
		
		public void mouseClicked(MouseEvent e) {
			
			restaurarColoresOriginales();//lo llamamos aqui para que cada vez que se clique se reinicien los colores
			 alfilSelected=(Piezas)((JLabel)e.getSource()).getClientProperty("alfil");
			 torreSelected=(Piezas)((JLabel)e.getSource()).getClientProperty("torre");
			 caballoSelected=(Piezas) ((JLabel)e.getSource()).getClientProperty("caballo");
			 peonSelected = (Piezas) ((JLabel) e.getSource()).getClientProperty("peon");//con getClientProperty nos lleva a la pieza que hay asociada a esa casilla
			 reySelected=(Piezas)((JLabel)e.getSource()).getClientProperty("rey");
			 damaSelected=(Piezas)((JLabel)e.getSource()).getClientProperty("dama");
			 
			
			 
			 
			 if(peonSelected!=null) {
				 
				 peonActivado=true;
				 
				 int filaActual=peonSelected.getFilas();
				 
				 int columnaActual=peonSelected.getColumnas();
				 
				 if(peonSelected.getColor().equals("Blanco")) {
				 
				 for (int i = filaActual; i > filaActual-3 ; i--) {
					 
					 
					 
					 if(i>=0 && i<=7) {
						 
						 peonSelected.setCasilla(casillasConNombre[i][columnaActual]);
						 
						 if(peonSelected.esMovimientoValido(i, columnaActual)) {
							 
								System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][columnaActual]);

								casillasConNombre[i][columnaActual].setBackground(Color.red);
							
								casillasConNombre[i][columnaActual].addMouseListener(new moverPieza());
							 
						 }
						 
						 
						 
						 
					 }
					
				}
				 
				 peonSelected.reset();
				 
				 
					for (int i = columnaActual-1; i < columnaActual+2; i++) {
						
						if(i>=0 && i<=7 && filaActual>0 && filaActual<8) {
						
						peonSelected.setCasilla(casillasConNombre[filaActual-1][i]);
						
						if(peonSelected.puedeCapturar(casillasConNombre[filaActual-1][i], peonSelected) && i!=columnaActual) {
							
							casillasConNombre[filaActual-1][i].setBackground(Color.orange);
						}
						
					}
						}
					
					peonSelected.reset();
				 
				 }
				 
				 if(peonSelected.getColor().equals("Negro")) {
					 
				 for (int i = filaActual; i < filaActual+3 ; i++) {
					 
					 
					 
					 if(i>=0 && i<=7) {
						 
						 peonSelected.setCasilla(casillasConNombre[i][columnaActual]);
						 
						 if(peonSelected.esMovimientoValido(i, columnaActual)) {
							 
								System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][columnaActual]);

								casillasConNombre[i][columnaActual].setBackground(Color.red);
							
								casillasConNombre[i][columnaActual].addMouseListener(new moverPieza());
							 
						 }
						 
						 
						 
						 
					 }
					
				}
				 
				 peonSelected.reset();
				 
			for (int i = columnaActual-1; i < columnaActual+2; i++) {
				
				if(i>=0 && i<=7 && filaActual>0 && filaActual<8) {
				
				peonSelected.setCasilla(casillasConNombre[filaActual+1][i]);
				
				if(peonSelected.puedeCapturar(casillasConNombre[filaActual+1][i], peonSelected) && i!=columnaActual) {
					
					casillasConNombre[filaActual+1][i].setBackground(Color.orange);
				}
				
			}
				}
			
			peonSelected.reset();
				 
				 }
				 }
			 
			 
	 if(caballoSelected!=null) {
				 
			caballoActivado=true;
			
			int filaActual=caballoSelected.getFilas();
			
			int columnaActual=caballoSelected.getColumnas();
			
			for (int i = filaActual-3; i < filaActual+3 ; i++) {
				
				for (int j = columnaActual-3; j < columnaActual+3; j++) {
					
					if(i>=0 && j>=0 && i<=7 && j<=7) {
					
					caballoSelected.setCasilla(casillasConNombre[i][j]);
				
					
					if(caballoSelected.esMovimientoValido(i, j)) {
						
						System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);

						casillasConNombre[i][j].setBackground(Color.red);
						
						if(caballoSelected.puedeCapturar(casillasConNombre[i][j], caballoSelected)) {
							
							casillasConNombre[i][j].setBackground(Color.orange);
						}
					
						casillasConNombre[i][j].addMouseListener(new moverPieza());
						
						
					}
					
					caballoSelected.reset();
					
					
				}
				}
				
				
			}
				 }
			 
			 
			 if(torreSelected!=null) {
				 
				 torreActivado=true;
				 
			int filaActual=torreSelected.getFilas();
			
			int columnaActual=torreSelected.getColumnas();
			
			// columna de sur a norte
			
			for (int i = filaActual; i < 8; i++) {
				
				torreSelected.setCasilla(casillasConNombre[i][columnaActual]);
				
				if(torreSelected.esMovimientoValido(i, columnaActual)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][columnaActual]);

					
					
					if(torreSelected.puedeCapturar(casillasConNombre[i][columnaActual], torreSelected)) {
						
						casillasConNombre[i][columnaActual].setBackground(Color.orange);
						
					}else {
						
						casillasConNombre[i][columnaActual].setBackground(Color.red);
						
					}
				
					casillasConNombre[i][columnaActual].addMouseListener(new moverPieza());
				}
			}
			
			//torreSelected.setCasilla(casillasConNombre[filaActual][columnaActual]);
			torreSelected.reset();
			
			
			//columna de norte a sur
			
			for (int i = filaActual; i >= 0; i--) {
				
				torreSelected.setCasilla(casillasConNombre[i][columnaActual]);
				
			
				
				if(torreSelected.esMovimientoValido(i, columnaActual)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][columnaActual]);	

					if(torreSelected.puedeCapturar(casillasConNombre[i][columnaActual], torreSelected)) {
						
						casillasConNombre[i][columnaActual].setBackground(Color.orange);
						
					}else {
						
						casillasConNombre[i][columnaActual].setBackground(Color.red);
						
					}
				
					casillasConNombre[i][columnaActual].addMouseListener(new moverPieza());
				}
				
			}
			
			//torreSelected.setCasilla(casillasConNombre[filaActual][columnaActual]);
			torreSelected.reset();
			
			//fila del oeste al este
			
			for (int i = columnaActual; i < 8; i++) {
				
				torreSelected.setCasilla(casillasConNombre[filaActual][i]);
				
				if(torreSelected.esMovimientoValido(filaActual, i)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[filaActual][i]);
					
					
					
					if(torreSelected.puedeCapturar(casillasConNombre[filaActual][i], torreSelected)) {
						
						casillasConNombre[filaActual][i].setBackground(Color.orange);
					}else {
						
						casillasConNombre[filaActual][i].setBackground(Color.red);
						
					}
				
					casillasConNombre[filaActual][i].addMouseListener(new moverPieza());
				
				}
			}
			
			//torreSelected.setCasilla(casillasConNombre[filaActual][columnaActual]);
			torreSelected.reset();
			
			
			//fila del este al oeste
			for (int i = columnaActual; i >= 0; i--) {
				
				torreSelected.setCasilla(casillasConNombre[filaActual][i]);
								
				if(torreSelected.esMovimientoValido(filaActual, i)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[filaActual][i]);
					
					if(torreSelected.puedeCapturar(casillasConNombre[filaActual][i], torreSelected)) {
						
						casillasConNombre[filaActual][i].setBackground(Color.orange);
					}else {
						
						casillasConNombre[filaActual][i].setBackground(Color.red);
						
					}
			
					casillasConNombre[filaActual][i].addMouseListener(new moverPieza());
				
				}
				
			}
				
				torreSelected.reset();
				
				
				 
				 
			 }
			 
			 
	 if(alfilSelected!=null) {
		 
		 int filaActual=alfilSelected.getFilas();
		 
		 int columnaActual=alfilSelected.getColumnas();
		 
		 int contador;
		
		 alfilActivado=true;
		 
		 // de oeste a este de norte a sur
		 
		 contador=columnaActual;
				 
		for (int i = filaActual; i < 8; i++) {
			
			if(contador<=7 && contador>=0) {
			
			alfilSelected.setCasilla(casillasConNombre[i][contador]);
			
			if(alfilSelected.esMovimientoValido(i, contador)) {
				
				System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][contador]);
				
				
				
				if(alfilSelected.puedeCapturar(casillasConNombre[i][contador], alfilSelected)) {
					
					casillasConNombre[i][contador].setBackground(Color.orange);
				}else {
					
					casillasConNombre[i][contador].setBackground(Color.red);
					
				}
				
				casillasConNombre[i][contador].addMouseListener(new moverPieza());
			}
			
			
			
			contador++;
			
			}
			
		}
			
		
		alfilSelected.reset();
		
		 // de este a oeste de sur a norte
		
		contador=columnaActual;
		 
		for (int i = filaActual; i >= 0; i--) {
			
			if(contador<=7 && contador>=0) {
			
			alfilSelected.setCasilla(casillasConNombre[i][contador]);
			
			if(alfilSelected.esMovimientoValido(i, contador)) {
				
				System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][contador]);
				
				
				if(alfilSelected.puedeCapturar(casillasConNombre[i][contador], alfilSelected)) {
					
					casillasConNombre[i][contador].setBackground(Color.orange);
				}else {
					
					casillasConNombre[i][contador].setBackground(Color.red);
					
				}
				
				casillasConNombre[i][contador].addMouseListener(new moverPieza());
			}
			
			
				
				contador--;
				
				}
			
			
			
		}
			
		
		alfilSelected.reset();
		
		
		 // este a oeste y de norte a sur
		
		contador=filaActual;
		 
		for (int i = columnaActual; i >= 0; i--) {
			
			if(contador<=7 && contador>=0) {
			
			alfilSelected.setCasilla(casillasConNombre[contador][i]);
			
			if(alfilSelected.esMovimientoValido(contador, i)) {
				
				System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[contador][i]);
				
				
				
				if(alfilSelected.puedeCapturar(casillasConNombre[contador][i], alfilSelected)) {
					
					casillasConNombre[contador][i].setBackground(Color.orange);
				}else {
					
					casillasConNombre[contador][i].setBackground(Color.red);
					
				}
				
				casillasConNombre[contador][i].addMouseListener(new moverPieza());
			}
			
			
				
				contador++;
				
				}
			
		}
			
		
		alfilSelected.reset();
		
		
		 // de oeste a este y de norte a sur
		 
		contador=filaActual;
		
		for (int i = columnaActual; i < 8; i++) {
			
			if(contador<=7 && contador>=0) {
			
			alfilSelected.setCasilla(casillasConNombre[contador][i]);
			
			if(alfilSelected.esMovimientoValido(contador, i)) {
				
				System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[contador][i]);
				
				
				
				if(alfilSelected.puedeCapturar(casillasConNombre[contador][i], alfilSelected)) {
					
					casillasConNombre[contador][i].setBackground(Color.orange);
				}else {
					
					casillasConNombre[contador][i].setBackground(Color.red);
				}
				
				casillasConNombre[contador][i].addMouseListener(new moverPieza());
			}
			
			
				
				contador--;
				
				}
			
		}
			
		
		alfilSelected.reset();
		 
			 }
	 
	 
	 
	 if(reySelected!=null) {
		 
		 reyActivado=true;
		 
		 int filaActual=reySelected.getFilas();
		 
		 int columnaActual=reySelected.getColumnas();
		 
		 for (int i = filaActual-1; i <=filaActual+1 ; i++) {
			 
			 for (int j = columnaActual-1; j <=columnaActual+1; j++) {
				 
				 if(i>=0 && i<=7 && j>=0 && j<=7) {
					 
					 reySelected.setCasilla(casillasConNombre[i][j]);
				 
				 if(reySelected.esMovimientoValido(i, j)) {
					 
						System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
						
						
						
						if(reySelected.puedeCapturar(casillasConNombre[i][j], reySelected)) {
							
							casillasConNombre[i][j].setBackground(Color.orange);
							
						}else {
							
							casillasConNombre[i][j].setBackground(Color.red);
							
						}
						
						casillasConNombre[i][j].addMouseListener(new moverPieza());
					 
					 
					 
				 }
				
			}
				 
				 reySelected.reset();
			 }
			
		}
	 }
	 
	 if(damaSelected!=null) {
		 
		 damaActivado=true;
		 
			int filaActual=damaSelected.getFilas();
			
			int columnaActual=damaSelected.getColumnas();
			
			int contador;
			
			// columna de sur a norte
			
			for (int i = filaActual; i < 8; i++) {
				
				damaSelected.setCasilla(casillasConNombre[i][columnaActual]);
				
				if(damaSelected.esMovimientoValido(i, columnaActual)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][columnaActual]);

					
					
					if(damaSelected.puedeCapturar(casillasConNombre[i][columnaActual], damaSelected)) {
						
						casillasConNombre[i][columnaActual].setBackground(Color.orange);
					}else {
						
						casillasConNombre[i][columnaActual].setBackground(Color.red);
					}
				
					casillasConNombre[i][columnaActual].addMouseListener(new moverPieza());
				}
			}
			
			//torreSelected.setCasilla(casillasConNombre[filaActual][columnaActual]);
			damaSelected.reset();
			
			
			//columna de norte a sur
			
			for (int i = filaActual; i >= 0; i--) {
				
				damaSelected.setCasilla(casillasConNombre[i][columnaActual]);
				
			
				
				if(damaSelected.esMovimientoValido(i, columnaActual)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][columnaActual]);	

					if(damaSelected.puedeCapturar(casillasConNombre[i][columnaActual], damaSelected)) {
						
						casillasConNombre[i][columnaActual].setBackground(Color.orange);
					}else {
						
						casillasConNombre[i][columnaActual].setBackground(Color.red);
					}
				
					casillasConNombre[i][columnaActual].addMouseListener(new moverPieza());
				}
				
			}
			
			//torreSelected.setCasilla(casillasConNombre[filaActual][columnaActual]);
			damaSelected.reset();
			
			//fila del oeste al este
			
			for (int i = columnaActual; i < 8; i++) {
				
				damaSelected.setCasilla(casillasConNombre[filaActual][i]);
				
				if(damaSelected.esMovimientoValido(filaActual, i)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[filaActual][i]);
					
					
					
					if(damaSelected.puedeCapturar(casillasConNombre[filaActual][i], damaSelected)) {
						
						casillasConNombre[filaActual][i].setBackground(Color.orange);
						
					}else {
						
						casillasConNombre[filaActual][i].setBackground(Color.red);
					}
				
					casillasConNombre[filaActual][i].addMouseListener(new moverPieza());
				
				}
			}
			
			//torreSelected.setCasilla(casillasConNombre[filaActual][columnaActual]);
			damaSelected.reset();
			
			
			//fila del este al oeste
			for (int i = columnaActual; i >= 0; i--) {
				
				damaSelected.setCasilla(casillasConNombre[filaActual][i]);
								
				if(damaSelected.esMovimientoValido(filaActual, i)) {
					
					System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[filaActual][i]);
					
					if(damaSelected.puedeCapturar(casillasConNombre[filaActual][i], damaSelected)) {
						
						casillasConNombre[filaActual][i].setBackground(Color.orange);
						
					}else {
						
						casillasConNombre[filaActual][i].setBackground(Color.red);
					}
			
					casillasConNombre[filaActual][i].addMouseListener(new moverPieza());
				
				}
				
			}
				
				damaSelected.reset();
				
				
				 contador=columnaActual;
				 
					for (int i = filaActual; i < 8; i++) {
						
						if(contador<=7 && contador>=0) {
						
						damaSelected.setCasilla(casillasConNombre[i][contador]);
						
						if(damaSelected.esMovimientoValido(i, contador)) {
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][contador]);
							
							
							
							if(damaSelected.puedeCapturar(casillasConNombre[i][contador], damaSelected)) {
								
								casillasConNombre[i][contador].setBackground(Color.orange);
								
							}else {
								
								casillasConNombre[i][contador].setBackground(Color.red);
								
							}
							
							casillasConNombre[i][contador].addMouseListener(new moverPieza());
						}
						
						
						
						contador++;
						
						}
						
					}
						
					
					damaSelected.reset();
					
					 // de este a oeste de sur a norte
					
					contador=columnaActual;
					 
					for (int i = filaActual; i >= 0; i--) {
						
						if(contador<=7 && contador>=0) {
						
						damaSelected.setCasilla(casillasConNombre[i][contador]);
						
						if(damaSelected.esMovimientoValido(i, contador)) {
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][contador]);
							
							if(damaSelected.puedeCapturar(casillasConNombre[i][contador], damaSelected)) {
								
								casillasConNombre[i][contador].setBackground(Color.orange);
								
							}else {
								
								casillasConNombre[i][contador].setBackground(Color.red);
								
							}
							
							casillasConNombre[i][contador].addMouseListener(new moverPieza());
						}
						
						
							
							contador--;
							
							}
						
						
						
					}
						
					
					damaSelected.reset();
					
					
					 // este a oeste y de norte a sur
					
					contador=filaActual;
					 
					for (int i = columnaActual; i >= 0; i--) {
						
						if(contador<=7 && contador>=0) {
						
						damaSelected.setCasilla(casillasConNombre[contador][i]);
						
						if(damaSelected.esMovimientoValido(contador, i)) {
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[contador][i]);
							
							if(damaSelected.puedeCapturar(casillasConNombre[contador][i], damaSelected)) {
								
								casillasConNombre[contador][i].setBackground(Color.orange);
								
							}else {
								
								casillasConNombre[contador][i].setBackground(Color.red);
								
							}
							
							casillasConNombre[contador][i].addMouseListener(new moverPieza());
						}
						
						
							
							contador++;
							
							}
						
					}
						
					
					damaSelected.reset();
					
					
					 // de oeste a este y de norte a sur
					 
					contador=filaActual;
					
					for (int i = columnaActual; i < 8; i++) {
						
						if(contador<=7 && contador>=0) {
						
						damaSelected.setCasilla(casillasConNombre[contador][i]);
						
						if(damaSelected.esMovimientoValido(contador, i)) {
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[contador][i]);
							
							if(damaSelected.puedeCapturar(casillasConNombre[contador][i], damaSelected)) {
								
								casillasConNombre[contador][i].setBackground(Color.orange);
								
							}else {
								
								casillasConNombre[contador][i].setBackground(Color.red);
								
							}
							
							casillasConNombre[contador][i].addMouseListener(new moverPieza());
						}
						
						
							
							contador--;
							
							}
						
					}
						
					
					damaSelected.reset();
		 
		 
		 
	 }
			 
				
			/*	for (int i = 0; i < 8; i++) {
					
					for (int j = 0; j < 8; j++) {
						
						if(peonSelected!=null) {
						
						if(peonSelected.esMovimientoValido(i, j)) {
							
							casillasConNombre[i][j].setBackground(Color.red);
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
							
							peonActivado=true;
							
							casillasConNombre[i][j].addMouseListener(new moverPieza());
						}
						
						
						}
						
						
						
						if(caballoSelected!=null) {
						if(caballoSelected.esMovimientoValido(i, j)) {
							
							casillasConNombre[i][j].setBackground(Color.red);
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
							
							caballoActivado=true;
							
							casillasConNombre[i][j].addMouseListener(new moverPieza());
							
						}
						}
						
						if(torreSelected!=null) {
							
							torreSelected.setCasilla(casillasConNombre[i][j]);

							if(torreSelected.esMovimientoValido(i, j)) {
								
								
							
							
							casillasConNombre[i][j].setBackground(Color.red);
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
							
							torreActivado=true;
							
							casillasConNombre[i][j].addMouseListener(new moverPieza());
							
							
							
							}

						}
						
						
						if(alfilSelected!=null) {
							
							if(alfilSelected.esMovimientoValido(i, j)) {
								
								casillasConNombre[i][j].setBackground(Color.red);
								
								System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
								
								alfilActivado=true;
								
								casillasConNombre[i][j].addMouseListener(new moverPieza());
							}
							
						}
						
						
						 if(reySelected!=null) {
							
							if(reySelected.esMovimientoValido(i, j)) {
								
								casillasConNombre[i][j].setBackground(Color.red);
								
								System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
								
								reyActivado=true;
								
								casillasConNombre[i][j].addMouseListener(new moverPieza());
							}
							
						}
						 
						 if(damaSelected!=null) {
								
								if(damaSelected.esMovimientoValido(i, j)) {
									
									casillasConNombre[i][j].setBackground(Color.red);
									
									System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
									
									damaActivado=true;
									
									casillasConNombre[i][j].addMouseListener(new moverPieza());
								}
								
							}
						
					}
					
				}
				
				if(torreSelected!=null) {
				
				torreSelected.setHayPiezaColumna(false);
				
				torreSelected.setHayPiezaFila(false);
				
				}*/
				
			
	
		}

	
		
	
	
	
	
}
	
	private class moverPieza extends MouseAdapter {

	    @Override
	    public void mouseClicked(MouseEvent e) {
	        JPanel casillaSelected = (JPanel) e.getSource();

	        if (peonActivado && peonSelected != null) {
	            // Obtener la nueva fila y columna de la casilla seleccionada
	            int nuevaFila = (int) casillaSelected.getClientProperty("fila");
	            int nuevaColumna = (int) casillaSelected.getClientProperty("columna");

	            // Remover la imagen del peón de la casilla original
	            casillasConNombre[peonSelected.getFilas()][peonSelected.getColumnas()].removeAll();
	            casillasConNombre[peonSelected.getFilas()][peonSelected.getColumnas()].repaint();

	            // Mover la pieza a la nueva posición (actualizar sus coordenadas internas)
	            peonSelected.mover(nuevaFila, nuevaColumna);
	            
	            // Añadir la imagen del peón a la nueva casilla
	            JLabel nuevoIcono = new JLabel(peonSelected.getImagenPieza());
	            casillaSelected.add(nuevoIcono);
	            casillaSelected.revalidate();
	            casillaSelected.repaint();
	            
	            //añadimos el clientProperty al "nuevo" JLabel para poder añadirle de nuevo el primer mouselistener para que se pueda mover de nuevo
	            nuevoIcono.putClientProperty("peon", peonSelected);
	            nuevoIcono.addMouseListener(new ControladorMovimiento());

	            // Desactivar el estado de peón activado
	            peonActivado = false;

	            System.out.println("Peón movido a la fila " + nuevaFila + " y columna " + nuevaColumna);

	            // Restaurar los colores originales de las casillas
	            restaurarColoresOriginales();
	        }
	        
	        //----------------------------------------------------------------------------Movimiento del caballo
	        
	        if (caballoActivado && caballoSelected != null) {
	            // Obtener la nueva fila y columna de la casilla seleccionada
	            int nuevaFila = (int) casillaSelected.getClientProperty("fila");
	            int nuevaColumna = (int) casillaSelected.getClientProperty("columna");

	            // Remover la imagen del peón de la casilla original
	            casillasConNombre[caballoSelected.getFilas()][caballoSelected.getColumnas()].removeAll();
	            casillasConNombre[caballoSelected.getFilas()][caballoSelected.getColumnas()].repaint();

	            // Mover la pieza a la nueva posición (actualizar sus coordenadas internas)
	            caballoSelected.mover(nuevaFila, nuevaColumna);

	            // Añadir la imagen del peón a la nueva casilla
	            JLabel nuevoIcono = new JLabel(caballoSelected.getImagenPieza());
	            casillaSelected.add(nuevoIcono);
	            casillaSelected.revalidate();
	            casillaSelected.repaint();
	            
	            //añadimos el clientProperty al "nuevo" JLabel para poder añadirle de nuevo el primer mouselistener para que se pueda mover de nuevo
	            nuevoIcono.putClientProperty("caballo", caballoSelected);
	            nuevoIcono.addMouseListener(new ControladorMovimiento());

	            // Desactivar el estado de peón activado
	            caballoActivado = false;

	            System.out.println("Caballo movido a la fila " + nuevaFila + " y columna " + nuevaColumna);

	            // Restaurar los colores originales de las casillas
	            restaurarColoresOriginales();
	        }
	        
	        //---------------------------------------------------Movimiento de la torre
	        
	        if (torreActivado && torreSelected != null) {
	            // Obtener la nueva fila y columna de la casilla seleccionada
	            int nuevaFila = (int) casillaSelected.getClientProperty("fila");
	            int nuevaColumna = (int) casillaSelected.getClientProperty("columna");

	            // Remover la imagen del peón de la casilla original
	            casillasConNombre[torreSelected.getFilas()][torreSelected.getColumnas()].removeAll();
	            casillasConNombre[torreSelected.getFilas()][torreSelected.getColumnas()].repaint();

	            // Mover la pieza a la nueva posición (actualizar sus coordenadas internas)
	            torreSelected.mover(nuevaFila, nuevaColumna);
	            
	            
	            // Añadir la imagen del peón a la nueva casilla
	            JLabel nuevoIcono = new JLabel(torreSelected.getImagenPieza());
	            casillaSelected.add(nuevoIcono);
	            casillaSelected.revalidate();
	            casillaSelected.repaint();
	            
	            //añadimos el clientProperty al "nuevo" JLabel para poder añadirle de nuevo el primer mouselistener para que se pueda mover de nuevo
	            nuevoIcono.putClientProperty("torre", torreSelected);
	            nuevoIcono.addMouseListener(new ControladorMovimiento());

	            // Desactivar el estado de peón activado
	            torreActivado = false;

	            System.out.println("torre movido a la fila " + nuevaFila + " y columna " + nuevaColumna);

	            // Restaurar los colores originales de las casillas
	            
	            //torreSelected.reset();
	            restaurarColoresOriginales();
	        }
	        
	        //---------------------------------------------------------------Movimiento del alfil
	        
	        if (alfilActivado && alfilSelected != null) {
	            // Obtener la nueva fila y columna de la casilla seleccionada
	            int nuevaFila = (int) casillaSelected.getClientProperty("fila");
	            int nuevaColumna = (int) casillaSelected.getClientProperty("columna");

	            // Remover la imagen del peón de la casilla original
	            casillasConNombre[alfilSelected.getFilas()][alfilSelected.getColumnas()].removeAll();
	            casillasConNombre[alfilSelected.getFilas()][alfilSelected.getColumnas()].repaint();

	            // Mover la pieza a la nueva posición (actualizar sus coordenadas internas)
	            alfilSelected.mover(nuevaFila, nuevaColumna);

	            // Añadir la imagen del peón a la nueva casilla
	            JLabel nuevoIcono = new JLabel(alfilSelected.getImagenPieza());
	            casillaSelected.add(nuevoIcono);
	            casillaSelected.revalidate();
	            casillaSelected.repaint();
	            
	            //añadimos el clientProperty al "nuevo" JLabel para poder añadirle de nuevo el primer mouselistener para que se pueda mover de nuevo
	            nuevoIcono.putClientProperty("alfil", alfilSelected);
	            nuevoIcono.addMouseListener(new ControladorMovimiento());

	            // Desactivar el estado de peón activado
	            alfilActivado = false;

	            System.out.println("alfil movido a la fila " + nuevaFila + " y columna " + nuevaColumna);

	            // Restaurar los colores originales de las casillas
	            restaurarColoresOriginales();
	        }
	        
	        
       //---------------------------------------------------------------Movimiento de la dama
	        
	        if (damaActivado && damaSelected != null) {
	            // Obtener la nueva fila y columna de la casilla seleccionada
	            int nuevaFila = (int) casillaSelected.getClientProperty("fila");
	            int nuevaColumna = (int) casillaSelected.getClientProperty("columna");

	            // Remover la imagen del peón de la casilla original
	            casillasConNombre[damaSelected.getFilas()][damaSelected.getColumnas()].removeAll();
	            casillasConNombre[damaSelected.getFilas()][damaSelected.getColumnas()].repaint();

	            // Mover la pieza a la nueva posición (actualizar sus coordenadas internas)
	            damaSelected.mover(nuevaFila, nuevaColumna);

	            // Añadir la imagen del peón a la nueva casilla
	            JLabel nuevoIcono = new JLabel(damaSelected.getImagenPieza());
	            casillaSelected.add(nuevoIcono);
	            casillaSelected.revalidate();
	            casillaSelected.repaint();
	            
	            //añadimos el clientProperty al "nuevo" JLabel para poder añadirle de nuevo el primer mouselistener para que se pueda mover de nuevo
	            nuevoIcono.putClientProperty("dama", damaSelected);
	            nuevoIcono.addMouseListener(new ControladorMovimiento());

	            // Desactivar el estado de peón activado
	            damaActivado = false;

	            System.out.println("dama movido a la fila " + nuevaFila + " y columna " + nuevaColumna);

	            // Restaurar los colores originales de las casillas
	            restaurarColoresOriginales();
	        }
	        
    //---------------------------------------------------------------Movimiento de la rey
	        
	        if (reyActivado && reySelected != null) {
	            // Obtener la nueva fila y columna de la casilla seleccionada
	            int nuevaFila = (int) casillaSelected.getClientProperty("fila");
	            int nuevaColumna = (int) casillaSelected.getClientProperty("columna");

	            // Remover la imagen del peón de la casilla original
	            casillasConNombre[reySelected.getFilas()][reySelected.getColumnas()].removeAll();
	            casillasConNombre[reySelected.getFilas()][reySelected.getColumnas()].repaint();

	            // Mover la pieza a la nueva posición (actualizar sus coordenadas internas)
	            reySelected.mover(nuevaFila, nuevaColumna);

	            // Añadir la imagen del peón a la nueva casilla
	            JLabel nuevoIcono = new JLabel(reySelected.getImagenPieza());
	            casillaSelected.add(nuevoIcono);
	            casillaSelected.revalidate();
	            casillaSelected.repaint();
	            
	            // añadimos el clientProperty al "nuevo" JLabel para poder añadirle de nuevo el primer mouselistener para que se pueda mover de nuevo
	            nuevoIcono.putClientProperty("rey", reySelected);
	            nuevoIcono.addMouseListener(new ControladorMovimiento());

	            // Desactivar el estado de peón activado
	            reyActivado = false;

	            System.out.println("rey movido a la fila " + nuevaFila + " y columna " + nuevaColumna);

	            // Restaurar los colores originales de las casillas
	            restaurarColoresOriginales();
	        }
	        
	        
	    }
	}
	
	
	public void restaurarColoresOriginales() {//replicamos la logica hecha para colorear las casillas en este metodo
		
		for (int i = 0; i < 8; i++) {
			
			
			
			if(i%2==0) {
				
			
				
			for (int j = 0; j < 8; j++) {
				
				limpiarMouseListeners(casillasConNombre[i][j]);
				
				if(j%2==0) {
					
					casillasConNombre[i][j].setBackground(Color.white);
					
				}else {
					
					casillasConNombre[i][j].setBackground(Color.green);
					
				}
			
			
			}
			
			
			
			}else {
			
			for (int k = 0; k < 8; k++) {
				
				limpiarMouseListeners(casillasConNombre[i][k]);
				
				if(k%2!=0) {
					
					casillasConNombre[i][k].setBackground(Color.white);
					
				}else {
					
					casillasConNombre[i][k].setBackground(Color.green);
					
				}
				
			}
			
			}
			
		
		
		
	}
			}
	
	public void limpiarMouseListeners(JPanel casilla) {
		
		for(MouseListener ml: casilla.getMouseListeners()) {
			
			casilla.removeMouseListener(ml);
		}
	}
	
	}
	

	





	


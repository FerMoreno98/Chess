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
				
				laminaCasillas.add(casilla);
				
				nombreCasilla[i][j]=letra+Integer.toString(8-i);
				
				casilla.setName(nombreCasilla[i][j]);
				
				casillasConNombre[i][j]=casilla;//asociamos un array de JPanel para que cada casilla tenga una posicion y podamos llamar en el mouse listener a posiciones concretas
				
				//para colocar los peones blancos en su poscion inicial
				
				if(i==6) {
				
					Piezas p=new Peon("Blanco",i,j,new ImageIcon(getClass().getResource("/images/peonblanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("pieza", p); //para asociar la pieza con la casilla
					
					if(icono.getClientProperty("pieza")==null) {
						
						System.out.println("el putclientproperty no funciona");
					}
					
					icono.addMouseListener(new ControladorMovimiento());
					
				}
				
				// para colocar las torres negras en su poscion inicial
				
				if(i==0 && j==0) {

					Piezas p=new Torre("Negro",i,j,new ImageIcon(getClass().getResource("/images/torre.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==0 && j==7) {

					Piezas p=new Torre("Negro",i,j,new ImageIcon(getClass().getResource("/images/torre.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				
				// para colocar las CABALLOS negros en su poscion inicial
				
				if(i==0 && j==1) {
					
					Piezas p=new Caballo("Negro",i,j,new ImageIcon(getClass().getResource("/images/caballo.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==0 && j==6) {
					
					Piezas p=new Caballo("Negro",i,j,new ImageIcon(getClass().getResource("/images/caballo.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				
	// para colocar las ALFILES negros en su poscion inicial
				
				if(i==0 && j==2) {
					
					Piezas p=new Alfil("Negro",i,j,new ImageIcon(getClass().getResource("/images/alfil.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==0 && j==5) {
					
					Piezas p=new Alfil("Negro",i,j,new ImageIcon(getClass().getResource("/images/alfil.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
				}
				
	// para colocar las DAMA Negro en su poscion inicial
				
				if(i==0 && j==3) {

					Piezas p=new Dama("Negro",i,j,new ImageIcon(getClass().getResource("/images/dama.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
				}
				
				// para colocar las REY Negro en su poscion inicial
				
				if(i==0 && j==4) {
					
					
					
					Piezas p=new Rey("Negro",i,j,new ImageIcon(getClass().getResource("/images/rey.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
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
				
				laminaCasillas.add(casilla);
				
				nombreCasilla[i][k]=letra+Integer.toString(8-i);
				
				casilla.setName(nombreCasilla[i][k]);
				
				casillasConNombre [i][k]=casilla; //asociamos un array de JPanel para que cada casilla tenga una posicion y podamos llamar en el mouse listener a posiciones concretas
				
				
				//Para colocar los peones negros en su posicion inicial
				
				if(i==1) {
					
					Piezas p=new Peon("Negro",i,k,new ImageIcon(getClass().getResource("/images/peon.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					icono.putClientProperty("pieza", p); //para asociar la pieza con la casilla
					
					
					icono.addMouseListener(new ControladorMovimiento());
					
					
					
				}
				
				
		// para colocar las torres blancas en su poscion inicial
				
				if(i==7 && k==0) {
					
					Piezas p=new Torre("Blanco",i,k,new ImageIcon(getClass().getResource("/images/torreBlanca.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==7 && k==7) {

					Piezas p=new Torre("Blanco",i,k,new ImageIcon(getClass().getResource("/images/torreBlanca.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				// para colocar las CABALLOS blancos en su poscion inicial
				
				if(i==7 && k==6) {
					
					
					Piezas p=new Caballo("Blanco",i,k,new ImageIcon(getClass().getResource("/images/caballoblanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==7 && k==1) {

					Piezas p=new Caballo("Blanco",i,k,new ImageIcon(getClass().getResource("/images/caballoblanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
	// para colocar las ALFILES blancos en su poscion inicial
				
				if(i==7 && k==5) {
					
					Piezas p=new Alfil("Blanco",i,k,new ImageIcon(getClass().getResource("/images/alfilBlanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				
					
				}
				
				if(i==7 && k==2) {
					
					
					
					Piezas p=new Alfil("Blanco",i,k,new ImageIcon(getClass().getResource("/images/alfilBlanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
				}
				
				
				// para colocar las DAMA Blanco en su poscion inicial
				
				if(i==7 && k==3) {
					
					
					
					Piezas p=new Dama("Blanco",i,k,new ImageIcon(getClass().getResource("/images/damablanca.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
		
					
				}
				
				// para colocar las REY Blanco en su poscion inicial
				
				if(i==7 && k==4) {
					
					
					
					Piezas p=new Rey("Blanco",i,k,new ImageIcon(getClass().getResource("/images/reyblanco.gif")));
					
					icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
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
		
		private void restaurarColoresOriginales() {//replicamos la logica hecha para colorear las casillas en este metodo
			
			for (int i = 0; i < 8; i++) {
				
				
				
				if(i%2==0) {
					
				
					
				for (int j = 0; j < 8; j++) {
					
					if(j%2==0) {
						
						casillasConNombre[i][j].setBackground(Color.white);
						
					}else {
						
						casillasConNombre[i][j].setBackground(Color.green);
						
					}
				
				
				}
				
				
				
				}else {
				
				for (int k = 0; k < 8; k++) {
					
					if(k%2!=0) {
						
						casillasConNombre[i][k].setBackground(Color.white);
						
					}else {
						
						casillasConNombre[i][k].setBackground(Color.green);
						
					}
					
				}
				
				}
				
			
			
			
		}
				}
			
		
		
		
		public void mouseClicked(MouseEvent e) {
			
			restaurarColoresOriginales();//lo llamamos aqui para que cada vez que se clique se reinicien los colores
		
			
			 Piezas piezaSelected = (Piezas) ((JLabel) e.getSource()).getClientProperty("pieza");//con getClientProperty nos lleva a la pieza que hay asociada a esa casilla
		
			if(piezaSelected==null) {
				
				System.out.println("algo falla");
				
			}
				
				for (int i = 0; i < 8; i++) {
					
					for (int j = 0; j < 8; j++) {
						
						if(piezaSelected.esMovimientoValido(i, j)) {
							
							casillasConNombre[i][j].setBackground(Color.red);
							
							System.out.println("Se deben iluminar de rojo los puntos "+ nombreCasilla[i][j]);
						}
						
					}
					
				}
			
	
		}

	
		
	
	
	
	
}
	}
	

	





	


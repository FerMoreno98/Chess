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
	
	private JPanel laminaCasillas;
	
	private String [] [] nombreCasilla;
	
	private JButton boton;
	
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
				
				JPanel casilla=new JPanel();
				
				casilla.setBorder(borde);
				
				laminaCasillas.add(casilla);
				
				nombreCasilla[i][j]=letra+Integer.toString(8-i);
				
				
				//para colocar los peones blancos en su poscion inicial
				
				if(i==6) {
				
					Piezas p=new Peon("Blanco",i,j,new ImageIcon(getClass().getResource("/images/peonblanco.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				// para colocar las torres negras en su poscion inicial
				
				if(i==0 && j==0) {

					Piezas p=new Torre("Negro",i,j,new ImageIcon(getClass().getResource("/images/torre.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==0 && j==7) {

					Piezas p=new Torre("Negro",i,j,new ImageIcon(getClass().getResource("/images/torre.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				
				// para colocar las CABALLOS negros en su poscion inicial
				
				if(i==0 && j==1) {
					
					Piezas p=new Caballo("Negro",i,j,new ImageIcon(getClass().getResource("/images/caballo.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==0 && j==6) {
					
					Piezas p=new Caballo("Negro",i,j,new ImageIcon(getClass().getResource("/images/caballo.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				
	// para colocar las ALFILES negros en su poscion inicial
				
				if(i==0 && j==2) {
					
					Piezas p=new Alfil("Negro",i,j,new ImageIcon(getClass().getResource("/images/alfil.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==0 && j==5) {
					
					Piezas p=new Alfil("Negro",i,j,new ImageIcon(getClass().getResource("/images/alfil.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
				}
				
	// para colocar las DAMA Negro en su poscion inicial
				
				if(i==0 && j==3) {

					Piezas p=new Dama("Negro",i,j,new ImageIcon(getClass().getResource("/images/dama.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
				}
				
				// para colocar las REY Negro en su poscion inicial
				
				if(i==0 && j==4) {
					
					
					
					Piezas p=new Rey("Negro",i,j,new ImageIcon(getClass().getResource("/images/rey.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
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
				
				JPanel casilla=new JPanel();
				
				casilla.setBorder(borde);
				
				laminaCasillas.add(casilla);
				
				nombreCasilla[i][k]=letra+Integer.toString(8-i);
				
				
				//Para colocar los peones negros en su posicion inicial
				
				if(i==1) {
					
					Piezas p=new Peon("Negro",i,k,new ImageIcon(getClass().getResource("/images/peon.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				
		// para colocar las torres blancas en su poscion inicial
				
				if(i==7 && k==0) {
					
					Piezas p=new Torre("Blanco",i,k,new ImageIcon(getClass().getResource("/images/torreBlanca.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==7 && k==7) {

					Piezas p=new Torre("Blanco",i,k,new ImageIcon(getClass().getResource("/images/torreBlanca.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				// para colocar las CABALLOS blancos en su poscion inicial
				
				if(i==7 && k==6) {
					
					
					Piezas p=new Caballo("Blanco",i,k,new ImageIcon(getClass().getResource("/images/caballoblanco.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==7 && k==1) {

					Piezas p=new Caballo("Blanco",i,k,new ImageIcon(getClass().getResource("/images/caballoblanco.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
	// para colocar las ALFILES blancos en su poscion inicial
				
				if(i==7 && k==5) {
					
					Piezas p=new Alfil("Blanco",i,k,new ImageIcon(getClass().getResource("/images/alfilBlanco.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
				}
				
				if(i==7 && k==2) {
					
					
					
					Piezas p=new Alfil("Blanco",i,k,new ImageIcon(getClass().getResource("/images/alfilBlanco.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
					
				}
				
				
				// para colocar las DAMA Blanco en su poscion inicial
				
				if(i==7 && k==3) {
					
					
					
					Piezas p=new Dama("Blanco",i,k,new ImageIcon(getClass().getResource("/images/damablanca.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
					casilla.add(icono);
					
		
					
				}
				
				// para colocar las REY Blanco en su poscion inicial
				
				if(i==7 && k==4) {
					
					
					
					Piezas p=new Rey("Blanco",i,k,new ImageIcon(getClass().getResource("/images/reyblanco.gif")));
					
					JLabel icono=new JLabel(p.getImagenPieza());
					
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
	
	private class ControladorMovimiento implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton botonPulsado=(JButton)e.getSource();
			
			if(botonPulsado.getText()=="Peon") {
				
				
				
			}
			
		}
		
		public void moverPieza(int nuevaFila,int nuevaColumna, Piezas[][] movimiento) {
			
			
		
		
	}
	
	
	
}
	

}



	


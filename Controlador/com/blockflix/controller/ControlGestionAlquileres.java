package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.src.alquiler.GestionAlquileres;
import com.blockflix.src.socios.Socio;
import com.blockflix.view.empleado.AlquilarDialog;
import com.blockflix.view.empleado.GestionAlquileresPanel;

public class ControlGestionAlquileres implements ActionListener {

	private GestionAlquileresPanel ga;
	private Socio socio;
	public ControlGestionAlquileres(GestionAlquileresPanel ga){
		this.ga = ga;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();
		
		if (cmd.equals(GestionAlquileresPanel.BA)){
			//ALQUILAR
			AlquilarDialog ad = new AlquilarDialog();
			ad.setVisible(true);
			
		}
		else if (cmd.equals(GestionAlquileresPanel.BD)){
			//DEVOLVER
			if (checkSocio()){
				//SE DEVUELVE
				int salida = Main.emp.devolverAlquiler(socio.getnSocio());
				if (salida==0){
					//TODO OK
					JOptionPane.showMessageDialog(new JFrame(),

							"Alquiler devuelto satisfactoriamente",
							"Devolución completada",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					//SOCIO SANCIONADO
					JOptionPane.showMessageDialog(new JFrame(),

							"Socio sancionado, se retrasó en la devolución",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
	
	public boolean checkSocio(){

		//SE BUSCA POR NºDE SOCIO

		//Se introdujo un nº de socio
		int nSocio=-1;
		boolean isNumber=true;
		//Se comprueba si lo que se ha introducido es un integer
		try{
			nSocio = Integer.parseInt(ga.getSocioId());
		}catch(NumberFormatException e){
			//El nsocio no es un integer

			isNumber=false;

		}
		//Si se introdujo un número
		if (isNumber){
			socio = Main.emp.gs.buscarSocio(nSocio);
			//No Encontro al socio, 
			if (socio==null){
				JOptionPane.showMessageDialog(new JFrame(),

						"No existe socio con esa id",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			//Enconto al socio
			else{
				
				
				//Comprobamos que el socio  tiene alquileres
				if (Main.emp.ga.tieneAlquileres(nSocio)){
					
					return true;
				}

				//El socio no tiene alquileres
				JOptionPane.showMessageDialog(new JFrame(),

						"El socio no tiene alquileres que devolver",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

		}
		//Lo que se introdujo no era un integer, se avisa al usuario
		else{
			//No es un numero, se avisa
			JOptionPane.showMessageDialog(new JFrame(),

					"Los nº de socio son números naturales",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		

	}
}

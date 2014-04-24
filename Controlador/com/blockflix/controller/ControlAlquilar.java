package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.contratos.Contrato;
import com.blockflix.src.productos.Producto;
import com.blockflix.src.socios.Socio;
import com.blockflix.view.empleado.AlquileresPanel;
import com.blockflix.view.empleado.PagoDialog;

public class ControlAlquilar implements ActionListener{

	private AlquileresPanel ap;
	private Socio socio;
	private ArrayList<Producto> listaProductos;
	public ControlAlquilar(AlquileresPanel ap){
		socio = null;
		this.ap=ap;
		listaProductos = new ArrayList<Producto>();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();

		if (cmd.equals(AlquileresPanel.BADDALQUILER)){
			//SE QUIERE AÑADIR ALQUILER A LISTA
			//Comprobamos que no se han añadido el maximo de alquileres
			if (listaProductos.size()>Constantes.variables.MAX_ALQUILERES){
				JOptionPane.showMessageDialog(new JFrame(),

						"Ha alcanzado el máximo de alquileres",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			//Comprobamos campos
			else if (checkField(ap.getProductoId())){
				//Comprobamos si existe el producto o ejemplares
				if (checkProducto(ap.getProductoId())){
					ap.insertRow(listaProductos.size(), listaProductos.get(listaProductos.size()).getId());
				}else{
					JOptionPane.showMessageDialog(new JFrame(),

							"El producto indicado no tiene ejemplares, no existe o ya está añadido",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}


		}else if (cmd.equals(AlquileresPanel.BPAGAR)){
			//SE QUIERE PAGAR

			//SE COMPRUEBA QUE HAY PRODUCTOS EN LA LISTA

			//SE COMPRUEBA QUE EXISTE EL SOCIO
			if (checkSocio()){
				//SOCIO VALIDO
				if (!listaProductos.isEmpty()){
					//Hay productos que alquilar
					Contrato c;
					boolean pagoCorrecto=true;
					if ( (c=Main.emp.gc.getContratoSocio(socio.getnSocio())) == null || Main.emp.necesitaPagarAlquiler(c,listaProductos)){

						//Se paga, se supone que el pago se va a realizar correctamente
						
						
						PagoDialog pd = new PagoDialog(Main.emp.calcularCuantiaAlquiler(listaProductos));
						pd.setControlador(new ControlPago(pd));
						pd.setVisible(true);
						if (!pd.isPagoRealizado()){
							pagoCorrecto=false;
							pd.dispose();
						}
						
					}
					else {
						//No se paga
						JOptionPane.showMessageDialog(new JFrame(),

								"Su tarifa cubre los productos, no necesita pagar",
								"No necesita pagar",
								JOptionPane.INFORMATION_MESSAGE);
					}
					//PAGO CORRECTO, SE ALQUILA
					if (pagoCorrecto){
						//Si se ha llegado aqui se cumplen todas las condiciones para el alquiler y se procede a realizarse
						Main.emp.alquilar(socio.getnSocio(), listaProductos);
						JOptionPane.showMessageDialog(new JFrame(),

								"Alquiler realizado correctamente",
								"Alquiler realizado",
								JOptionPane.INFORMATION_MESSAGE);
						
					}
					//PAGO NO CORRECTO
					else {
						JOptionPane.showMessageDialog(new JFrame(),

								"Error con el aquiler, no se pudo realizar",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}
	}

	public boolean yaEstaSeleccionado(Producto p){
		for (Producto prod : listaProductos){
			if (prod.getId()==p.getId())
				return true;
		}
		return false;
	}

	public boolean checkProducto(String id){
		int idProducto=-1;
		boolean isNumber=true;
		Producto p;
		//Se comprueba si lo que se ha introducido es un integer
		try{
			idProducto = Integer.parseInt(ap.getProductoId());
		}catch(NumberFormatException e){
			//El id no es un integer

			isNumber=false;
		}
		//Es una id válida, comprobamos si existe
		if (isNumber){
			p=Main.emp.gp.buscarProductoById(idProducto);
			//Si no encuentra el producto
			if (p==null){
				return false;
			}
			else{
				//No hay ejemplares
				if(Main.emp.ge.buscarEjemplaresProducto(idProducto).isEmpty()){
					return false;
				}
				//Hay ejemplares, se añade el producto a la lista para alquilar
				else{
					//Vemos si no estaba ya añadido
					if (yaEstaSeleccionado(p)){
						return false;
					}
					//si se llega aqui, se puede agregar
					this.listaProductos.add(p);
					return true;
				}
			}
		}
		return false;
	}

	
	public boolean checkField(String text){
		if (text.trim().isEmpty())
			return false;
		else return true;
	}



	public boolean checkSocio(){

		//SE BUSCA POR NºDE SOCIO

		//Se introdujo un nº de socio
		int nSocio=-1;
		boolean isNumber=true;
		//Se comprueba si lo que se ha introducido es un integer
		try{
			nSocio = Integer.parseInt(ap.getSocioId());
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
				//Comprobamos que no tenga sancion//Comprobamos que el socio no tenga sancion
				if (Main.emp.gs.isSocioSancionado(nSocio)){
					JOptionPane.showMessageDialog(new JFrame(),

							"Socio sancionado, no puede alquilar",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return false;
				}
				//Socio no sancionado, comprobamos que no tenga alquileres
				//Comprobamos que el socio no tiene alquileres
				if (Main.emp.ga.tieneAlquileres(nSocio)){
					JOptionPane.showMessageDialog(new JFrame(),

							"El socio tiene alquileres pendientes de devolver...",
							"Error",
							JOptionPane.ERROR_MESSAGE);

					return false;
				}

				//El socio puede alquilar
				return true;
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

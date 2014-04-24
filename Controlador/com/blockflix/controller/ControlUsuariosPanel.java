package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.src.socios.Socio;
import com.blockflix.view.empleado.AddUsuarioDialog;
import com.blockflix.view.empleado.ProfileDialog;
import com.blockflix.view.empleado.UsuariosPanel;

public class ControlUsuariosPanel implements ActionListener{
	private UsuariosPanel up;
	Socio socio;

	public ControlUsuariosPanel (UsuariosPanel up){
		this.up=up;
		socio=null;
	}

	@Override
	public void actionPerformed(ActionEvent c) {
		// TODO Auto-generated method stub
		String cmd = c.getActionCommand();

		if (cmd.equals(UsuariosPanel.BA)){
			//AÑADIR USUARIO
			AddUsuarioDialog addDialog =new AddUsuarioDialog();//(JFrame)SwingUtilities.getWindowAncestor(up));
			addDialog.setControlador(new ControlAddUsuario(addDialog));
			addDialog.setVisible(true);
		}
		else if (cmd.equals(UsuariosPanel.BS)){
			//BUSCAR USUARIO
			if (!checkField(up.getSearchValue())){
				//Error en los campos
				JOptionPane.showMessageDialog(new JFrame(),

						"Faltan campos por rellenar",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				//SE BUSCA POR DNI
				if (up.getSelectedOption().equals(UsuariosPanel.RBDNI)){
					//Se introdujo un DNI
					socio = Main.emp.gs.buscarSocio(up.getSearchValue());
					if (socio==null){
						//No existe el socio
						resetAll();
					}
					else{

						up.setNsocioResult(Integer.toString(socio.getnSocio()));
						up.setNameResult(socio.getNombre()+" "+socio.getApellidos());
					}
				}
				//SE BUSCA POR NºDE SOCIO
				else{
					//Se introdujo un nº de socio
					int nSocio=-1;
					boolean isNumber=true;
					//Se comprueba si lo que se ha introducido es un integer
					try{
						nSocio = Integer.parseInt(up.getSearchValue());
					}catch(NumberFormatException e){
						//El nsocio no es un integer
						resetAll();
						isNumber=false;

					}
					//Si se introdujo un número
					if (isNumber){
						socio = Main.emp.gs.buscarSocio(nSocio);
						//No Encontro al socio, se resetean los campos
						if (socio==null){
							resetAll();
						}
						//Enconto al socio, se muestra su info
						else{
							up.setNsocioResult(Integer.toString(socio.getnSocio()));
							up.setNameResult(socio.getNombre()+" "+socio.getApellidos());
						}

					}
					//Lo que se introdujo no era un integer, se avisa al usuario
					else{
						//No es un numero, se avisa
						JOptionPane.showMessageDialog(new JFrame(),

								"Los nº de socio son números naturales",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		}
		//VER PERFIL DE USUARIO
		else if (cmd.equals(UsuariosPanel.BP)){
			//Se quiere ver el perfil del socio
			if (socio==null){
				//No existe el socio, no se puede ver el perfil
				JOptionPane.showMessageDialog(new JFrame(),

						"No se puede mostrar perfil, no hubo resultados en la búsqueda",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				//Se muestra el perfil del socio
				ProfileDialog pd = new ProfileDialog(socio);
				pd.setVisible(true);
			}
		}

	}

	public boolean checkField(String text){
		if (text.trim().isEmpty())
			return false;
		else return true;
	}

	public void resetAll(){
		socio=null;
		up.setNameResult("No se encontraron resultados");
		up.setNsocioResult("No se encontraron resultados");

	}

}



package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.src.socios.Socio;
import com.blockflix.view.empleado.AddUsuarioDialog;
import com.blockflix.view.empleado.UsuariosPanel;

public class ControlUsuariosPanel implements ActionListener{
	private UsuariosPanel up;
	int nSocio;
	
	public ControlUsuariosPanel (UsuariosPanel up){
		this.up=up;
		nSocio = -1;
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
				//Se comprueba si existe
				if (up.getSelectedOption().equals(UsuariosPanel.RBDNI)){
					//Se introdujo un DNI
					Socio socio = Main.emp.gs.buscarSocio(up.getSearchValue());
					if (socio==null){
						//No existe el socio
						resetAll();
					}
					else{
						nSocio = socio.getnSocio();
						up.setNsocioResult(Integer.toString(nSocio));
						up.setNameResult(socio.getNombre()+" "+socio.getApellidos());
					}
				}
				else{
					//Se introdujo un nº de socio
					
				}
			}
		}
		
	}
	
	public boolean checkField(String text){
		if (text.trim().isEmpty())
			return false;
		else return true;
	}
	
	public void resetAll(){
		nSocio=-1;
		up.setNameResult("No se encontraron resultados");
		up.setNsocioResult("No se encontraron resultados");
		
	}

}



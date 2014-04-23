package com.blockflix.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.blockflix.view.VentanaPrincipal;

public class ControlVentanaPrincipal implements WindowListener{

	private VentanaPrincipal vp;
	
	public ControlVentanaPrincipal(VentanaPrincipal vp){
		this.vp = vp;
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		vp.saveAndExit();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}

package com.blockflix.view.empleado;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.blockflix.src.socios.Socio;

public class ProfileDialog extends JDialog{
	JPanel mainPanel,leftPanel,rightPanel,datosPersonales,panelTarifa, topPanel,bottomPanel;
	JLabel nombre,apellidos,direccion,telefono,dni,nSocio;
	JLabel title;
	JButton addTarifa;
	public ProfileDialog(Socio socio){
		//INI
		title=new JLabel("Ficha de socio");
		title.setFont(new Font(null,Font.BOLD,24));
		mainPanel=new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		datosPersonales= new JPanel(new GridLayout(3,2,3,3));
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
		nombre = new JLabel(socio.getNombre());
		apellidos= new JLabel(socio.getApellidos());
		direccion= new JLabel(socio.getDireccion());
		telefono= new JLabel(socio.getTelefono());
		dni= new JLabel(socio.getDni());
		nSocio= new JLabel(Integer.toString(socio.getnSocio()));
		addTarifa = new JButton("Cambiar tarifa");
		panelTarifa=new JPanel();
		
		//Panel superior
		topPanel.add(title);
		
		//Panel de datos personales
		datosPersonales.add(new JLabel("<html><b>Nombre:</b></html>"));
		datosPersonales.add(nombre);
		datosPersonales.add(new JLabel("<html><b>Apellidos:</b></html>"));
		datosPersonales.add(apellidos);
		datosPersonales.add(new JLabel("<html><b>Dirección:</b></html>"));
		datosPersonales.add(direccion);
		datosPersonales.add(new JLabel("<html><b>Teléfono:</b></html>"));
		datosPersonales.add(telefono);
		datosPersonales.add(new JLabel("<html><b>Nº de Socio:</b></html>"));
		datosPersonales.add(nSocio);
		datosPersonales.add(new JLabel("<html><b>DNI/NIE:</b></html>"));
		datosPersonales.add(dni);
		datosPersonales.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		
		//Panel Tarifa
		panelTarifa.add(new JLabel("<html><b>Tarifa contratada:</b></html>"));
		panelTarifa.add(addTarifa);
		panelTarifa.setBorder(BorderFactory.createTitledBorder("Tarifas"));
		
		//Panel izquierda
		
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(datosPersonales);
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)) ;
		
		//Panel derecha
		rightPanel.add(Box.createVerticalStrut(10));
		rightPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		rightPanel.add(Box.createVerticalStrut(10));
		rightPanel.add(panelTarifa);
		rightPanel.add(Box.createVerticalStrut(10));
		rightPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		rightPanel.add(Box.createVerticalStrut(10));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)) ;
		//Panel inferior
		bottomPanel.add(leftPanel);
		bottomPanel.add(Box.createHorizontalStrut(20));
		bottomPanel.add(rightPanel);
		
		
		//Panel Principal
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20)) ;
		
		
		//Contenedor
	
		this.add(mainPanel);
		this.setTitle("Información del socio");
		
		this.pack();
//		this.setResizable(false);
		this.setLocationRelativeTo(null);
	//	this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}

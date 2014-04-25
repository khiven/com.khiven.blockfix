package com.blockflix.view.empleado;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GestionAlquileresPanel extends JPanel {

	private JLabel lTitle;
	private JButton bAlquilar,bDevolver;
	private JTextField jtNsocio;
	public static final String BA = "BA";
	public static final String BD = "BD";
	public GestionAlquileresPanel(){
		jtNsocio = new JTextField(5);
		bDevolver = new JButton("Devolver alquiler");
		bDevolver.setActionCommand(BD);
		bAlquilar = new JButton("Alquilar");
		bAlquilar.setActionCommand(BA);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		lTitle = new JLabel("Gestión de Alquileres");
		lTitle.setFont(new Font(null,Font.BOLD,32));
		
		JPanel panelTitulo = new JPanel(new FlowLayout());
		panelTitulo.add(lTitle);
		this.add(panelTitulo);
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));
		
		JPanel panelAlquilar = new JPanel(new FlowLayout());
		panelAlquilar.add(bAlquilar);
		this.add(panelAlquilar);
		
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));
		
		
		JPanel panelDevolver = new JPanel(new FlowLayout()); //GridLayout(1,3));
		panelDevolver.add(new JLabel("NºSocio"));
		panelDevolver.add(jtNsocio);
		panelDevolver.add(bDevolver);
		this.add(panelDevolver);
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));
		this.setBorder(BorderFactory.createEmptyBorder(10,50,10,50)) ;
		
	}
	
	public void setControlador(ActionListener c){
		bAlquilar.addActionListener(c);
		bDevolver.addActionListener(c);
	}
	public String getSocioId(){
		return jtNsocio.getText();
	}
}

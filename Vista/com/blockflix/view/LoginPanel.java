package com.blockflix.view;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel{
	public static final String BG = "BG";
	private JButton bEmpleado;
	private JButton bGerente;
	private JPasswordField pwField;
	private JTextField error;
	public LoginPanel(){
		
		bEmpleado = new JButton("Login Empleado");
		bGerente = new JButton("Login Gerente");
		bGerente.setActionCommand(BG);
		
		//Creamos un pwfield que tiene un texto inicial y al hacer click se resetea
		error = new JTextField("Password Incorrecto...");
		pwField = new JPasswordField("Password gerente");
		pwField.setEchoChar((char)0);

	    pwField.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	            pwField.setText("");
	            pwField.setEchoChar('*');
	        }

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
		
	
		
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		this.add(bEmpleado);
		this.add(Box.createHorizontalStrut(5));
		this.add(new JSeparator(SwingConstants.VERTICAL));
		this.add(Box.createHorizontalStrut(5));
		this.add(bGerente);
		this.add(pwField);
		this.add(error);
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		error.setVisible(false);
		
		
	}

	
	public void setControlador(ActionListener c){
		pwField.addActionListener(c);
		bGerente.addActionListener(c);
	}
	public char[] getPassword(){
		return pwField.getPassword();
	}
}

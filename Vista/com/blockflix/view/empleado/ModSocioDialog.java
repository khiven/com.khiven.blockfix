package com.blockflix.view.empleado;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ModSocioDialog extends JDialog {

		public static final String BA = "BA";
		public static final String BC = "BC";
		private JLabel lTitulo;
		private JPanel mainPanel;
		private AddUsuarioForm formulario;
		private JPanel buttonContainer;
		private JPanel titleContainer;
		private JButton bOk,bCancel;

		public ModSocioDialog(){


			//super((JFrame)SwingUtilities.getWindowAncestor(parent),"Añadir Usuario");
			lTitulo = new JLabel("Modificar socio");
			lTitulo.setFont(new Font(null,Font.BOLD,32));
			titleContainer=new JPanel();
			formulario = new AddUsuarioForm();
			bOk=new JButton("Modificar Socio");
			bOk.setActionCommand(BA);
			bCancel=new JButton("Cancelar");
			bCancel.setActionCommand(BC);
			buttonContainer = new JPanel();
			mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
			titleContainer.add(lTitulo);
			mainPanel.add(titleContainer);

			mainPanel.add(Box.createVerticalStrut(10));
			mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
			mainPanel.add(Box.createVerticalStrut(10));

			mainPanel.add(formulario);

			mainPanel.add(Box.createVerticalStrut(10));
			mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
			mainPanel.add(Box.createVerticalStrut(10));

			buttonContainer.add(bOk);
			buttonContainer.add(bCancel);
			mainPanel.add(buttonContainer);

			mainPanel.add(Box.createVerticalStrut(10));
			mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
			mainPanel.add(Box.createVerticalStrut(10));

			mainPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50)) ;

			this.setTitle("Modificar socio");
			this.add(mainPanel);
			this.pack();
			this.setResizable(false);
			this.setLocationRelativeTo(null);
		//	this.setAlwaysOnTop(true);
			this.setModal(true);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


		}

		

		public void setControlador(ActionListener c){
			bOk.addActionListener(c);
			bCancel.addActionListener(c);

		}
		
		public boolean checkFields(){
			return formulario.checkFields();
		}
		
		public String getNombre(){
			return formulario.gettNombre().getText();
		}

		
		public String getApellidos(){
			return formulario.gettApellidos().getText();
		}
		public String getDireccion(){
			return formulario.gettDireccion().getText();
		}
		public String getTelefono(){
			return formulario.gettTelefono().getText();
		}

		public String getDni(){
			return formulario.gettDni().getText();
		}
		
		


	}



package com.blockflix.view.empleado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UsuariosPanel extends JPanel{
	public static final String BA = "BA";
	public static final String BS = "BS";
	public static final String BP = "BP";
	public static final String RBDNI = "RBDNI";
	public static final String RBNSOCIO = "RBNSOCIO";
	
	
	
	private JButton addSocio;
	private JButton searchSocios,viewProfile;
	private JLabel lSocios,lNombreSocio,lNsocio,lResNombreSocio,lResNsocio;
	private JTextField tfBuscarSocio;
	private JRadioButton rbDni,rbId;
	private ButtonGroup group;
	
	
	
	public UsuariosPanel(){
		addSocio = new JButton("Añadir nuevo socio");
		addSocio.setActionCommand(BA);
		searchSocios = new JButton("Buscar socio");
		searchSocios.setActionCommand(BS);
		viewProfile = new JButton("Ver perfil del socio");
		viewProfile.setActionCommand(BP);
		lSocios=new JLabel("Gestión de Socios");
		lSocios.setFont(new Font(null,Font.BOLD,32));
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		JPanel pLabel = new JPanel(new FlowLayout());
		pLabel.add(lSocios);
		this.add(pLabel);
		
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));

		JPanel paddSocio = new JPanel(new FlowLayout());
		paddSocio.add(addSocio);
		this.add(paddSocio);

		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));

		
		JPanel psearchSocios = new JPanel(new FlowLayout());
		group = new ButtonGroup();
		rbDni = new JRadioButton("DNI");
		rbId = new JRadioButton("NºSocio");
		rbId.setSelected(true);
		group.add(rbId);
		group.add(rbDni);
		tfBuscarSocio = new JTextField(10);
		tfBuscarSocio.setActionCommand(BS);
		psearchSocios.add(rbId);
		psearchSocios.add(rbDni);
		psearchSocios.add(tfBuscarSocio);
		psearchSocios.add(searchSocios);
		//psearchSocios.setBorder(BorderFactory.createEtchedBorder());
		this.add(psearchSocios);
		this.add(Box.createVerticalStrut(10));
		JPanel pResultados = new JPanel(new GridLayout(2,2,5,15));
		lNombreSocio = new JLabel("<html><b>Nombre del socio:</b></html>");
		lResNombreSocio = new JLabel();
		lResNsocio = new JLabel();
		lNsocio = new JLabel("<html><b>Nº de socio:</b></html>");
		pResultados.add(lNombreSocio);
		pResultados.add(lResNombreSocio);
		pResultados.add(lNsocio);
		pResultados.add(lResNsocio);
	//	pResultados.setBorder(BorderFactory.createEtchedBorder());
		this.add(pResultados);
		this.add(Box.createVerticalStrut(10));
		JPanel pViewProfile = new JPanel(new FlowLayout());
		pViewProfile.add(viewProfile);
		
		this.add(pViewProfile);
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));

	
		this.setBorder(BorderFactory.createEmptyBorder(10,50,10,50)) ;
		
		
	}
	
	public void setControlador(ActionListener c){
		addSocio.addActionListener(c);
		searchSocios.addActionListener(c);
		viewProfile.addActionListener(c);
		tfBuscarSocio.addActionListener(c);
		
	}
	public String getSelectedOption(){
		if (rbDni.isSelected())
			return RBDNI;
		else
			return RBNSOCIO;
	}
	
	public String getSearchValue(){
		return this.tfBuscarSocio.getText();
	}
	
	public void setNameResult(String name){
		this.lResNombreSocio.setText(name);
	}
	public void setNsocioResult(String nSocio){
		this.lResNsocio.setText(nSocio);
	}
	
}

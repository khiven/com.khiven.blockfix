package com.blockflix.view.empleado;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PagoDialog extends JDialog {

	JPanel mainPanel;
	JLabel lTitle,lTotal;
	JTextField tfNtarjeta;
	JPasswordField tfPwTarjeta;
	double cantidad;
	JButton bPagar;
	private boolean pagoRealizado = false;
	public PagoDialog(double cantidad){
		tfNtarjeta=new JTextField(12);
		tfPwTarjeta = new JPasswordField(4);
		
		bPagar = new JButton("Realizar Pago");
		this.cantidad=cantidad;
		lTitle = new JLabel("Pasarela de pago");
		lTitle.setFont(new Font(null,Font.BOLD,32));
		lTotal=new JLabel();
		lTotal.setFont(new Font(null,Font.BOLD,18));
		lTotal.setText(getTotalString(cantidad));
		
		mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		JPanel titlePanel = new JPanel(new FlowLayout());
		titlePanel.add(lTitle);
		
		mainPanel.add(titlePanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mainPanel.add(Box.createVerticalStrut(10));
		
		JPanel infoPagoPanel = new JPanel(new GridLayout(3,2,10,0));
		infoPagoPanel.add(new JLabel("<html><b>Va a proceder a pagar a BlockFlix</b></html>"));
		infoPagoPanel.add(lTotal);
		infoPagoPanel.add(new JLabel("Nº de tarjeta"));
		infoPagoPanel.add(tfNtarjeta);
		infoPagoPanel.add(new JLabel("Pin"));
		infoPagoPanel.add(tfPwTarjeta);
		infoPagoPanel.setBorder(BorderFactory.createTitledBorder("Información del pago"));
		
		mainPanel.add(infoPagoPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mainPanel.add(Box.createVerticalStrut(10));
		
		JPanel panelBoton = new JPanel(new FlowLayout());
		panelBoton.add(bPagar);
		mainPanel.add(panelBoton);
		
		this.add(mainPanel);
		this.setTitle("Pasarela de Pago");	
		this.pack();
//		this.setResizable(false);
		this.setLocationRelativeTo(null);
//		this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	public String getTotalString(double precio){
		return Double.toString(precio)+"€";
	}
	public double getTotal(){
		return this.cantidad;
	}
	public String getPin(){
		return String.valueOf(this.tfPwTarjeta.getPassword());
	}
	public String getNtarjeta(){
		return this.tfNtarjeta.getText();
	}
	
	public void setControlador(ActionListener c){
		bPagar.addActionListener(c);
	}
	public boolean isPagoRealizado(){
		return this.pagoRealizado;
	}
	public void setPagoRealizado(boolean pago){
		this.pagoRealizado=pago;
	}
	
}

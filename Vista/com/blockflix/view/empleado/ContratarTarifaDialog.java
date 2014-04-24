package com.blockflix.view.empleado;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.socios.Socio;

public class ContratarTarifaDialog extends JDialog{

	
	public static final String BPAGO = "BPAGO";
	public static final String CBTARIFAS = "CBTARIFAS";
	public static final String CBSUPLEMENTO = "CBSUPLEMENTO";
	
	private JLabel lTitle,lTotal;
	private JButton bPagar;
	private JCheckBox cbSuplemento;
	private JComboBox cbTarifas;
	private String[] lTarifas = {TipoTarifa.PELICULAS.toString(),TipoTarifa.SERIES.toString(),
			TipoTarifa.MUSICA.toString(),TipoTarifa.PELICULAS_SERIES.toString(),
			TipoTarifa.PELICULAS_MUSICA.toString(),TipoTarifa.SERIES_MUSICA.toString(),
			TipoTarifa.PREMIUM.toString()};
	private boolean tarifaContratada;
	private Socio socio;
	
	public ContratarTarifaDialog(Socio socio){
		this.socio=socio;
	tarifaContratada=false;
	bPagar = new JButton("Pagar");
	bPagar.setActionCommand(BPAGO);
	lTitle=new JLabel("Contratar Tarifa");
	lTitle.setFont(new Font(null,Font.BOLD,32));
	lTotal=new JLabel("TOTAL");
	lTotal.setFont(new Font(null,Font.BOLD,18));
	JPanel mainPanel = new JPanel();
	mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
	JPanel pLabel = new JPanel(new FlowLayout());
	pLabel.add(lTitle);
	
	mainPanel.add(pLabel);
	
	mainPanel.add(Box.createVerticalStrut(10));
	mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
	mainPanel.add(Box.createVerticalStrut(10));
	
	JPanel panelTarifas = new JPanel(new GridLayout(2,2));
	cbTarifas = new JComboBox(lTarifas);
	cbTarifas.setActionCommand(CBTARIFAS);
	cbSuplemento = new JCheckBox("Suplemento de 1 día extra de alquiler");
	cbSuplemento.setActionCommand(CBSUPLEMENTO);
	panelTarifas.add(cbTarifas);
	panelTarifas.add(cbSuplemento);
	panelTarifas.add(new JLabel("Total a pagar:"));
	panelTarifas.add(lTotal);
	panelTarifas.setBorder(BorderFactory.createTitledBorder("Seleccione Tarifa"));
	
	mainPanel.add(panelTarifas);
	mainPanel.add(Box.createVerticalStrut(10));
	mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
	mainPanel.add(Box.createVerticalStrut(10));
	
	JPanel panelPagar = new JPanel(new FlowLayout());
	panelPagar.add(bPagar);
	mainPanel.add(panelPagar);
	mainPanel.add(Box.createVerticalStrut(10));
	mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
	mainPanel.add(Box.createVerticalStrut(10));

	this.add(mainPanel);
	this.setTitle("Contratar tarifa");	
	this.pack();
//	this.setResizable(false);
	this.setLocationRelativeTo(null);
//	this.setAlwaysOnTop(true);
	this.setModal(true);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}
	
	public void setPrecioTotal(String precio){
		lTotal.setText(precio+"€");
	}
	
	public void setControlador(ActionListener c){
		cbSuplemento.addActionListener(c);
		cbTarifas.addActionListener(c);
		bPagar.addActionListener(c);
	}
	
	public boolean isSuplemento(){
		return cbSuplemento.isSelected();
	}
	public String getSelectedTarifa(){
		return (String)cbTarifas.getSelectedItem();
	}
	public boolean isTarifaContratada(){
		return this.tarifaContratada;
	}
	
	public void setTarifaContratada(boolean b){
		this.tarifaContratada=b;
	}
	public Socio getSocio(){
		return this.socio;
	}
	
}

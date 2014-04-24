package com.blockflix.view.empleado;

import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.contratos.Contrato;
import com.blockflix.src.socios.Socio;

public class ProfileDialog extends JDialog{
	JPanel mainPanel,leftPanel,rightPanel,datosPersonales,panelTarifa, topPanel,bottomPanel,sancionPanel;
	JLabel nombre,apellidos,direccion,telefono,dni,nSocio;
	JLabel title;
	JLabel lisSancionado,lCuantia,lTarifa,lExtension;
	JButton addTarifa,bPagarSancion,bModificarSocio,bEliminarSocio;
	JTable tablaAlquileres;
	String[] titulosTabla = {"Producto","ID","Fecha devolución"};
	JScrollPane scrollTabla;
	int numRows;
	public static final String BDELSOCIO = "BDELSOCIO";
	public static final String BMODSOCIO = "BMODSOCIO";
	public static final String BPAGSANCION = "BPAGSANCION";
	public static final String BTARIFA = "BTARIFA";
	Socio socio;
	
	public ProfileDialog(Socio socio){
		//INI
		this.socio = socio;
		numRows = Constantes.variables.MAX_ALQUILERES;
		DefaultTableModel tableModel = new DefaultTableModel(numRows,titulosTabla.length);
		tableModel.setColumnIdentifiers(titulosTabla);
		tablaAlquileres = new JTable(tableModel);
		tablaAlquileres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		addTarifa.setActionCommand(BTARIFA);
		panelTarifa=new JPanel(new GridLayout(3,2));
		
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
		
		lTarifa=new JLabel("Sin tarifa contratada");
		panelTarifa.add(lTarifa);
		panelTarifa.add(new JLabel("<html><b>Extensión temporal:</b></html>"));
		lExtension=new JLabel("No");
		panelTarifa.add(lExtension);
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
	
		
		scrollTabla=new JScrollPane(tablaAlquileres);
		Dimension d = tablaAlquileres.getSize();
		scrollTabla.setPreferredSize(new Dimension(d.width,tablaAlquileres.getRowHeight()*(numRows+5)));
		scrollTabla.setBorder(BorderFactory.createTitledBorder("Alquileres"));
		
		leftPanel.add(scrollTabla);
		
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
		
		sancionPanel = new JPanel(new GridLayout(3,2));
		sancionPanel.setBorder(BorderFactory.createTitledBorder("Sanciones"));
		sancionPanel.add(new JLabel("<html><b>Socio sancionado:</b></html>"));
		lisSancionado=new JLabel("Socio sin sanción");
		sancionPanel.add(lisSancionado);
		sancionPanel.add(new JLabel("<html><b>Cuantía:</b></html>"));
		lCuantia = new JLabel("0€");
		sancionPanel.add(lCuantia);
		bPagarSancion=new JButton("Pagar sanción");
		bPagarSancion.setActionCommand(BPAGSANCION);
		sancionPanel.add(bPagarSancion);
		
		rightPanel.add(sancionPanel);
		rightPanel.add(Box.createVerticalStrut(10));
		rightPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		rightPanel.add(Box.createVerticalStrut(10));
		
		//Botones
		JPanel panelBotones = new JPanel(new GridLayout(1,1));
		bModificarSocio = new JButton("Modificar Socio");
		bModificarSocio.setActionCommand(BMODSOCIO);
		bEliminarSocio = new JButton("Eliminar Socio");
		bEliminarSocio.setActionCommand(BDELSOCIO);
		panelBotones.add(bModificarSocio);
		panelBotones.add(bEliminarSocio);
		rightPanel.add(panelBotones);
		rightPanel.add(Box.createVerticalStrut(10));
		rightPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		rightPanel.add(Box.createVerticalStrut(10));
		
		
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
	
	
	public void setControlador(ActionListener c){
		addTarifa.addActionListener(c);
		bEliminarSocio.addActionListener(c);
		bModificarSocio.addActionListener(c);
		bPagarSancion.addActionListener(c);
		
	}
	public void setInfoSocio(Socio socio){
		//INFO DE SANCION
		if (socio.getEstado()==Constantes.EstadoSocio.SANCIONADO){
			lisSancionado.setText("Socio sancionado");
			lCuantia.setText(Double.toString(socio.getSancion())+"€" );
		}
		//INFO DE TARIFA
		Contrato c;
		if ((c=Main.emp.gc.getContratoSocio(socio.getnSocio()))!=null){
			//Tiene tarifa
			lTarifa.setText(c.getTarifa().toString());
			if (c.getExtTiempo()){
				lExtension.setText("Sí");
			}
		}
		
	}
	public Socio getSocio(){
		return this.socio;
	}
	public void setLtarifa(String tarifa){
		lTarifa.setText(tarifa);
	}
}

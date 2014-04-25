package com.blockflix.view.empleado;

import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.socios.Socio;

public class AlquileresPanel extends JPanel{

	private JLabel title;
	private JTextField idProducto,nSocio;
	private Socio socio;
	private JButton addAlquiler,pagar;
	private JTable tablaProductos;
	private JScrollPane scrollTabla;
	private JTable tablaAlquileres;
	private int numRows;
	private String[] titulosTabla= {"ID Producto"};
	public static final String BADDALQUILER = "BADDALQUILER";
	public static final String BPAGAR = "BPAGAR";
	private DefaultTableModel tableModel;
	public AlquileresPanel(){
		numRows = Constantes.variables.MAX_ALQUILERES;
		tableModel = (new DefaultTableModel(numRows,titulosTabla.length){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		});
		
		tableModel.setColumnIdentifiers(titulosTabla);
		tablaAlquileres = new JTable(tableModel);
		tablaAlquileres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		idProducto = new JTextField(5);
		addAlquiler = new JButton("Añadir para alquilar");
		addAlquiler.setActionCommand(BADDALQUILER);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		title=new JLabel("Ficha de socio");
		title.setFont(new Font(null,Font.BOLD,24));
		JPanel titlePanel = new JPanel(new FlowLayout());
		this.add(titlePanel);
		
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));
		
		JPanel panelSeleccion = new JPanel(new GridLayout(1,2));
		panelSeleccion.add(idProducto);
		panelSeleccion.add(addAlquiler);
		panelSeleccion.setBorder(BorderFactory.createTitledBorder("Selección de productos"));
		
		this.add(panelSeleccion);
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));
		
		JPanel panelTabla = new JPanel(new GridLayout(1,1));
		scrollTabla=new JScrollPane(tablaAlquileres);
		Dimension d = tablaAlquileres.getSize();
		scrollTabla.setPreferredSize(new Dimension(d.width,tablaAlquileres.getRowHeight()*(numRows+5)));
		scrollTabla.setBorder(BorderFactory.createTitledBorder("Alquileres"));
		panelTabla.add(scrollTabla);
		
		this.add(panelTabla);
		
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));
		
		JPanel panelBoton = new JPanel(new GridLayout(2,2));
		panelBoton.add(new JLabel("Nº de socio"));
	
		pagar = new JButton("Pagar Alquiler");
		pagar.setActionCommand(BPAGAR);
		nSocio = new JTextField(5);
		panelBoton.add(nSocio);
		panelBoton.add(pagar);
		panelBoton.setBorder(BorderFactory.createTitledBorder("Selección de socio y pago"));
		this.add(panelBoton);
	}
	
	public void setControlador(ActionListener c){
		addAlquiler.addActionListener(c);
		pagar.addActionListener(c);
	}
	
	public String getProductoId(){
		return idProducto.getText();
	}
	public String getSocioId(){
		return nSocio.getText();
	}
	public void insertRow(int pos,int idProducto){
		Object[] nuevaFila={new Integer(idProducto)};
		
		tableModel.setValueAt(idProducto, pos-1,0);
		//tableModel.addRow(nuevaFila);
	}
}

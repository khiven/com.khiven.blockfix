package com.blockflix.viewGerente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.blockflix.src.Main;
import com.blockflix.src.productos.Producto;

public class PreguntaId extends JFrame{
	
	private GerentePanel gpanel;
	private PreguntaId frame = this;
	private int id;

	public PreguntaId(GerentePanel gpanel){
		this.setGpanel(gpanel);
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Introduzca el id del producto:");
		JTextField tField = new JTextField("Inserte ID");
		JButton bBuscar = new JButton("Buscar");
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(tField);
		panel.add(bBuscar);
		this.add(panel);
		this.setSize(new Dimension(300,200));
		this.setResizable(false);
		tField.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent e) {
				frame.setId(Integer.parseInt((((JTextField)e.getSource()).getText())));
			}
			
		});
		bBuscar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				VerProducto ver = new VerProducto(Main.ger.gp.buscarProductoById(frame.getId()),frame.getGpanel());
				ver.setVisible(true);
				frame.dispose();
			}
			
		});
	}

	public GerentePanel getGpanel() {
		return gpanel;
	}

	public void setGpanel(GerentePanel gpanel) {
		this.gpanel = gpanel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

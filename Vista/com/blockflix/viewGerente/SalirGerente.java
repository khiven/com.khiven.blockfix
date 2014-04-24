package com.blockflix.viewGerente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.blockflix.viewGerente.GerentePanel;;

public class SalirGerente extends JPanel {
	
	private GerentePanel gpanel;
	
	public SalirGerente(GerentePanel gpanel){
		this.setGpanel(gpanel);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel lTSalir = new JLabel("Pulse salir para volver al login o cambie de pestaña.");
		JButton bSalir = new JButton("Salir");
		this.add(lTSalir);
		this.add(bSalir);
		bSalir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				((SalirGerente)source.getParent()).getGpanel().setVisible(false);
				((SalirGerente)source.getParent()).getGpanel().getMainWindow().getParent().getComponent(0).setVisible(true);
				((SalirGerente)source.getParent()).getGpanel().getMainWindow().getParent().getComponent(1).setVisible(true);
			}
			
		});
		
	}

	public GerentePanel getGpanel() {
		return gpanel;
	}

	public void setGpanel(GerentePanel gpanel) {
		this.gpanel = gpanel;
	}

}

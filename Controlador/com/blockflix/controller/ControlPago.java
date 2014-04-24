package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.view.empleado.PagoDialog;

public class ControlPago implements ActionListener {

	PagoDialog pd;
	
	public ControlPago(PagoDialog pd){
		this.pd = pd;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Se intenta pagar
		if (pagar()==0){
//			//Pago correcto
			JOptionPane.showMessageDialog(new JFrame(),

					"Pago realizado correctamente.",
					"Pago correcto",
					JOptionPane.INFORMATION_MESSAGE);
			pd.setPagoRealizado(true);
			pd.setVisible(false);
		
		}

		else{
//			//Pago incorrecto
			JOptionPane.showMessageDialog(new JFrame(),

					"Pago incorrecto, revise sus datos e inténtelo de nuevo.",
					"Pago incorrecto",
					JOptionPane.ERROR_MESSAGE);
			pd.setPagoRealizado(false);
		}

	}

	public int pagar(){
		//Intentamos pagar con los datos de PagoDialog
		
		if (Main.emp.pagar(pd.getNtarjeta(), pd.getPin(), pd.getTotal())){
			//Pago correcto
			return 0;
		}
		else{
			//Pago incorrecto
			return -1;
		}

	}
}

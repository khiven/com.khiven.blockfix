package com.blockflix.view.empleado;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.blockflix.view.SpringUtilities;

public class AddUsuarioForm extends JPanel {

	private JLabel lNombre,lApellidos,lDireccion,lTelefono,lDni;
	private JTextField tNombre,tApellidos,tDireccion,tTelefono,tDni;


	public AddUsuarioForm(){
	
		// Formulario Datos Usuario
		this.setLayout(new SpringLayout());
		lNombre = new JLabel("Nombre: ",JLabel.TRAILING);
		this.add(lNombre);
		tNombre = new JTextField(10);
		lNombre.setLabelFor(tNombre);
		this.add(tNombre);
		lApellidos= new JLabel("Apellidos: ",JLabel.TRAILING);
		this.add(lApellidos);
		tApellidos = new JTextField(10);
		lApellidos.setLabelFor(tApellidos);
		this.add(tApellidos);
		lDireccion = new JLabel("Dirección: ",JLabel.TRAILING);
		this.add(lDireccion);
		tDireccion = new JTextField(10);
		lDireccion.setLabelFor(tDireccion);
		this.add(tDireccion);
		lTelefono = new JLabel("Teléfono: ",JLabel.TRAILING);
		this.add(lTelefono);
		tTelefono = new JTextField(10);
		lTelefono.setLabelFor(tTelefono);
		this.add(tTelefono);
		lDni = new JLabel("DNI/NIE: ",JLabel.TRAILING);
		this.add(lDni);
		tDni= new JTextField();
		lDni.setLabelFor(tDni);
		this.add(tDni);

	SpringUtilities.makeCompactGrid(this,5,2,6,6,6,6);
		

		
	}


	public JTextField gettNombre() {
		return tNombre;
	}




	public JTextField gettApellidos() {
		return tApellidos;
	}




	public JTextField gettDireccion() {
		return tDireccion;
	}




	public JTextField gettTelefono() {
		return tTelefono;
	}





	public JTextField gettDni() {
		return tDni;
	}


}

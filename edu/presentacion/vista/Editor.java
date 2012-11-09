/*
 * Creado el 25-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import edu.compilador.CodigoFuente;


public class Editor extends JTextArea{

	public Editor(){

		this.setEnabled(true);
		this.setTabSize(2);
		this.setFont(new Font("Courier New",Font.BOLD,17));
		
		this.setForeground(Color.black);
	}
	
	public void setCodigo(CodigoFuente codigo){
		setText(codigo.getFormaCodigo());
	}
	
	/* (no Javadoc)
	 * @see javax.swing.text.JTextComponent#setText(java.lang.String)
	 */
	public void setText(String s) {
		super.setText(s);
		
	}


}

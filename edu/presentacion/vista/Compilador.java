/*
 * Creado el 26-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

/**Compilador.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class Compilador extends JTextArea{
	
	
	public Compilador(){
		
		setEditable(false);
		this.setTabSize(2);
		this.setFont(new Font("Courier New",Font.ITALIC,14));
		this.setForeground(Color.black);
		
	}
}

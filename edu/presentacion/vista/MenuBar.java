/*
 * Creado el 25-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**MenuBar.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class MenuBar extends JMenuBar{
	private MiAccionListener listener;
	
	public MenuBar(MiAccionListener listener){
		this.listener= listener;
		
		JMenu archivo= new JMenu("archivo");
		
		JMenuItem nuevo= new JMenuItem("Nuevo");
		nuevo.setActionCommand(MiAccionListener.NUEVO());
		nuevo.addActionListener(listener);
		archivo.add(nuevo);

		
		JMenuItem abrir= new JMenuItem("Abrir...");
		abrir.setActionCommand(MiAccionListener.ABRIR());
		abrir.addActionListener(listener);
		archivo.add(abrir);
	
		JMenuItem guardar= new JMenuItem("Guardar");
		guardar.setActionCommand(MiAccionListener.GUARDAR());
		guardar.addActionListener(listener);
		archivo.add(guardar);

				
		JMenuItem guardarAs= new JMenuItem("Guardar como...");
		guardarAs.setActionCommand(MiAccionListener.GUARDARAS());
		guardarAs.addActionListener(listener);
		archivo.add(guardarAs);
		
		add(archivo);
		
		JMenu codigo= new JMenu("Codigo Fuente");
		JMenuItem compilar= new JMenuItem("Compilar");
		compilar.setActionCommand(MiAccionListener.COMPILAR());
		compilar.addActionListener(listener);
		codigo.add(compilar);
				
		JMenuItem ejecutar= new JMenuItem("Ejecutar");
		ejecutar.setActionCommand(MiAccionListener.EJECUTAR());
		ejecutar.addActionListener(listener);
		codigo.add(ejecutar);
		add(codigo);
	}
	
	public MiAccionListener getListener() {
		return listener;
	}
	public void setListener(MiAccionListener listener) {
		this.listener = listener;
	}

}

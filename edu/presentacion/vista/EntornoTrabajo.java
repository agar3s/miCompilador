/*
 * Creado el 25-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import edu.compilador.CodigoFuente;

public class EntornoTrabajo extends JFrame{
	
	private File file;
	private BarraDeHerramientas barra;
	private Editor editor;
	private MenuBar menu;
	private MiArbolDeProyectos arbol;
	private Compilador compilador;
	private MiAccionListener listener;
	private CodigoFuente codigo;
	
	private JSplitPane pane1, pane2;
	
	public EntornoTrabajo(){
		
		listener= new MiAccionListener(this);
		
		barra= new BarraDeHerramientas();
		
		editor= new Editor();
		
		menu= new MenuBar(listener);
		arbol= new MiArbolDeProyectos();
		compilador= new Compilador();
		
		
		
		barra.setBorderPainted(true);
		barra.setSize(200,30);
		barra.setVisible(true);
		barra.setRollover(true);
		this.setJMenuBar(menu);

		this.organizar();
		this.setSize(630,470);
		this.setVisible(true);
		this.setTitle("Plataforma");
		
	}
	private void organizar(){
		
		JScrollPane scroll1= new JScrollPane(editor);
		scroll1.setVisible(true);
		scroll1.setPreferredSize(new Dimension(getSize().width,getSize().height));
		
		JScrollPane scroll2= new JScrollPane(compilador);
		scroll2.setVisible(true);
		scroll2.setPreferredSize(new Dimension(getSize().width,getSize().height));
		
		
		pane1= new JSplitPane(
			JSplitPane.VERTICAL_SPLIT, scroll1,scroll2);
		
		pane1.setDividerSize(5);
		pane1.setDividerLocation(300);
		pane1.setOneTouchExpandable(true);
		
		
		pane2= new JSplitPane(
			JSplitPane.HORIZONTAL_SPLIT,arbol,pane1);
		
		pane2.setDividerLocation(130);
		pane2.setDividerSize(5);
		pane2.setOneTouchExpandable(true);
		
		this.getContentPane().add(barra,BorderLayout.NORTH);
		this.getContentPane().add(pane2,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		final EntornoTrabajo et= new EntornoTrabajo();
		et.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
	public MiArbolDeProyectos getArbol() {
		return arbol;
	}

	public BarraDeHerramientas getBarra() {
		return barra;
	}

	public Compilador getCompilador() {
		return compilador;
	}

	public Editor getEditor() {
		return editor;
	}
	
	
	public MenuBar getMenu() {
		return menu;
	}
	public void setArbol(MiArbolDeProyectos proyectos) {
		arbol = proyectos;
	}

	public void setBarra(BarraDeHerramientas herramientas) {
		barra = herramientas;
	}

	public void setCompilador(Compilador compilador) {
		this.compilador = compilador;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public void setMenu(MenuBar bar) {
		menu = bar;
	}

	public File getFile() {
		
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public CodigoFuente getCodigo() {
		return codigo;
	}

	public void setCodigo(CodigoFuente fuente) {
		codigo = fuente;
	}

}

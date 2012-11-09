/*
 * Creado el 24-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import edu.compilador.funciones.FuncionCompilador;
import edu.compilador.instrucciones.Instruccion;
import edu.compilador.instrucciones.Principal;
import edu.presentacion.consola.Consola;
import edu.recurso.lista.Lista;


public class CodigoFuente {
	private Instruccion instruccion;
	private String codigo;
	private FuncionCompilador consola;
	private String nombre;
	
	public CodigoFuente(String codigo){
		this.codigo= codigo;
		instruccion= new Principal(new Lista());
	}
	
	public void decodificar(){
		instruccion= new Principal(new Lista());
		Lector lector= new Lector(instruccion);
		instruccion= lector.decodificar(codigo,1);
		System.out.println(instruccion.mostrarVariables());
	}
	public int reporte(){
		return instruccion.mostrarErrores();
	}
	//retorna el codigo en forma normal, osea .txt
	public String getFormaCodigo(){
		return instruccion.getFormaCodigo(0);
	}
	
	public Instruccion getInstruccion(){
		return instruccion;
	}
	
	public boolean ejecutar(){
		
		JFrame ventana= new JFrame(nombre);
		ventana.setSize(400,200);
		ventana.setResizable(false);
		consola= new FuncionCompilador();
		Consola consol= new Consola();
		JScrollPane pane= new JScrollPane(consol.getConsola());
		consola.setConsola(consol);
		ventana.getContentPane().add(pane);
		ventana.setVisible(true);
		instruccion.setConsola(consola);
		boolean b=instruccion.ejecutar();
		return b;
	}

	public FuncionCompilador getConsola() {
		return consola;
	}

	public void setConsola(FuncionCompilador compilador) {
		consola = compilador;
	}

}

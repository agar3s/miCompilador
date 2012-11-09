/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.funciones;

import edu.compilador.RecursoCompilador;
import edu.compilador.clases.Cadena;
import edu.compilador.clases.Entero;
import edu.compilador.clases.Real;
import edu.presentacion.consola.Consola;

public class FuncionCompilador extends RecursoCompilador{
	
	private Consola consola;
	
	public FuncionCompilador(){
		setTipoR("entero");
	}
	public void setConsola(Consola consola){
		this.consola= consola;
	}
		
	public void leer(Entero entero){
		//while(!consola.isIngresado())
		String s= consola.getG();
		try{
			int valor= Integer.parseInt(s);
			entero.setValor(valor);
		}catch(NumberFormatException nfe){
			consola.escribirln("Error de asignación de variable entera");
		}
		
	}
	

	public void leer(Cadena cadena){

		String s= consola.getG();
		cadena.setValor(s);
		
	}
	public void leer(Real real){
		String s= consola.getG();
		try{
			double valor= Double.parseDouble(s);
			real.setValor(valor);
		}catch(NumberFormatException nfe){
			consola.escribirln("Error de asignación de variable real");
		}
	}
	
	public void escribir(Entero entero){
		String s= ""+entero.getValor();
		consola.escribir(s);
	}
	public void escribir(Cadena cadena){
		String s= ""+cadena.getValor();
		consola.escribir(s);
	}
	public void escribir(Real real){
		String s= ""+real.getValor();
		consola.escribir(s);
	}
	public void escribirln(Entero entero){
		String s= ""+entero.getValor();
		consola.escribirln(s);
	}
	public void escribirln(Cadena cadena){
		String s= ""+cadena.getValor();
		consola.escribirln(s);
	}
	public void escribirln(Real real){
		String s= ""+real.getValor();
		consola.escribirln(s);
	}

	public Consola getConsola() {
		return consola;
	}

}

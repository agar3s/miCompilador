/*
 * Creado el 21-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.lineas;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.lineas.FuncionSistema;
import edu.compilador.lineas.Indeterminada;
import edu.compilador.lineas.Linea;
import edu.compilador.sentencias.Reservada;
import edu.compilador.sentencias.Separador;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;

/**IdentificadorInvocacion.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class IdentificadorInvocacion extends IdentificadorLinea{
	
	//las funciones pueden tener dentro de si operaciones
	//pero solo si retornan un valor que sea el parametro
	//tambien pueden tener funciones
	public IdentificadorInvocacion(Instruccion instruccion) {
		super(instruccion);
	}
	
	//por ahora no se aplican llamados a funciones
	public Linea identificarCode(Lista lista){
		Linea linea= null;
		boolean identifico= false;
		if(lista.tamanio()==4){
			if(lista.elementoEn(0) instanceof Reservada &&
			isFuncionCompilador((Reservada)lista.elementoEn(0)) &&
			lista.elementoEn(1) instanceof Separador &&
			((Separador)lista.elementoEn(1)).getTipo().compareTo("(")==0 &&
			lista.elementoEn(2) instanceof Variable &&
			lista.elementoEn(3) instanceof Separador &&
			((Separador)lista.elementoEn(3)).getTipo().compareTo(")")==0){
				Lista ingreso= new Lista();
				ingreso.add(lista.elementoEn(0));
				ingreso.add(lista.elementoEn(2));
				linea= new FuncionSistema(ingreso);
				identifico=true;
			}
		}
		if(!identifico){
			linea= new Indeterminada(lista);
			((Indeterminada)linea).setError(Indeterminada.ERROR_EXPRESION_NO_VALIDA());
		}
		return linea;
	}
	
	public static boolean isFuncionCompilador(Reservada reservada){
		boolean funcion= false;
		if(reservada.getRecurso().getTipoR().compareTo("leer")==0)
			funcion=true;
		else if(reservada.getRecurso().getTipoR().compareTo("escribir")==0)
			funcion=true;
		else if(reservada.getRecurso().getTipoR().compareTo("escribirln")==0)
			funcion=true;
		return funcion;
	}
}

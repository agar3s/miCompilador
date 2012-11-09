/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.compilador.sentencias.Sentencia;
import edu.recurso.lista.Lista;


public class Indeterminada extends Linea {
	private String informeError;
	private final static int ERROR_EXPRESION_NO_VALIDA=0;
	private final static int ERROR_VARIABLE_NO_EXISTENTE=1;
	private final static int ERROR_VARIABLE_DUPLICADA=2;
	private final static int ERROR_OPERACION_NO_VALIDA=3;
	private final static int ERROR_OPERADOR_NO_VALIDO=3;

	public Indeterminada(Lista sentencias) {
		super(sentencias);
	}
//	public String getError(){
//		informeError= informeError+"-> ";
//		for(int i=0; i<getSentencias().tamanio(); i++){
//		//	if(getSentencias().elementoEn(i) instanceof Sentencia)
//		//		informeError= informeError+" "+((Sentencia)(getSentencias().elementoEn(i))).getTipo();
//			/*else*/ if(getSentencias().elementoEn(i) instanceof Indeterminada)
//				informeError= informeError+" "+((Indeterminada)(getSentencias().elementoEn(i))).getError();
//		}
//		return informeError;
//	}
	public String getError(){
		boolean fin=false;
		for(int i=0; i<getSentencias().tamanio();i++){
			if(getSentencias().elementoEn(i) instanceof Indeterminada){
				fin=true;
				break;
			}
		}
		if(fin){
			informeError=informeError+": ";
			for(int i=0; i<getSentencias().tamanio(); i++)
				if(getSentencias().elementoEn(i) instanceof Sentencia)
					informeError= informeError+" "+((Sentencia)(getSentencias().elementoEn(i))).getTipo();
	
		}else{
			for(int i=0; i<getSentencias().tamanio(); i++)
				if(getSentencias().elementoEn(i) instanceof Indeterminada)
					informeError= informeError+" "+((Indeterminada)(getSentencias().elementoEn(i))).getError();
		
		}
		return informeError;
	}
	
	public void setError(int i){
		if(i==Indeterminada.ERROR_EXPRESION_NO_VALIDA){
			informeError= "La expresion no es valida como sentencia";
		}else
		if(i==Indeterminada.ERROR_OPERACION_NO_VALIDA()){
			informeError= "Discrepancia de tipos";
		}else  if(i== Indeterminada.ERROR_VARIABLE_DUPLICADA()){
			informeError= "La variable esta duplicada";
		}else if(i==Indeterminada.ERROR_VARIABLE_NO_EXISTENTE()){
			informeError= "La variable no existe";
		}else if(i==Indeterminada.ERROR_OPERADOR_NO_VALIDO()){
			informeError= "La Operacion no admite ciertos operadores";
		}
	}
	public void setError(String error){
		informeError=error;
	}
	public static int ERROR_OPERACION_NO_VALIDA() {
		return ERROR_OPERACION_NO_VALIDA;
	}

	public static int ERROR_VARIABLE_DUPLICADA() {
		return ERROR_VARIABLE_DUPLICADA;
	}

	public static int ERROR_VARIABLE_NO_EXISTENTE() {
		return ERROR_VARIABLE_NO_EXISTENTE;
	}
	
	public String getInformeError() {
		return informeError;
	}

	public static int ERROR_EXPRESION_NO_VALIDA() {
		return ERROR_EXPRESION_NO_VALIDA;
	}

	public static int ERROR_OPERADOR_NO_VALIDO() {
		return ERROR_OPERADOR_NO_VALIDO;
	}

	public void ejecutar() {
		
	}

}

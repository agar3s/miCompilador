/*
 * Creado el 21-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.lineas;

import edu.compilador.clases.Bool;
import edu.compilador.clases.Cadena;
import edu.compilador.clases.ClaseCompilador;
import edu.compilador.clases.Entero;
import edu.compilador.clases.Real;
import edu.compilador.instrucciones.Instruccion;
import edu.compilador.lineas.Declaracion;
import edu.compilador.lineas.Indeterminada;
import edu.compilador.lineas.Linea;
import edu.compilador.sentencias.Indeterminado;
import edu.compilador.sentencias.Reservada;
import edu.compilador.sentencias.Sentencia;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;


public class IdentificadorDeclaracion
	extends IdentificadorLinea {
	
	private String error;

	public IdentificadorDeclaracion(Instruccion instruccion) {
		super(instruccion);
		setSucesor(new IdentificadorAsignacion(getInstruccion()));
	}
	
	public Linea identificarCode(Lista lista){
		Linea linea= null;
		boolean identifico=false;
		
		if(lista.tamanio()>=2){
			if(	lista.elementoEn(0) instanceof Reservada &&
				isClaseCompilador( ((Reservada)lista.elementoEn(0)) ) ){
					
				if(lista.tamanio()%2==0&&identificarDeclaracion(lista)){
					linea= new Declaracion(addVariables(lista));
					identifico=true;
				}
			}
		}
		if(!identifico)
			linea= ((IdentificadorAsignacion)getSucesor()).identificarCode(lista);
		if(error!=null&&linea instanceof Indeterminada){
			((Indeterminada)linea).setError(error);
		}
		return linea;
	}
	
	private boolean identificarDeclaracion(Lista lista){
		boolean correcto= true;
		int i=1;
		while(correcto&&i<lista.tamanio()){
			if(i%2==1){
				if(!(lista.elementoEn(i) instanceof Indeterminado)){	
					correcto=false; 
					if(lista.elementoEn(i) instanceof Variable){
						error="La variable "+ ((Variable)lista.elementoEn(i)).getTipo()+" ya esta declarada";
					}
				}
			}else
				if(((Sentencia)lista.elementoEn(i)).getTipo().compareTo(",")!=0)
					correcto=false;
			i++;
		}
		if(correcto){
			for(int j=1; j<lista.tamanio(); j=j+2){
				for(int k=j+2; k<lista.tamanio(); k=k+2){
					if(((Indeterminado)lista.elementoEn(j)).getTipo()
					.compareTo(((Indeterminado)lista.elementoEn(k)).getTipo())==0){
						correcto=false;
						error="Variable "+((Indeterminado)lista.elementoEn(k)).getTipo()+" duplicada";
						break;
					}
				}
			}
		}
		
		return correcto;

	}
	private Lista addVariables(Lista lista){
		int i=1;
		Lista temp= new Lista();
		temp.add(lista.elementoEn(0));
		while(i<lista.tamanio()){
			ClaseCompilador clasee=((ClaseCompilador)((Reservada)lista.elementoEn(0)).getRecurso());
			ClaseCompilador nueva=null;
			if(clasee instanceof Entero){
				nueva= new Entero(0);
			}else if(clasee instanceof Real){
				nueva= new Real(0);
			}else if(clasee instanceof Cadena){
				nueva= new Cadena("","");	
			}else if(clasee instanceof Bool){
				nueva= new Bool(false);
			}
			
			getInstruccion().addVariable(
				new Variable(((Sentencia)lista.elementoEn(i)).getTipo(),nueva));
			temp.add(lista.elementoEn(i));
			i=i+2;
		}
		return temp;
	}
	
	public static boolean isClaseCompilador(Reservada reservada){
		boolean clase=false;
		if(reservada.getRecurso().getTipoR().compareTo("entero")==0)
			clase=true;
		else if(reservada.getRecurso().getTipoR().compareTo("real")==0)
			clase=true;
		else if(reservada.getRecurso().getTipoR().compareTo("cadena")==0)
			clase=true;
		else if(reservada.getRecurso().getTipoR().compareTo("bool")==0)
			clase=true;
		return clase;
	}

	public String getError() {
		return error;
	}

	public void setError(String string) {
		error = string;
	}

}

/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.compilador.clases.AlphaNumerico;
import edu.compilador.clases.Logico;
import edu.compilador.clases.Numerico;
import edu.compilador.sentencias.Comparador;
import edu.compilador.sentencias.Constante;
import edu.compilador.sentencias.Operador;
import edu.compilador.sentencias.OperadorLogico;
import edu.compilador.sentencias.Reservada;
import edu.compilador.sentencias.Separador;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;


/*
 * La linea de tipo operacion se utiliza para la linea de asignacion
 * una linea de este tipo, efectua una operacion entre variables y
 * devuelve un valor, una linea de este tipo esta conformada por
 * sentencias: operadores, operandos, variables y constantes.
 * los valores retornados por funciones, se consideran variables
 * solo se pueden operar variables de tipo numerico, enteros y reales
 */
public abstract class Operacion extends Linea{

	public Operacion(Lista sentencias) {
		super(sentencias);
		
	}
	
	//este metodo solo recibe una lista de sentencias, que 
	//son del tipo operacion
	public static boolean isOperacionNumerica(Lista sentencias){
		boolean numerica=false;
		for(int i=0; i<sentencias.tamanio(); i++){
			if(	sentencias.elementoEn(i) instanceof Variable &&
			(((Variable)sentencias.elementoEn(i)).getClase() instanceof AlphaNumerico||
			((Variable)sentencias.elementoEn(i)).getClase() instanceof Logico)){
				numerica=false;
				break;
			}else if(sentencias.elementoEn(i) instanceof Constante &&
				((Constante)sentencias.elementoEn(i)).getValor() instanceof AlphaNumerico){
				
				numerica=false;
				break;
			}else if(sentencias.elementoEn(i) instanceof Separador &&
				((Separador)sentencias.elementoEn(i)).getTipo().compareTo("\"")==0){
				numerica=false;
				break;
			}else if( sentencias.elementoEn(i) instanceof Operador &&(
			((Operador)sentencias.elementoEn(i)).getTipo().compareTo("=")==0||(
			((Operador)sentencias.elementoEn(i)).getTipo().compareTo("<-")==0))){
				numerica=false;
				break;			
			}else if( sentencias.elementoEn(i) instanceof Reservada){
				numerica=false;
				break;
			}else if(sentencias.elementoEn(i) instanceof Comparador||
				sentencias.elementoEn(i) instanceof OperadorLogico){
				numerica=false;
				break;
				}else if(sentencias.elementoEn(i) instanceof Operacion){
					if(!(sentencias.elementoEn(i) instanceof OperacionNumerica)){
						numerica=false; 
						break;
					}else
						numerica=true;
				}else
				numerica=true; 
				
		}
					
		return numerica;
	}
	public static boolean isOperacionAlphaNumerica(Lista sentencias){
		boolean alpha=false;
		for(int i=0; i<sentencias.tamanio(); i++){
			if(	sentencias.elementoEn(i) instanceof Variable &&
			(((Variable)sentencias.elementoEn(i)).getClase() instanceof Numerico||
			((Variable)sentencias.elementoEn(i)).getClase() instanceof Logico)){
				alpha=false;
				break;
			}else if(sentencias.elementoEn(i) instanceof Constante &&
				((Constante)sentencias.elementoEn(i)).getValor() instanceof Numerico){
				alpha=false;				
				break;
			}else if(sentencias.elementoEn(i) instanceof Operador)
				{
					String operador=((Operador)sentencias.elementoEn(i)).getTipo();
					if(operador.compareTo("-")==0||operador.compareTo("*")==0||
					operador.compareTo("/")==0||operador.compareTo("-")==0||
					operador.compareTo("%")==0||operador.compareTo("=")==0||
					operador.compareTo("<-")==0)
						{alpha=false;
							
						break;} 
					else
						alpha=true;
				}
			else if(sentencias.elementoEn(i) instanceof Reservada){
				alpha=false;
				break;
			}else if(sentencias.elementoEn(i) instanceof Comparador||
				sentencias.elementoEn(i) instanceof OperadorLogico){
				alpha=false;
				break;
			}else if(sentencias.elementoEn(i) instanceof Operacion){
				alpha=false;
				break;
			}else
				alpha=true;  

		}
		
		return alpha;
	}
}

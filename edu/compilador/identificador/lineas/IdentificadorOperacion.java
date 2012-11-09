/*
 * Creado el 19-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.lineas;

import edu.compilador.RecursoCompilador;
import edu.compilador.clases.Cadena;
import edu.compilador.clases.Entero;
import edu.compilador.clases.Real;
import edu.compilador.instrucciones.Instruccion;
import edu.compilador.lineas.Indeterminada;
import edu.compilador.lineas.Linea;
import edu.compilador.lineas.Operacion;
import edu.compilador.lineas.OperacionAlphaNumerica;
import edu.compilador.lineas.OperacionLogica;
import edu.compilador.lineas.OperacionNumerica;

import edu.compilador.sentencias.Comparador;
import edu.compilador.sentencias.Constante;
import edu.compilador.sentencias.Indeterminado;
import edu.compilador.sentencias.Operador;
import edu.compilador.sentencias.OperadorLogico;
import edu.compilador.sentencias.Reservada;
import edu.compilador.sentencias.Sentencia;
import edu.compilador.sentencias.Separador;
import edu.compilador.sentencias.Variable;

import edu.recurso.lista.Lista;

public class IdentificadorOperacion
	extends IdentificadorLinea {
	
	
	//se supone que este puede tener la opcion de buscar
	//las funciones creadas que retornen un valor y validarlas
	//como variables.
	public IdentificadorOperacion(Instruccion instruccion) {
		super(instruccion);
	}
	public Linea identificarCode(Lista lista){
		
		
		Linea linea = null;
		boolean isCorrecto= true;
		int i=0;
		while(isCorrecto&&i<lista.tamanio()){
			if(lista.elementoEn(i) instanceof Operador){
				if(	((Sentencia)lista.elementoEn(i)).getTipo()=="="||
					((Sentencia)lista.elementoEn(i)).getTipo()=="<-")
					isCorrecto=false;
			}
			else if(lista.elementoEn(i) instanceof Indeterminado){
				
				lista= identificarNumericos(lista, i);
				if(lista.elementoEn(i)instanceof Indeterminado){
					isCorrecto=false;
				}
				
			}else if(lista.elementoEn(i) instanceof Separador){
				if(	((Sentencia)lista.elementoEn(i)).getTipo().compareTo("(")!=0&&
					((Sentencia)lista.elementoEn(i)).getTipo().compareTo(")")!=0&&
					((Sentencia)lista.elementoEn(i)).getTipo().compareTo(".")!=0&&
					((Sentencia)lista.elementoEn(i)).getTipo().compareTo("\"")!=0)
					isCorrecto= false;
				else if(((Sentencia)lista.elementoEn(i)).getTipo().compareTo("\"")==0){
					
					lista= convertirCadena(lista, i);
				}
			
			}else if(lista.elementoEn(i) instanceof Reservada){
				RecursoCompilador recurso=((Reservada)(lista.elementoEn(i))).getRecurso();
				if(recurso.getTipoR().compareTo("bool")!=0){
					isCorrecto=false;
				}
			}else if(lista.elementoEn(i) instanceof Comparador||
				lista.elementoEn(i) instanceof OperadorLogico){
				
			}
			else if(!(lista.elementoEn(i) instanceof Variable)){
				isCorrecto=false;
				
			}	
			i++;
		}
		
		if(!isCorrecto){
			linea = new Indeterminada(lista);
			
		}else{
			System.out.println("llegue hasta aquí");
			boolean numerico= Operacion.isOperacionNumerica(lista);
			boolean alpha= Operacion.isOperacionAlphaNumerica(lista);
			if(numerico){	
				Lista temp= organizarOperacion(lista,numerico,alpha);	
				boolean operacionCorrecta=!buscarErrores(temp);
				
				if(operacionCorrecta)
					linea= new OperacionNumerica(temp);
				else{
					linea = new Indeterminada(temp);
					linea.setError("La Operacion no esta correcta");
				}
			} 
			else if(alpha){
				
				Lista temp= organizarOperacion(lista,numerico,alpha);	
				boolean operacionCorrecta=!buscarErrores(temp);
				if(operacionCorrecta)
					linea= new OperacionAlphaNumerica(temp); 
				else{
					linea = new Indeterminada(temp);
					
				}	
			}else {
				System.out.println("Puede ser logica");
				 Lista temp=organizarOperacion(lista,numerico,alpha);
				 boolean operacionCorrecta=!buscarErrores(temp); 
				if(operacionCorrecta)
					linea= new OperacionLogica(temp);
				else{
					linea = new Indeterminada(lista);
					((Indeterminada)linea).setError(Indeterminada.ERROR_OPERACION_NO_VALIDA());
				}
			}

		}
		return linea;
	}
	
	private Lista identificarNumericos(Lista lista, int i){
		
		if(((Indeterminado)lista.elementoEn(i)).isNumerico()){
			if(lista.elementoEn(i+1)!=null &&
			   ((Sentencia)lista.elementoEn(i+1)).getTipo().compareTo(".")==0&&
			   lista.elementoEn(i+2)!=null&&
			   (lista.elementoEn(i+2)instanceof Indeterminado&&
			   ((Indeterminado)lista.elementoEn(i+2)).isNumerico())){
				
				
				lista=identificarReal(lista, i);
				
		}else if(lista.elementoEn(i+1)!=null &&
			((Sentencia)lista.elementoEn(i+1)).getTipo().compareTo(".")!=0){
				
				
				lista= IdentificarEntero(lista, i);
			}
			else if(lista.elementoEn(i+1)==null){
				
				lista= IdentificarEntero(lista, i);
			}
		}
		return lista;
	}
	
	private Lista identificarReal(Lista lista, int i){
		double real= Double.parseDouble(
			((Sentencia)lista.elementoEn(i)).getTipo()+
				((Sentencia)lista.elementoEn(i+1)).getTipo()+
					((Sentencia)lista.elementoEn(i+2)).getTipo());
				   	
		for(int h=0; h<3; h++)
			lista.removerEn(i);
		Sentencia realC= new Constante(null,new Real(real));
		lista.addEn(realC, i);
		return lista;
	}
	
	private Lista IdentificarEntero(Lista lista, int i){
		int entero= Integer.parseInt(((Sentencia)lista.elementoEn(i)).getTipo());
		Sentencia enteroC= new Constante(null,new Entero(entero));			
		lista.removerEn(i);
		lista.addEn(enteroC, i);
		return lista;
	}
	
	private Lista convertirCadena(Lista lista, int i){
		int j=i+1;
		String cadena="";
		while(	lista.elementoEn(j)!=null&&
			((Sentencia)lista.elementoEn(j)).getTipo().compareTo("\"")!=0){
			cadena= cadena+((Sentencia)lista.elementoEn(j)).getTipo()+" ";
			
			j++;
		}
		if(((Sentencia)lista.elementoEn(j)).getTipo().compareTo("\"")==0){
			System.out.println(cadena);			
			for(int h=0; h<=j-i+1; h++)
				lista.removerEn(i);
							
			Sentencia cadenaC= new Constante(null, new Cadena(cadena));
			lista.addEn(cadenaC,i);
		}
		return lista;
	}
	
	//este metodo, convierte los argumentos que esten dentro de parentesis
	//en otra operación, que se incluye en la operacion original.
	private Lista organizarOperacion(Lista lista, boolean numerico,boolean alpha){
		
		Lista nuevaLista=new Lista();
		int i=0;
		while(i<lista.tamanio()){
			if(	lista.elementoEn(i) instanceof Separador&&
			(((Separador)lista.elementoEn(i)).getTipo().compareTo("(")==0)){
				Lista temp=new Lista();
				boolean cerrado=false;
				int contador=1;
				lista.removerEn(i);
				while(contador>0&&i<lista.tamanio()){
					if(	lista.elementoEn(i) instanceof Separador&&
					(((Separador)lista.elementoEn(i)).getTipo().compareTo("(")==0))
						contador++;
					else if(lista.elementoEn(i) instanceof Separador&&
					(((Separador)lista.elementoEn(i)).getTipo().compareTo(")")==0)){
						contador--; 	
						boolean correcto=true;
						if(i+1!=lista.tamanio()){
							if(lista.elementoEn(i+1) instanceof Variable||
								lista.elementoEn(i+1) instanceof Constante){
									correcto=false;
									temp.add(lista.elementoEn(i+1));
									lista.removerEn(i+1);
							}
						}
						if(!correcto){
							while(i<lista.tamanio()){
								temp.add(lista.elementoEn(i));
								lista.removerEn(i);
							}
							nuevaLista.add(new Indeterminada(temp));
						}
						
					} 
					
					if(contador==0){
						cerrado=true; 
					} 
					else
						temp.add(lista.elementoEn(i));
					
					lista.removerEn(i);
					
				}
				if(cerrado&&temp.tamanio()!=0){
					if(numerico){
						temp= organizarOperacion(temp,numerico,alpha);
						nuevaLista.add(new OperacionNumerica(temp));
					}
					else if(alpha){
						temp=organizarOperacion(temp, numerico,alpha);
						nuevaLista.add(new OperacionAlphaNumerica(temp));
					}else{
						nuevaLista=organizarLogica(nuevaLista,temp, lista, i);
					}

				}else{
					nuevaLista.add(new Indeterminada(temp));
				}		
			}else if(lista.elementoEn(i) instanceof Separador&&
			(((Separador)lista.elementoEn(i)).getTipo().compareTo(")")==0)){
				Lista temp= new Lista();
				while(i<lista.tamanio()){
					temp.add(lista.elementoEn(i));
					lista.removerEn(i);
				}
				nuevaLista.add(new Indeterminada(temp));
			}else if(lista.elementoEn(i) instanceof Variable||
				lista.elementoEn(i) instanceof Constante){
				nuevaLista.add(lista.elementoEn(i));
				lista.removerEn(i);
				if(lista.elementoEn(i) instanceof Variable||
				lista.elementoEn(i) instanceof Constante||
				(lista.elementoEn(i) instanceof Separador&&
				((Separador)lista.elementoEn(i)).getTipo().compareTo("(")==0)){
					Lista temp= new Lista();
					while(i<lista.tamanio()){
						temp.add(lista.elementoEn(i));
						lista.removerEn(i);
					}
					nuevaLista.add(new Indeterminada(temp));
				}
			}else if(lista.elementoEn(i) instanceof Operador||
					lista.elementoEn(i) instanceof OperadorLogico||
					lista.elementoEn(i) instanceof Comparador){
				
				if(lista.elementoEn(i) instanceof Operador){
					nuevaLista.add(lista.elementoEn(i));  
					lista.removerEn(i);
				}else{
					Operacion operacion=organizarLogica(nuevaLista);
					Lista temp= nuevaLista;
					nuevaLista= new Lista();
					System.out.println(((Sentencia)(lista.elementoEn(i))).getTipo());
					if(operacion==null){
						while(i<lista.tamanio()){
							temp.add(lista.elementoEn(i));
							lista.removerEn(i);
						}
						nuevaLista.add(new Indeterminada(temp));	
					}else{
						Sentencia sentence=(Sentencia) lista.elementoEn(i);

						lista.removerEn(i);
						
						Operacion operacion2= organizarLogica(lista);
						temp=lista;
						lista=new Lista();
						if(operacion2==null){
							nuevaLista.add(new Indeterminada(temp));	
						}else{
							temp= new Lista();
							temp.add(operacion);
							temp.add(sentence);
							temp.add(operacion2);
							//nuevaLista.add(new OperacionLogica(temp));
							nuevaLista=temp;
							System.out.println("operacion 2 a 2");
						}
					}
				}
				if(lista.elementoEn(i) instanceof Operador||
					lista.elementoEn(i) instanceof OperadorLogico||
					lista.elementoEn(i) instanceof Comparador){
					Lista temp= new Lista();
					while(i<lista.tamanio()){
						temp.add(lista.elementoEn(i));
						lista.removerEn(i);
					}
					nuevaLista.add(new Indeterminada(temp));
				}
			}
			else 
				i++;
		}
		
		return nuevaLista;
	}
	
	
	private boolean buscarErrores(Lista lista){
		boolean erronea=false;
		for(int i=0; i<lista.tamanio(); i++){
			if(lista.elementoEn(i) instanceof Indeterminada){
				erronea=true;
				break;
			}else if(lista.elementoEn(i) instanceof OperacionNumerica){
				erronea= buscarErrores(
					((OperacionNumerica)lista.elementoEn(i)).getSentencias());
				if(erronea)
					break;
				else if(lista.elementoEn(i+1)!=null&&lista.elementoEn(i+1) instanceof OperacionNumerica){
					erronea=true;
					break;
				}
			}else if(lista.elementoEn(i) instanceof OperacionAlphaNumerica){
				erronea= buscarErrores(
					((OperacionAlphaNumerica)lista.elementoEn(i)).getSentencias());
				if(erronea)
					break;
				else if(lista.elementoEn(i+1)!=null&&lista.elementoEn(i+1) instanceof OperacionAlphaNumerica){
					erronea=true;
					break;
				}
			}	
		}
	
		return erronea;
	}
	
	private Lista organizarLogica(Lista nuevaLista,Lista temp,Lista lista,int i){
		boolean alp=Operacion.isOperacionAlphaNumerica(temp);
		boolean num=Operacion.isOperacionNumerica(temp);
		temp=organizarOperacion(temp,alp,num);
		boolean correcta=!buscarErrores(temp);
		if(correcta){
			if(alp){
				nuevaLista.add(new OperacionAlphaNumerica(temp)); 
				System.out.println("sub alpha");
			} 
			else if(num){	
				nuevaLista.add(new OperacionNumerica(temp));
				System.out.println("sub numerica");
			}
			else{
				nuevaLista.add(new OperacionLogica(temp));
				System.out.println("sub logica");
			}
		}else{
			while(i<lista.tamanio()){
				temp.add(lista.elementoEn(i));
				lista.removerEn(i);
			}
			nuevaLista.add(new Indeterminada(temp));
		} 
		return nuevaLista;
	}
	
	private Operacion organizarLogica(Lista lista){
		Operacion operacion=null;
		boolean alp=Operacion.isOperacionAlphaNumerica(lista);
		boolean num=Operacion.isOperacionNumerica(lista);
		lista=organizarOperacion(lista,alp,num);
		boolean correcta=!buscarErrores(lista);
		if(correcta){
			if(alp){
				operacion=new OperacionAlphaNumerica(lista); 
				System.out.println("sub alpha");
			} 
			else if(num){	
				operacion=new OperacionNumerica(lista);
				System.out.println("sub numerica");
			}
			else{
				operacion=new OperacionLogica(lista);
				System.out.println("sub logica");
			}
		}
		return operacion;
	}
}

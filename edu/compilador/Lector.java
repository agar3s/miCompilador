/*
 * Creado el 03-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
 
 /*
  * El lector de lineas es el que lee el codigo de fuente y lo
  * codifica por lineas para enviarlo a su revision sintactica,
  * el codigo debe estar bien escrito, es decir una linea solo
  * puede tener como ultimo caracter, ";", "{" ó "}".
  * sino se termina en uno de estos caracteres se salta a la
  * siguiente linea y se concatena hasta que se llegue a uno de 
  * los caracteres de notacion final. cuando se encuentre una llave
  * de apertura "{", se debe buscar la llave que la cierra, si en el
  * trancurso de la busqueda se encuentran mas llaves de apertura se
  * repite el proceso, las lineas de codigo dentro de las llaves
  * reciben el nombre de instrucción, y en ellas esta contenido mas 
  * codigo.
  * 
  */
package edu.compilador;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.lineas.LineaComentario;


/**LectorLineas.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class Lector {
	
	private Instruccion instruccion;
	
	public Lector(Instruccion instruccion) {
		this.instruccion=instruccion;
	}
	
	public Instruccion decodificar(String codigo, int k){
		
		Compilador code= new Compilador(instruccion);
		code.setContadorLineas(k);
		String temp= "";
		for(int i=0; i<codigo.length(); i++){
			
			if(codigo.charAt(i)=='/'&&codigo.charAt(i+1)=='*'){	//codigo comentado
				String comentario="/*";
				boolean comentarioCorrecto=true;;
				i= i+2;
				try{
					while(codigo.charAt(i)!='*'||codigo.charAt(i+1)!='/'){
						
						comentario= comentario+codigo.charAt(i);
						i++;
					}
					comentario=comentario+"/";
					i++;
				}
				catch(IndexOutOfBoundsException ioe){
					instruccion.setError("linea"+code.getContadorLineas()+" se esperaba final del comentario");
					comentarioCorrecto=false;
				}
				if(comentarioCorrecto)
					code.getInstruccion().getInstrucciones().add(new LineaComentario(comentario));
			}else if(codigo.charAt(i)!=';'&&
					codigo.charAt(i)!='{'&&
					codigo.charAt(i)!='}'&&
					codigo.charAt(i)!='\n'&&
					codigo.charAt(i)!='\t'){
						
				temp= temp +codigo.charAt(i);
				
			}else if(codigo.charAt(i)==';'){
				code.enviarLinea(temp);
				temp= "";
			}else if(codigo.charAt(i)=='{'){
				
				int contador=1;
				String temp2="";
				i++;
				boolean cerrado=false;
				while(!cerrado){
					try{		
						if(codigo.charAt(i)=='{'){
							contador++;
							temp2=temp2+codigo.charAt(i);
						}else if(codigo.charAt(i)=='}'){
							contador--;
							if(contador!=0)
								temp2= temp2+codigo.charAt(i);
						}else{
							temp2= temp2+ codigo.charAt(i);
						}
						
						if(contador==0){
							cerrado= true;
							code.enviarInstruccion(temp, temp2);
							temp="";
							temp2="";
							i--;
						}
						i++;
					}catch(StringIndexOutOfBoundsException sti){
						instruccion.setError("linea"+code.getContadorLineas()+" Se esperaba corchete }");
						cerrado=true;
					}
				}
			} else if(codigo.charAt(i)=='}'){
				
				instruccion.setError("linea"+code.getContadorLineas()+" Falta un delimitador {");
			}
			
		}
		
		return code.getInstruccion()
		;
	}
	
}

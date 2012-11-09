/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;

/**Separador.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/

/*
 * Las sentencias de tipo separador, son las que se utilizan en
 * el caso en el que no existen espacios entre sentencia y sentencia
 * para denotar que existe otro tipo de sentencia en la misma linea
 * de codigo, los separadores son: ',', '.', '(', ')', '[', ']',
 * '{', '}', ''', '"', '/*' y '*/
 /*
 * 
 * aunque estos separadores cumplan distintas funciones dentro de una
 * linea de codigo, se pueden agrupar en esta clase:
 * 
 * ',': separador coma, que se utiliza al momento de declaracion de
 * 		variables y para separar parametros. 
 * 		Ejemplo: Entero a, b;	//Separador ',', denota dos nuevas variables
 * 				 Funcion(a, b, c) //separador ',' denota el paso de tres variables
 *
 * '.': separador punto, que se utiliza al llamado de una funcion de 
 * 		una variable especifica.
 * 		Ejemplo: X.lea();		//separador '.', llama a la funcion lea del objeto X
 * 
 * '(' y ')': separadores parentesis (abre y cierra), se utilizan
 * 		para denotar los parametros que recibe una funcion, para
 * 		los parametros dentro de las intrucciones de control y dentro
 * 		de las intrucciones de funcion.
 * 		Ejemplo: Funcion(Entero a, Entero b){	//separador ( y termina con )
 * 				 indica que la funcion recibe parametros, para crear una nueva instruccion funcion
 * 				 si(x!=y)	//separador ( para los parametros del condicional si, ) para terminar de
 * 				 ingresar condiciones.
 * 				 a.funcion(b, c); //separador ( envia los parametros de la funcion del objeto a.
 * 
 * '[' y ']': separadores parentesis cuadrados, solo se utilizan
 * 		para denotar vectores o matrices de objetos.
 * 		Ejemplo: Real a[5]; //denota un vector de 5 posiciones llamado "a" de tipo Real
 * 
 * '{' y '}': separadores llaves, son los que denotan el princio de
 * 		una instruccion y su final.
 * 
 * ''': separador comilla simple, se utiliza para denotar caracteres
 * 		Ejemplo: Caracter a= 'a'; se necesitan ' inicial y ' final.
 * 
 * '"': separador comillas dobles, se utiliza para denotar una 
 * 		cadena de caracteres.
 * 		Ejemplo: escriba("habia una vez...");
 * 
 * ";": separador punto y coma, se utiliza para denotar el final de
 * 		una linea de codigo, para asi finalmente enviar la cadena
 * 		que conforma la linea y revisarla para su evaluar su correcta
 * 		escritura. tambien se utiliza en la intruccion cicloPara, en la
 * 		que se separan los distintos tipo de parametros que conforman
 * 		esta instruccion.
 * 
 * "/*": separador comentario, este separador permite comentar el codigo
 * 		 todo lo que preceda a este separador es omitido por el compilador
 * 		 hasta que se cierre con el separador */
	
public class Separador extends Sentencia{

	public Separador(String tipo) {
		super(tipo);
	}

}

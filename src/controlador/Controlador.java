package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import datos.Pais;

/**
 * Clase Controlador. Se encarga de las funciones utiles del programa
 * 
 * @author Dani Kuradchyk
 */
public class Controlador {

	/** ArrayList de los paises */
	private ArrayList<Pais> paises;

	/**
	 * Constructor de el controlador que inicializa el array de paises
	 */
	public Controlador() {
		this.paises = new ArrayList<>();

	}

	/**
	 * Anadir pais.
	 * Metodo que añade un pais al array
	 *
	 * @param p El pais que se pasa por parametros
	 */
	public void anadirPais(Pais p) {
		this.paises.add(p);
	}

	/**
	 * Comprueba paises.
	 *	Metodo que comprueba si el pais que se le pasa por parametro existe en el array
	 * @param p pais
	 * @return true si se ha encontrado el pais dentro del array
	 */
	public boolean compruebaPaises(Pais p) {
		boolean corr = false;
		if (paises.contains(p)) {
			corr = true;
		}
		return corr;
	}

	/**
	 * Validar fecha.
	 *	Metodo que valida el formato de la fecha
	 * @param fecha  fecha
	 * @return true devuelve true si la fecha esta en formato correcto
	 */
	public static boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * Devuelve los paises
	 *
	 * @return paises 
	 */
	public ArrayList<Pais> getPaises() {
		return paises;
	}

	/**
	 * Cambia el valor del array
	 *
	 * @param paises el nuevo array de paises
	 */
	public void setPaises(ArrayList<Pais> paises) {
		this.paises = paises;
	}

}
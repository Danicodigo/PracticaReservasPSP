package datos;

import java.util.ArrayList;

/**
 * Clase Menus
 * Esta clase guarta todos los menus 
 * 
 * @author Dani Kuradchyk
 */
public class Menus {
	
	/** La linea que se usa en los distintos menus */
	private String linea="---------------------------------------------------------------------------------";

	/**
	 * Menu opciones.
	 */
	public void menuOpciones() {
		System.out.println(linea);
		System.out.println("Introduce \"1\" para reservar un vuelo");
		System.out.println("(1) Reservar vuelo");
		System.out.println(linea);
	}
	
	/**
	 * Menu principal.
	 */
	public void menuPrincipal() {
		System.out.println("¡Bienvenido al sistema de reservas de vuelo AirDani!");
		String men="     ____\r\n" + 
				"     \\\\  `.\r\n" + 
				"      \\\\   `.\r\n" + 
				"       \\ \\   `.\r\n" + 
				"        \\\\     `.\r\n" + 
				"        :. . . . `._______________________.-~|~~-._\r\n" + 
				"        \\                                 ---'-----`-._\r\n" + 
				"         /\"\"\"\"\"\"\"/     AirDani ...---------..         ~-._________\r\n" + 
				"        //     .`_________  .-`           \\ .-~           /\r\n" + 
				"       //    .'       ||__.~             .-~_____________/\r\n" + 
				"      //___.`           .~            .-~\r\n" + 
				"                      .~           .-~\r\n" + 
				"                    .~         _.-~\r\n" + 
				"                    `-_____.-~'";
		System.out.println(men);
		System.out.println("Presiona cualquier tecla para continuar...");
	}
	
	/**
	 * Menu paises.
	 * Metodo que recorre el array de paises y va mostrando su nombre y lo pone en mayusculas
	 *
	 * @param paises un array de paises
	 */
	public void menuPaises(ArrayList<Pais> paises) {
		System.out.println(linea);
		for (Pais pais : paises) {
			System.out.println(pais.getNombre().toUpperCase());
		}
		System.out.println(linea);
		
	}
	
	/**
	 * Menu clase.
	 */
	public void menuClase() {
		System.out.println(linea);
		System.out.println("Economica");
		System.out.println("Ejecutiva");
		System.out.println("Primera clase");
		System.out.println(linea);
	}
	
	/**
	 * Menu final.
	 */
	public void menuFinal() {
		System.out.println(linea);
		System.out.println("Teclee una de las opciones");
		System.out.println("\"Ver reserva\"");
		System.out.println("\"Salir\"");
		System.out.println(linea);
	}
	
	/**
	 * Menu opc incorrecta.
	 *Menu que muestra cuando una opcion se escribio de forma erronea
	 *
	 * @param entrada es el texto que el usuario escribe
	 * @param string es la opcion de error
	 */
	public void menuOpcIncorrecta(String entrada, String string) {
		System.out.println("Opcion incorrecra, por favor repitalo de nuevo. Error: "+string+": "+entrada+" invalido");
	}
	
	/**
	 * Opciones.
	 *
	 * @param entrada es el texto que el usuario escribe
	 * @return the string que devuelve null si la opcion es incorrecta
	 */
	public String opciones(String entrada) {
		if (entrada.matches("[1-3]")) {

			return entrada;
		} else {
			menuOpcIncorrecta(entrada, "Opcion");
			return null;
		}
	}

}

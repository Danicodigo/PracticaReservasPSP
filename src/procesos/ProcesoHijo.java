package procesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import controlador.Controlador;
import datos.Menus;
import datos.Pais;
import datos.Reserva;


/**
 * The Class ProcessHijo.
 * 
 * La clase donde se encuentra la logica del programa se encarga de recoger los
 * datos que le envia el cliente desde el Procceso padre y leerlos desde el
 * buffer.
 * 
 * @author Dani Kuradchyk
 */
public class ProcesoHijo {

	/**
	 * El metodo main que contiene la logica de la aplicacion
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/** entrada que guarda lo que le el buffer **/
		String entrada = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		/** Menu para utilizar los distintos menus **/
		Menus menu = new Menus();
		/** control para usar las funciones **/
		Controlador control = new Controlador();
		/** reserva **/
		Reserva reserva;
		/** correcto sirve para validar los distintos menus **/
		boolean correcto = true;
		/** Creamos los distintos paises disponibles **/
		Pais p1 = new Pais("ESPAÑA");
		Pais p2 = new Pais("PORTUGAL");
		Pais p3 = new Pais("ITALIA");
		Pais p4 = new Pais("FRANCIA");
		/** Añadimos los paises al Array **/
		control.anadirPais(p1);
		control.anadirPais(p2);
		control.anadirPais(p3);
		control.anadirPais(p4);
		/**
		 * Declaro las distintas variables para guardar la informacion de la reserva
		 **/
		String fechaSalida = "";
		String fechaLLegada = "";
		Pais origen;
		Pais destino;
		String clase;

		try {
			/**Mustra el menu principal y pide cualquier tecla por el teclado**/
			menu.menuPrincipal();
			entrada = br.readLine();
			/**Muestra menu de opciones**/
			do {
				menu.menuOpciones();
				entrada = br.readLine();
			}while(menu.opciones(entrada)==null);
			
			/**Valida el pais de origen**/
			do {
				System.out.println("Introduce tu origen: ");
				menu.menuPaises(control.getPaises());
				entrada = br.readLine().toUpperCase();
				if (control.compruebaPaises(new Pais(entrada))) {

					correcto = true;
				} else {
					menu.menuOpcIncorrecta(entrada, "Pais");
					correcto = false;
				}

			} while (!correcto);
			/**Guarda el origen**/
			origen = new Pais(entrada);
			/**Valida el pais de destino **/
			do {

				System.out.println("Introduce tu destino: ");
				menu.menuPaises(control.getPaises());
				entrada = br.readLine().toUpperCase();
				if (control.compruebaPaises(new Pais(entrada))) {

					correcto = true;
				} else {
					menu.menuOpcIncorrecta(entrada, "Pais");
					correcto = false;
				}

			} while (!correcto);
			/**Guarda el destino**/
			destino = new Pais(entrada);
			/**Valida la clase de vuelo**/
			do {

				System.out.println("¿Introduce en que clase quieres viajar?");
				menu.menuClase();
				entrada = br.readLine();
				if (entrada.equalsIgnoreCase("economica") || entrada.equalsIgnoreCase("ejecutiva")
						|| entrada.equalsIgnoreCase("primera clase")) {

					correcto = true;
				} else {
					menu.menuOpcIncorrecta(entrada, "Clase");
					correcto = false;
				}

			} while (!correcto);
			/**Guarda la clase**/
			clase = entrada.toUpperCase();
			/**Valida la fecha de salida**/
			do {

				System.out.println("Introduce la fecha de salida en el siguente formato: \"dd/MM/yyyy\"");
				entrada = br.readLine();
				if (Controlador.validarFecha(entrada)) {
					correcto = true;
				} else {
					menu.menuOpcIncorrecta(entrada, "Fecha");
					correcto = false;
				}
			} while (!correcto);
			/**guarda la fecha de salida**/
			fechaSalida = entrada;
			/**Valida la fecha de llegada**/
			do {
				System.out.println("Introduce la fecha de llegada en el siguente formato: \"dd/MM/yyyy\"");
				entrada = br.readLine();
				if (Controlador.validarFecha(entrada)) {

					correcto = true;
				} else {
					menu.menuOpcIncorrecta(entrada, "Fecha");
					correcto = false;
				}
			} while (!correcto);
			/**Guarda la fecha de llegada**/
			fechaLLegada = entrada;
			
			/**Crea la reserva con todos los atributos**/
			reserva = new Reserva(origen, destino, clase, fechaSalida, fechaLLegada);
			System.out.println("Reserva completada con exito!");
			/**Valida el menu final**/
			do {
				System.out.println("¿Que desea hacer ahora?");
				menu.menuFinal();
				entrada = br.readLine();
				if (entrada.equalsIgnoreCase("salir")) {
					System.out.println("¡Hasta la proxima!");
					correcto = true;
				} else if (entrada.equalsIgnoreCase("ver reserva")) {
					reserva.mostrar();
					correcto = false;
				} else {
					menu.menuOpcIncorrecta(entrada, "Opcion");
					correcto = false;
				}
			} while (!correcto);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package datos;

/**
 * The Class Reserva.
 * Clase de la reserva que contiene los atributos de la misma
 * 
 * @author Dani Kuradchyk
 */
public class Reserva {
	
	/** origen. guarda el origen */
	private Pais origen;
	
	/** The destino. gruarda el destino */
	private Pais destino;
	
	/** The clase. guarda la clase */
	private String clase;
	
	/** The fecha salida. guarda la fecha de salida */
	private String fechaSalida;
	
	/** The fecha L legada. guarda la fecha de llegada*/
	private String fechaLLegada;

	/**
	 * Constructor reserva con todos los atributos
	 *
	 * @param origen el pais origee
	 * @param destino el pais destino
	 * @param clase es la clase de vuelo
	 * @param fechaSalida la fecha de salida
	 * @param fechaLLegada la fecha de entrada
	 */
	public Reserva(Pais origen, Pais destino, String clase, String fechaSalida, String fechaLLegada) {
		this.origen = origen;
		this.destino = destino;
		this.clase = clase;
		this.fechaSalida = fechaSalida;
		this.fechaLLegada = fechaLLegada;
	}

	/**
	 * Constructor vacio de una reserva.
	 */
	public Reserva() {
	}

	/**
	 * Mostrar. 
	 * 
	 * Muestra la reserva por consola
	 */
	public void mostrar() {
		System.out.println("------------------------------------------------");
		System.out.println("Reserva: ");
		System.out.println("Origen: "+origen.getNombre());
		System.out.println("Destino: "+ this.destino.getNombre());
		System.out.println("Clase: "+this.clase);
		System.out.println("Fecha de salida: "+this.fechaSalida);
		System.out.println("Fecha de LLegada: "+this.fechaLLegada);
		System.out.println("------------------------------------------------");
	}

	/**
	 * Devuelve el pais origen
	 *
	 * @return the origen
	 */
	public Pais getOrigen() {
		return origen;
	}

	/**
	 * Cambia el pais origen.
	 *
	 * @param origen the new origen
	 */
	public void setOrigen(Pais origen) {
		this.origen = origen;
	}

	/**
	 * Devuelve el pais destino.
	 *
	 * @return the destino
	 */
	public Pais getDestino() {
		return destino;
	}

	/**
	 * Cambia el pais destino.
	 *
	 * @param destino the new destino
	 */
	public void setDestino(Pais destino) {
		this.destino = destino;
	}

	/**
	 * Devuelve la clase de vuelo.
	 *
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}

	/**
	 * Cambia la clase de vuelo.
	 *
	 * @param clase the new clase
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

	/**
	 * Devuelve la fecha salida.
	 *
	 * @return the fecha salida
	 */
	public String getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * cambia la fecha salida.
	 *
	 * @param fechaSalida the new fecha salida
	 */
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Devuelve la  Gets the fecha Llegada.
	 *
	 * @return the fecha Llegada
	 */
	public String getFechaLLegada() {
		return fechaLLegada;
	}

	/**
	 *Cambia la fecha Llegada.
	 *
	 * @param fechaLLegada the new fecha L legada
	 */
	public void setFechaLLegada(String fechaLLegada) {
		this.fechaLLegada = fechaLLegada;
	}
	
}
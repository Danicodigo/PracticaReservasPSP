package datos;

/**
 * The Class Pais.
 */
public class Pais {
    
    /** The nombre. */
    private String nombre;

    /**
     * Instantiates a new pais.
     *
     * @param nombre the nombre
     */
    public Pais(String nombre) {
        this.nombre = nombre;

    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj){
		 return this.nombre.equals(((Pais) obj).nombre);
	}
    
    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
    	return this.nombre;
    }
    
    /**
     * Sets the nombre.
     *
     * @param nombre the new nombre
     */
    public void setNombre(String nombre) {
    	this.nombre=nombre;
    }
}
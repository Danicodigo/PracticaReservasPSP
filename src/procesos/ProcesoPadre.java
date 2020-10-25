package procesos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Class TestProcessIO.
 */
public class ProcesoPadre {

	/**
	 * Checks if is alive.
	 *
	 * @param p the p
	 * @return true, if is alive
	 */
	public static boolean isAlive(Process p) {
		//si el proceso hijo ha terminado devuelve falso, si no ha terminado lanza una excepción y devuelve true
		try {
			p.exitValue(); 
			return false;
		}
		catch (IllegalThreadStateException e) {
			return true;
		}
	}
	
	/**
	 * Run process.
	 *
	 * @param command the command
	 * @throws InterruptedException the interrupted exception
	 */
	private static void runProcess(String command) throws InterruptedException{
		Process pro;
		try {
			pro = Runtime.getRuntime().exec(command);
			pro.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		runProcess("javac -cp src src/procesos/ProcesoHijo.java");
        Process process = Runtime.getRuntime().exec("java -cp src procesos/ProcesoHijo");
		InputStream out = process.getInputStream(); //configuramos la salida del proceso hijo
		OutputStream in = process.getOutputStream(); //configuramos la entrada del proceso hijo

		byte[] buffer = new byte[4000]; //buffer de comunicación entre procesos
		while (isAlive(process)) {
			//se comprueba el stream de salida del proceso hijo
			int no = out.available();
			if (no > 0) {
				//si el stream de salida del proceso hijo tiene información se muestra por pantalla
				int n = out.read(buffer, 0, Math.min(no, buffer.length));
				System.out.println(new String(buffer, 0, n));
			}

			//se comprueba si hay información para enviar al proceso hijo
			int ni = System.in.available();
			if (ni > 0) {
				//si existe información se envía al proceso hijo
				int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
				in.write(buffer, 0, n);
				in.flush();
			}

			try {
				Thread.sleep(10); //se introduce un retardo de 10 milisegundos
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

		System.out.println(process.exitValue());
	}
}
/**
 * 
 */
package vista;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import controlador.*;
import modelo.AutomatasException;

/**
 * @author Miguel
 *
 */
public class VistaConsola implements Vista{
	
	//LA UTILIDAD DE EsTA CLASE EN EL FUTURO SERÁ UNA PARTE DE LA INTERFAZ GRÁFICA
	//DE MOMENTO SOLO PASA LAS QUERYS AL CONTROLADOR
	private Controlador controlador;
	private String query;
	
	public VistaConsola() {
		query=null;
		controlador=Controlador_imp.getInstancia();
		controlador.registraVista(this);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			query=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejecuta();
	}
	
	public void ejecuta() {
		try {
			controlador.ejecutaQuery(query);
		} catch(AutomatasException e){
			System.out.println(e.getMensaje());
		}
	}

	@Override
	public void trataMensaje(String mensaje) {
		// TODO Auto-generated method stub
		System.out.println(mensaje);
	}

}

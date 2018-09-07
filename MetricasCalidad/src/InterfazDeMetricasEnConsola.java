import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfazDeMetricasEnConsola {
	
	private static final String PRESENTACION = "ALGORITMO PARA OBTENCIÓN DEL NIVEL DE CALIDAD ALCANZADO\n\n" 
									+ 	"Las siguiente son las caracteristicas que puede evaluar: \n"
									+	"\t 1. Funcionabilidad\n"
									+	"\t\t a. Seguridad de Acceso\n"
									+	"\t\t b. Exactitud de los resultados\n"
									+	"\t 2. Eficiencia\n"
									+	"\t\t a. Utilización de recursos\n"
									+	"\t\t b. Comportamiento frente al tiempo\n"
									+	"\t 3. Fiabilidad\n"
									+	"\t\t a. Tolerancia a fallos\n"
									+	"\t\t b. Capacidad de recuperación de errores\n"
									+	"\t 4. Mantenibilidad\n"
									+	"\t\t a. Capacidad del código de ser analizado\n"
									+	"\t\t b. Capacidad del código de ser cambiado\n"
									+	"\t 5. Usabilidad\n"
									+	"\t\t a. Capacidad de ser entendido\n"
									+	"\t\t b. Capacidad de ser operado\n"
									+	"\t 6. Portabilidad\n"
									+	"\t\t a. Adaptabilidad\n"
									+	"\t\t b. Instalabilidad\n\n"
									+	"Ingrese las caracteristicas que desea evaluar separadas con coma\n"
									+	"\t por ejemplo:\n"
									+	"\t\t\t 1a,1b,3a,4b,6a\n\n";
	
	private static final String[] INDICE = {"1a", "1b", "2a", "2b", "3a", "3b", "4a", "4b", "5a", "5b", "6a", "6b"};

	public static void main(String[] args) {
		
		Caracteristicas caracteristicas = new Caracteristicas();
		
		cargarInterfaz(caracteristicas);
		
		double calidad = ProcesarCaracteristicas.calcularCalidad(caracteristicas);
		
		System.out.println("\n El nivel de calidad alcanzado es del: " + calidad + "% .");

	}

	private static void cargarInterfaz(Caracteristicas caracteristicas) {
		
		System.out.println(PRESENTACION);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			validarEntrada(input.split(","));
		} catch (Exception e) {
			
			e.printStackTrace();
			
			cargarInterfaz(caracteristicas);
		}
		
		solicitarDatos(caracteristicas, input.split(","));
	}


	private static void validarEntrada(String[] input) throws Exception {
		
		for(String indiceIngresado: input) {
			
			boolean encontrado = false;
			
			for(int i = 0; i < INDICE.length && !encontrado; i++) {
				
				if(indiceIngresado.trim().equals(INDICE[i])) {
					encontrado = true;
				}
			}
			
			if(!encontrado) {
				throw new Exception("El indice " + indiceIngresado + " no es correcto. Intente nuevamente.");
			}
		}
	}

	
	private static void solicitarDatos(Caracteristicas caracteristicas, String[] input) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(String indiceIngresado: input) {
			
			switch(indiceIngresado.trim()){
				
				case "1a": 
					
					System.out.println("Ingresar 1 si hay encriptacion de datos o 0 si no lo hay\n");
					
					
					
					break;
					
				case "1b": 
					break;
					
				case "2a": 
					break;
					
				case "2b": 
					break;
					
				case "3a": 
					break;
					
				case "3b": 
					break;
					
				case "4a": 
					break;
					
				case "4b": 
					break;
					
				case "5a": 
					break;
					
				case "5b": 
					break;
					
				case "6a": 
					break;
					
				case "6b": 
					break;
					
			}
			
//			if(indiceIngresado.trim().equals("1b")){ 
//				
//			}
//			
//			if(caracteristicas.getOrdenError() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getUsoProcesador() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getTiempoSinInformarEstado() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getProteccionDatosProcesados() != null && caracteristicas.getLogActividades() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getReanudarActividadAnteFalla() != null && caracteristicas.getReanudarEnEstadoAnterior() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getPorcentajeComentariosPorMetodo() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
////		if(caracteristicas.getComplejidadCiclomatica() != null) {
////			valor ++;
////		}
//			
//			if(caracteristicas.getAyduaContextual() != null && caracteristicas.getManualUsuarioIncorporado() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getCapacidadDeSerOperado() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getCantSOCompatibles() != null) {
//				cantidadCaracteristicas ++;
//			}
//			
//			if(caracteristicas.getCantPasosInstalacion() != null) {
//				cantidadCaracteristicas ++;
//			}
		}
		
		
	}
}

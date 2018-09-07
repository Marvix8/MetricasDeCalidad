

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
		
		String input = System.console().readLine();
		
		try {
			validarEntrada(input.split(","));
		} catch (Exception e) {
			
			e.printStackTrace();
			
			cargarInterfaz(caracteristicas);
		}
		
		solicitarDatos(caracteristicas);
	}


	private static void validarEntrada(String[] split) throws Exception {
		
		for(String indiceIngresado: split) {
			
			for(int i = 0; i < INDICE.length; i++) {
				
				if(!indiceIngresado.equals(INDICE[i])) {
					throw new Exception("El indice " + indiceIngresado + " no es correcto. Intente nuevamente.");
				}
			}
		}
	}

	
	private static void solicitarDatos(Caracteristicas caracteristicas) {
		// TODO Auto-generated method stub
		
	}
}

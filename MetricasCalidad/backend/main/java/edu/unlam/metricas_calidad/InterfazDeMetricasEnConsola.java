package edu.unlam.metricas_calidad;
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
		
		String mensaje;
		
		boolean error;
		
		for(String indiceIngresado: input) {
			
			switch(indiceIngresado.trim()){
				
				case "1a": 
					
					mensaje = "Ingresar 1 si hay encriptacion de datos o 0 si no lo hay\n";
					
					caracteristicas.setEncriptacionDatos(ingresoBooleano(mensaje, null));
					
					mensaje = "Ingresar 1 si hay inicio de sesion de usuario o 0 si no lo hay\n";
					
					caracteristicas.setInicioSesionUsuarios(ingresoBooleano(mensaje, null));
					
					break;
					
				case "1b": 
					
					mensaje = "Ingresar el orden del error de los resultados\n";
					
					caracteristicas.setOrdenError(ingresoValor(mensaje));
					
					break;
					
				case "2a": 
					
					mensaje = "Ingrese el porcentaje de uso del procesador\n";
					error = false;
					
					do {
						try {
							caracteristicas.setUsoProcesador(ingresoValor(mensaje));
						} catch (CaracteristicaException e) {
							System.out.println(e);
							error = true;
						}
					}while(error);

					break;
					
				case "2b": 					
					
					mensaje = "Ingrese el tiempo maximo sin informar el estado de una solicitud\n";
					error = false;
					
					do {
						try {
							caracteristicas.setTiempoSinInformarEstado(ingresoValor(mensaje));
						} catch (CaracteristicaException e) {
							System.out.println(e);
							error = true;
						}
					}while(error);
					
					break;
					
				case "3a": 					
					
					mensaje = "Ingrese 1 si se protegen los datos procesados ante errores o 0 de no ser asi\n";
					
					caracteristicas.setProteccionDatosProcesados(ingresoBooleano(mensaje, null));
					
					mensaje = "Ingrese 1 si se realiza un log de actividades del sistema o 0 si no se realiza\n";
					
					caracteristicas.setLogActividades(ingresoBooleano(mensaje, null));

					break;
					
				case "3b": 					
					
					mensaje = "Ingrese 1 si el sistema reanuda las actividades si se produce una falla crítica o 0 si no lo hace\n";
					
					caracteristicas.setReanudarActividadAnteFalla(ingresoBooleano(mensaje, null));
					
					mensaje = "Ingrese 1 si al reanudar las actividades el sistema vuelve al estado anterior o 0 si no es asi\n";
					
					caracteristicas.setReanudarEnEstadoAnterior(ingresoBooleano(mensaje, null));

					break;
					
				case "4a": 					
					
					mensaje = "Ingrese el porcentaje de comentarios por metodo\n";
					error = false;
					
					do {
						try {
							caracteristicas.setPorcentajeComentariosPorMetodo(ingresoValor(mensaje));
						} catch (CaracteristicaException e) {
							System.out.println(e);
							error = true;
						}
					}while(error);	

					break;
					
				case "4b": 				
					
					mensaje = null; 

					break;
					
				case "5a": 
					
					mensaje = "Ingrese 1 si posee ayuda contextual sobre menús y botones de acción o 0 si no los posee\n";
					
					caracteristicas.setAyudaContextual(ingresoBooleano(mensaje, null));
					
					mensaje = "Ingrese 1 si posee manual de usuario incorporado al sistema como un menú dedicado o 0 de no poseerlo\n";
					
					caracteristicas.setManualUsuarioIncorporado(ingresoBooleano(mensaje, null));
					
					break;
					
				case "5b": 					
					
					mensaje = "Ingrese 1, 2 o 3 segun la capacidad de ser operado, siendo 3 la mejor calificacion\n";
					
					double calificacion;
					
					do {
						calificacion = ingresoValor(mensaje);
						
						if(calificacion == 1) {
							caracteristicas.setCapacidadDeSerOperado(Calificacion.MALO);
						}else if(calificacion == 2) {
							caracteristicas.setCapacidadDeSerOperado(Calificacion.REGULAR);
						}else if(calificacion == 3){
							caracteristicas.setCapacidadDeSerOperado(Calificacion.BUENO);
						}else {
							System.out.println("El valor ingresado no es correcto\n");
						}
					}while (calificacion !=1 && calificacion != 2 && calificacion != 3);
						
					break;
					
				case "6a": 					
					
					mensaje = "Ingrese con cuantos sistemas operativos es compatible el sistema\n";
					error = false;
					
					do {
						try {
							caracteristicas.setCantSOCompatibles(ingresoValor(mensaje));
						} catch (CaracteristicaException e) {
							System.out.println(e);
							error = true;
						}
					}while(error);
					
					break;
					
				case "6b": 					

					mensaje = "Ingrese la cantidad minima de pasos para instalar el sistema\n";
					error = false;
					
					do {
						try {
							caracteristicas.setCantPasosInstalacion(ingresoValor(mensaje));
						} catch (CaracteristicaException e) {
							System.out.println(e);
							error = true;
						}
					}while(error);
					
					break;
					
			}
		}
	}

	private static Boolean ingresoBooleano(String mensaje, BufferedReader bufferReader) {
		
		BufferedReader br;
		
		if(bufferReader == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}else {
			br = bufferReader;
		}
		
		System.out.println(mensaje);
		String input = null;
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(input.trim().equals("1")) {
			return true;
		}
		else if(input.trim().equals("0")){
			return false;
		}
		else {
			System.out.println("Ingreso invalido, vuelva a intentar\n");
			ingresoBooleano(mensaje, br);
		}
		
		return null;
	}
	
	private static double ingresoValor(String mensaje) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(mensaje);
		String input = null;
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		double valor = 0;
		try {
			valor = Double.valueOf(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return valor;
	}
}

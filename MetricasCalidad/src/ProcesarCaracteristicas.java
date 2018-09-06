
public class ProcesarCaracteristicas {
	
	public static double calcularCalidad(Caracteristicas caracteristicas) {
		
		double valorAlcanzado = calcularValorAlcanzado(caracteristicas);
		
		double valorMaximo = calcularValorMaximo(caracteristicas);
		
		return (valorAlcanzado/valorMaximo) * 100;
	}
	
	private static double calcularValorAlcanzado(Caracteristicas caracteristicas) {
		
		double valor = 0;
		
		if(caracteristicas.getEncriptacionDatos() != null) {
			valor += medirCaracteristica()
		}
	}
	
	private static double medirCaracteristica(Object obj, double limiteSup, double limiteInf) {
		return 0;
	}

}

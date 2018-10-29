package edu.unlam.metricas_calidad;

public class Caracteristicas {
	
	public static boolean setEncriptacionDatos;
	private Boolean encriptacionDatos;
	private Boolean inicioSesionUsuarios;
	private Double ordenError;
	private Double usoProcesador;
	private Double tiempoSinInformarEstado;
	private Boolean proteccionDatosProcesados;
	private Boolean logActividades;
	private Boolean reanudarActividadAnteFalla;
	private Boolean reanudarEnEstadoAnterior;
	private Double	porcentajeComentariosPorMetodo;
	private Double complejidadCiclomatica;
	private Boolean ayduaContextual;
	private Boolean manualUsuarioIncorporado;
	private CapacidadDeSerOperado capacidadDeSerOperado;
	private Double cantSOCompatibles;
	private Double cantPasosInstalacion;
	
	
	public Boolean getEncriptacionDatos() {
		return encriptacionDatos;
	}
	public void setEncriptacionDatos(Boolean encriptacionDatos) {
		this.encriptacionDatos = encriptacionDatos;
	}
	public Boolean getInicioSesionUsuarios() {
		return inicioSesionUsuarios;
	}
	public void setInicioSesionUsuarios(Boolean inicioSesionUsuarios) {
		this.inicioSesionUsuarios = inicioSesionUsuarios;
	}
	public Double getOrdenError() {
		return ordenError;
	}
	public void setOrdenError(Double ordenError) {
		this.ordenError = ordenError;
	}
	public Double getUsoProcesador() {
		return usoProcesador;
	}
	public void setUsoProcesador(Double usoProcesador) throws CaracteristicaException {
		
		if(usoProcesador < 0 || usoProcesador > 100) {
			throw new CaracteristicaException("El uso del procesador debe ser un valor entre 0 y 100\n");
		}
		this.usoProcesador = usoProcesador;
	}
	public Double getTiempoSinInformarEstado() {
		return tiempoSinInformarEstado;
	}
	public void setTiempoSinInformarEstado(Double tiempoSinInformarEstado) throws CaracteristicaException {
		
		if(tiempoSinInformarEstado <= 0) {
			throw new CaracteristicaException("El tiempo debe ser un valor mayor a 0\n");
		}
		this.tiempoSinInformarEstado = tiempoSinInformarEstado;
	}
	public Boolean getProteccionDatosProcesados() {
		return proteccionDatosProcesados;
	}
	public void setProteccionDatosProcesados(Boolean proteccionDatosProcesados) {
		this.proteccionDatosProcesados = proteccionDatosProcesados;
	}
	public Boolean getLogActividades() {
		return logActividades;
	}
	public void setLogActividades(Boolean logActividades) {
		this.logActividades = logActividades;
	}
	public Boolean getReanudarActividadAnteFalla() {
		return reanudarActividadAnteFalla;
	}
	public void setReanudarActividadAnteFalla(Boolean reanudarActividadAnteFalla) {
		this.reanudarActividadAnteFalla = reanudarActividadAnteFalla;
	}
	public Boolean getReanudarEnEstadoAnterior() {
		return reanudarEnEstadoAnterior;
	}
	public void setReanudarEnEstadoAnterior(Boolean reanudarEnEstadoAnterior) {
		this.reanudarEnEstadoAnterior = reanudarEnEstadoAnterior;
	}
	public Double getPorcentajeComentariosPorMetodo() {
		return porcentajeComentariosPorMetodo;
	}
	public void setPorcentajeComentariosPorMetodo(Double porcentajeComentariosPorMetodo) throws CaracteristicaException {
		
		if(porcentajeComentariosPorMetodo < 0 || porcentajeComentariosPorMetodo > 100) {
			throw new CaracteristicaException("El porcentaje debe ser un valor entre 0 y 100\n");
		}
		this.porcentajeComentariosPorMetodo = porcentajeComentariosPorMetodo;
	}
	public Double getComplejidadCiclomatica() {
		return complejidadCiclomatica;
	}
	public void setComplejidadCiclomatica(Double complejidadCiclomatica) throws CaracteristicaException {
		
		if(complejidadCiclomatica <= 0) {
			throw new CaracteristicaException("La complejidad ciclomatica debe ser un valor mayor a 0\n");
		}
		this.complejidadCiclomatica = complejidadCiclomatica;
	}
	public Boolean getAyduaContextual() {
		return ayduaContextual;
	}
	public void setAyduaContextual(Boolean ayduaContextual) {
		this.ayduaContextual = ayduaContextual;
	}
	public Boolean getManualUsuarioIncorporado() {
		return manualUsuarioIncorporado;
	}
	public void setManualUsuarioIncorporado(Boolean manualUsuarioIncorporado) {
		this.manualUsuarioIncorporado = manualUsuarioIncorporado;
	}
	public CapacidadDeSerOperado getCapacidadDeSerOperado() {
		return capacidadDeSerOperado;
	}
	public void setCapacidadDeSerOperado(CapacidadDeSerOperado capacidadDeSerOperado) {
		this.capacidadDeSerOperado = capacidadDeSerOperado;
	}
	public Double getCantSOCompatibles() {
		return cantSOCompatibles;
	}
	public void setCantSOCompatibles(Double cantSOCompatibles) throws CaracteristicaException {
		
		if(cantSOCompatibles <= 0) {
			throw new CaracteristicaException("La cantidad de sistemas operativos compatibles debe ser un valor mayor a 0\n");
		}
		this.cantSOCompatibles = cantSOCompatibles;
	}
	public Double getCantPasosInstalacion() {
		return cantPasosInstalacion;
	}
	public void setCantPasosInstalacion(Double cantPasosInstalacion) throws CaracteristicaException {
		
		if(cantPasosInstalacion <= 0) {
			throw new CaracteristicaException("La cantidad de pasos para la instalacion debe ser un valor mayor a 0\n");
		}
		this.cantPasosInstalacion = cantPasosInstalacion;
	}

}

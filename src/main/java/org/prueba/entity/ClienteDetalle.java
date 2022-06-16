package org.prueba.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDetalle extends  Cliente {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyy")
	private Date fechaProbableMuerte;

	public Date getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}

	public void setFechaProbableMuerte(Date fechaProbableMuerte) {
		this.fechaProbableMuerte = fechaProbableMuerte;
	}
}

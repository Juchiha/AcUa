package models;

public class Aspirante {
	
	String strPrimerNombre;
	String strSegundoNombre;
	String strPrimerApellido;
	String strSegundoApellido;
	String strNumeroDocumento;
	String strAc;
	String strNuevoAc;
	String strFechaUpdate;
	String strPeriodo;
	
	
	
	public Aspirante(String strPrimerNombre, String strSegundoNombre, String strPrimerApellido,
			String strSegundoApellido, String strNumeroDocumento, String strAc, String strNuevoAc,
			String strFechaUpdate, String strPeriodo) {
		super();
		this.strPrimerNombre = strPrimerNombre;
		this.strSegundoNombre = strSegundoNombre;
		this.strPrimerApellido = strPrimerApellido;
		this.strSegundoApellido = strSegundoApellido;
		this.strNumeroDocumento = strNumeroDocumento;
		this.strAc = strAc;
		this.strNuevoAc = strNuevoAc;
		this.strFechaUpdate = strFechaUpdate;
		this.strPeriodo = strPeriodo;
	}

	public String getStrPrimerNombre() {
		return strPrimerNombre;
	}

	public void setStrPrimerNombre(String strPrimerNombre) {
		this.strPrimerNombre = strPrimerNombre;
	}

	public String getStrSegundoNombre() {
		return strSegundoNombre;
	}

	public void setStrSegundoNombre(String strSegundoNombre) {
		this.strSegundoNombre = strSegundoNombre;
	}

	public String getStrPrimerApellido() {
		return strPrimerApellido;
	}

	public void setStrPrimerApellido(String strPrimerApellido) {
		this.strPrimerApellido = strPrimerApellido;
	}

	public String getStrSegundoApellido() {
		return strSegundoApellido;
	}

	public void setStrSegundoApellido(String strSegundoApellido) {
		this.strSegundoApellido = strSegundoApellido;
	}

	public String getStrNumeroDocumento() {
		return strNumeroDocumento;
	}

	public void setStrNumeroDocumento(String strNumeroDocumento) {
		this.strNumeroDocumento = strNumeroDocumento;
	}

	public String getStrAc() {
		return strAc;
	}

	public void setStrAc(String strAc) {
		this.strAc = strAc;
	}

	public String getStrNuevoAc() {
		return strNuevoAc;
	}

	public void setStrNuevoAc(String strNuevoAc) {
		this.strNuevoAc = strNuevoAc;
	}

	public String getStrFechaUpdate() {
		return strFechaUpdate;
	}

	public void setStrFechaUpdate(String strFechaUpdate) {
		this.strFechaUpdate = strFechaUpdate;
	}

	public String getStrPeriodo() {
		return strPeriodo;
	}

	public void setStrPeriodo(String strPeriodo) {
		this.strPeriodo = strPeriodo;
	}

	public Aspirante() {
		
	}

	@Override
	public String toString() {
		return "{\"strPrimerNombre\":\"" + strPrimerNombre + "\", \"strSegundoNombre\":\"" + strSegundoNombre
				+ "\", \"strPrimerApellido\":\"" + strPrimerApellido + "\", \"strSegundoApellido\":\"" + strSegundoApellido
				+ "\", \"strNumeroDocumento\":\"" + strNumeroDocumento + "\", \"strAc\":\"" + strAc + "\", \"strNuevoAc\":\"" + strNuevoAc
				+ "\", \"strFechaUpdate\":\"" + strFechaUpdate + "\", \"strPeriodo\":\"" + strPeriodo + "\"}";
	}
	
	
	
}

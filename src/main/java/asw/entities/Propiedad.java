package asw.entities;


public class Propiedad {
	
	private String propiedad;
	private String valor;
	
	
	public Propiedad(String propiedad, String valor) {
		super();
		this.propiedad = propiedad;
		this.valor = valor;
	}
	
	
	public String getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}

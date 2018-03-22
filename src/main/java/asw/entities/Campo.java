package asw.entities;


public class Campo {
	
	private String propiedad;
	private String valor;
	
	
	public Campo(String propiedad, String valor) {
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

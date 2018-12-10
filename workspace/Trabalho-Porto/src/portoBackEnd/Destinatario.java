package portoBackEnd;

public class Destinatario {
	private String codigo;
	private String destino;
		
	public Destinatario(String codigo, String destino) {
		this.codigo = codigo;
		this.destino = destino;
	}
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}

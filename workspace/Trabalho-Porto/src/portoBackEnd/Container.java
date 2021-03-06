package portoBackEnd;

import java.util.Date;

public class Container {
	private String codigo;
	private Transportadora remetente;
	private Destinatario destinatario;
	private String conteudo;
	private Date dataEntrada;
	private Date dataSaida;
	
	public Container(String codigo, Transportadora remetente, Destinatario destinatario, String conteudo, Date dataEntrada) {
		this.codigo = codigo;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.setConteudo(conteudo);
		this.dataEntrada = dataEntrada;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Transportadora getRemetente() {
		return remetente;
	}
	
	public void setRemetente(Transportadora remetente) {
		this.remetente = remetente;
	}
	
	public Destinatario getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}
	
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
}

package Background;


public class Pessoa {
	private String nome;
	private String email;
	private Double RendimentoMensal;
	
	public Pessoa(String n, String em, double r) {
		this.nome = n;
		this.email = em;
		this.RendimentoMensal = r;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRendimentoMensal() {
		return RendimentoMensal;
	}

	public void setRendimentoMensal(Double rendimentoMensal) {
		RendimentoMensal = rendimentoMensal;
	}
	
	
}

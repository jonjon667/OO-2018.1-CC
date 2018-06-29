package Background;


public class Despesa {
	private String descricao;
	private double valor;
	
		public Despesa(String d, double v) {
			this.descricao = d;
			this.valor = v;
		}
	public String getDescricao() {
		
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	
}


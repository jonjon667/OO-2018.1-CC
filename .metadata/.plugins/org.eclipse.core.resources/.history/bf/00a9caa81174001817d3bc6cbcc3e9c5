package Background;

import java.util.ArrayList;
import java.util.List;

public class Despesa {
	private String nomeCategoria;
	private static double totalDespesas=0;
	
	
	public static double getTotalDespesas() {
		return totalDespesas;
	}


	private List<SubRendimento> subs = new ArrayList<SubRendimento>();
	
	
	public void  AddSub(SubRendimento oi) {
		subs.add(oi);
		totalDespesas+=oi.getVlaor();
		
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNome(String nome) {
		this.nomeCategoria = nome;
	}

}

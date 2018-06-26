package Background;

import java.util.ArrayList;
import java.util.List;

public class SubCategoria {
	String nomeSubCategoria;
	public List<Despesa> desps = new ArrayList<Despesa>();
	
	
	public String getNomeSubCategoria() {
		return nomeSubCategoria;
	}

	public void setNomeSubCategoria(String nomeSubCategoria) {
		this.nomeSubCategoria = nomeSubCategoria;
	}

	public void imprimetodas() {
		for(int i = 0; i<desps.size();i++) {
			System.out.println(desps.get(i).getDescricao() +" " + desps.get(i).getValor() +"\n");
		}
	}
	
	
	public boolean addDisp(Despesa n) {
		return desps.add(n);
	}
	
	public int getDespsSize() {
	return desps.size();
	}
	
	public double getValortotal(){
		double totdesp = 0;
		for (int i=0;i<desps.size();i++) {
				totdesp+=desps.get(i).getValor();
		}
		return totdesp;
	}
}

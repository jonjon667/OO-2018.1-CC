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

	public static double totalNaSub = 0;
	
	
	
	public boolean addDisp(Despesa n) {
		totalNaSub+= n.getValor();
		return desps.add(n);
	}
	
	public int getDespsSize() {
	return desps.size();
	}
	
	public double getValor(){
		return totalNaSub;
	}
}

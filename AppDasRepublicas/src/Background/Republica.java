package Background;

import java.util.ArrayList;

import java.util.List;



public class Republica {
	public List<Categoria> desp = new ArrayList<Categoria>();
	public List<Pessoa> pessoa = new ArrayList<Pessoa>();
	static double totalRendaMoradores = 0;
	
	
	
	public int getNumPessoas() {
		return pessoa.size();
	} 
	
	public int getNumCategorias() {
		return desp.size();
	} 
	public double getTotalDespesas(){
		double total=0;
		for(int i=0;i<desp.size();i++) {
			total+=desp.get(i).getTotalDespesas();
		}
		return total;
	}

	public static double getTotalRendaMoradores() {
		return totalRendaMoradores;
	}
	
	public boolean addCategoria(String nome) {
		Categoria top = new Categoria();
		top.setNome(nome);
		desp.add(top);
		return true;	
	}
	public boolean addSubCategoria(String nome,int indexCat){
		SubCategoria top = new SubCategoria();
		top.setNomeSubCategoria(nome);
		desp.get(indexCat).AddSub(top);
		return true;
	}
	
	public boolean getLista() {
		for(int i=0;i<pessoa.size();i++) {
		System.out.println(pessoa.get(i).getNome()+"\n"+pessoa.get(i).getEmail()+"\n"+pessoa.get(i).getRendimentoMensal());
		}
		return true;
	}
	
	
	public boolean addPessoa(Pessoa n) {
		totalRendaMoradores+= n.getRendimentoMensal();
		pessoa.add(n);
		return true;
	}
	
	
}




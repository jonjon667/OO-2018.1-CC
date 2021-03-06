package Running;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JOptionPane;
import Background.Despesa;
import Background.Pessoa;
import Background.Republica;

public class App {
	
	public static Republica rep = new Republica();
	
	public static void main (String[] args) {
		
		
	
		Object[] opcoesPossiveis = {"--- Selecione uma opcao ---",
									"Cadastrar Morador", 
				                    "Cadastrar Uma nova Categoria", 
				                    "Cadastrar Sub Categoria",
				                    "Cadastrar Despesas",
				                    "Calcular Divis�o",
				                    "total",
				                    "Carregar lista de moradores",
				                    "Sair"};
		Object opcaoDefault = opcoesPossiveis[0];
		Object opcaoSelecionada = null;
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(null, 
											"Selecione uma das opcoes a seguir:", 
											"App das Republicas Top", 
											JOptionPane.QUESTION_MESSAGE, 
											null, 
											opcoesPossiveis, 
											opcaoDefault);
			switch ((String) opcaoSelecionada) {
			case "Cadastrar Morador":
				  cadastrarMorador();
			    break;
			    	
			case "Cadastrar Uma nova Categoria":
				cadastrarCategoria();
				break;
				
			case "Cadastrar Despesas":
				cadastrarDespesas();
				
			break;
			
			case "Cadastrar Sub Categoria":
				cadastrarSubCategoria();
			break;
			
			case "total":
				rep.getLista();
				
			break;
			
			case "Carregar lista de moradores":
				gravarDoTxt();
			break;
			
			case "Calcular Divis�o":
				calcularDivisao();
			break;
			default:
				break;
			}
		} while (!((String)opcaoSelecionada).equals((String)opcoesPossiveis[6]));
	}

	
	


	public static boolean cadastrarSubCategoria() {
		
		String[] nomesCategoria = new String[rep.desp.size()];
		for (int i=0; i<rep.desp.size(); i++) {
			nomesCategoria[i] = rep.desp.get(i).getNomeCategoria();
		}
		String nomeCategoriaSelecionada = (String)JOptionPane.showInputDialog(null, 
				                                     "Escolha Categoria da Despesa", 
				                                     "Menu de Categorias", 
        				                             JOptionPane.INFORMATION_MESSAGE, 
		        		                             null, 
				                                     nomesCategoria, 
				                                     null);
		int indexCategoria = pesquisarCategoria(nomeCategoriaSelecionada);
		String nomeSubCat = JOptionPane.showInputDialog("Informe a nova Sub categoria:");
		return rep.addSubCategoria(nomeSubCat, indexCategoria);
	}


	/*private static boolean gravarNoTxt() {
		
	}*/


	public static boolean gravarDoTxt() {
		FileReader arquivo = null;
		BufferedReader buffer;
		boolean resposta; 
		String nomeArquivo = "moradores.txt";
		try {
			arquivo = new FileReader(nomeArquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		buffer = new BufferedReader(arquivo);
		String line = "";
		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		do {
			String[] campos = line.split(";");
			double renda = Double.parseDouble(campos[2]);
			Pessoa morador = new Pessoa(campos[0],campos[1],renda);
			resposta = rep.addPessoa(morador);
			
			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		} while (line != null);
		
		JOptionPane.showMessageDialog(null, "Moradores do Arquvio \"" + nomeArquivo + "\" Cadastrados com Sucesso!");
		return resposta;
	}
	
		


	public static boolean cadastrarCategoria() {
		String nomeCat = JOptionPane.showInputDialog("Informe a nova categoria:");
		rep.addCategoria(nomeCat);
		return true;
		
	}
	public static void cadastrarDespesas() {
		
		String[] nomesCategoria = new String[rep.desp.size()];
		for (int i=0; i<rep.desp.size(); i++) {
			nomesCategoria[i] = rep.desp.get(i).getNomeCategoria();
		}
		
		String nomeCategoriaSelecionada = (String)JOptionPane.showInputDialog(null, 
				                                     "Escolha Categoria da Despesa", 
				                                     "Menu de Categorias", 
        				                             JOptionPane.INFORMATION_MESSAGE, 
		        		                             null, 
				                                     nomesCategoria, 
				                                     null);
		
		int indexCategoria = pesquisarCategoria(nomeCategoriaSelecionada);
		
		
		
		String[] nomesSubCategoria = new String[rep.desp.get(indexCategoria).getSubSize()];
		for (int i=0; i<rep.desp.get(indexCategoria).getSubSize(); i++) {
			nomesSubCategoria[i] = rep.desp.get(indexCategoria).subs.get(i).getNomeSubCategoria();
		}
		
		String nomeSubCategoriaSelecionada = (String)JOptionPane.showInputDialog(null, 
				                                     "Escolha a SubCategoria da Despesa", 
				                                     "Menu de Categorias", 
        				                             JOptionPane.INFORMATION_MESSAGE, 
		        		                             null, 
				                                     nomesSubCategoria, 
				                                     null);
		
		int indexSubCategoria = pesquisarSubCategoria(nomeSubCategoriaSelecionada,indexCategoria );
		
		String ondeEsta = "(" +rep.desp.get(indexCategoria).getNomeCategoria() +"-> " +rep.desp.get(indexCategoria).subs.get(indexSubCategoria).getNomeSubCategoria()+")";
		String descricaoDespesa = JOptionPane.showInputDialog("Informe a descricao do gasto " +ondeEsta);
		Double valorDespesa =Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do gasto "+ ondeEsta));
		Despesa oi = new Despesa(descricaoDespesa,valorDespesa);
		rep.desp.get(indexCategoria).subs.get(indexSubCategoria).addDisp(oi);
	}



	public static int pesquisarCategoria(String nomedCategoria) {
		int resp = 0;
		for (int i=0; i<rep.desp.size(); i++) {
			if( rep.desp.get(i).getNomeCategoria().equals(nomedCategoria)) {
				 resp = i;
				
			}
		}
		return resp;
	}
	
	private static int pesquisarSubCategoria(String nomedaSubCategoria, int indexCat) {
		int resp = 0;
		for (int i=0; i<rep.desp.get(indexCat).getSubSize(); i++) {
			if( rep.desp.get(indexCat).subs.get(i).getNomeSubCategoria().equals(nomedaSubCategoria)) {
				 resp = i;
				
			}
		}
		return resp;
	}



	public static boolean cadastrarMorador() {
		String nomeMorador =(String) JOptionPane.showInputDialog(null, "Select the Port number for server creation", "Server Connection\n", JOptionPane.OK_CANCEL_OPTION, null, null, null);
		String emailMorador = JOptionPane.showInputDialog("Informe o e-mail do morador:");
		Double rendMorador = Double.parseDouble( JOptionPane.showInputDialog("Informe a renda do morador:"));
		Pessoa morador = new Pessoa(nomeMorador,emailMorador,rendMorador);
		rep.addPessoa(morador);
		return true;
	}
	
	private static boolean calcularDivisao() {
		String mensagem ="";
		Object[] ops = {"Normal",
		"Proporcional"};
		int escolhida = JOptionPane.showOptionDialog(null, "Qual tipo de media?", "Opcoes de m�dia", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, ops,ops[0] );
		double tot = rep.getTotalDespesas();
	
		//for(int i = 0; i<rep.getNumCategorias();i++ ) {
			//System.out.println(tot +" mais " + rep.desp.get(i).getTotalDespesas());
			//tot+=rep.desp.get(i).getTotalDespesas();
		//}
		
		if(escolhida == 0){
		
			double Valor = (tot/rep.getNumPessoas());
		
			for(int i = 0; i<rep.getNumPessoas();i++ ) {
				mensagem += (rep.pessoa.get(i).getNome() + " deve pagar " + Valor + "\n");
			}
			  
		}
		else {
			
			for(int i = 0; i<rep.getNumPessoas();i++ ) {
				double Valor;
				Valor = ((rep.pessoa.get(i).getRendimentoMensal()/rep.getTotalRendaMoradores()) * tot); 
				mensagem += (rep.pessoa.get(i).getNome() + " deve pagar " + Valor  + " Reais\n");
			}
		}
		JOptionPane.showMessageDialog(null, mensagem);
		return true;
	}

}
	


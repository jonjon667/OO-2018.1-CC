package Background;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Running.App;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class MenuP extends JFrame {
	String texto = "";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuP frame = new MenuP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuP() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(411, 112, 21, 48);
		contentPane.add(scrollBar);
		
		JButton btnNewButton = new JButton("Add Categoria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App.cadastrarCategoria();
			}
		});
		btnNewButton.setBounds(12, 76, 217, 65);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Add Subcategoria");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.cadastrarSubCategoria();
			}
		});
		btnNewButton_1.setBounds(12, 154, 217, 65);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add despesas");
		btnNewButton_2.setBounds(12, 232, 217, 65);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.cadastrarDespesas();
			}
		});
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Calcular Divis\u00E3o");
		btnNewButton_3.setBounds(12, 310, 217, 53);
		contentPane.add(btnNewButton_3);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(288, 154, 6, 22);
		contentPane.add(textPane_1);
		
		TextArea textArea = new TextArea();
		textArea.setText("            Moradores cadastrados \n");
		textArea.setEditable(false);
		textArea.setBounds(313, 20, 440, 343);
		contentPane.add(textArea);
		
		JButton btnAddMorador = new JButton("Add Morador");
		btnAddMorador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App.cadastrarMorador();
				int i=App.rep.getNumPessoas()-1;
				String t = App.rep.pessoa.get(i).getNome() + "\nEmail:" + App.rep.pessoa.get(i).getEmail() + "\nRenda:"
						+ App.rep.pessoa.get(i).getRendimentoMensal() + "\n////////////////////\n";
				texto += t;
				textArea.setText(texto);}
		});
		btnAddMorador.setBounds(12, 0, 217, 72);
		contentPane.add(btnAddMorador);
		
	}
	private void modPane(String string) {
		
	}
}


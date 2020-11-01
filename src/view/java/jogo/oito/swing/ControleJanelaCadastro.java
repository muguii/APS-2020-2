package jogo.oito.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jogo.oito.banco.BancoException;
import jogo.oito.dao.JogadorDao;
import jogo.oito.dao.implementacao.JogadorDaoJdbc;
import jogo.oito.entidade.Jogador;

public class ControleJanelaCadastro implements ActionListener {

	private JogadorDao jogadorDao;
	private JTextField textFieldNome;
	private JTextField textFieldLogin;
	private JPasswordField fieldSenha;
	
	public ControleJanelaCadastro(JTextField textFieldNome, JTextField textFieldLogin, JPasswordField fieldSenha) {
		this.textFieldNome = textFieldNome;
		this.textFieldLogin = textFieldLogin;
		this.fieldSenha = fieldSenha;
		jogadorDao = new JogadorDaoJdbc();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			String nome = textFieldNome.getText();
			String login = textFieldLogin.getText();
			String senha = String.valueOf(fieldSenha.getPassword());
			
			Jogador jogador = new Jogador(nome, login, senha);
			
			jogadorDao.inserir(jogador);
			
			fecharJanela(event);
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
			
		} 
		catch (BancoException exception) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao efetuar seu cadastro!", "Erro!", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
		}
	}
	
	private void fecharJanela(ActionEvent event) {
		JComponent source = (JComponent)event.getSource();
		Component root = SwingUtilities.getRoot(source);
		JFrame janelaCadastro = (JFrame)root;
		janelaCadastro.dispose();
	}

}

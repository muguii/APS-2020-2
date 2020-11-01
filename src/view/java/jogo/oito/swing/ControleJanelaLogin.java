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
import jogo.oito.dao.PartidaDao;
import jogo.oito.dao.implementacao.JogadorDaoJdbc;
import jogo.oito.dao.implementacao.PartidaDaoJdbc;
import jogo.oito.entidade.Jogador;
import jogo.oito.entidade.Partida;

public class ControleJanelaLogin implements ActionListener {

	private JogadorDao jogadorDao;
	private PartidaDao partidaDao;
	private JTextField textFieldLogin;
	private JPasswordField fieldSenha;
	
	public ControleJanelaLogin(JTextField textFieldLogin, JPasswordField fieldSenha) {
		this.textFieldLogin = textFieldLogin;
		this.fieldSenha = fieldSenha;
		jogadorDao = new JogadorDaoJdbc();
		partidaDao = new PartidaDaoJdbc();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String login = textFieldLogin.getText();
		Jogador jogador = jogadorDao.pesquisarJogador(login);
		
		if (autenticarJogador(jogador)) {
			Partida partida = new Partida(jogador);
			partidaDao.inserir(partida);
			new JanelaJogo(partida);
			fecharJanela(event);
		} else 
			JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
			
	}
	
	private boolean autenticarJogador(Jogador jogador) {
		try {
			String senha = String.valueOf(fieldSenha.getPassword());
			
			if (jogador == null)
				return false;
			else if (jogador.getSenha().equals(senha))
				return true;
			else
				return false;
			
		} 
		catch (BancoException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}

	private void fecharJanela(ActionEvent event) {
		JComponent source = (JComponent)event.getSource();
		Component root = SwingUtilities.getRoot(source);
		JFrame janelaCadastro = (JFrame)root;
		janelaCadastro.dispose();
	}
	
}

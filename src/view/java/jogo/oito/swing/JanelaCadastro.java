package jogo.oito.swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JanelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JLabel labelNome;
	private JLabel labelLogin;
	private JLabel labelSenha;
	private JTextField textFieldNome;
	private JTextField textFieldLogin;
	private JPasswordField fieldSenha;

	public JanelaCadastro() {
		configurarTela();
		montarTela();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void configurarTela() {
		setTitle("Cadastro - Jogo do 8");		
		setSize(380, 420);
		getContentPane().setLayout(null);
	}
	
	private void montarTela() {
		montarPanelPrincipal();
		montarLabels();
		montarFields();
		montarBotoes();
	}

	private void montarPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(20, 11, 330, 350);
		panelPrincipal.setLayout(null);
		
		getContentPane().add(panelPrincipal);
	}

	private void montarLabels() {
		labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setBounds(25, 110, 75, 15);
		
		labelLogin = new JLabel("Login:");
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLogin.setBounds(25, 140, 75, 15);
		
		labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSenha.setBounds(25, 170, 75, 15);
		
		panelPrincipal.add(labelNome);
		panelPrincipal.add(labelLogin);
		panelPrincipal.add(labelSenha);
	}

	private void montarFields() {
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 105, 145, 25);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(110, 135, 145, 25);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setBounds(110, 165, 145, 25);
		
		panelPrincipal.add(textFieldNome);
		panelPrincipal.add(textFieldLogin);
		panelPrincipal.add(fieldSenha);
	}

	private void montarBotoes() {
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(110, 200, 70, 25);
		botaoSalvar.addActionListener(new ControleJanelaCadastro(textFieldNome, textFieldLogin, fieldSenha));
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(185, 200, 70, 25);
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		panelPrincipal.add(botaoSalvar);
		panelPrincipal.add(botaoSair);
	}
}

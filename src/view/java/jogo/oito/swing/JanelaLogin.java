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

public class JanelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JTextField textFieldLogin;
	private JPasswordField fieldSenha;
	private JLabel labelLogin;
	private JLabel labelSenha;
	private JButton botaoLogar;
	private JButton botaoSair;
	private JButton botaoCadastrar;
	
	public JanelaLogin() {
		configurarTela();
		montarTela();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void configurarTela() {
		setTitle("Login - Jogo do 8");		
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
		labelLogin = new JLabel("Login:");
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLogin.setBounds(25, 85, 75, 15);
		
		labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSenha.setBounds(25, 116, 75, 15);
		
		panelPrincipal.add(labelLogin);
		panelPrincipal.add(labelSenha);
	}

	private void montarFields() {
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(110, 81, 145, 25);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setBounds(110, 112, 145, 25);
		
		panelPrincipal.add(textFieldLogin);
		panelPrincipal.add(fieldSenha);
	}

	private void montarBotoes() {
		botaoLogar = new JButton("Logar");
		botaoLogar.setBounds(110, 158, 70, 25);
		botaoLogar.addActionListener(new ControleJanelaLogin(textFieldLogin, fieldSenha));
		
		botaoSair = new JButton("Sair");
		botaoSair.setBounds(185, 158, 70, 25);
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(110, 188, 145, 25);
		botaoCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaCadastro();
			}
		});
		
		panelPrincipal.add(botaoLogar);
		panelPrincipal.add(botaoSair);
		panelPrincipal.add(botaoCadastrar);
	}
}

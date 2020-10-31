package jogo.oito.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InterfaceGrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelCimaEsquerda;
	private JLabel labelCima;
	private JLabel labelCimaDireita;
	private JLabel labelMeioEsquerda;
	private JLabel labelMeio;
	private JLabel labelMeioDireita;
	private JLabel labelBaixoEsquerda;
	private JLabel labelBaixo;
	private JLabel labelBaixoDireita;
	private JLabel labelMovimentos;
	private JLabel labelQuantidadeDeMovimentos;
	private JPanel panelPrincipal;
	private JPanel panelGrid;
	private JPanel panelBotoes;
	private JButton botaoCima;
	private JButton botaoEsquerda;
	private JButton botaoBaixo;
	private JButton botaoDireita;
	
	private ControleInterfaceGrafica controle;

	public InterfaceGrafica() {
		configurarJanela();
		montarTela();
		this.controle = new ControleInterfaceGrafica(panelGrid.getComponents(), labelQuantidadeDeMovimentos);
		setVisible(true);
		controle.iniciarJogo();
	}

	private void configurarJanela() {
		setTitle("Jogo Do Oito");		
		setSize(380, 420);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void montarTela() {
		montarPanels();
		montarLabels();
		montarBotoes();
	}

	private void montarPanels() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(20, 11, 330, 350);
		panelPrincipal.setLayout(null);
		
		panelGrid = new JPanel();
		panelGrid.setBackground(new Color(119, 136, 153));
		panelGrid.setBorder(new EmptyBorder(1,1,1,1));
		panelGrid.setBounds(15, 51, 300, 220);
		panelGrid.setLayout(new GridLayout(3, 3, 1, 1));
		
		panelBotoes = new JPanel();
		panelBotoes.setBounds(15, 280, 300, 58);
		panelBotoes.setLayout(null);
		
		getContentPane().add(panelPrincipal);
		panelPrincipal.add(panelGrid);
		panelPrincipal.add(panelBotoes);
	}

	private void montarLabels() {
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		labelCimaEsquerda = new JLabel();
		labelCimaEsquerda.setForeground(Color.BLACK);
		labelCimaEsquerda.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelCimaEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
		labelCimaEsquerda.setBorder(border);
		
		labelCima = new JLabel();
		labelCima.setForeground(Color.BLACK);
		labelCima.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelCima.setHorizontalAlignment(SwingConstants.CENTER);
		labelCima.setBorder(border);
		
		labelCimaDireita = new JLabel();
		labelCimaDireita.setForeground(Color.BLACK);
		labelCimaDireita.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelCimaDireita.setHorizontalAlignment(SwingConstants.CENTER);
		labelCimaDireita.setBorder(border);
		
		labelMeioEsquerda = new JLabel();
		labelMeioEsquerda.setForeground(Color.BLACK);
		labelMeioEsquerda.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelMeioEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
		labelMeioEsquerda.setBorder(border);
		
		labelMeio = new JLabel();
		labelMeio.setForeground(Color.BLACK);
		labelMeio.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelMeio.setHorizontalAlignment(SwingConstants.CENTER);
		labelMeio.setBorder(border);
		
		labelMeioDireita = new JLabel();
		labelMeioDireita.setForeground(Color.BLACK);
		labelMeioDireita.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelMeioDireita.setHorizontalAlignment(SwingConstants.CENTER);
		labelMeioDireita.setBorder(border);
		
		labelBaixoEsquerda = new JLabel();
		labelBaixoEsquerda.setForeground(Color.BLACK);
		labelBaixoEsquerda.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelBaixoEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
		labelBaixoEsquerda.setBorder(border);
		
		labelBaixo = new JLabel();
		labelBaixo.setForeground(Color.BLACK);
		labelBaixo.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelBaixo.setHorizontalAlignment(SwingConstants.CENTER);
		labelBaixo.setBorder(border);
		
		labelBaixoDireita = new JLabel();
		labelBaixoDireita.setForeground(Color.BLACK);
		labelBaixoDireita.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelBaixoDireita.setHorizontalAlignment(SwingConstants.CENTER);
		labelBaixoDireita.setBorder(border);
		
		labelMovimentos = new JLabel("Movimentos");
		labelMovimentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelMovimentos.setBounds(128, 5, 80, 25);
		
		labelQuantidadeDeMovimentos = new JLabel();
		labelQuantidadeDeMovimentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelQuantidadeDeMovimentos.setBounds(162, 28, 46, 14);
		
		panelGrid.add(labelCimaEsquerda);
		panelGrid.add(labelCima);
		panelGrid.add(labelCimaDireita);
		panelGrid.add(labelMeioEsquerda);
		panelGrid.add(labelMeio);
		panelGrid.add(labelMeioDireita);
		panelGrid.add(labelBaixoEsquerda);
		panelGrid.add(labelBaixo);
		panelGrid.add(labelBaixoDireita);
		panelPrincipal.add(labelMovimentos);
		panelPrincipal.add(labelQuantidadeDeMovimentos);
	}

	private void montarBotoes() {
		botaoCima = new JButton("CIMA");
		botaoCima.setBounds(100, 0, 98, 23);
		botaoCima.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.moverParaCima();
			}
			
		});
		
		botaoDireita = new JButton("DIREITA");
		botaoDireita.setBounds(200, 28, 98, 23);
		botaoDireita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.moverParaDireita();
			}
			
		});
		
		botaoBaixo = new JButton("BAIXO");
		botaoBaixo.setBounds(100, 28, 98, 23);
		botaoBaixo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.moverParaBaixo();
			}
			
		});
		
		botaoEsquerda = new JButton("ESQUERDA");
		botaoEsquerda.setBounds(0, 28, 98, 23);
		botaoEsquerda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.moverParaEsquerda();
			}
			
		});
		
		panelBotoes.add(botaoCima);
		panelBotoes.add(botaoDireita);
		panelBotoes.add(botaoBaixo);
		panelBotoes.add(botaoEsquerda);
	}
}

package br.com.nksoftware.estudo.game.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.nksoftware.estudo.Main;
import br.com.nksoftware.estudo.game.player.Player;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerSelect extends JFrame {


	private static final long serialVersionUID = 2724154179763658060L;
	private JPanel contentPane;
	private JTextField playerOneName;
	private JTextField PlayerOneSymbol;
	private JTextField PlayerTwoSymbol;
	private JTextField PlayerTwoName;

	public PlayerSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 255));
		panel.setBounds(0, 0, 561, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSelecionarJogadores = new JLabel("SELECIONAR JOGADORES");
		lblSelecionarJogadores.setForeground(new Color(255, 255, 255));
		lblSelecionarJogadores.setFont(new Font("Serif", Font.BOLD, 26));
		lblSelecionarJogadores.setBounds(111, 11, 337, 37);
		panel.add(lblSelecionarJogadores);
		
		playerOneName = new JTextField();
		playerOneName.setBounds(38, 136, 310, 20);
		contentPane.add(playerOneName);
		playerOneName.setColumns(10);
		
		PlayerOneSymbol = new JTextField();
		PlayerOneSymbol.setBounds(446, 136, 86, 20);
		contentPane.add(PlayerOneSymbol);
		PlayerOneSymbol.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(38, 114, 58, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblSmbolo = new JLabel("S\u00EDmbolo:");
		lblSmbolo.setBounds(445, 117, 58, 20);
		contentPane.add(lblSmbolo);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(38, 191, 58, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("S\u00EDmbolo:");
		label_1.setBounds(445, 194, 58, 20);
		contentPane.add(label_1);
		
		PlayerTwoSymbol = new JTextField();
		PlayerTwoSymbol.setColumns(10);
		PlayerTwoSymbol.setBounds(446, 213, 86, 20);
		contentPane.add(PlayerTwoSymbol);
		
		PlayerTwoName = new JTextField();
		PlayerTwoName.setColumns(10);
		PlayerTwoName.setBounds(38, 213, 310, 20);
		contentPane.add(PlayerTwoName);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player(playerOneName.getText(), PlayerOneSymbol.getText());
				Player playerTwo = new Player(PlayerTwoName.getText(), PlayerTwoSymbol.getText());
				Main.getGameManager().setPlayerOne(player);
				Main.getGameManager().setPlayerTwo(playerTwo);
				Main.getGameManager().setNextTime();
				setVisible(false);
				Main.openGameWindow();
			}
		});
		btnIniciar.setBackground(new Color(51, 102, 204));
		btnIniciar.setForeground(new Color(255, 255, 255));
		btnIniciar.setFont(new Font("SansSerif", Font.BOLD, 24));
		btnIniciar.setBounds(38, 258, 494, 41);
		contentPane.add(btnIniciar);
	}
}

package br.com.nksoftware.estudo.game.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.nksoftware.estudo.Main;
import br.com.nksoftware.estudo.game.block.Block;
import br.com.nksoftware.estudo.game.player.Player;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -5482054724277955231L;

	private JPanel contentPane;
	
	private JButton restartButton;
	private JLabel lblPlayerTime;
	private Block[] block;
	
	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(Color.BLACK);

		Block block0 = new Block(null);
		block0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block0);
			}
		});
		block0.setBounds(10, 11, 147, 89);
		contentPane.add(block0);

		Block block1 = new Block(null);
		block1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block1);
			}
		});
		block1.setBounds(167, 11, 147, 89);
		contentPane.add(block1);

		Block block2 = new Block(null);
		block2.setBounds(324, 11, 147, 89);
		block2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block2);
			}
		});
		contentPane.add(block2);

		Block block3 = new Block(null);
		block3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block3);
			}
		});
		block3.setBounds(10, 111, 147, 89);
		contentPane.add(block3);

		Block block4 = new Block(null);
		block4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block4);
			}
		});
		block4.setBounds(167, 111, 147, 89);
		contentPane.add(block4);

		Block block5 = new Block(null);
		block5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block5);
			}
		});
		block5.setBounds(324, 111, 147, 89);
		contentPane.add(block5);

		Block block6 = new Block(null);
		block6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block6);
			}
		});
		block6.setBounds(10, 211, 147, 89);
		contentPane.add(block6);

		Block block7 = new Block(null);
		block7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block7);
			}
		});
		block7.setBounds(167, 211, 147, 89);
		contentPane.add(block7);

		Block block8 = new Block(null);
		block8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().validateBlockClicked(block8);
			}
		});
		block8.setBounds(324, 211, 147, 89);
		contentPane.add(block8);

		this.block = new Block[9];
		this.block[0] = block0;
		this.block[1] = block1;
		this.block[2] = block2;
		this.block[3] = block3;
		this.block[4] = block4;
		this.block[5] = block5;
		this.block[6] = block6;
		this.block[7] = block7;
		this.block[8] = block8;

		lblPlayerTime = new JLabel("Vez do jogador: " + Main.getGameManager().getPlayerTime().getName());
		lblPlayerTime.setBounds(20, 314, 451, 14);
		contentPane.add(lblPlayerTime);
		
		restartButton = new JButton("REINICIAR");
		restartButton.setForeground(new Color(255, 255, 255));
		restartButton.setBackground(new Color(255, 0, 0));
		restartButton.setBounds(334, 310, 134, 18);
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGameManager().restartGame();
			}
		});
		
		construcWindow();

	}
	public void setPlayerTime(Player player) {
		setTextLabel("Vez do jogador: " + player.getName());
	}
	public void construcWindow() {
	}

	public Block[] getBlocks() {
		return this.block;
	}
	public void setTextLabel(String text) {
		lblPlayerTime.setText(text);
	}
	public JPanel getPanel() {
		return this.contentPane;
	}
	public JButton getRestartButton() {
		return this.restartButton;
	}
}

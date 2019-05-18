package br.com.nksoftware.estudo.game.block;

import javax.swing.JButton;

import br.com.nksoftware.estudo.game.player.Player;

public class Block extends JButton{

	private static final long serialVersionUID = 1L;
	
	private Player owner;
	
	public Block(Player owner) {
		this.owner = owner;
	}
	
	public Player getOwner() {
		return this.owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}

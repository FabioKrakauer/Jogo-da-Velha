package br.com.nksoftware.estudo.game;

import br.com.nksoftware.estudo.Main;
import br.com.nksoftware.estudo.game.block.Block;
import br.com.nksoftware.estudo.game.player.Player;

public class GameManager {
	
	private Player player_one;
	private Player player_two;
	
	private int playerTime;
	public GameManager() {
		playerTime = 0;
	}
	
	public void setPlayerOne(Player player) {
		this.player_one = player;
	}
	public void setPlayerTwo(Player player) {
		this.player_two = player;
	}
	
	public Player getPlayerOne() {
		return this.player_one;
	}
	
	public Player getPlayerTwo() {
		return this.player_two;
	}
	
	public Player getPlayerTime() {
		if(playerTime == 1) {
			return player_one;
		}else if(playerTime == 2) {
			return player_two;
		}
		return new Player("ERROR", "XXXXX");
	}
	
	public void setNextTime() {
		if(playerTime == 1) {
			playerTime = 2;
		}else if(playerTime == 2) {
			playerTime = 1;
		}else {
			playerTime = 1;
		}
		Main.gameWindow.setPlayerTime(getPlayerTime());
	}
	
	public void validateBlockClicked(Block block) {
		if(block.getOwner() == null) {
			block.setOwner(Main.getGameManager().getPlayerTime());
			block.setText(block.getOwner().getSymbol());
			Main.getGameManager().setNextTime();
			if(hasFinished()) {
				Main.gameWindow.getPanel().add(Main.gameWindow.getRestartButton());
				if(getWinner() == null) {
					Main.gameWindow.setTextLabel("##VELHA##");
				}else {
					Main.gameWindow.setTextLabel("VENCEDOR: " + getWinner().getName());
				}
			}
		}
	}
	
	public boolean checkWinner(Player player) {
		Block[] block = Main.gameWindow.getBlocks();
		if(block[0].getOwner() != null && block[1].getOwner() != null && block[2].getOwner() != null) {		
			if(block[0].getOwner().equals(player) && block[1].getOwner().equals(player) && block[2].getOwner().equals(player)) {
				return true;
			}
		}

		if(block[3].getOwner() != null && block[4].getOwner() != null && block[5].getOwner() != null) {		
			if(block[3].getOwner().equals(player) && block[4].getOwner().equals(player) && block[5].getOwner().equals(player)) {
				return true;
			}
		}

		if(block[6].getOwner() != null && block[7].getOwner() != null && block[8].getOwner() != null) {		
			if(block[6].getOwner().equals(player) && block[7].getOwner().equals(player) && block[8].getOwner().equals(player)) {
				return true;
			}
		}

		if(block[0].getOwner() != null && block[3].getOwner() != null && block[6].getOwner() != null) {		
			if(block[0].getOwner().equals(player) && block[3].getOwner().equals(player) && block[6].getOwner().equals(player)) {
				return true;
			}
		}

		if(block[1].getOwner() != null && block[4].getOwner() != null && block[7].getOwner() != null) {		
			if(block[1].getOwner().equals(player) && block[4].getOwner().equals(player) && block[7].getOwner().equals(player)) {
				return true;
			}
		}
	
		if(block[2].getOwner() != null && block[5].getOwner() != null && block[8].getOwner() != null) {		
			if(block[2].getOwner().equals(player) && block[5].getOwner().equals(player) && block[8].getOwner().equals(player)) {
				return true;
			}
		}
		if(block[0].getOwner() != null && block[4].getOwner() != null && block[8].getOwner() != null) {		
			if(block[0].getOwner().equals(player) && block[4].getOwner().equals(player) && block[8].getOwner().equals(player)) {
				return true;
			}
		}
		
		if(block[2].getOwner() != null && block[4].getOwner() != null && block[6].getOwner() != null) {		
			if(block[2].getOwner().equals(player) && block[4].getOwner().equals(player) && block[6].getOwner().equals(player)) {
				return true;
			}
		}
		return false;
	}
	public boolean allBlocksMarked() {
		for(Block block : Main.gameWindow.getBlocks()) {
			if(block.getOwner() == null) {
				return false;
			}
		}
		return true;
	}
	public boolean hasFinished() {
		if(checkWinner(getPlayerOne())) {
			return true;
		}
		if(checkWinner(getPlayerTwo())) {
			return true;
		}
		if(allBlocksMarked()) {
			return true;
		}
		return false;
	}
	public Player getWinner() {
		if(checkWinner(getPlayerOne())) {
			return getPlayerOne();
		}
		if(checkWinner(getPlayerTwo())) {
			return getPlayerTwo();
		}
		return null;
	}
	public void restartGame() {
		Main.gameWindow.getPanel().remove(Main.gameWindow.getRestartButton());
		setNextTime();
		Main.gameWindow.setTextLabel("Vez do jogador: " + getPlayerTime().getName());
		for(Block block : Main.gameWindow.getBlocks()) {
			block.setOwner(null);
			block.setText("");
		}
	}
}

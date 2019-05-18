package br.com.nksoftware.estudo;

import br.com.nksoftware.estudo.game.GameManager;
import br.com.nksoftware.estudo.game.gui.GameWindow;
import br.com.nksoftware.estudo.game.gui.PlayerSelect;

public class Main {
	
	public static GameWindow gameWindow;
	public static PlayerSelect playerSelect;
	public static GameManager gameManager;
	
	
	public static void main(String[] args) {
		gameManager = new GameManager();
		gameWindow = new GameWindow();
		playerSelect = new PlayerSelect();
		playerSelect.setVisible(true);
	}
	public static GameManager getGameManager() {
		return gameManager;
	}
	
	public static void openGameWindow() {
		gameWindow.setVisible(true);
	}
}

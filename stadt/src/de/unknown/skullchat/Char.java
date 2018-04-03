package de.unknown.skullchat;

public enum Char {
	
	BLOCK('█'), 
	DARK_SHADE('▓'), 
	MEDIUM_SHADE('▒'), 
	LIGHT_SHADE('░');
	
	private char c;
	
	private Char(char c) {this.c = c;}
	
	public char getChar() {
		return this.c;
	}
	
}

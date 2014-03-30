package fr.iutbm.horube.android_projet;

public class GtsParserSingleton {
	
	private static Shape instance = null;
	
	private GtsParserSingleton(){
		
	}
	
	public static Shape getInstance(){
		return instance;
	}
	
	public static void setInstance(Shape mod){
		instance = mod;
	}
}

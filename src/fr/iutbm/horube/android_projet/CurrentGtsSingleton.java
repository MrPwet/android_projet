package fr.iutbm.horube.android_projet;

public class CurrentGtsSingleton {
	
	private static GtsModele instance = null;
	
	private CurrentGtsSingleton(){
		
	}
	
	public static GtsModele getInstance(){
		return instance;
	}
	
	public static void setInstance(GtsModele mod){
		instance = mod;
	}
}

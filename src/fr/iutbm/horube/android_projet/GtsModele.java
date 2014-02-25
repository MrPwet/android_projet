package fr.iutbm.horube.android_projet;

public class GtsModele {
	String id;
	private String name;
	private String url;
	private int icon;
	private String path;
	
	public GtsModele(String id, String name, String url, int icon, String path) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.path = path;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	
}

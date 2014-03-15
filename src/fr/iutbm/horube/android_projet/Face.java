package fr.iutbm.horube.android_projet;

import java.util.List;
import java.util.ArrayList;

public class Face {
	List<Edge> edges;
	
	public Face(Edge e1, Edge e2, Edge e3) {
		this.edges = new ArrayList<Edge>();
		this.edges.add(e1);
		this.edges.add(e2);
		this.edges.add(e3);
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
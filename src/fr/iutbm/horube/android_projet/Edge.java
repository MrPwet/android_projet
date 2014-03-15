package fr.iutbm.horube.android_projet;

import java.util.ArrayList;
import java.util.List;

public class Edge {
	List<Vertex> vertex;

	public Edge(Vertex v1, Vertex v2) {
		this.vertex = new ArrayList<Vertex>();
		this.vertex.add(v1);
		this.vertex.add(v2);
	}

	public List<Vertex> getVertex() {
		return vertex;
	}

	public void setVertex(List<Vertex> vertex) {
		this.vertex = vertex;
	}
}
package fr.iutbm.horube.android_projet;

import java.util.List;

public class Shape {
	List<Vertex> vertex;
	List<Edge> edges;
	List<Face> faces;
	
	public Shape(List<Vertex> vertex, List<Edge> edges, List<Face> faces) {
		this.vertex = vertex;
		this.edges = edges;
		this.faces = faces;
	}

	public List<Vertex> getVertex() {
		return vertex;
	}

	public void setVertex(List<Vertex> vertex) {
		this.vertex = vertex;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public List<Face> getFaces() {
		return faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}
}

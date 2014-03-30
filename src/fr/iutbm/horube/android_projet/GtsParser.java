package fr.iutbm.horube.android_projet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class GtsParser {
	public static Shape parse(InputStream inputStream) {
		List<Vertex> lstVertex = new ArrayList<Vertex>();
		List<Edge> lstEdges = new ArrayList<Edge>();
		List<Face> lstFaces = new ArrayList<Face>();
		
		try {
			GZIPInputStream gzipStream = new GZIPInputStream(inputStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(gzipStream));
			String line;
			int nbVertex = 0, nbEdges = 0, nbFaces = 0;
			
			if((line = br.readLine()) != null) {
				String[] result = line.split(" ");
				nbVertex = Integer.parseInt(result[0]);
				nbEdges = Integer.parseInt(result[1]);
				nbFaces = Integer.parseInt(result[2]);
				
			}
			
			for(int i = 0 ; i < nbVertex ; i++) {
				line = br.readLine();
				String result[] = line.split(" ");
				Vertex temp = new Vertex();
				temp.setX(Float.parseFloat(result[0]));
				temp.setY(Float.parseFloat(result[1]));
				temp.setZ(Float.parseFloat(result[2]));
				lstVertex.add(temp);
			}
			
			for(int i = 0 ; i < nbEdges ; i++) {
				line = br.readLine();
				String result[] = line.split(" ");
				Vertex v1 = lstVertex.get(Integer.parseInt(result[0])-1);
				Vertex v2 = lstVertex.get(Integer.parseInt(result[1])-1);
				Edge temp = new Edge(v1,v2);
				lstEdges.add(temp);
			}
			
			for(int i = 0 ; i < nbFaces ;  i++) {
				line = br.readLine();
				String result[] = line.split(" ");
				Edge e1 = lstEdges.get(Integer.parseInt(result[0])-1);
				Edge e2 = lstEdges.get(Integer.parseInt(result[1])-1);
				Edge e3 = lstEdges.get(Integer.parseInt(result[2])-1);
				Face temp = new Face(e1, e2, e3);
				lstFaces.add(temp);
				
			}
			
			br.close();
			gzipStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Shape(lstVertex, lstEdges, lstFaces);
	}
	
	public static Shape parse(String filename){
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parse(fis);
		
	}
}

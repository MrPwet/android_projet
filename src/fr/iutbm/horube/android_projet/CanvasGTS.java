package fr.iutbm.horube.android_projet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class CanvasGTS extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder sh;
	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	Shape gts = GtsParserSingleton.getInstance();
		
	public CanvasGTS(Context context){
		super(context);
		sh = getHolder();
		sh.addCallback(this);
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.FILL);
	}

	
	public void surfaceCreated(SurfaceHolder holder) {
		Canvas canvas = sh.lockCanvas();
		canvas.drawColor(Color.WHITE);
		//canvas.drawCircle(200, 400, 50, paint);
		drawGTS(canvas, 100);
		sh.unlockCanvasAndPost(canvas);
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
		int height) {
		Canvas canvas = sh.lockCanvas();
		canvas.drawColor(Color.WHITE);
		//canvas.drawCircle(200, 400, 50, paint);
		drawGTS(canvas, 100);
		sh.unlockCanvasAndPost(canvas);
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	public void drawGTS(Canvas canvas, int zoom)
	{
		Point center = new Point((int)(getWidth()/2), (int)(getHeight()/2));
		List<Face> faces = gts.getFaces();
		for(Face f: faces)
		{
			List<Edge> fedges = f.getEdges();
			for(Edge fedge: fedges)
			{				
				canvas.drawLine(center.x + zoom*fedge.getVertex().get(0).getX(),
								center.y -zoom*fedge.getVertex().get(0).getY(),
								center.x + zoom*fedge.getVertex().get(1).getX(),
								center.y -zoom*fedge.getVertex().get(1).getY(),
								paint);
			}
		}
	}
	
	public void translateGTS(String direction, float valeur) {
		if(direction.equals("horizontal")) {
			List<Face> faces = gts.getFaces();
			for(Face f : faces) {
				List<Edge> fedges = f.getEdges();
				for(Edge fedge : fedges) {
					float x1 = fedge.getVertex().get(0).getX();
					float x2 = fedge.getVertex().get(1).getX();
					
					fedge.getVertex().get(0).setX(x1 + valeur);
					fedge.getVertex().get(1).setX(x2 + valeur);
				}
			}
		} 
		else {
			List<Face> faces = gts.getFaces();
			for(Face f : faces) {
				List<Edge> fedges = f.getEdges();
				for(Edge fedge : fedges) {
					float x1 = fedge.getVertex().get(0).getX();
					float x2 = fedge.getVertex().get(1).getX();
					
					fedge.getVertex().get(0).setX(x1 + valeur);
					fedge.getVertex().get(1).setX(x2 + valeur);
				}
			}
		}
	}
	
	public void rotateX(double angleDegree) {
		double angleRadian = Math.toRadians(angleDegree); 
		List<Face> faces = gts.getFaces();
		for(Face f : faces) {
			List<Edge> fedges = f.getEdges();
			for(Edge fedge : fedges) {
				List<Vertex> vertex = fedge.getVertex();
				for(Vertex v : vertex) {
					float oldX = v.getX();
					float oldY = v.getY();
					float oldZ = v.getZ();
					
					float x = oldX;
					float y = (float)(Math.cos(angleRadian) * oldY - Math.sin(angleRadian) * oldZ);
					float z = (float)(Math.sin(angleRadian) * oldY + Math.cos(angleRadian) * oldZ);
					
					v.setX(x);
					v.setY(y);
					v.setZ(z);
				}
			}
		}
	}
	
	public void rotateY(double angleDegree) {
		double angleRadian = Math.toRadians(angleDegree); 
		List<Face> faces = gts.getFaces();
		for(Face f : faces) {
			List<Edge> fedges = f.getEdges();
			for(Edge fedge : fedges) {
				List<Vertex> vertex = fedge.getVertex();
				for(Vertex v : vertex) {
					float oldX = v.getX();
					float oldY = v.getY();
					float oldZ = v.getZ();
					
					float x = (float)(Math.cos(angleRadian) * oldX + Math.sin(angleRadian) * oldZ);
					float y = oldY;
					float z = (float)(- Math.sin(angleRadian) * oldY + Math.cos(angleRadian) * oldZ);
					
					v.setX(x);
					v.setY(y);
					v.setZ(z);
				}
			}
		}
	}
	
	public void rotateZ(double angleDegree) {
		double angleRadian = Math.toRadians(angleDegree); 
		List<Face> faces = gts.getFaces();
		for(Face f : faces) {
			List<Edge> fedges = f.getEdges();
			for(Edge fedge : fedges) {
				List<Vertex> vertex = fedge.getVertex();
				for(Vertex v : vertex) {
					float oldX = v.getX();
					float oldY = v.getY();
					float oldZ = v.getZ();
					
					float x = (float)(Math.cos(angleRadian)* oldX - Math.sin(angleRadian) * oldY);
					float y = (float)(Math.sin(angleRadian) * oldX - Math.cos(angleRadian) * oldY);
					float z = oldZ;
					
					v.setX(x);
					v.setY(y);
					v.setZ(z);
				}
			}
		}
	}
	

}

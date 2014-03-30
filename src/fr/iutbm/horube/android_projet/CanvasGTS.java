package fr.iutbm.horube.android_projet;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class CanvasGTS extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder sh;
	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	Shape gts;
		
	public CanvasGTS(Context context) {
		super(context);
		/* POUR TESTER, METTRE UN FICHIER GTS DANS LE PATH CI DESSOUS */
		gts = GtsParser.parse("/storage/sdcard0/gtsmodel/file.gts.gz");
		sh = getHolder();
		sh.addCallback(this);
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.FILL);
	}
	
	public CanvasGTS(Context context, String file) {
		super(context);
		gts = GtsParser.parse(file);
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
}

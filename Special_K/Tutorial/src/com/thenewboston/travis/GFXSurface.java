package com.thenewboston.travis;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

	MyBringBackSurface ourSurfaceView;
	float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaledX, scaledY, cX, cY;
	Bitmap test, plus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ourSurfaceView = new MyBringBackSurface(this);
		// implement ontouch
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		dX = dY = aniX = aniY = scaledX = scaledY = cX = cY = 0;
		// declare and import bitmap
		test = BitmapFactory.decodeResource(getResources(), R.drawable.green);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.blue);
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	// called when surface is touched
	public boolean onTouch(View arg0, MotionEvent arg1) {
		x = arg1.getX();
		y = arg1.getY();

		switch (arg1.getAction()) {
		// when finger is pushed down
		case MotionEvent.ACTION_DOWN:
			sX = arg1.getX();
			sY = arg1.getY();
			dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
			break;
		// when finger is lifted up
		case MotionEvent.ACTION_UP:
			fX = arg1.getX();
			fY = arg1.getY();
			dX = fX - sX;
			dY = fY - sY;
			scaledX = dX / 30;
			scaledY = dY / 30;
			x = y = 0;
			break;
		}

		return true;
	}

	public class MyBringBackSurface extends SurfaceView implements Runnable {

		// declare variables
		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public MyBringBackSurface(Context context) {
			super(context);
			// define holder variable
			ourHolder = getHolder();
		}

		public void pause() {
			// stop the run while-loop when paused
			isRunning = false;
			while (true) {
				// try to let thread join
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			// set thread to null again
			ourThread = null;
		}

		// this runs when the activity starts
		public void resume() {
			// start the run while-loop when resumed
			isRunning = true;
			// create a new thread, use THIS run-method further below
			ourThread = new Thread(this);
			// start thread
			ourThread.start();
		}

		public void run() {
			while (isRunning) {
				// check if surface is valid
				if (!ourHolder.getSurface().isValid()) {
					// keep checking if-statement until valid
					continue;
				}
				// set up canvas and lock it for painting
				Canvas canvas = ourHolder.lockCanvas();
				// draw background color
				canvas.drawRGB(02, 02, 150);
				if (sX != 0 && sY != 0) {
					canvas.drawBitmap(plus, sX - (plus.getWidth() / 2), sY
							- (plus.getHeight() / 2), null);
				}
				if (x != 0 && y != 0) {
					canvas.drawBitmap(test, x - (test.getWidth() / 2), y
							- (test.getHeight() / 2), null);
				}
				if (fX != 0 && fY != 0) {
					canvas.drawBitmap(test, fX - (test.getWidth() / 2) - aniX,
							fY - (test.getHeight() / 2) - aniY, null);
					/* canvas.drawBitmap(plus, fX - (plus.getWidth() / 2), fY
							- (plus.getHeight() / 2), null); */
				}
				cX = fX - (test.getWidth() / 2) - aniX;
				cY = fY - (test.getHeight() / 2) - aniY;
				aniX = aniX + scaledX;
				aniY = aniY + scaledY;
				if (aniX < 0 && aniY < 0) {
					if (cX >= (sX - (test.getWidth() / 2))
							&& cY >= (sY - (test.getHeight() / 2))) {
						dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
					}
				}
				if (aniX < 0 && aniY >= 0) {
					if (cX >= (sX - (test.getWidth() / 2))
							&& cY < (sY - (test.getHeight() / 2))) {
						dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
					}
				}
				if (aniX >= 0 && aniY < 0) {
					if (cX < (sX - (test.getWidth() / 2))
							&& cY >= (sY - (test.getHeight() / 2))) {
						dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
					}
				}
				if (aniX >= 0 && aniY >= 0) {
					if (cX < (sX - (test.getWidth() / 2))
							&& cY < (sY - (test.getHeight() / 2))) {
						dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
					}
				}
				// unlock and display canvas
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

}

package com.thenewboston.travis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.graphics.Typeface;
import android.graphics.Paint.Align;

public class MyBringBack extends View {

	Bitmap gBall;
	float changingY;
	Typeface font;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.green);
		changingY = -(gBall.getHeight());
		font = Typeface.createFromAsset(context.getAssets(),
				"fonts/promisedfreedom.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		canvas.drawText("mybringback", canvas.getWidth() / 2, 200, textPaint);
		canvas.drawBitmap(gBall,
				((canvas.getWidth() / 2) - (gBall.getWidth() / 2)), changingY,
				null);
		if (changingY < canvas.getHeight()) {
			changingY += 10;
		} else {
			changingY = -(gBall.getHeight());
		}
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 500);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}

}

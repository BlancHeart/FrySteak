
package realobj;

import brain.Main;
import processing.core.*;

public class Furniture extends Kitchen{
	PImage bb, cb, frame, picA, picB;

	final int PicSize = 190000;
	int currDist, tempDist, i, aColor, bColor;
	
	public Furniture(Main p){
		pen = p;
		try {
			bb = pen.loadImage("../media/image/blackboard.jpg");
			cb = pen.loadImage("../media/image/board.png");
			frame = pen.loadImage("../media/image/frame.png");
			picA = pen.loadImage("../media/image/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg");
			//https://www.google.com/culturalinstitute/asset-viewer/the-starry-night/bgEuwDxel93-Pg?utm_source=google&utm_medium=kp&hl=en&projectId=art-projec
			picB = pen.loadImage("../media/image/Starry_Night_Over_the_Rhone.jpg");
			//http://en.wikipedia.org/wiki/Starry_Night_Over_the_Rhone#mediaviewer/File:Starry_Night_Over_the_Rhone.jpg
		} catch (NullPointerException e) {
			PApplet.println("There is something wrong with your image file");
		}
		currDist = 1;
	}
	
	/**
	 * Copy Constructor
	 */
	@Override
	public void drawMe() {
		// TODO Auto-generated method stub
		pen.line(pen.width*0.9f, pen.height*0.67f, 0, pen.height*0.67f);
		pen.line(pen.width*0.9f, pen.height*0.67f, pen.width*0.9f, 0);
		pen.line(pen.width*0.9f, pen.height*0.67f, pen.width, pen.height);
		
		pen.pushMatrix();
		pen.scale(pen.ScaleN);
		drawCarbinet();
		pen.popMatrix();
		
		pen.pushMatrix();
		pen.translate(30*pen.ScaleN, 170*pen.ScaleN);
		pen.scale(pen.ScaleN, pen.ScaleN/2f);
		drawStove();
		pen.popMatrix();
		
		pen.pushMatrix();
		pen.translate(460*pen.ScaleN, 200*pen.ScaleN);
		pen.scale(pen.ScaleN*0.25f);
		drawChopB();
		pen.popMatrix();
		
		pen.pushMatrix();
		pen.translate(360*pen.ScaleN, 75*pen.ScaleN);
		pen.scale(pen.ScaleN*0.25f);
		drawPic();
		pen.popMatrix();
		
		pen.pushMatrix();
		pen.translate(500*pen.ScaleN, 75*pen.ScaleN);
		pen.scale(pen.ScaleN*0.18f);
		drawBlackB();
		pen.popMatrix();
	}
	
	private void drawCarbinet(){
		pen.fill(100);
		pen.rect(30, 10, 240, 115);
		pen.fill(192);
		pen.rect(35, 15, 230, 50);
		pen.rect(35, 70, 230 , 50);
		pen.noStroke();
		pen.fill(128);
		pen.rect(38, 15.5f, 220, 35);
		pen.rect(38, 70.5f, 220, 30);
		pen.stroke(0);
		pen.line(38, 50.5f, 35, 65);
		pen.line(258, 50.5f, 265, 65);
		pen.line(38, 100.5f, 35, 120);
		pen.line(258, 100.5f, 265, 120);
	}
	
	private void drawStove(){
		pen.fill(128);
		pen.pushMatrix();
		pen.translate(0, 5);
		pen.stroke(64);
		for(int i = 0; i < 10; i++)
		{
			pen.quad(-10, -10, 480, -10, 480+260*0.2f, 250, -10+260*0.2f, 250);
			pen.translate(0, -0.5f);
		}
		pen.stroke(0);
		pen.popMatrix();
		pen.fill(0);
		pen.quad(0, 0, 240, 0, 240+240*0.2f, 240, 240*0.2f, 240);
	}
	
	private void drawPic(){
		if(currDist < 16777215 )
		{
			for(int i = 0; i < PicSize; i++)
			{

				int tempDist = PApplet.abs(picA.pixels[i]-picB.pixels[i]);
				if(tempDist > 0)
				{
					if(tempDist  < currDist)
						picA.set(i%475, i/475, picB.pixels[i]);
//						picA.pixels[i] = picB.pixels[i];
				}
			}
			currDist += 5355;
		}
		pen.image(picA, 0, 0);
		pen.image(frame, 0, 0);
	}
	
	private void drawChopB(){
		pen.image(cb, 0, 0);
	}
	
	private void drawBlackB(){
		pen.image(bb, 0, 0);
	}

}

package realobj;
import brain.Main;
import processing.core.*;

public class Pan extends KitchenDecorator{
PImage img;
	public Pan(Kitchen s, Main p) {
		super(s, p);
		// TODO Auto-generated constructor stub
		try {
			img = pen.loadImage("../media/image/pan1.png");
		} catch (NullPointerException e) {
			PApplet.println("There is something wrong with your image file");
		}
	}
	
	public void drawMe(){
		super.drawMe();
		
		pen.pushMatrix();
		pen.translate(143*pen.ScaleN, 228*pen.ScaleN);
		pen.scale(pen.ScaleN);
		drawPan();
		pen.popMatrix();
	}
	
	private void drawPan(){
		pen.scale(0.25f,0.25f);
		pen.image(img, 0, 0);
	}
	

}

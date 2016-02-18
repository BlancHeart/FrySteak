package realobj;
import brain.Main;
import processing.core.*;

public class Plate extends KitchenDecorator{
PImage img;
	public Plate(Kitchen s, Main p) {
		super(s, p);
		// TODO Auto-generated constructor stub
		try {
			img = pen.loadImage("../media/image/plate.png");
		} catch (NullPointerException e) {
			PApplet.println("There is something wrong with your image file");
		}
	}
	
	public void drawMe(){
		super.drawMe();
		
		pen.pushMatrix();
		if(pen.plateC)
		{
			if(PApplet.abs(pen.mouseX-174*pen.ScaleN)<80*pen.ScaleN && PApplet.abs(pen.mouseY-208*pen.ScaleN)<45*pen.ScaleN)
			{
				pen.translate((174+56)*pen.ScaleN, (200-30)*pen.ScaleN);
				pen.scale(pen.ScaleN*0.4f, pen.ScaleN*0.3f);
				drawPan();
			}
			else
			{
				pen.translate(pen.mouseX, pen.mouseY);
				pen.scale(pen.ScaleN*0.4f, pen.ScaleN*0.3f);
				drawPan();
			}
		}
		else
		{
			if(pen.plateB)
			{
				pen.translate(380*pen.ScaleN, 250*pen.ScaleN);
				pen.scale(pen.ScaleN*0.8f, pen.ScaleN*0.8f);
				drawPan();
			}
			else
			{
				pen.translate(200*pen.ScaleN, 50*pen.ScaleN);
				pen.scale(pen.ScaleN*0.4f, pen.ScaleN*0.3f);
				drawPan();
			}
		}
		pen.popMatrix();
	}
	
	private void drawPan(){
		pen.scale(0.25f,0.25f);
		pen.image(img, 0, 0);
	}

}
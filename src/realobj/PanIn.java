package realobj;
import brain.Main;
import processing.core.*;

public class PanIn extends KitchenDecorator{
PImage img;
	public PanIn(Kitchen s, Main p) {
		super(s, p);
		// TODO Auto-generated constructor stub
		try {
			img = pen.loadImage("../media/image/pan2.png");
		} catch (NullPointerException e) {
			PApplet.println("There is something wrong with your image file");
		}
	}
	
	public void drawMe(){
		super.drawMe();
		
		pen.pushMatrix();
		if(pen.panInC)
		{
			pen.translate(pen.mouseX, pen.mouseY);
		}
		else
		{
			pen.translate(120*pen.ScaleN, 100*pen.ScaleN);
		}
		pen.scale(pen.ScaleN*0.4f, pen.ScaleN*0.3f);
		drawPan();
		pen.popMatrix();
	}
	
	private void drawPan(){
		pen.scale(0.5f,0.5f);
		pen.image(img, 0, 0);
	}

}

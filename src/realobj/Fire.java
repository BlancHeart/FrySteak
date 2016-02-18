package realobj;
import brain.Main;
import processing.core.*;
public class Fire extends KitchenDecorator{

	public Fire(Kitchen s, Main p) {
		super(s, p);
		// TODO Auto-generated constructor stub
	}
	
	public void drawMe(){
		super.drawMe();
		pen.pushMatrix();
		pen.strokeWeight(2);
		pen.translate((30+240*0.6f)*pen.ScaleN, (170+240*0.25f)*pen.ScaleN);
		pen.scale(pen.ScaleN, pen.ScaleN*0.5f);
		drawElecFire(40, 120, pen.fireTemp);
		pen.strokeWeight(1);
		pen.popMatrix();
	}
	
	private void drawElecFire(int a, int b, float temp){
		if(temp > 20)
		{
			pen.noFill();
			pen.stroke(255,0,0);
			pen.rotate(temp/10.0f);
			float d = a+b*((temp-20.001f)%60)/60;
			pen.ellipse(0, 0, d, d);
			
			pen.pushMatrix();
			pen.translate(0,-0.25f*(a+b));
			drawElecFire(a/2, b/2, temp-60);
			pen.popMatrix();
			
			pen.pushMatrix();
			pen.rotate(pen.PI*2/3);
			pen.translate(0,-0.25f*(a+b));
			drawElecFire(a/2, b/2, temp-60);
			pen.popMatrix();
			
			pen.pushMatrix();
			pen.rotate(pen.PI*4/3);
			pen.translate(0,-0.25f*(a+b));
			drawElecFire(a/2, b/2, temp-60);
			pen.popMatrix();	
		}
		
	}
	

}

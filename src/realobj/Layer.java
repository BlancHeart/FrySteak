/**
 * 
 */
package realobj;
import brain.Main;
import func.*;
/**
 * @author KEY
 * Represent each layer in a steak.
 *
 */
public class Layer {
	Steak pen;
	public double temp;
	double maxTemp;
	int color;
	final float[] Shape = {2, 19.8997f, 8, 18.3303f, 12, 16, 16, 12, 18, 8.7178f, 19, 6.2450f};
	Lshape s;

	public Layer(Steak p){
		pen = p;
		temp = 20;
		maxTemp = 20;
		color = Cook.tempTOcolor(maxTemp);
		s = new Lshape(pen.p);

	}
	
	public void drawDown(int i){
		pen.p.pushMatrix();
		
		pen.p.stroke(pen.l.get(1).color-1052688);
		pen.p.fill(color);
		
		pen.p.beginShape();
		pen.p.curveVertex(-10, 20);
		
		pen.p.curveVertex(0+s.getS(i, 0), 20+s.getS(i, 1));
		
		for(int j = 0; j < Shape.length; j += 2)
			pen.p.curveVertex(Shape[j]+s.getS(i, 2+j), Shape[j+1]+s.getS(i, 3+j));
		
		pen.p.curveVertex(20+s.getS(i, 14), 0+s.getS(i, 15));
		
		for(int j = Shape.length - 2; j > 0; j -= 2)
			pen.p.curveVertex(Shape[j]+s.getS(i, 16+j), -Shape[j+1]+s.getS(i, 17+j));
		
		for(int j = 0; j < Shape.length; j += 2)
			pen.p.curveVertex(-Shape[j]+s.getS(i, 28+j), -Shape[j+1]+s.getS(i, 29+j));
		
		pen.p.curveVertex(-20+s.getS(i, 40), 0+s.getS(i, 41));
		
		for(int j = Shape.length - 2; j > 0; j -= 2)
			pen.p.curveVertex(-Shape[j]+s.getS(i, 42+j), Shape[j+1]+s.getS(i, 43+j));
		
		pen.p.curveVertex(0+s.getS(i, 0), 20+s.getS(i, 1));
		
		pen.p.curveVertex(10, 20);
		pen.p.endShape();
		
		pen.p.popMatrix();
	}
	
	public void drawSide(int i){
		pen.p.pushMatrix();
		
		pen.p.stroke(color);
		pen.p.line(-20+s.getS(i, 40), 0, 20+s.getS(i, 14), 0);
		
		pen.p.popMatrix();
	}
	public void update(double r1, double r2){
		temp += r1 - r2;
		if(temp > maxTemp)
			maxTemp = temp;
		color = Cook.tempTOcolor(maxTemp);
	}
	
	public void update(){
		if(temp > maxTemp)
			maxTemp = temp;
		color = Cook.tempTOcolor(maxTemp);	
	}
}

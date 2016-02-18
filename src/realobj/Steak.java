/**
 * 
 */
package realobj;
import java.util.ArrayList;

import brain.Main;
import controlP5.ControlEvent;
import processing.core.PApplet;
/**
 * @author KEY
 * Describe the look and attribute of steak,
 *  such as how will it change when it cooked.
 *
 */
public class Steak {
	final int LayerNum = 20;
	final float ScaleS;
	Main p;
	public ArrayList<Layer> l;
	ArrayList<Boundary> b;
	public boolean headORtail;
	
	/**
	 * constructor
	 */
	public Steak(Main p){
		this.p = p;
		ScaleS = p.ScaleN*1.0f;
		l = new ArrayList<Layer>();
		for(int i = 0; i < LayerNum; i ++)
		{
			l.add(new Layer(this));
		}
		b = new ArrayList<Boundary>();
		for(int i = 0; i < LayerNum-1; i ++)
		{
			b.add(new Boundary());
		}
		
		headORtail = true;
	}
	
	public void drawDown(){
		p.scale(ScaleS);
		p.pushMatrix();

		if(headORtail)
			for(int i = 0; i < l.size(); i++)
			{
				p.translate(0, -1);
				l.get(i).drawDown(i);
			}
		else
			for(int i = l.size()-1; i >= 0; i--)
			{
				p.translate(0, -1);
				l.get(i).drawDown(i);
			}
		
		p.popMatrix();
			
	}
	
	public void drawSide(){
		p.scale(2.5f*ScaleS);
		
		p.pushMatrix();
		p.strokeWeight(1.5f);
		if(headORtail)
			for(int i = 0; i < l.size(); i++)
			{
				p.translate(0, -1);
				l.get(i).drawSide(i);
			}
		else
			for(int i = l.size()-1; i >= 0; i--)
			{
				p.translate(0, -1);
				l.get(i).drawSide(i);
			}
		p.strokeWeight(1);
		p.popMatrix();
	}
	
	public void update(){
		
		for(int i = 0; i< b.size(); i++)
		{
			b.get(i).update(l.get(i), l.get(i+1));
		}
		for(int i = 1; i < l.size()-1; i++)
		{
			l.get(i).update(b.get(i-1).getRate(), b.get(i).getRate());
		}
		l.get(0).update();
		l.get(l.size()-1).update();
	}
}

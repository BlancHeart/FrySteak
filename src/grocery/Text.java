package grocery;
import brain.Main;
import processing.core.PApplet;
import processing.core.PFont;

public class Text {
	Main p;
	PFont Font;
	
	public Text(Main p)
	{
		this.p = p;
		Font = p.createFont("Calibri", 24, false);
	}
	
	public void ini(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Practise Cooking Steak!", p.width*0.5f, p.height*0.5f);
		p.popMatrix();
	}
	
	public void step1(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Turn on the fire", 500*p.ScaleN, 75*p.ScaleN);
		p.popMatrix();
	}
	
	public void step2(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Pan on", 500*p.ScaleN, 75*p.ScaleN);
		p.popMatrix();
	}
	
	public void step3(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Steak in", 500*p.ScaleN, 75*p.ScaleN);
		p.popMatrix();
	}
	
	public void step4(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Adjust the fire", 500*p.ScaleN, 40*p.ScaleN);
		p.text("temperature and", 500*p.ScaleN, 50*p.ScaleN);
		p.text("right click to", 500*p.ScaleN, 60*p.ScaleN);
		p.text("turn over the steak", 500*p.ScaleN, 70*p.ScaleN);
		p.text("based on your", 500*p.ScaleN, 80*p.ScaleN);
		p.text("own experience.", 500*p.ScaleN, 90*p.ScaleN);
		p.text("Turn off the fire", 500*p.ScaleN, 110*p.ScaleN);
		p.text("if you've done.", 500*p.ScaleN, 120*p.ScaleN);
		p.popMatrix();
	}
	
	public void step5(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Put the plate", 500*p.ScaleN, 70*p.ScaleN);
		p.text("on countertop", 500*p.ScaleN, 80*p.ScaleN);
		p.popMatrix();
	}
	
	public void step6(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("Move the steak", 500*p.ScaleN, 70*p.ScaleN);
		p.text("onto the plate", 500*p.ScaleN, 80*p.ScaleN);
		p.popMatrix();
	}
	
	public void step7(){
		p.pushMatrix();
		p.textFont(Font);
		p.textAlign(p.CENTER);
		p.fill(255);
		p.text("cut the steak", 500*p.ScaleN, 60*p.ScaleN);
		p.text("in half to check", 500*p.ScaleN, 70*p.ScaleN);
		p.text("the downess", 500*p.ScaleN, 80*p.ScaleN);
		p.text("by right clicking", 500*p.ScaleN, 90*p.ScaleN);
		p.popMatrix();
	}
}

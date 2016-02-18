
package brain;
import processing.core.*;
import ddf.minim.*;

import java.util.ArrayList;

import controlP5.*;
import func.*;
import grocery.Text;
import realobj.*;
/**
 * @author Ke Yang
 * 
 *
 */
public class Main extends PApplet{
	public int ScaleN; //control whole scale. e.g. 1080p ScaleN = 3
	Steak pfs; //pan fried steak
	Kitchen stuff;
	Creator c;
	ControlP5 ctrl;
	Knob k;
	Text t;
	Button b1, b2;
	Minim m;
	AudioPlayer bgm, fryS;
	
	public float fireTemp;
	boolean initiate;
//	--------------------------------------
//	A initiate
//	B display
// 	C movable
//	D disappear
//	--------------------------------------
	boolean fireA, fireD;
	public boolean panInC, panInD;
	boolean panA;
	boolean steakB1, steakB2, steakC, steakD;
	public boolean plateB, plateC;
	
	PImage img;
	
	/**
	 * Initiation 
	 */
	public void setup(){
		ScaleN = 2;
		size(640*ScaleN, 360*ScaleN);
		smooth();
		imageMode(CENTER);
		background(0);
		
		pfs = new Steak(this);
		ctrl = new ControlP5(this);
		
		k = ctrl.addKnob("fire", 0, 200, 0, 160*ScaleN, 300*ScaleN, 100);
		k.setStartAngle(5*PI/6);
		k.setAngleRange(4*PI/3);
		ctrl.getController("fire").hide();
		
		t = new Text(this);
		
		b1 = ctrl.addButton("Start", 0, (int)(width*0.5-20), (int)(height*0.1-10), 40, 20);
		b1.setColorCaptionLabel(color(255));
		b1.setColorBackground(color(0));
		ctrl.getController("Start").hide();
		
		b2 = ctrl.addButton("Restart", 0, (360-50)*ScaleN, (75-40)*ScaleN, 100*ScaleN, 80*ScaleN);
		b2.setColorCaptionLabel(color(0));
		b2.setColorBackground(color(255, 128));
		ctrl.getController("Restart").hide();
		
		m = new Minim(this);
		try{
			bgm = m.loadFile("../media/sound/Bach_Loop.mp3", 4192);
			fryS = m.loadFile("../media/sound/fry.mp3", 2048);
			
			bgm.loop();
		}
		catch(Exception e)
		{
			println("lol, check again");
		}
		
		stuff = null;
		c = new Creator(this);
		stuff = c.creatStuff(0, stuff);
		stuff = c.creatStuff(1, stuff);
		stuff = c.creatStuff(2, stuff);
		
		initiate = true;
		fireA = false; fireD = false;
		panInC = false; panInD = false;
		panA = false;
		steakB1 = false; steakB2 = false; steakC = false; steakD = false;
		plateB = false; plateC = false;
	}
	
	/**
	 * Updating
	 */
	public void draw(){
		
		if(initiate)
		{
			t.ini();
			ctrl.getController("Start").show();
		}
		else
		{
			stroke(0);
			fill(255);
			rect(0,0,width,height);
			
			stuff.drawMe();
			
			if(!fireA&&!fireD)
				t.step1();
			if(fireA&&!panInD)
				t.step2();
			if(panA&&!steakB1&&!fireD)
				t.step3();
			if(steakB1&&!fireD)
				t.step4();
			if(fireD&&!plateB)
				t.step5();
			if(plateB&&!steakB2)
				t.step6();
			if(steakB2&&!steakD)
				t.step7();
	
			if(!steakD)
			{
				if(steakC)
				{
					pushMatrix();
					translate(mouseX, mouseY);
					scale(ScaleN, ScaleN/2);
					pfs.drawDown();
					popMatrix();
				}
				else
				{
					if(steakB1)
					{
						pushMatrix();
						translate(174*ScaleN, 215*ScaleN);
						scale(ScaleN, ScaleN/2);
						pfs.drawDown();
						popMatrix();
						pfs.update();
						
					}
					else
					{
						if(steakB2)
						{
							pushMatrix();
							translate(380*ScaleN, 250*ScaleN);
							scale(ScaleN, ScaleN/2);
							pfs.drawDown();
							popMatrix();
						}
						else
						{
							pushMatrix();
							translate(460*ScaleN, 200*ScaleN);
							scale(ScaleN, ScaleN/2);
							pfs.drawDown();
							popMatrix();
						}
					}
				}
			}
			else
			{
				stuff = c.creatStuff(0, null);
				
				pushMatrix();		
				translate(width*0.5f,height*0.67f);
				scale(ScaleN, ScaleN);
				pfs.drawSide();
				popMatrix();
				
				ctrl.getController("Restart").show();
			}
		}
	}
	
	
	public void controlEvent(ControlEvent e){
		if(e.getName() == "fire")
		{	
			fireTemp = e.getController().getValue();	
			
			if(!fireA && !fireD && fireTemp>20)
			{
				fireA = true;
				stuff = c.creatStuff(2, c.creatStuff(3, stuff.getLast()));
			}
			if(steakB1&&fireA&&fireTemp<10)
			{
				fireA = false;
				fireD = true;
				stuff = c.creatStuff(1, c.creatStuff(4, stuff.getLast().getLast().getLast()));
				ctrl.getController("fire").hide();
			}
			
			if(pfs.headORtail)
			{
				pfs.l.get(0).temp = fireTemp;
				pfs.l.get(pfs.l.size()-1).temp = 20;
			}
			else
			{
				pfs.l.get(pfs.l.size()-1).temp = fireTemp;
				pfs.l.get(0).temp = 20;
			}
		}
		
		if (e.getController().getName() == "Start")
		{
			initiate = false;
			ctrl.getController("Start").hide();
			ctrl.getController("fire").show();
		}
		
		if (e.getController().getName() == "Restart")
		{
			reset();
		}
	}
	
	
	public void mousePressed(){
		if(mouseButton == LEFT)
		{
			if(fireA&&!panInD&&dist(mouseX, mouseY, 120*ScaleN, 100*ScaleN)<40*ScaleN)
			{
				panInC = true;
			}
			
			if(!steakD && (!steakB1 && panA && dist(mouseX, mouseY, 460*ScaleN, 200*ScaleN)<60*ScaleN) || (!steakB2 && plateB && dist(mouseX, mouseY, 143*ScaleN, 228*ScaleN)<60*ScaleN))
			{
				steakC = true;
				steakB1 = false;
			}
			if(fireD && !plateB && dist(mouseX, mouseY, 200*ScaleN, 50*ScaleN)<40*ScaleN)
			{
				plateC = true;
			}
		}
	}
	
	public void mouseReleased(){
		if(mouseButton == LEFT)
		{
			if(panInC)
			{
				if(dist(mouseX, mouseY, 143*ScaleN, 228*ScaleN)<60*ScaleN)
				{

					panInD = true;
					stuff = c.creatStuff(4, stuff.getLast());
					panA = true;
				}
				panInC = false;
			}
			
			if(steakC)
			{
				if(fireA && dist(mouseX, mouseY, 143*ScaleN, 228*ScaleN)<60*ScaleN)
				{
					steakB1 = true;
					fryS.rewind();
					fryS.play();
				}
				else
					if(fireD)
					{
						if(dist(mouseX, mouseY, 380*ScaleN, 250*ScaleN)<60*ScaleN)
						{
							steakB2 = true;
							steakB1 = false;
						}
						else
							steakB1 = true;
					}
				steakC = false;
			}
			
			if(plateC)
			{
				if(dist(mouseX, mouseY, 380*ScaleN, 250*ScaleN)<75*ScaleN)
				{
					plateB = true;
				}
				plateC = false;
			}
			
		}
	}
	
	public void mouseClicked(){
		if(mouseButton == RIGHT)
		{
			if(steakB1 && fireA && dist(mouseX, mouseY, 180*ScaleN, 210*ScaleN)<40*ScaleN)
			{
				pfs.headORtail=!pfs.headORtail;
				double tp = pfs.l.get(0).temp;
				pfs.l.get(0).temp = pfs.l.get(pfs.l.size()-1).temp;
				pfs.l.get(pfs.l.size()-1).temp = tp;
				
				fryS.rewind();
				fryS.play();
			}
			
			if(dist(mouseX, mouseY, 380*ScaleN, 250*ScaleN)<60*ScaleN)
			{
				steakD = true;
			}
		}
	}
	
	private void reset(){
		ctrl.getController("Restart").hide();
		ctrl.getController("fire").show();
		
		background(0);
		
		pfs = new Steak(this);
		
		stuff = c.creatStuff(0, stuff);
		stuff = c.creatStuff(1, stuff);
		stuff = c.creatStuff(2, stuff);
		
		fireA = false; fireD = false;
		panInC = false; panInD = false;
		panA = false;
		steakB1 = false; steakB2 = false; steakC = false; steakD = false;
		plateB = false; plateC = false;
	}
}

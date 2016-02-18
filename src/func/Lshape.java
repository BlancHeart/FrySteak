package func;
import brain.Main;
import processing.core.*;
import realobj.Steak;
public class Lshape {
	Main pen;
	final int LayerNum = 20;
	final int R = 3; // Perlin Noise Radius
	final float[][] s = new float[LayerNum][54];
	
	public Lshape(Main p){
		pen = p;
		for(int j = 0; j < 54; j++)
			for(int i = 0; i < LayerNum; i++)
				s[i][j] = R*pen.noise((j+0.075f*i))-R/2;
	}
	
	public float getS(int i, int j)
	{
		return s[i][j];
	}
}

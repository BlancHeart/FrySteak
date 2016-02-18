package func;

import realobj.Steak;

public class Cook{
	
	static int[] colorArr = {-8838124, -6869478, -6342099, -5748164, -5483434, -4957626, -5088962, -5678787, -6202819, -7122893, -8503517};
	
	private Cook(){
	}

	public static int tempTOcolor(double t){
		int c;
		if(t < 30)
			c = colorArr[0];
		else if(t < 40)
			c = colorArr[1];
		else if(t < 50)
			c = colorArr[2];
		else if(t < 60)
			c = colorArr[3];
		else if(t < 70)
			c = colorArr[4];
		else if(t < 80)
			c = colorArr[5];
		else if(t < 100)
			c = colorArr[6];
		else if(t < 120)
			c = colorArr[7];
		else if(t < 150)
			c = colorArr[8];
		else if(t < 180)
			c = colorArr[9];
		else
			c = colorArr[10];
		return c;
	}
	
}

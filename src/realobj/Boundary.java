package realobj;

public class Boundary {
	final int MPT = 200;//Max Pan Temp
	final double p = 2*2700*1000*0.0025*0.0025; // desity 
	final float F = 2;//depends on CPU frequency, Better CPU use smaller number
	double rate;
	
	public Boundary(){
		rate = 0;
	}
	
	public void update(Layer l1, Layer l2){
		double k1 = 0.08 + 0.52 * (1- l1.maxTemp/MPT);	// Sweat(1975) k = 0.080 + 0.52W W = water content
		double k2 = 0.08 + 0.52 * (1- l2.maxTemp/MPT);	// Suppose W = 1 - maxTemp of steak / MPT, the higher the temp the lower water contained.
		rate = (k1+k2)*(l1.temp - l2.temp)/p*F;
	}
	
	public double getRate(){
		return rate;
	}

}

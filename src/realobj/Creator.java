package realobj;

import brain.Main;

public class Creator {
	Main pen;
	public Creator(Main p){
		pen = p;
	}
	
	public Kitchen creatStuff(int i, Kitchen stuff){
		Kitchen k = null;
		switch(i){
		case 0:
			k = new Furniture(pen);
			break;
		case 1:
			k = new Plate(stuff, pen);
			break;
		case 2:
			k = new PanIn(stuff, pen);
			break;
		case 3:
			k = new Fire(stuff, pen);
			break;
		case 4:
			k = new Pan(stuff, pen);
			break;
		}
		return k;
	}
}

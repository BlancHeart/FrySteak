package realobj;
import brain.Main;
public class KitchenDecorator extends Kitchen{
	
	public KitchenDecorator(Kitchen s, Main p){
		stuff = s;
		pen = p;
	}
	
	public void drawMe(){
		stuff.drawMe();
	}
}

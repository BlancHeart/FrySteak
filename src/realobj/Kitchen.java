package realobj;

import brain.Main;

abstract public class Kitchen {
	public Kitchen stuff;
	Main pen;

	public abstract void drawMe();
	public Kitchen getLast()
	{
		return stuff;
	}
}

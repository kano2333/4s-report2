package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Dot extends Figure implements Serializable{
	int size;
	Dot(){
		size=50;
	}
	@Override public void paint(Graphics g) {
		g.setColor(color);
		g.drawOval(x-size/2,y-size/2,size,size);
		
	}
}
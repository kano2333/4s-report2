package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Dot2 extends Figure implements Serializable{
	int size;
	Dot2(){
		size=50;
	}
	@Override public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x-size/2,y-size/2,size,size);
		
	}
}
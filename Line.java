package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Line extends Figure implements Serializable{
	Line(){}
	@Override public void paint(Graphics g) {
		g.setColor(color);
		g.drawLine(x,y,x+w,y+h);
		
	}
}
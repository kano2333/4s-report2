package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Circle extends Figure implements Serializable{
	Circle(){}
	@Override public void paint(Graphics g){
		int r=(int)Math.sqrt((double)(w*w+h*h));
		g.setColor(color);
		g.drawOval(x-r,y-r,r*2,r*2);
		
	}
}
package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Circle2 extends Figure implements Serializable{
	Circle2(){}
	@Override public void paint(Graphics g){
		int r=(int)Math.sqrt((double)(w*w+h*h));
		g.setColor(color);
		g.fillOval(x-r,y-r,r*2,r*2);
		
	}
}
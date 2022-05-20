package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Ellipse2 extends Figure implements Serializable{
	Ellipse2(){}
	@Override public void paint(Graphics g) {
		g.setColor(color);
		if(w>0&&h>0)g.fillOval(x-(int)(1.41421356*w),y-(int)(1.41421356*h),(int)(2*1.41421356*w),(int)(2*1.41421356*h));
		else if(w<0&&h>0)g.fillOval(x-(int)(1.41421356*w),y-(int)(1.41421356*h),(int)(2*1.41421356*(-w)),(int)(2*1.41421356*h));
		else if(w>0&&h<0)g.fillOval(x-(int)(1.41421356*w),y-(int)(1.41421356*h),(int)(2*1.41421356*w),(int)(2*1.41421356*(-h)));
		else if(w<0&&h<0)g.fillOval(x-(int)(1.41421356*w),y-(int)(1.41421356*h),(int)(2*1.41421356*(-w)),(int)(2*1.41421356*(-h)));
	}
}
package report2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

class Polygon extends Figure implements Serializable{
	Polygon(){}
	@Override public void paint(Graphics g){
	    Graphics2D g2 = (Graphics2D)g;
	    g2.setColor(color);
	    int[] xpoints = {x,x+w/2,x+w,x+w,x+w/2,x};
	    int[] ypoints = {y,y-h/2,y,y+h,y+(int)(1.5*h),y+h};
	    g2.drawPolygon(xpoints,ypoints,6);
	}
}
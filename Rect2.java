package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Rect2 extends Figure implements Serializable{
	Rect2(){}
	@Override public void paint(Graphics g) {
		g.setColor(color);
		if(w>0&&h>0) g.fillRect(x,y,w,h);
		else if(w<0&&h>0)g.fillRect(x+w,y,-w,h);
		else if(w>0&&h<0)g.fillRect(x,y+h,w,-h);
		else if(w<0&&h<0)g.fillRect(x+w,y+h,-w,-h);
	}
}
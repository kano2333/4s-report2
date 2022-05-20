package report2;

import java.awt.Graphics;
import java.io.Serializable;

class Rect extends Figure implements Serializable{
	Rect(){}
	@Override public void paint(Graphics g) {
		g.setColor(color);
		if(w>0&&h>0) g.drawRect(x,y,w,h);
		else if(w<0&&h>0)g.drawRect(x+w,y,-w,h);
		else if(w>0&&h<0)g.drawRect(x,y+h,w,-h);
		else if(w<0&&h<0)g.drawRect(x+w,y+h,-w,-h);
	}
}
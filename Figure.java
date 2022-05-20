package report2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

class Figure extends Coord implements Serializable{
	Color color;
	int w,h;
	Figure(){
		w=h=0;
	}
	public void paint(Graphics g) {
	}
	public void setWH(int w,int h) {
		this.w=w;
		this.h=h;
	}
}
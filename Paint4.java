package report2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


class Paint4 extends Frame implements MouseListener,MouseMotionListener,ActionListener{
	int x,y;
	ArrayList<Figure>objList;
	ArrayList<Figure>saveList;
	CheckboxGroup cbg;
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
	CheckboxGroup co;
	Checkbox co1,co2,co3,co4,co5;
	Button remove,get,all,save,read,end;
	int mode=0;
	Figure obj;
	
	public static void main(String[] args) {
		Paint4 f=new Paint4();
		f.setSize(640,480);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
		}});
		f.setVisible(true);
		
		if(args.length==1)f.load(args[0]);
	}
	Paint4(){
		objList=new ArrayList<Figure>();
		saveList=new ArrayList<Figure>();
		
		setLayout(null);
		cbg=new CheckboxGroup();
		co=new CheckboxGroup();
		c1=new Checkbox("丸",cbg,true);
		c1.setBounds(480,30,60,30);
		add(c1);
		c2=new Checkbox("円",cbg,false);
		c2.setBounds(480,60,60,30);
		add(c2);
		c3=new Checkbox("四角",cbg,false);
		c3.setBounds(480,90,60,30);
		add(c3);
		c4=new Checkbox("線",cbg,false);
		c4.setBounds(480,120,60,30);
		add(c4);
		c5=new Checkbox("楕円",cbg,false);
		c5.setBounds(480,150,60,30);
		add(c5);
		c6=new Checkbox("六角形",cbg,false);
		c6.setBounds(480,180,60,30);
		add(c6);
		c7=new Checkbox("塗丸",cbg,false);
		c7.setBounds(560,30,60,30);
		add(c7);
		c8=new Checkbox("塗円",cbg,false);
		c8.setBounds(560,60,60,30);
		add(c8);
		c9=new Checkbox("塗四角",cbg,false);
		c9.setBounds(560,90,60,30);
		add(c9);
		c10=new Checkbox("塗楕円",cbg,false);
		c10.setBounds(560,150,60,30);
		add(c10);
		c11=new Checkbox("塗六角形",cbg,false);
		c11.setBounds(560,180,60,30);
		add(c11);
		
		co1=new Checkbox("赤色",co,true);
		co1.setBounds(400,30,60,30);
		add(co1);
		co2=new Checkbox("黄色",co,false);
		co2.setBounds(400,60,60,30);
		add(co2);
		co3=new Checkbox("緑色",co,false);
		co3.setBounds(400,90,60,30);
		add(co3);
		co4=new Checkbox("青色",co,false);
		co4.setBounds(400,120,60,30);
		add(co4);
		co5=new Checkbox("カラフル",co,false);
		co5.setBounds(400,150,60,30);
		add(co5);
		
		remove=new Button("削除");
		remove.setBounds(210,420,60,30);
		add(remove);
		get=new Button("復元");
		get.setBounds(280,420,60,30);
		add(get);
		all=new Button("全削除");
		all.setBounds(350,420,60,30);
		add(all);
		save=new Button("保存");
		save.setBounds(420,420,60,30);
		add(save);
		read=new Button("読込");
		read.setBounds(490,420,60,30);
		add(read);
		end=new Button("終了");
		end.setBounds(560,420,60,30);
		add(end);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		remove.addActionListener(this);
		get.addActionListener(this);
		all.addActionListener(this);
		save.addActionListener(this);
		read.addActionListener(this);
		end.addActionListener(this);
	}
	
	public void save(String fname) {
		try {
			FileOutputStream fos=new FileOutputStream(fname);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(objList);
			oos.close();
			fos.close();
		}catch(IOException e) {
		}
	}
	@SuppressWarnings("unchecked")
	public void load(String fname) {
		try {
			FileInputStream fis=new FileInputStream(fname);
			ObjectInputStream ois=new ObjectInputStream(fis);
			objList=(ArrayList<Figure>)ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
		}catch(ClassNotFoundException e) {
		}
		repaint();
	}
	
	@Override public void paint(Graphics g) {
		Figure f;
		for(int i=0;i<objList.size();i++) {
			f=(Figure)objList.get(i);
			f.paint(g);
		}
		if(mode>=1)obj.paint(g);
	}
	public void clear(){
		objList.clear();
		repaint();
	}
	public void undo() {
		if(objList.size()>0) {
			saveList.add(objList.get(objList.size()-1));
			objList.remove(objList.size()-1);
			repaint();
		}
	}
	public void redo() {
		if(saveList.size()>0) {
			objList.add(saveList.get(saveList.size()-1));
			saveList.remove(saveList.size()-1);
			repaint();
		}
	}
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="削除") undo();
		else if(e.getActionCommand()=="復元")redo();
		else if(e.getActionCommand()=="全削除") clear();
		else if(e.getActionCommand()=="保存") save("paint.dat");
		else if(e.getActionCommand()=="読込") load("paint.dat");
		else if(e.getActionCommand()=="終了") System.exit(0);
	}
	@Override public void mousePressed(MouseEvent e) {
		Checkbox c,d;
		x=e.getX();
		y=e.getY();
		c=cbg.getSelectedCheckbox();
		d=co.getSelectedCheckbox();
		obj=null;
		if(c==c1) {
			mode=1;
			obj=new Dot();
		}else if(c==c2) {
			mode=2;
			obj=new Circle();
		}else if(c==c3) {
			mode=2;
			obj=new Rect();
		}else if(c==c4) {
			mode=2;
			obj=new Line();
		}else if(c==c5) {
			mode=2;
			obj=new Ellipse();
		}else if(c==c6) {
			mode=2;
			obj=new Polygon();
		}else if(c==c7) {
			mode=2;
			obj=new Dot2();
		}else if(c==c8) {
			mode=2;
			obj=new Circle2();
		}else if(c==c9) {
			mode=2;
			obj=new Rect2();
		}else if(c==c10) {
			mode=2;
			obj=new Ellipse2();
		}else if(c==c11) {
			mode=2;
			obj=new Polygon2();
		}
		if(d==co1) {
			obj.color=Color.red;
		}else if(d==co2) {
			obj.color=Color.yellow;
		}else if(d==co3) {
			obj.color=Color.green;
		}else if(d==co4) {
			obj.color=Color.blue;
		}else if(d==co5) {
			int R=(int)(Math.random()*256);
			int G=(int)(Math.random()*256);
			int B=(int)(Math.random()*256);
			obj.color=new Color(R,G,B);
		}
		if(obj!=null) {
			obj.moveto(x, y);
			repaint();
		}
	}
	@Override public void mouseReleased(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if(mode==1)obj.moveto(x, y);
		else if(mode==2)obj.setWH(x-obj.x, y-obj.y);
		if(mode>=1) {
			objList.add(obj);
			obj=null;
		}
		mode=0;
		repaint();
	}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if(mode==1) {
			obj.moveto(x, y);
		}else if(mode==2) {
			obj.setWH(x-obj.x, y-obj.y);
		}
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}
}
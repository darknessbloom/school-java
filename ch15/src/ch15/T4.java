package ch15;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class T4 extends JFrame{
	T4(){
		setTitle("난수 알파벳");
		
		showalpa();
		setSize(300,200);
		setVisible(true);
	}
	void showalpa() {
		Random r =new Random();
		JPanel p= new JPanel();
		p.setLayout(null);

		JLabel a= new JLabel("a");
		JLabel b= new JLabel("b");
		JLabel c= new JLabel("c");
		JLabel d= new JLabel("d");
		JLabel e= new JLabel("e");
		JLabel f= new JLabel("f");
		JLabel g= new JLabel("g");
		JLabel h= new JLabel("h");
		JLabel i= new JLabel("i");
		JLabel j= new JLabel("j");
		a.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		b.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		c.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		d.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		e.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		f.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		g.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		h.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		i.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		j.setBounds(r.nextInt(270),r.nextInt(130),10,10);
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		p.add(f);
		p.add(g);
		p.add(h);
		p.add(i);
		p.add(j);
		p.setSize(270,130);
		add(p);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T4();

	}

}

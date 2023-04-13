package ch15;
import java.awt.*;
import javax.swing.*;

public class T6 extends JFrame{
	T6(){
		Container con = getContentPane();
		setTitle("박스 레이아웃");
		setLayout(new BoxLayout(con, BoxLayout.X_AXIS));
		JButton b1=new JButton("버튼1");
		JButton b2=new JButton("버튼2");
		JButton b3=new JButton("버튼3");
		JButton b4=new JButton("버튼4");
		JButton b5=new JButton("버튼5");
		con.add(b1);
		con.add(b2);
		con.add(b3);
		con.add(b4);
		con.add(b5);
		setSize(350,200);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T6();

	}

}

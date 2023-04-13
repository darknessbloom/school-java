package ch15;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class T7 extends JFrame {
	T7(){
		setTitle("카드 레이아웃");
		setLayout(new BorderLayout());
		setSize(300,500);
		showpoint();
		showcard();
		setVisible(true);
		
	}
	void showpoint() {
		JPanel p= new JPanel();
		p.setLayout(new GridLayout(1,0,10,10));
		JButton b1 =new JButton("<<");
		JButton b2 =new JButton("<");
		JButton b3 =new JButton(">");
		JButton b4 =new JButton(">>");
		p.add(b1);p.add(b2);
		p.add(b3);p.add(b4);
		add(p,BorderLayout.NORTH);
	}
	void showcard() {
		
		JButton b1 =new JButton("버튼1");
		JButton b2 =new JButton("버튼2");
		JButton b3 =new JButton("버튼3");
		JButton b4 =new JButton("버튼4");
		JButton b5 =new JButton("버튼5");
	
		add(b1,BorderLayout.CENTER);
		add(b2,BorderLayout.CENTER);
		add(b3,BorderLayout.CENTER);
		add(b4,BorderLayout.CENTER);
		add(b5,BorderLayout.CENTER);
		
	}
	CardLayout layout;
	public void roate() {
		while (true) {
			try {
				Thread.sleep(500);
				
			}catch(Exception e) {
				
			}
			layout.next(this.getContentPane());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T7().roate();

	}

}

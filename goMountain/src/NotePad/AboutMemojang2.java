package NotePad;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class AboutMemojang2 extends JDialog {
	
	public AboutMemojang2(Frame owner) {
		super(owner,"메모장정보",true);//modal (true) modaless(false)
		this.setSize(700,700);
		JPanel b= new JPanel();
		b.setBounds(10, 10, 600, 600);
		JButton b1= new JButton("이건버튼");
		JLabel l1= new JLabel();
		JLabel l2= new JLabel("제이라벨 \n 제이라벨");
		ImageIcon m1= new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jsk_icon.png")));
		l1.setIcon(m1);
		l1.setBounds(20,20,100,100);
		b.add(l1);
		b.add(b1);
		b.add(l2);
		this.add(b);
		this.setVisible(true);
		
	}

}

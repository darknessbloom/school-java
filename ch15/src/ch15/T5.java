package ch15;
import java.awt.*;
import javax.swing.*;
public class T5 extends JFrame {
	T5(){
		setTitle("애완 동물");
		setSize(300,200);
		setLayout(new FlowLayout());
		showradio();
		setVisible(true);
	}
	void showradio() {
		
		ButtonGroup b=new ButtonGroup();
		JRadioButton puppy=new JRadioButton("강아지");
		JRadioButton cat=new JRadioButton("고양이");
		JRadioButton fish=new JRadioButton("금붕어");
		b.add(puppy);b.add(cat);b.add(fish);
		add(puppy);add(cat);add(fish);
		puppy.setSelected(true);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T5();

	}

}

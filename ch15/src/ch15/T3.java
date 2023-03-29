package ch15;
import java.awt.*;
import javax.swing.*;
public class T3 extends JFrame{
	T3(){
		setTitle("색상 선택기");
		setLayout(new BorderLayout());
		setSize(300,150);
		showcombo();
		showcheck();
		showchoose();
		setResizable(false);
		setVisible(true);
	}
	void showcombo() {
		JPanel p =new JPanel();
		String [] color= {"빨간색","파란색","초록색"};
		JComboBox<String> cb= new JComboBox<>(color);
		p.add(cb);
		add(p,BorderLayout.NORTH);
	}

	void showcheck() {
		JPanel p=new JPanel();
		JCheckBox bg=new JCheckBox("배경색");
		JCheckBox fg=new JCheckBox("전경색");
		p.add(bg);p.add(fg);
		add(p,BorderLayout.CENTER);
		
	}
	void showchoose() {
		JPanel p=new JPanel();
		JButton yes =new JButton("예");
		JButton no =new JButton("아니오");
		p.add(yes);p.add(no);
		add(p,BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T3();

	}

}

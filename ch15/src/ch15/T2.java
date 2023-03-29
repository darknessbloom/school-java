package ch15;
//섭씨 온도를 화씨 온도로 변환 시키는 프로그램
import java.awt.*;
import javax.swing.*;
public class T2 extends JFrame {
	T2(){
		setTitle("섭씨->화씨");
		setSize(300,150);
		setLayout(new BorderLayout());
		showcenter();
		showsouth();
		setResizable(false);
		setVisible(true);
		
	}
	void showcenter(){
		JPanel board=new JPanel();
		JPanel cboard =new JPanel();
		JLabel c= new JLabel("섭씨");
		JTextField ec=new JTextField(20);
		cboard.add(c);cboard.add(ec);
		JPanel fboard=new JPanel();
		JLabel f= new JLabel("화씨");
		JTextField ef=new JTextField(20);
		fboard.add(f);fboard.add(ef);
		board.add(cboard);board.add(fboard);
		add(board,BorderLayout.CENTER);
	}
	void showsouth() {
		JPanel p=new JPanel();
		JButton re=new JButton("변환");
		p.add(re);
		add(p,BorderLayout.SOUTH);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T2();

	}

}

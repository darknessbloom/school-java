import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class playSwing extends JFrame {
	//JFrame 배치 방식은 BorderLayout 방식(동서남북센터, 기본:센터)
	JTextField tf= new JTextField(10);
	public playSwing() {
		this.setTitle("first gui");
		this.setSize(500,500);
		this.setLocation(500, 300);//음수 좌표 없음.
		this.setVisible(true);
		this.setLayout(new FlowLayout());//맨위줄, 중앙에 차례로 배치
		JPanel p1 =new JPanel();//배치방식 flowLayout
		JPanel p2 =new JPanel();
		JPanel p3 =new JPanel();
		
		p1.add(tf);
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.YELLOW);
		JButton bt1= new JButton("전화번호");
		JButton bt2= new JButton("검색");
		JButton bt3= new JButton("수정");
		JButton bt4= new JButton("삭제");
		JButton bt5= new JButton("알수없음");
		
		p2.add(bt1);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);
		p2.add(bt5);
		this.add(p1);this.add(p2);this.add(p3);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new playSwing();//new 생성자;
		
		

	}

}

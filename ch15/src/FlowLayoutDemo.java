import java.awt.*;
import javax.swing.*;
public class FlowLayoutDemo extends JFrame{
	public FlowLayoutDemo() {
		// TODO Auto-generated constructor stub
		setTitle("플로우 레이아웃!");
		JPanel p=new JPanel(new FlowLayout());//JPanel의 기본 배치 방식이 flowlayout이므로 생략할수 있다.
		p.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);//패널의 컴포넌트를 오른쪽에서 왼쪽으로 배치한다.
		JButton b1=new JButton("B1");
		JButton b2=new JButton("버튼 2");
		JButton b3=new JButton("Button 3");
		JButton b4=new JButton("Button Four");
		p.add(b1);//4개의 버튼을 패널에 부착함
		p.add(b2);
		p.add(b3);
		p.add(b4);
		add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlowLayoutDemo();

	}

}

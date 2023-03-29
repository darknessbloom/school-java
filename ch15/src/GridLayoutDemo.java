import java.awt.*;
import javax.swing.*;
public class GridLayoutDemo extends JFrame {
	GridLayoutDemo() {
		// TODO Auto-generated constructor stub
		setTitle("그리드 레이아웃!");
		setLayout(new GridLayout(0,3));//3개의 열로 구성된 그리드레이아웃으로 설정함.
		add(new JButton("B1"));
		add(new JButton("버튼 2"));
		add(new JButton("Button 3"));
		add(new JButton("Button Four"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,110);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutDemo();

	}

}

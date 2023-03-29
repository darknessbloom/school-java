import java.awt.*;
import javax.swing.*;
public class BorderLayoutDemo extends JFrame{
	BorderLayoutDemo() {
		// TODO Auto-generated constructor stub
		setTitle("보더레이아웃!");
		setLayout(new BorderLayout());
		//프레임의 레이아웃을 보더레이아웃으로 설정한다. 프레임의 기본 방식이므로 생략가능함
		add("East",new JButton("동"));
		add("West",new JButton("서"));
		add("South",new JButton("남"));
		add(new JButton("북"),BorderLayout.NORTH);
		add(new JButton("중앙"),BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutDemo();

	}

}

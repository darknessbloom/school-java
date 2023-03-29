import java.awt.*;
import javax.swing.*;
public class MakeCalculate extends JFrame {
	MakeCalculate() {
		// TODO Auto-generated constructor stub
		setTitle("계산기");
		setLayout(new BorderLayout(10,10)); //전체 가장 큰 틀을 보더레이아웃으로
		showNorth();//맨위 텍스트 입력필드
		showCenter();//계산기 버튼 부분
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,300);
		setResizable(false);
		setVisible(true);
	}
	void showNorth() {
		JPanel panel = new JPanel();
		JTextField f= new JTextField(20);//수식 입력하는 텍스트 필드
		panel.add(f,BorderLayout.CENTER);
		add(panel,BorderLayout.NORTH);
	}
	void showCenter() {
		JPanel panel= new JPanel();
		JPanel b0 =new JPanel();
		JButton on =new JButton("on");
		JButton off =new JButton("off");
		b0.add(on);b0.add(off);
		
		JPanel b1 =new JPanel();//버튼 첫번째
		JButton seven= new JButton("7");
		JButton eight= new JButton("8");
		JButton nine= new JButton("9");
		JButton plus= new JButton("+");
		b1.add(seven); b1.add(eight); b1.add(nine); b1.add(plus);
		JPanel b2 =new JPanel();
		JButton four= new JButton("4");
		JButton five= new JButton("5");
		JButton six= new JButton("6");
		JButton minus= new JButton("-");
		b2.add(four); b2.add(five); b2.add(six); b2.add(minus);
		JPanel b3 =new JPanel();
		JButton one= new JButton("1");
		JButton two= new JButton("2");
		JButton three= new JButton("3");
		JButton mul= new JButton("*");
		b3.add(one);b3.add(two);b3.add(three);b3.add(mul);
		JPanel b4 =new JPanel();
		JButton zero= new JButton("0");
		JButton dot= new JButton(".");
		JButton equl= new JButton("=");
		JButton divide= new JButton("÷");
		b4.add(zero);b4.add(dot);b4.add(equl);b4.add(divide);
		panel.add(b0);panel.add(b1);
		panel.add(b2);panel.add(b3);panel.add(b4);
		add(panel,BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MakeCalculate();

	}

}

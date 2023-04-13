import java.awt.*;
import javax.swing.*;
public class ComponentDemo extends JFrame {
	ComponentDemo() {
		// TODO Auto-generated constructor stub
		setTitle("원 넓이 구하기");
		setLayout(new BorderLayout(10,10));//BorderLayout방식으로 배치하며, 수평수직 간ㅋ격을 10픽셀로 설정
		showNorth();showCenter();showSouth();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,220);
		setVisible(true);
	}
	void showNorth() {//레이블과 텍스트 필드 배치
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel panel =new JPanel(new GridLayout(2,0));//패널 행이 2개인 GridLayout방식으로 설정함.
		JLabel l1=new JLabel("원의 반지름");
		JLabel l2=new JLabel("원의 넓이");//2개의 레이블을 생성
		
		//2개의 텍스트 필드를 생성 두번째 텍스트 필드는 입력할 수 없도록 설정
		JTextField t1= new JTextField(10);
		JTextField t2= new JTextField(10);
		t2.setEnabled(false);//입력불가능하게 설정
		p1.add(l1); p1.add(t1);
		p2.add(l2); p2.add(t2);
		
		panel.add(p1);
		panel.add(p2);
		add(panel,BorderLayout.NORTH);
		
		
	}
	void showCenter() {
		JPanel panel =new JPanel();
		
		//30행 20열의 텍스트 영역을 준비한 수 텍스트 영역을 문자열로 채움.
		JTextArea area=new JTextArea(30,20);
		area.setText("이영역에 원의 넓이를\n 계산하는 과정이 나타납니다");
		
		//텍스트 영역에 입력할 수 없도록 설정하고 텍스트 영역의 문자열을 빨간색으로 설정
		area.setEditable(false);
		area.setForeground(Color.RED);
		panel.add(area);
		add(panel,BorderLayout.CENTER);
	}
	void showSouth() {
		String[] color= {"red","blue"}; //콬보박스에 추가할 문자열
		//수평 수직 간격이 10픽셀인 FlowLayout 방식의 패널을 생성함.
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JButton cal= new JButton("계산");
		JComboBox <String> cb=new JComboBox<>(color);
		JButton reset= new JButton("리셋");
		
		panel.add(cal);panel.add(cb); panel.add(reset);
		add(panel,BorderLayout.SOUTH);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComponentDemo();

	}

}

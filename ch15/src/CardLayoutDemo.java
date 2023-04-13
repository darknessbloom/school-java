import java.awt.*;
import javax.swing.*;
public class CardLayoutDemo extends JFrame {
	CardLayout layout; //생성자와  rotate()메서드에서 사용하려고 멤버변수로 선언
	public void rotate() {
		// cardLayout을 이용해 컨테이너에 쌓여있는 컴포넌트를 0,5초마다 하나씩 넘긴다음 다음 컴포넌트로 이동
		while(true) {
			try {
				Thread.sleep(500);
				
			}catch(Exception e) {
				
			}
			layout.next(this.getContentPane());
		}
	
	}
	CardLayoutDemo(){
		setTitle("카드 레이아웃!");//프레임의 배치 관리자를 카드레이아웃으로 설정
		layout =new CardLayout();
		setLayout(layout);
		add(new JButton("버튼 0"));
		add(new JButton("버튼 1"));
		add(new JButton("버튼 2"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CardLayoutDemo().rotate();//애플리케이션 객체를 설정해 rotate메서드를 실행

	}

}

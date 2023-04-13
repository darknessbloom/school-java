//종료할수 있는 프레임 애플리케이션
import javax.swing.*;
public class JFrame3Demo extends JFrame {
	JFrame3Demo(){
		setTitle("안녕스윙!");
		JButton b = new JButton("버튼");
		add(b);//버튼을 프레임의 컨텐트패인에 부착
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임을 닫으면 애플리케이션을 강제 종료하도록 설정
		setSize(300,100);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrame3Demo();

	}

}

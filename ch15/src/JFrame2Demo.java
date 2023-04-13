import javax.swing.JFrame;
public class JFrame2Demo extends JFrame{//JFrame2Demo: JFrame의 자식 클래스이며, main()메서드를 포함하는 애플리케이션 클래스
	JFrame2Demo(){
		//생성자
		setTitle("안녕스윙!");
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrame2Demo();

	}

}

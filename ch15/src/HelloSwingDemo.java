import javax.swing.JFrame;
public class HelloSwingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f= new JFrame();//프레임생성
		f.setTitle("안녕 스윙!");//프레임의 타이틀과 설정
		f.setSize(300,100);//가로 세로의 크기를 픽셀개수로 나타냄. 
		//setVisible(true); 메서드를 호출하기 전에 먼저 필요한 모든 컴포넌트를 프레임에 부착해야함.
		f.setVisible(true);//생성된 프레임을 보여주는 메서드 이게 없으면 프레임은 생성되지만 우리가 눈으로 볼수 없음.

	}

}

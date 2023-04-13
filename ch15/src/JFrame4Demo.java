import javax.swing.*;
public class JFrame4Demo extends JFrame{
	JFrame4Demo(){
		setTitle("안녕스윙!");
		JPanel p=new JPanel();
		JLabel l= new JLabel("안녕,스윙!");
		JButton b=new JButton("버튼");
		p.add(l);//레이블과 버튼을 패널에 부착
		p.add(b);
		add(p);//패널을 프레임에 부착
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(300,100);//창크기를 명시적으로 정함
		pack(); //내용에 알맞게 창크기를 조절
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrame4Demo();

	}

}

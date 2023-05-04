package NotePad;

import java.awt.*;

import javax.management.openmbean.OpenType;
import javax.swing.*;

public class AboutMemojang extends JDialog {
JPanel Right;
JPanel Back;


public AboutMemojang(Frame owner) {
	super(owner,"메모장정보",true);//modal (true) modaless(false)
	this.setSize(500,300);
	//this.setLayout(new BorderLayout());
	//this.setModal(false);
	Toolkit kit=Toolkit.getDefaultToolkit();

	JPanel page1=new JPanel() {
		Image background=new ImageIcon(AboutMemojang.class.getResource("icon.png")).getImage();
		String d1="장선경 메모장 정보";
		String d2="자바메모장 정보창 구현:20230426";
		String d3="@Jsk All right reserved";
		String d4="memojang version 11.2301.22.1";

		public void paint(Graphics g) {//그리는 함수
			g.drawImage(background, 10, 60,getWidth()/2-100,getHeight()/2, null);//background를 그려줌
			g.setFont(new Font("", Font.BOLD, 20));
			g.drawString(d1, 210,100);
			g.setFont(new Font("", Font.BOLD, 15));
			g.drawString(d2, 190,120);
			g.drawString(d3, 210,140);
			g.drawString(d4, 190,160);

			System.out.println(getWidth());
			System.out.println(getHeight());

		}
	};
	ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage(getClass().getResource("jsk_icon.png")));
	this.setIconImage(icon.getImage());

	//Back.setSize(450,270);
	//Right.add(detail);
	//j1.add(b1);
	//page1.setLayout(null); //레이아웃 설정하기 위해.
	//page1.setBounds(0, 0, 100, 100);
	//this.add(j1);
	page1.setSize(100,100);
	//Back.setBackground(Color.black`);
	//Back.add(page1);
	//Back.add(detail,BorderLayout.CENTER);
	this.add(page1);
	//this.add(detail);
	this.setLocationRelativeTo(owner);
	this.setVisible(true);
	//이름 아이콘 이미지 저작권정보 언제 누가 왜 버전정보.
}



}
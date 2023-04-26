package NotePad;

import java.awt.*;

import javax.management.openmbean.OpenType;
import javax.swing.*;



public class AboutMemojang extends JDialog {
	JPanel j1;
	JButton b1;
	public AboutMemojang(Frame owner) {
		super(owner,"메모장정보",true);//modal (true) modaless(false)
		this.setSize(200,200);
		//this.setModal(false);
		Toolkit kit=Toolkit.getDefaultToolkit();
		JPanel page1=new JPanel() {
			Image background=new ImageIcon(AboutMemojang.class.getResource("fimage.png")).getImage();
			public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌
				
			}
		};
		ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage(getClass().getResource("jsk_icon.png")));
		this.setIconImage(icon.getImage());
		
		b1=new JButton("버튼");
		j1=new JPanel();
		j1.setSize(190,190);
		//j1.add(b1);
		page1.setLayout(null); //레이아웃 설정하기 위해.
		page1.setBounds(0, 0, 100, 100);
		//this.add(j1);
		page1.setSize(100,100);
		this.add(page1);
		this.setLocationRelativeTo(owner);
		this.setVisible(true);
		//이름 아이콘 이미지 저작권정보 언제 누가 왜 버전정보.
	}
}

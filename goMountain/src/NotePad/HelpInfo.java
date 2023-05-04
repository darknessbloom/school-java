package NotePad;

import java.awt.Color;
import javax.swing.*;

public class HelpInfo extends JFrame {
	public HelpInfo() {
		this.setTitle("도움말 정보"); 
		JTabbedPane t = new JTabbedPane(JTabbedPane.TOP);
		JPanel p1 = new JPanel(); p1.setBackground(Color.white);
		JPanel p2 = new JPanel(); p2.setBackground(Color.getHSBColor(50, 50, 20));
		JPanel p3 = new JPanel(); p3.setBackground(Color.getHSBColor(50, 50, 50));
		t.add("도움말", p1);
		t.add("메뉴소개", p2);
		t.add("고객센터안내", p3);
		this.add(t);
		this.setSize(450, 350);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HelpInfo();
	}

}

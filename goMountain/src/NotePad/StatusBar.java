package NotePad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;  
import java.util.Date;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class StatusBar extends JPanel {

	JPanel leftBar, midBar, rightBar;
	JLabel left, mid, right;
	JTextArea ta;
	
	public StatusBar(JFrame owner, JTextArea ta) {
		this.ta = ta;
		left = new JLabel("A");	
		mid = new JLabel("B");
		right = new JLabel("C");
		
		leftBar = new JPanel();
		leftBar.setBackground(new Color(230, 230, 230));  // 0~255
		midBar = new JPanel();
		midBar.setBackground(new Color(240, 240, 240));
		rightBar = new JPanel();
		midBar.setBackground(new Color(250, 250, 250));
		
		leftBar.add(left);
		midBar.add(mid);
		rightBar.add(right);		
			
		this.setLayout(new GridLayout(1, 3));
		this.add(leftBar);
		this.add(midBar);
		this.add(rightBar);
		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}			
		});
		
		timer.start();		
	}
	int x=0, y=0,c=0,cn=0;//cn:지금까지 쌓인 
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    // 날짜를 생성해서 left 레일블에 표시
	    Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd aa HH:mm:ss");				
		left.setText(sd.format(d));
		
		// 커서의 위치값 가져와서 mid 레이블에 표시	
		
		try {			
			y = ta.getCaretPosition();
			x = ta.getLineOfOffset(y);
			if(x!=c) {
				y-=cn;
				cn+=y;
				c=x;//c현재행값저장
			}
				
		} catch (BadLocationException e) {
			e.printStackTrace();
		} 
		mid.setText("행 : " + (x+1) + " 열 : " + (y+1-cn));		
		
		// 글짜크기 비율값 계산해서 right 레이블에 표시
		Font ft = ta.getFont();
		double rate = ft.getSize()/12.0 * 100;
		right.setText(String.format("%.0f", rate)+"%");
	}
}

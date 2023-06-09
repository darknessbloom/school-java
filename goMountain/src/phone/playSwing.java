package phone;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
public class playSwing extends JFrame implements ActionListener{
	//JFrame 배치 방식은 BorderLayout 방식(동서남북센터, 기본:센터)
	JTextField tf_name,tf_phone,tf_email,tf_age;
	JTable jt;
	DefaultTableModel dtm;
	PreparedStatement ps =null;
	ResultSet rs = null;//select한  결과를 리턴받는 객체
	Connection con=null;
	public playSwing() {
		this.setTitle("first gui");
		this.setSize(500,800);
		this.setLocation(1420, 300);//음수 좌표 없음.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);//맨위줄, 중앙에 차례로 배치
		JPanel p1 =new JPanel();//배치방식 flowLayout
		JPanel p2 =new JPanel();
		
		
		String [] Title= {"이름","폰번호","이메일","나이"};
		Object [] [] row= new Object[0][4];
		dtm= new DefaultTableModel(row,Title);
		
		jt=new JTable(dtm);
		jt.addMouseListener(new MouseAdapter() {//어댑터클래스

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=jt.getSelectedRow();
				tf_name.setText(jt.getValueAt(row,0).toString());
				tf_phone.setText(jt.getValueAt(row,1).toString());
				tf_email.setText(jt.getValueAt(row,2).toString());
				System.out.println(jt.getValueAt(row,3));
				tf_age.setText((String)jt.getValueAt(row,3));
				//toString는 null값을 문자로 바꾸지 못함.
				
			}

			
			
		}
				
				
				
				
				
				);
		
		JScrollPane p3 =new JScrollPane(jt);
		JLabel name =new JLabel("이름:");
		JLabel phone =new JLabel("폰번호:");
		JLabel email =new JLabel("이메일:");
		JLabel age =new JLabel("나이:");
		tf_name=new JTextField(20);
		tf_phone=new JTextField(20);
		tf_email=new JTextField(20);
		tf_age=new JTextField(20);
		
		p1.add(name);p1.add(tf_name);
		p1.add(phone);p1.add(tf_phone);
		p1.add(email);p1.add(tf_email);
		p1.add(age);p1.add(tf_age);
		p1.setBackground(Color.pink);
		p2.setBackground(Color.YELLOW);
		JButton bt1= new JButton("전화번호");
		JButton bt2= new JButton("검색");
		JButton bt3= new JButton("수정");
		JButton bt4= new JButton("삭제");
		JButton bt5= new JButton("추가");
		JButton bt6= new JButton("리셋");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		p2.add(bt1);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);
		p2.add(bt5);
		p2.add(bt6);
		
		p1.setBounds(10, 10, 250, 100);
		p2.setBounds(10, 130, 450, 40);
		p3.setBounds(10, 180, 460, 570);
		p3.setBackground(Color.white);
		this.add(p1);this.add(p2);this.add(p3);
		this.setResizable(false);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			//UIManager.setLookAndFeel ("motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel ("javax.swing.plaf.metal.MetalLookAndFeel");//LookAndFeel Windows 스타일 적용
			//SwingUtilities.updateComponentTreeUI();
			JFrame.setDefaultLookAndFeelDecorated(true); 
		}catch(Exception e){
			e.getMessage();
		}
		new playSwing();//new 생성자;
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//버튼에 써져있는 내용확인 e.getActionCommand()
	
		String cmd= e.getActionCommand();
		if(cmd.equals("전화번호")) {
			display(0);
			
		}
			
		else if(cmd.equals("검색")) {
			//tf.setBackground(Color.red);
			display(1);
			
		}
		else if(cmd.equals("수정")) {
			//tf.setFont(new Font("궁서체",Font.BOLD,20));
			update();
			display(0);
			
		}
		else if(cmd.equals("삭제")) {
			//tf.setText("");
			delete();
			display(0);
			
	
		}
		else if(cmd.equals("추가")) {
			//tf.setText("");
			//tf.setBackground(Color.white);
			insert();
			
	
		}
		else if(cmd.equals("리셋")) {
			tf_name.setText("");
			tf_email.setText("");
			tf_phone.setText("");
			tf_age.setText("");
		}
		
			
	}
	public ResultSet select(int kind) {
		con=makeConnection();
		if(con != null) {
			String sql;
			try {
				if (kind==0) {//전화번호부 전체조회
					sql="select * from person";
					ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					
				}
				else {//전화번호부 검색
					sql="select * from person where name= ? ";
					ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ps.setString(1, tf_name.getText());
				}
			
			
				//prepareStatement-> 메서드
				rs= ps.executeQuery();//select실행시 ->테이블 변화 없음
				System.out.println(rs);
				if(rs.next()) {
					rs.beforeFirst();
						
				}
				else {
					JOptionPane.showMessageDialog(this,"검색되지 않습니다.");
					sql="select * from person";
					ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs= ps.executeQuery();
					
				}
					
					
			
	
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ps 객체생성 오류");
				e.printStackTrace();//추적정보출력
			}
			
			
		}
		return rs;
		
	}
	public void insert() {
		con=makeConnection();
		//Scanner in=new Scanner(System.in);
		if(con != null) {
			String sql;
			if(tf_age.getText().equals(""))
				sql="insert into person(name,phone,email) values(?,?,?)";
			else
				sql="insert into person values(?,?,?,?)";
				
			int x=0;
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,tf_name.getText());
				ps.setString(2,tf_phone.getText());
				ps.setString(3,tf_email.getText());
				if(!tf_age.getText().equals(""))
					ps.setInt(4,Integer.parseInt(tf_age.getText()));
				
				x=ps.executeUpdate();
				
				
			}catch(SQLException ex){
				if(x==0) {
					JOptionPane.showMessageDialog(this,"전화번호가 중복되었거나 필수입력사항을 입력하지 않았습니다.");
					
				}
				
				
				
				
			}
		}
		
		
	}
	public  void delete() {
		con=makeConnection();
		if(con != null) {
			
			
			
			try {
				String sql="delete from person where phone = ? ";
				ps=con.prepareStatement(sql);
				ps.setString(1,tf_phone.getText());
				ps.executeUpdate();
					
				}
				
				
			catch(SQLException e) {
				
			}
			
		}
		
	}
	
	public  void update() {
		con=makeConnection();
		if(con != null) {
			
			try {
		
				String sql="update person set name=?, email=?,age=? where phone=?";
					
				ps=con.prepareStatement(sql);
				ps.setString(1,tf_name.getText());
				ps.setString(2,tf_email.getText());
				if(tf_age.getText().equals(""))
					ps.setString(3,null);
				else
					ps.setInt(3,Integer.parseInt(tf_age.getText()));
				ps.setString(4,tf_phone.getText());
				
					
				ps.executeUpdate();
					
				
				
				
			}catch(SQLException e) {
				
			}
			
		}
		
	}
	public void display(int kind) {
		rs=select(kind);
		try {
			String info[]=new String[4];
			dtm.setRowCount(0);//행개수를 0이되게 설정
			while(rs.next()) {
				info[0]=rs.getString(1);
				info[1]=rs.getString(2);
				info[2]=rs.getString(3);
				info[3]=rs.getString(4);
				dtm.addRow(info);
				
			}
		}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	
	public Connection makeConnection() {
		String url=
				"jdbc:mysql://localhost:3306/myapp?serverTimezone=Asia/Seoul";
		String id="root";
		String pw="1234";
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//드라이버로딩
			System.out.println("데이터베이스연결중");
			con=DriverManager.getConnection(url,id,pw);//db연결명령
			System.out.println("데이터베이스 연결성공");
		}catch(ClassNotFoundException e) {//com.mysql.cj.jdbc.Driver 로딩시 예외가 발생할때(위치에 없거나..) 실행할 구문
			System.out.println("jdbc 드라이버를 찾지 못했습니다");
			
		}catch(SQLException e){//SQLException e ->SQLException를 줄여서 e로 쓰기
			System.out.println("데이터베이스 연결실패");
			System.out.println(e.getMessage());
		}
		return con;
	}
					

}

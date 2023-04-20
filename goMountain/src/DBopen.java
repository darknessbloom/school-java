import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBopen {
	PreparedStatement ps =null;
	ResultSet rs = null;//select한  결과를 리턴받는 객체
	Connection con=null;
	public ResultSet select() {
		con=makeConnection();
		if(con != null) {
			String sql;
			try {
				//distinct 중복데이터가 있으면 1개만 가져오는것.
				sql="select distinct date_num from memo";
				
				ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				rs= ps.executeQuery();//select실행시 ->테이블 변화 없음
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ps 객체생성 오류");
				e.printStackTrace();//추적정보출력
			}
			
			
		}
		return rs;
		
	}
	public ResultSet select(String dd) {
		con=makeConnection();
		if(con != null) {
			String sql;
			try {
				
				sql="select * from memo where date_num= ? ";
				ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ps.setString(1,dd);
				rs= ps.executeQuery();//select실행시 ->테이블 변화 없음
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ps 객체생성 오류");
				e.printStackTrace();//추적정보출력
			}
			
			
		}
		return rs;
		
	}
	
	public void insert(String dd,String msg) {
		con=makeConnection();
		//Scanner in=new Scanner(System.in);
		if(con != null) {
			String sql;
			
			sql="insert into memo values(null,?,?)";
			
				
			int x=0;
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, dd);
				ps.setString(2,msg);
				
				x=ps.executeUpdate();
				if(x==1)
					System.out.println("추가성공");
				
				
			}catch(SQLException ex){
				System.out.println("추가실패!");
				
				
				
				
			}
		}
		
		
	}
public  void delete(int id) {
		con=makeConnection();
		if(con != null) {
			
			
			
			try {
				String sql="delete from memo where id = ? ";
				ps=con.prepareStatement(sql);
				ps.setInt(1,id);
				ps.executeUpdate();
					
				}
				
				
			catch(SQLException e) {
				
			}
			
		}
		
	}
	
	/*public  void update() {
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
		
	*/
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

package NotePad;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Memojang extends JFrame implements ActionListener{
	// 전역변수 영역
	JTextArea ta = new JTextArea();
	
	JButton newBtn, openBtn, saveBtn, exitBtn, copyBtn, pasteBtn, cutBtn, fontBtn, colBtn;
	StatusBar stBar;
	JFileChooser jfc;
	File file = null;
	boolean isNew = false; // 새로운 입력내용이 발생했는지 CHECK 저장이 필요한지 여부 확인 false:저장불필요
	String filename = null;// 저장하고 불러오는 파일이름을 저장	
	
	public Memojang() {
		this.setTitle("길동이의 메모장...");			
		JScrollPane sp = new JScrollPane(ta);
		this.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        ta.requestFocus();
		        
		    }
		}); 
		
		
		ta.addKeyListener(new KeyAdapter() {//KeyAdapter() 여러메소드중 하나만 쓰고 싶을때,Adapter()사용
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				isNew=true;
				
			}
		});
		this.add(sp);
		makeMenu();
		
		jfc = new JFileChooser();
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(1000, 200, 500, 500);
		this.setVisible(true);				
	}
	
	public void makeMenu() {
		JMenuBar mb = new JMenuBar();		
		JToolBar tb = new JToolBar();
		stBar = new StatusBar(this, this.ta);
		
		////////// JToolBar 메뉴 ////////////
		ImageIcon newF = new ImageIcon("image/newicon.png");	
		ImageIcon openF = new ImageIcon("image/newicon.png");
		ImageIcon saveF = new ImageIcon("image/newicon.png");	
		ImageIcon extF = new ImageIcon("image/newicon.png");
		ImageIcon copyF = new ImageIcon("image/newicon.png");	
		ImageIcon pasteF = new ImageIcon("image/newicon.png");
		ImageIcon cutF = new ImageIcon("image/newicon.png");	
		ImageIcon fontF = new ImageIcon("image/newicon.png");
		ImageIcon colF = new ImageIcon("image/newicon.png");	
		
		newBtn = new JButton(newF);
		openBtn = new JButton(openF);
		saveBtn = new JButton(saveF);
		exitBtn = new JButton(extF);	
		copyBtn = new JButton(copyF);	
		pasteBtn = new JButton(pasteF);
		cutBtn = new JButton(cutF);	
		fontBtn = new JButton(fontF);		
		colBtn = new JButton(colF);
		
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		copyBtn.addActionListener(this);
		pasteBtn.addActionListener(this);
		cutBtn.addActionListener(this);
		fontBtn.addActionListener(this);
		colBtn.addActionListener(this);
		
		newBtn.setToolTipText("새파일을 작성해요~");
		saveBtn.setToolTipText("문서를 저장합니다");		
		exitBtn.setToolTipText("문서작성을 종료합니다");
		copyBtn.setToolTipText("복사해욤^^");			
		pasteBtn.setToolTipText("붙여넣어요~");
		cutBtn.setToolTipText("싹뚝 잘라요@@");		
		fontBtn.setToolTipText("글꼴을 바꿔요");
		colBtn.setToolTipText("글자색상을 비꿔요");	
		
		tb.add(newBtn); tb.add(openBtn); tb.add(saveBtn); tb.add(exitBtn);
		tb.addSeparator();
		tb.add(copyBtn); tb.add(pasteBtn); tb.add(cutBtn);
		tb.addSeparator();
		tb.add(fontBtn); tb.add(colBtn);		
		
		////////// 파일메뉴 ////////////
		JMenu file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_saveAs = new JMenuItem("다른이름으로 저장");
		JMenuItem file_exit = new JMenuItem("끝내기");
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_saveAs.addActionListener(this);
		file_exit.addActionListener(this);
		
		file.add(file_new); file.add(file_open);
		file.addSeparator();
		file.add(file_save); file.add(file_saveAs);
		file.addSeparator();
		file.add(file_exit);
		
		////////// 편집메뉴 ////////////	
		JMenu edit = new JMenu("편집");
		JMenuItem edit_cut = new JMenuItem("잘라내기");
		JMenuItem edit_copy = new JMenuItem("복사");
		JMenuItem edit_paste = new JMenuItem("붙여넣기");
		JMenuItem edit_find = new JMenuItem("찾기");
		JMenuItem edit_replace = new JMenuItem("바꾸기");
		JMenuItem edit_datetime = new JMenuItem("시간/날짜");
		JMenuItem edit_all = new JMenuItem("전체선택");
		edit.add(edit_cut); edit.add(edit_copy); edit.add(edit_paste);  
		edit.addSeparator();
		edit.add(edit_find);edit.add(edit_replace);
		edit.addSeparator();
		edit.add(edit_datetime); edit.add(edit_all);
		edit_cut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.cut();
				
				
			}
		});
		edit_copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.copy();
				
				
			}
		});
		edit_paste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.paste();
				
				
			}
		});
		edit_all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.selectAll();
				
				
			}
		});
		
		edit_datetime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date d = new Date();
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd aa HH:mm:ss");				
				ta.append(sd.format(d));
				
				
				
			}
		});
	
		
		
		
		/////서식메뉴
		JMenu form = new JMenu("서식");
		JMenuItem form_font = new JMenuItem("글꼴");
		JMenuItem form_fontColor = new JMenuItem("글자색");
		JMenuItem form_backColor = new JMenuItem("배경색");
		form.add(form_font); form.add(form_fontColor); form.add(form_backColor); 
		
		JMenu view = new JMenu("보기");
		JMenuItem view_zoom = new JMenuItem("확대/축소");
		JMenuItem view_statusBar = new JMenuItem("상태표시줄");
		view.add(view_zoom); view.add(view_statusBar);
		
		////////// 도움말 메뉴 부분 ////////////
		JMenu help = new JMenu("도움말");
		JMenuItem help_info = new JMenuItem("도움말 정보");		
		JMenuItem help_about = new JMenuItem("메모장 정보");
		help_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HelpInfo();
			}			
		});
		help_about.addActionListener(this);
		help.add(help_info); help.addSeparator();  
		help.add(help_about);
				
		mb.add(file); mb.add(edit); mb.add(form); mb.add(view); mb.add(help);
		this.setJMenuBar(mb);	
		this.add(tb, BorderLayout.NORTH);
		this.add(BorderLayout.SOUTH, stBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("메모장 정보")) {
			new AboutMemojang(this);
			
		}
		else if(cmd.equals("새파일") || e.getSource() == newBtn) {
			this.setTitle("jsk메모장");
			filename=null;
			saveCheck();
		}
		else if(cmd.equals("열기") || e.getSource() == openBtn) {
			int a=saveCheck();
			if (a==0)
				open();
		}
		else if(cmd.equals("저장") || e.getSource() == saveBtn) {
			save();
			
		}
		else if(cmd.equals("다른이름으로 저장")) {
			saveAs();
			
		}
		else if(cmd.equals("끝내기") || e.getSource() == exitBtn) {
			int a=saveCheck();
			if (a==0)
				System.exit(1);
				
				
		}
	}
	public int saveCheck() {
		int val=0;
		if (isNew==true) {
			int yesno=JOptionPane.showConfirmDialog(this, "저장하시겠습니까?");
			if(yesno==JOptionPane.YES_OPTION) {
				save();
				ta.setText("");
				
			}
				
				
			
				
			else if(yesno==JOptionPane.NO_OPTION) {
				ta.setText("");
				isNew=false;
				
			}
			else if(yesno==JOptionPane.CANCEL_OPTION) {
				val=1;
			}
			
		}
		return val;
		
	}
		
	
	
	public void open() {
		int re = jfc.showOpenDialog(this);
		if (re == jfc.APPROVE_OPTION) {//열기버튼을 눌렀을때
			file = jfc.getSelectedFile();//선택한파일을 가리키게함.
			this.setTitle(file.getAbsolutePath() + "jsk 메모장");
			
			//타이틀제목은 파일 절대경로+jsk메모장이라는 이름으로 설정
			String data = "";
			int ch;
			try {
				FileReader fr = new FileReader(file);//파일리더객체: 파일을 읽기위해 존재함.
				BufferedReader br= new BufferedReader(fr);//fr이 가리키는 내용을 단번에 읽어올수 있음.
				ta.setText("");
				String dd="";
//				String total="";
				while((dd=br.readLine())!=null) {
					ta.append(dd+System.lineSeparator());
					
				}
					
				//ta.setText(total);
//				while ((ch = fr.read()) != -1)  // -1이면 EOF(EndOfFile)
//					data = data + (char) ch;
//				ta.setText(data);
				fr.close();//파일리더 객체 닫기
				isNew =false;//저장될 변화가 없는 상태
				filename=file.getName();
			} 
			catch (FileNotFoundException e) {
				e.getMessage();
			}
			catch (IOException e) {
			e.getMessage();
			}
		}
	}
	
	public void save() {
		if (filename==null)//파일이름이 설정된적이 없을때
		{
			
			int re=jfc.showSaveDialog(this);
			if(re==jfc.APPROVE_OPTION) {
				file=jfc.getSelectedFile();
				filename=file.getName();
			}
				
		}
			
		
		String dd=ta.getText();
		try {
			FileWriter fw= new FileWriter(file);//반드시 예외처리필요
			fw.write(dd);
			fw.close();
			this.setTitle(file.getAbsolutePath() + "jsk 메모장");
			isNew=false;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void saveAs() {
		
		int re=jfc.showSaveDialog(this);
		if(re==jfc.APPROVE_OPTION) {
			file=jfc.getSelectedFile();
			filename=file.getName();
			String dd=ta.getText();
			try {
				FileWriter fw= new FileWriter(file);//반드시 예외처리필요
				fw.write(dd);
				fw.close();
				this.setTitle(file.getAbsolutePath() + "jsk 메모장");
				isNew=false;
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Memojang();
	}
}

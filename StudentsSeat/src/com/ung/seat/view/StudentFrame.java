package com.ung.seat.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import com.ung.seat.controller.StudentController;

public class StudentFrame extends JFrame {
	private StudentController sc = new StudentController();
	private String[] students;
	
	private JPanel classPane;
	private JPanel mainPane;
	private JPanel recordPane;
	
	public StudentFrame() {
		setTitle("자리배치하기");
		setSize(700, 500);
		setLocationRelativeTo(null);
		getContainerListeners();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100,100,700,500);
		mainPane();
	}
	public void mainPane() {
		mainPane=new JPanel();
		mainPane.setBounds(100,100,700,500);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		JButton Title=new JButton("학생자리 관리 프로그램");
		Title.setBounds(100, 10, 500, 70);
		Title.setFont(new Font("굴림", Font.PLAIN, 20));
		Title.setBackground(Color.GREEN);
		Title.setForeground(Color.WHITE);
		
		JButton classButton= new JButton("학생 자리 배정");
		classButton.setBounds(100, 180, 500, 70);
//		JButton studentButton= new JButton("학생정보수정");
//		studentButton.setBounds(100, 260, 500, 70);
		JButton recordButton= new JButton("기록보기");
		recordButton.setBounds(100, 300, 500, 70);
		mainPane.add(Title);
		mainPane.add(classButton);
//		mainPane.add(studentButton);
		mainPane.add(recordButton);
		mainPane.setLayout(null);
		mainPane.setVisible(true);
		recordButton.addActionListener(event -> {
			mainPane.setVisible(false);
			recordPane();
					});
		classButton.addActionListener(event -> {
			mainPane.setVisible(false);
			classPane();
					});
		
	}
	public void classPane() {
		String[] result=new String[23];
		classPane=new JPanel();
		classPane.setBounds(100,100,700,500);
		classPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(classPane);
		JButton Title2=new JButton("교탁");
		Title2.setBounds(10, 10, 80, 50);
		Title2.setFont(new Font("굴림", Font.PLAIN, 20));
		classPane.add(Title2);
		
		randomSet();
		JButton button[] = new JButton[23];
		ActionListener listener=new ActionListener() {//버튼클릭시 실행할 메소드 이렇게 구현부를 만들어줘야된다고합니다.
			int count =0;
			@Override
			public void actionPerformed(ActionEvent e) {
				 if (e.getSource() instanceof JButton) {
					 if(count>22) {return;}
				result[count]=students[count];
				((JButton)e.getSource()).setText(students[count++]);//랜덤배치된 학생 이름을 가저와서 버튼에 집어넣습니다.
				((JButton)e.getSource()).setEnabled(false);// 사용한 버튼을 비활성화
				}
			}
		};
		
		for (int i = 0; i < 23; i++) {
			button[i] = new JButton(i+1+"");//버튼에 숫자를 넣어주는 생성자
			button[i].addActionListener(listener);
		}

		
		button[0].setBounds(21, 77, 80, 50);
		button[12].setBounds(21, 188, 80, 50);
		button[5].setBounds(21, 133, 80, 50);
		button[1].setBounds(100, 77, 80, 50);
		button[2].setBounds(177, 77, 80, 50);
		button[3].setBounds(403, 77, 80, 50);
		button[4].setBounds(480, 77, 80, 50);
		button[6].setBounds(100, 133, 80, 50);
		button[7].setBounds(177, 133, 80, 50);
		button[8].setBounds(254, 133, 80, 50);
		button[9].setBounds(403, 133, 80, 50);
		button[10].setBounds(480, 133, 80, 50);
		button[11].setBounds(557, 133, 80, 50);
		button[13].setBounds(100, 188, 80, 50);
		button[14].setBounds(177, 188, 80, 50);
		button[15].setBounds(254, 188, 80, 50);
		button[16].setBounds(403, 188, 80, 50);
		button[17].setBounds(480, 188, 80, 50);
		button[18].setBounds(557, 188, 80, 50);
		button[19].setBounds(177, 244, 80, 50);
		button[20].setBounds(254, 244, 80, 50);
		button[21].setBounds(403, 244, 80, 50);
		button[22].setBounds(480, 244, 80, 50);
		for (int i = 0; i < button.length; i++) {
			classPane.add(button[i]);
		}
		JButton record=new JButton("저장하기");
		record.setBounds(480, 360, 100, 50);
		record.addActionListener(event -> {
			if(result[22]!=null) {
				Success();
	          sc.resultRecord(result);
	          }
	    });
		JButton Exit=new JButton("메인메뉴로");
		Exit.setBounds(360, 360, 100, 50);
		Exit.addActionListener(event -> {
			
			classPane.setVisible(false);
			mainPane();
		});
		
		classPane.add(Exit);
		classPane.add(record);
		
		classPane.setLayout(null);
		classPane.setVisible(true);
		add(classPane);
		
	}
	public void recordPane() {
		String[] record=sc.recordView();
		recordPane=new JPanel();
		recordPane.setBounds(100,100,700,500);
		recordPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(recordPane);
		JButton Title=new JButton("지난결과");
		Title.setBounds(250, 10, 120, 50);
		Title.setFont(new Font("굴림", Font.PLAIN, 20));
		recordPane.add(Title);
		JButton button[] = new JButton[23];
		
		
		for (int i = 0; i < 23; i++) {
			button[i] = new JButton(record[i]);//버튼에 숫자를 넣어주는 생성자
		}
		
		button[0].setBounds(21, 77, 80, 50);
		button[1].setBounds(100, 77, 80, 50);
		button[2].setBounds(177, 77, 80, 50);
		button[3].setBounds(403, 77, 80, 50);
		button[4].setBounds(480, 77, 80, 50);
		button[5].setBounds(21, 133, 80, 50);
		button[6].setBounds(100, 133, 80, 50);
		button[7].setBounds(177, 133, 80, 50);
		button[8].setBounds(254, 133, 80, 50);
		button[9].setBounds(403, 133, 80, 50);
		button[10].setBounds(480, 133, 80, 50);
		button[11].setBounds(557, 133, 80, 50);
		button[12].setBounds(21, 188, 80, 50);
		button[13].setBounds(100, 188, 80, 50);
		button[14].setBounds(177, 188, 80, 50);
		button[15].setBounds(254, 188, 80, 50);
		button[16].setBounds(403, 188, 80, 50);
		button[17].setBounds(480, 188, 80, 50);
		button[18].setBounds(557, 188, 80, 50);
		button[19].setBounds(177, 244, 80, 50);
		button[20].setBounds(254, 244, 80, 50);
		button[21].setBounds(403, 244, 80, 50);
		button[22].setBounds(480, 244, 80, 50);
		for (int i = 0; i < button.length; i++) {
			recordPane.add(button[i]);
		}
		JButton Exit=new JButton("메인메뉴로");
		Exit.setBounds(360, 360, 100, 50);
		Exit.addActionListener(event -> {
			
			recordPane.setVisible(false);
			mainPane();
		});
		
		recordPane.add(Exit);
		recordPane.setLayout(null);
		recordPane.setVisible(true);
		add(recordPane);
		 
		
	}
	public void Success() {// 성공메세지출력
		JFrame success=new JFrame();
		success.setTitle("성공!");
		success.setSize(500, 200);
		success.setLocationRelativeTo(null);
		success.getContainerListeners();
		success.setVisible(true);
		success.setBounds(100,80,300,200);
		success.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel successPane=new JPanel();
		successPane.setBounds(100,80,100,80);
		successPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		success.setContentPane(successPane);
		JButton OK=new JButton("성공");
		OK.setBounds(100, 60, 60, 50);
		successPane.add(OK);
		OK.addActionListener(event -> {
			success.setVisible(false);
		});
	}
	
	public void randomSet() {
		String[] student = sc.StudentList();
		int randomArr[] = new int[23];
		students = new String[23];//새 배열에 랜덤배치를 합니다.
		for (int i = 0; i < student.length; i++) {
			int index = (int) (Math.random() * 23);
			if (randomArr[index] != 0) {
				i--;
				continue;
			}
			randomArr[index]++;
			students[i] = student[index];
		}
	}


	

}

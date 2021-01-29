package mini;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InfoFrame {
	
	private JTextField infoIdT;
	private JTextField infoBirthDateT;
	private JPasswordField infoPwdChT1;
	private JPasswordField infoPwdChT2;
	private JFrame frame;

	
	public InfoFrame(JFrame frame) {  
		
		this.frame = new JFrame();
		MemberManager memberManager = new MemberManager();
		ImagePanel panel4 = new ImagePanel(new ImageIcon("src/images/4.jpg").getImage());
		frame.add(panel4);		
		frame.pack();
		
		
		JLabel infoNameL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName());
		infoNameL.setFont(new Font("굴림", Font.BOLD, 28));
		infoNameL.setBounds(491, 160, 310, 50);
		panel4.add(infoNameL);
		
		
		JLabel infoBirthDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate());
		infoBirthDateL.setFont(new Font("굴림", Font.BOLD, 28));
		infoBirthDateL.setBounds(491, 280, 310, 50);
		panel4.add(infoBirthDateL);
		
		JLabel infoAdrrL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getAdrr());
		infoAdrrL.setFont(new Font("굴림", Font.BOLD, 28));
		infoAdrrL.setBounds(491, 397, 310, 50);
		panel4.add(infoAdrrL);
		
		JLabel infoJoinDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate());
		infoJoinDateL.setFont(new Font("굴림", Font.BOLD, 28));
		infoJoinDateL.setBounds(491, 517, 310, 50);
		panel4.add(infoJoinDateL);
		
		JLabel infoRevDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getRevDate());
		infoRevDateL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevDateL.setBounds(491, 640, 150, 50);
		panel4.add(infoRevDateL);
		
		JLabel infoRevTimeL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getRevTime());
		infoRevTimeL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevTimeL.setBounds(651, 640, 150, 50);
		panel4.add(infoRevTimeL);
		
		JLabel infoRevPriceL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getPrice() + "원");
		infoRevPriceL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevPriceL.setBounds(811, 640, 150, 50);
		panel4.add(infoRevPriceL);
		

		JLabel infoMemberla = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");		//회원정보 라벨
		infoMemberla.setFont(new Font("굴림", Font.BOLD, 19));
		infoMemberla.setBounds(1356, 21, 214, 42);
		panel4.add(infoMemberla);
//		infoMemberla.setText(MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");
		
	
		
		memberManager.Info();
		
		JButton infoHomeBtn = new JButton(); //홈버튼
		infoHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		infoHomeBtn.setBounds(1274, 21, 70, 54);
		panel4.add(infoHomeBtn);
		infoHomeBtn.addActionListener(new ActionListener() { //비번변경 전 정보확인창 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				
				frame.getContentPane().removeAll();
				LoginFrame loginframe = new LoginFrame(frame); 

			
			}
		});
		
		
		JButton infoLogout = new JButton();		//로그아웃 버튼
		infoLogout.setIcon(new ImageIcon("C:\\버튼이미지\\로그아웃.png"));
		infoLogout.setBounds(1388, 73, 156, 30);
		panel4.add(infoLogout);
		infoLogout.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				
				frame.getContentPane().removeAll();
				LoginFrame loginframe = new LoginFrame(frame);

				
			}
		});
		
		
		JButton pwdchBtn = new JButton();		//pwd 변경버튼
		pwdchBtn.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경.png"));
		pwdchBtn.setBounds(492, 736, 192, 29);
		panel4.add(pwdchBtn);
		pwdchBtn.addActionListener(new ActionListener() { //비번변경 전 정보확인창 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				BeforeResetPassWord brp = new BeforeResetPassWord(frame);
			}
		});
		
		
		JButton memberDelBtn = new JButton();	//회원탈퇴 버튼
		memberDelBtn.setIcon(new ImageIcon("src/buttonImages/회원탈퇴.png"));
		memberDelBtn.setBounds(913, 736, 129, 29);
		panel4.add(memberDelBtn);
		memberDelBtn.addActionListener(new ActionListener() { //회원탈퇴 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				MembershipQuit mq = new MembershipQuit(frame);
			}
		});
		
		
		JButton cancelBookBtn = new JButton(""); //예약확인 버튼
		cancelBookBtn.setIcon(new ImageIcon("src/buttonImages/버튼이미지/예약취소.png"));
		cancelBookBtn.setBounds(971, 632, 143, 59);
		panel4.add(cancelBookBtn);
		cancelBookBtn.addActionListener(new ActionListener() { //예약취소 버튼
			
			public void actionPerformed(ActionEvent e) {
				
				memberManager.resvervationCancel();
				infoRevDateL.setText(" ");
				infoRevTimeL.setText(" ");
				infoRevPriceL.setText(" ");
				
				
			}
		});
	}
	

}
	
	
	
	



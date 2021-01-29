package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AfterLoginFrame {//이니셜 3이었던 부분
	
	private JFrame frame;
	
	public AfterLoginFrame(JFrame frame) {
		
		this.frame = new JFrame();
		ImagePanel panel2 = new ImagePanel(new ImageIcon("src/Images/2.jpg").getImage());
		frame.add(panel2);
		frame.pack();
		
		JLabel homeMemberL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName()+"님 환영합니다.");
		homeMemberL.setFont(new Font("굴림", Font.BOLD, 28));
		homeMemberL.setForeground(Color.WHITE);
		homeMemberL.setBounds(196, 530, 362, 32);
		panel2.add(homeMemberL);
		
		
		JButton homeRevBtn = new JButton("");
		homeRevBtn.setForeground(Color.BLACK);
		homeRevBtn.setIcon(new ImageIcon("src/buttonImages/예약하기.jpg"));
		homeRevBtn.setBounds(101, 638, 254, 50);
		panel2.add(homeRevBtn);
		homeRevBtn.addActionListener(new ActionListener() {	//예약하기 버튼
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				ReservationFrame revframe = new ReservationFrame(frame);

			}
		});
		
		
		JButton homeinfoBtn = new JButton("");
		homeinfoBtn.setIcon(new ImageIcon("src/buttonImages/개인정보확인.png"));
		homeinfoBtn.setBounds(392, 631, 254, 62);
		panel2.add(homeinfoBtn);
		homeinfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				InfoFrame infoframe = new InfoFrame(frame);

				
			}
		});
		
		
		JButton homeLogoutBtn = new JButton("");
		homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/h로그아웃.jpg"));
		homeLogoutBtn.setBounds(101, 698, 154, 37);
		panel2.add(homeLogoutBtn);
		homeLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.getContentPane().removeAll();
				LoginFrame lf = new LoginFrame(frame);
				
			}
		});
		
	}
	
	
}

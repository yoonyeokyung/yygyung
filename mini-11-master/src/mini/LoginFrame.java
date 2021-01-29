package mini;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javax.swing.JLabel;

public class LoginFrame {
	
	private JFrame frame;
	private JTextField loginIdT;
	private JPasswordField loginPwdT;
	
	public LoginFrame(JFrame frame) {

		MemberManager memberManager = new MemberManager();
		
		this.frame = new JFrame();
		
		ImagePanel panel1 = new ImagePanel(new ImageIcon("src/Images/1.jpg").getImage());
		frame.getContentPane().add(panel1);
		frame.pack();
		
		
		
		loginIdT = new JTextField();
		loginIdT.setBounds(95, 487, 568, 62);
		panel1.add(loginIdT);
		loginIdT.setColumns(10);
		
		loginPwdT = new JPasswordField();
		loginPwdT.setBounds(95, 577, 568, 62);
		panel1.add(loginPwdT);
		loginPwdT.setColumns(10);
		
		
		JButton loginBtn = new JButton("");
		loginBtn.setIcon(new ImageIcon("src/buttonImages/로그인.jpg"));
		loginBtn.setBounds(98, 660, 565, 62);
		panel1.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {	//로그인버튼
			public void actionPerformed(ActionEvent e) {
				if(memberManager.login(loginIdT.getText(), loginPwdT.getText())) {
		
				frame.getContentPane().removeAll();				
				AfterLoginFrame alf = new AfterLoginFrame(frame);
				
				}
			}
		});
		
//		JButton loginJoinBtn = new JButton("");
//		loginJoinBtn.setIcon(null);
//		loginJoinBtn.setBounds(107, 744, 194, 34);
//		panel1.add(loginJoinBtn);
		
		
		
		
		JButton ResetPasswordBtn = new JButton("");
		ResetPasswordBtn.setIcon(null);
		ResetPasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				BeforeResetPassWord brf = new BeforeResetPassWord(frame);
				
			}
		});
		
		
		ResetPasswordBtn.setBounds(449, 744, 214, 34);
		panel1.add(ResetPasswordBtn);
		
		JLabel JoinNewID = new JLabel("");
		JoinNewID.setBounds(107, 744, 194, 34);
		panel1.add(JoinNewID);
		
		JoinNewID.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				//MainPage 이동
				frame.getContentPane().removeAll();
				JoinFrame jf = new JoinFrame(frame);
				

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel j = (JLabel)e.getSource();
				
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel)e.getSource();
				
				
			}
			
		});
		
		
		
//		loginJoinBtn.addActionListener(new ActionListener() {	//회원가입 버튼
//			public void actionPerformed(ActionEvent e) {
//
//				frame.getContentPane().removeAll();
//				JoinFrame jf = new JoinFrame(frame);
//				
//				
//			}
//		});
	
		
	}
}

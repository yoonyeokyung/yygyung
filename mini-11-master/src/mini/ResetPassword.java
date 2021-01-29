package mini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class ResetPassword {
		
	private JFrame frame;
	
	public ResetPassword(JFrame frame) {
				
		ImagePanel panel8 = new ImagePanel(new ImageIcon("src/images/8.jpg").getImage());
		frame.add(panel8);
		frame.pack();
		
		JPasswordField infoPwdChT1 = new JPasswordField();
		infoPwdChT1.setBounds(617, 262, 369, 54);
		panel8.add(infoPwdChT1);
		infoPwdChT1.setColumns(20);
		
		JPasswordField infoPwdChT2 = new JPasswordField();
		infoPwdChT2.setBounds(617, 401, 369, 54);
		panel8.add(infoPwdChT2);
		infoPwdChT2.setColumns(20);
		
		JButton pwdchbtn1 = new JButton(""); //비번 변경 버튼 
		pwdchbtn1.setIcon(new ImageIcon("src/buttonImages/비밀번호변경확인.jpg"));
		pwdchbtn1.setBounds(617, 533, 371, 62);
		panel8.add(pwdchbtn1);
		pwdchbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberManager memberManager = new MemberManager();
			
					if(memberManager.changedPwd(infoPwdChT1.getText(),infoPwdChT2.getText())) {
						
						frame.getContentPane().removeAll();
						InfoFrame iff = new InfoFrame(frame);
		
					}
					
					
				}
			});
			
			
			
		}
		
		

}

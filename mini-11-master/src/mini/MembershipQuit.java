package mini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MembershipQuit {

	private JFrame frame;
	
	
	public MembershipQuit(JFrame frame) {
		
		
		ImagePanel panel5 = new ImagePanel(new ImageIcon("src/images/5.jpg").getImage());
		frame.add(panel5);
		frame.pack();
		
		JButton pwdYes = new JButton("");
		pwdYes.setIcon(new ImageIcon("src/buttonImages/예.png"));
		pwdYes.setBounds(530, 487, 211, 67);
		panel5.add(pwdYes);
		
		pwdYes.addActionListener(new ActionListener() {//회원 삭제 예 버튼
			public void actionPerformed(ActionEvent e) {
				MemberManager memberManager = new MemberManager();
				memberManager.MemberDelete();
				
				
				LoginFrame loginframe = new LoginFrame(frame);
				
			}
		});
		
		
		JButton pwdNo = new JButton("");
		pwdNo.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
		pwdNo.setBounds(845, 487, 211, 67);
		panel5.add(pwdNo);
		
		pwdNo.addActionListener(new ActionListener() {//회원 삭제 아니요 버튼
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "발전하는 O2B2가 되겠습니다.");
				
				frame.getContentPane().removeAll();
				InfoFrame iff = new InfoFrame(frame);
			}
		});
		
		
	}
	
	
}

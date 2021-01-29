package mini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BeforeResetPassWord {

	
	private JFrame frame;
	
	public BeforeResetPassWord(JFrame frame) {
		
		
		ImagePanel panel7 = new ImagePanel(new ImageIcon("src/images/7.jpg").getImage());
		frame.add(panel7);	
		frame.pack();
		
		
		JTextField infoIdT = new JTextField();
		infoIdT.setBounds(617, 262, 369, 54);
		panel7.add(infoIdT);
		infoIdT.setColumns(20);
		
		
		JTextField infoBirthDateT = new JTextField();
		infoBirthDateT.setBounds(617, 422, 369, 59);
		panel7.add(infoBirthDateT);
		infoBirthDateT.setColumns(20);
		
		
		JButton infoCkBtn = new JButton("");
		infoCkBtn.setIcon(new ImageIcon("src/buttonImages/개인정보확인.png"));
		infoCkBtn.setBounds(599, 526, 380, 74);
		panel7.add(infoCkBtn);
		
		infoCkBtn.addActionListener(new ActionListener() { // 비번호변경으로 가는 버튼
			public void actionPerformed(ActionEvent e) {
				MemberManager memberManager = new MemberManager();
				
				if(memberManager.EditInfopwd(infoIdT.getText() , infoBirthDateT.getText())) {
					
					frame.getContentPane().removeAll();
					ResetPassword rp = new ResetPassword(frame);
				}
					
				
				
			}
		});
		
		
		
	}
	
}

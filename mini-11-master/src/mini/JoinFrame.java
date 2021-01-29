package mini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JoinFrame  {
	
	
	private JTextField getIdField ;
	private JPasswordField getPwdField;
	private JPasswordField getPwd2Field;
	private JTextField getNameField;
	private String getGender;
	private JTextField getBirthField;
	private JTextField getAddrField;
	private JFrame frame;
	
	
	public JoinFrame(JFrame frame) {	// 이니셜 3이었던 부분
		
		this.frame = new JFrame();
		MemberManager memberManager = new MemberManager();
		ImagePanel panel3 = new ImagePanel(new ImageIcon("src/Images/3.jpg").getImage());
		frame.getContentPane().add(panel3);
		frame.pack();
		
		
		getIdField = new JTextField();
		getIdField.setBounds(403, 290, 257, 55);
		panel3.add(getIdField);
		getIdField.setColumns(10);
		
		
	
		
				
		getPwdField = new JPasswordField();
		getPwdField.setBounds(403, 442, 371, 59);
		panel3.add(getPwdField);
		getPwdField.setColumns(10);

		
		getPwd2Field = new JPasswordField();
		getPwd2Field.setBounds(403, 565, 371, 55);
		panel3.add(getPwd2Field);
		getPwd2Field.setColumns(10);

		
		getNameField = new JTextField();
		getNameField.setBounds(832, 290, 379, 59);
		panel3.add(getNameField);
		getNameField.setColumns(10);

		
		getBirthField = new JTextField();
		getBirthField.setBounds(832, 442, 379, 59);
		panel3.add(getBirthField);
		getBirthField.setColumns(10);

		
		getAddrField = new JTextField();
		getAddrField.setBounds(836, 565, 379, 55);
		panel3.add(getAddrField);
		getAddrField.setColumns(10);

		
		
		JRadioButton genWomBtn = new JRadioButton("여자");
		genWomBtn.setBounds(538, 768, 134, 38);
		panel3.add(genWomBtn);
		
		
		
		JRadioButton genManbtn = new JRadioButton("남자");
		genManbtn.setBounds(413, 768, 121, 38);
		panel3.add(genManbtn);
		
		
		
		ButtonGroup group = new ButtonGroup();
				
		group.add(genManbtn);
		group.add(genWomBtn);
		genManbtn.setSelected(true);
		
		genManbtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				
				genManbtn.setActionCommand("남자");
				 getGender = group.getSelection().getActionCommand();
				
			}
		});
		
		genWomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				genWomBtn.setActionCommand("여자");
				 getGender = group.getSelection().getActionCommand();
				
			}
		});
		
		
		JButton joinHomeBtn = new JButton("");	//홈버튼
		joinHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		joinHomeBtn.setBounds(1503, 27, 70, 54);
		panel3.add(joinHomeBtn);
		joinHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				LoginFrame lf = new LoginFrame(frame);
				
			}
		});
	
		
		JButton idCheck = new JButton("");		//중복확인버튼
		idCheck.setIcon(new ImageIcon("src/buttonImages/중복확인.jpg"));
		idCheck.setBounds(672, 290, 90, 59);
		panel3.add(idCheck);
		idCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				memberManager.idCheck(getIdField.getText());
			}
		});
	
	
		JButton joinBtn = new JButton("");		//회원가입 버튼
		joinBtn.setIcon(new ImageIcon("src/buttonImages/회원가입.jpg"));
		joinBtn.setBounds(832, 727, 379, 68);
		panel3.add(joinBtn);
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				
				String id = getIdField.getText(); 
				String pwd = getPwdField.getText();
				String pwd2 = getPwd2Field.getText();
				String name = getNameField.getText(); 
				String birthDate = getBirthField.getText(); 
				String addr = getAddrField.getText(); 				
				String signupDate = date.format(new Date());
				
				
				if(memberManager.pwdCheck(pwd,pwd2) && 
						memberManager.isBlankCheck(id, pwd2, name, birthDate, addr) && 
						memberManager.birthDateCheck(birthDate)) {					
							
							memberManager.Join(id, pwd, name, 
							addr, birthDate, getGender);
										
					frame.getContentPane().removeAll();
					LoginFrame loginFrame = new LoginFrame(frame);
					
				}
			
			}
		});
		
	}
	

}

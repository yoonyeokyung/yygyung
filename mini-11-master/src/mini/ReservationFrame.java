package mini;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class ReservationFrame  {
	
	
	private String revTime ;
	private int revPrice;
	private JLabel rvePriceL = new JLabel();
		
	
	


	public ReservationFrame(JFrame frame) {
		
		ImagePanel panel6 = new ImagePanel(new ImageIcon("src/images/61.jpg").getImage());
		frame.add(panel6);
		frame.pack();
		
		JLabel revMemberL = new JLabel( MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");
		revMemberL.setFont(new Font("굴림", Font.BOLD, 20));
		revMemberL.setBounds(1272, 40, 224, 32);
		panel6.add(revMemberL);
		
		rvePriceL = new JLabel();
		rvePriceL.setFont(new Font("굴림", Font.BOLD, 20));
		rvePriceL.setBounds(1406, 662, 119, 32);
		panel6.add(rvePriceL);
		
		//============================미용가격 체크 박스 버튼 ========================
		
		JCheckBox[] revPriceCk = new JCheckBox[7]; 
		
		for(int i = 0 ; i < 7 ; i++) {
			revPriceCk[i] = new JCheckBox("");
			panel6.add(revPriceCk[i]);
		}
		
		revPriceCk[0].setBounds(1231, 213, 21, 23);
		revPriceCk[1].setBounds(1231, 261, 21, 23);
		revPriceCk[2].setBounds(1232, 305, 21, 23);
		revPriceCk[3].setBounds(1231, 360, 21, 23);
		revPriceCk[4].setBounds(1232, 409, 21, 23);
		revPriceCk[5].setBounds(1232, 459, 21, 23);
		revPriceCk[6].setBounds(1232, 506, 21, 23);
		
		
		int[] price = {10 , 30, 25, 110, 110, 70, 130};	
		
		for(int i = 0 ; i < revPriceCk.length ; i++) {
		
		revPriceCk[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sum  = 0;
				
				for(int i = 0 ; i < revPriceCk.length ; i++) {
					
					if(revPriceCk[i].isSelected()) {
						sum += price[i];
					}
				
//				System.out.println(sum);
				rvePriceL.setText(sum + ",000원");
				revPrice = sum;
			}
				
			}
		});
		
		}
		
		//============================예약시간 라디오 버튼 ==============================
		ButtonGroup group = new ButtonGroup();
		JRadioButton[] rveTimebtn = new JRadioButton[6];
		
		for(int i = 0 ; i < rveTimebtn.length ; i++) {
			rveTimebtn[i] = new JRadioButton("");
			group.add(rveTimebtn[i]);
			panel6.add(rveTimebtn[i]);
			
		}
		
		rveTimebtn[0].setBounds(387, 707, 22, 23);
		rveTimebtn[1].setBounds(611, 707, 22, 23);
		rveTimebtn[2].setBounds(840, 707, 22, 23);
		rveTimebtn[3].setBounds(387, 781, 22, 23);
		rveTimebtn[4].setBounds(611, 781, 22, 23);
		rveTimebtn[5].setBounds(840, 781, 22, 23);
		

		for(int i = 0 ; i < rveTimebtn.length ; i++) {
			
		rveTimebtn[i].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(rveTimebtn[0].isSelected()) {
					rveTimebtn[0].setActionCommand("10시"); 
					
				}else if(rveTimebtn[1].isSelected()) {
					rveTimebtn[1].setActionCommand("11시");
					
				}else if(rveTimebtn[2].isSelected()) {
					rveTimebtn[2].setActionCommand("12시");
					
				}else if(rveTimebtn[3].isSelected()) {
					rveTimebtn[3].setActionCommand("2시");
					
				}else if(rveTimebtn[4].isSelected()) {
					rveTimebtn[4].setActionCommand("3시");
					
				}else if(rveTimebtn[5].isSelected()) {
					rveTimebtn[5].setActionCommand("4시");
				}
					
				revTime = group.getSelection().getActionCommand();
//				System.out.println(revTime);
				boolean isTrue = false;
				for(int i = 0 ; i < MemberDB.listDB.size() ; i++ ) {
					if(MemberDB.listDB.get(i).getRevTime().equals(revTime)) {
						isTrue = true;
					}
				}
				
				if(isTrue) {
					
//					ImagePanel panel10 = new ImagePanel(new ImageIcon("src/images/10.jpg").getImage());
//	    			frame.getContentPane().add(panel10);
//	    			frame.pack();
//					JOptionPane.showInternalMessageDialog(null, "이미 예약된시간입니다. 다른시간에 예약 부닥드립니다.");
				}else {
//					JOptionPane.showInternalMessageDialog(null, "예약 가능한 시간입니다.");
				}
			}
		});
		
		}
		
		
		
		
				
		
		JButton reserveHomeBtn = new JButton("");
		reserveHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		reserveHomeBtn.setBounds(1193, 30, 49, 42);
		panel6.add(reserveHomeBtn);
		reserveHomeBtn.addActionListener(new ActionListener() {  //홈버튼
			public void actionPerformed(ActionEvent e) {
				
				LoginFrame loginFrame = new LoginFrame(frame);
				frame.getContentPane().removeAll();
			
				
			}
		});
		
		JButton reserveResvervationBtn = new JButton("New button");
		reserveResvervationBtn.setIcon(new ImageIcon("src/buttonImages/예약하기.jpg"));
		reserveResvervationBtn.setBounds(1272, 802, 252, 49);
		panel6.add(reserveResvervationBtn);
		reserveResvervationBtn.addActionListener(new ActionListener() {  //예약하기 버튼
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				
				MemberManager membermanager = new MemberManager();
//				membermanager.resvervation(revPrice ,revTime);
				
				
				
				
				frame.getContentPane().removeAll();
				ReservationConfirmFrame rcf = new ReservationConfirmFrame(frame,membermanager.resvervation(revPrice ,revTime));
				
			}
		});
		

		
	}
		

		
		
	
//	
//		LoginFrame loginFrame = new LoginFrame(frame);
//		frame.getContentPane().removeAll();
//		
//		frame.getContentPane().removeAll();
//		ReservationConfirmFrame rcf = new ReservationConfirmFrame(frame);
//	
}

package mini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ReservationConfirmFrame {
	
	private JFrame frame;
	
	
	public ReservationConfirmFrame(JFrame frame, boolean is) {
		
//		JoinFrame joinframe = new JoinFrame(frame);
		
//		boolean is = false;
		if(is) {
			ImagePanel panel9 = new ImagePanel(new ImageIcon("src/images/9.jpg").getImage());
			frame.add(panel9);		
			frame.pack();
			
			
			JButton revnoBtn = new JButton("New button");
			revnoBtn.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
			revnoBtn.setBounds(898, 486, 177, 53);
			panel9.add(revnoBtn);
			revnoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frame.getContentPane().removeAll();
					ReservationFrame res = new ReservationFrame(frame);
					
					
				}
			});
			
			
			JButton revyesBtn = new JButton("New button");
			revyesBtn.setIcon(new ImageIcon("src/buttonImages/예.png"));
			revyesBtn.setBounds(572, 486, 185, 53);
			panel9.add(revyesBtn);
			revyesBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frame.getContentPane().removeAll();
					LoginFrame loginFrame = new LoginFrame(frame);
					
					
				}
			});
			
		}else {
			ImagePanel panel10 = new ImagePanel(new ImageIcon("src/images/10.jpg").getImage());
			frame.add(panel10);
			frame.pack();
			
			JButton rvenoBtn1 = new JButton("New button");
			rvenoBtn1.setIcon(new ImageIcon("src/buttonImages/예.png"));
			rvenoBtn1.setBounds(731, 484, 184, 49);
			panel10.add(rvenoBtn1);
			rvenoBtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frame.getContentPane().removeAll();
					ReservationFrame res = new ReservationFrame(frame);
					
				}
			});
			
			
		}
		
		
		
	}

		
		
	}
	
	
	

	


package mini;


import javax.swing.JFrame;

public class JFrame1{
	
	
	public JFrame1() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		LoginFrame lf = new LoginFrame(frame);
		
	}

}

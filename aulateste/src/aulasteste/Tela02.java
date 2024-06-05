package aulasteste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Tela02 {

	private JFrame frmMytext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela02 window = new Tela02();
					window.frmMytext.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMytext = new JFrame();
		frmMytext.setTitle("myText");
		frmMytext.setBounds(100, 100, 450, 300);
		frmMytext.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMytext.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("your text right here");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		lblNewLabel.setBounds(24, 50, 400, 96);
		frmMytext.getContentPane().add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(175, 227, 89, 23);
		frmMytext.getContentPane().add(btnExit);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}

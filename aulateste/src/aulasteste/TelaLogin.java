package aulasteste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frmMytext;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMytext = new JFrame();
		frmMytext.setTitle("myText LogIn");
		frmMytext.setBounds(100, 100, 450, 300);
		frmMytext.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMytext.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(105, 99, 212, 20);
		frmMytext.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(105, 74, 46, 14);
		frmMytext.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(105, 130, 75, 14);
		frmMytext.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("SignIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teste", "root", "");
					Statement stmt = con.createStatement();
					String sql = "select * from aluno where login='" + txtUser.getText()+"' and senha='"+txtPassword.getText()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login com Sucesso");
						txtUser.setText(null);
						txtPassword.setText(null);
						Tela02.main(null);
				}else {
						JOptionPane.showMessageDialog(null, "Login não permitido");
						txtUser.setText(null);
						txtPassword.setText(null);
				}
					con.close();
				} catch (Exception e1) {
					
					System.out.print(e1);}
				
				/* String user = txtUser.getText();
				String password = txtPassword.getText();
				Tela02.main(null); */
				
			}
		});
		btnLogin.setBounds(335, 193, 89, 23);
		frmMytext.getContentPane().add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(105, 155, 212, 20);
		frmMytext.getContentPane().add(txtPassword);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText(null);
				txtPassword.setText(null);
			}
		});
		btnClear.setBounds(10, 193, 89, 23);
		frmMytext.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 227, 89, 23);
		frmMytext.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("LogIn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblNewLabel_2.setBounds(161, 11, 106, 64);
		frmMytext.getContentPane().add(lblNewLabel_2);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaCadNovoUsuario exibir = new
				TelaCadNovoUsuario();
				exibir.setVisible(true);
				txtUser.setText(null);
				txtPassword.setText(null);
				TelaCadNovoUsuario.main(null);
				}
				});
		
		btnSignup.setBounds(335, 227, 89, 23);
		frmMytext.getContentPane().add(btnSignup);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

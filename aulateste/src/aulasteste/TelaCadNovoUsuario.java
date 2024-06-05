package aulasteste;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class TelaCadNovoUsuario {

	private JFrame frmSignup;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadNovoUsuario window = new TelaCadNovoUsuario();
					window.frmSignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadNovoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignup = new JFrame();
		frmSignup.setTitle("myText - SignUp");
		frmSignup.setBounds(100, 100, 450, 300);
		frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignup.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(117, 101, 192, 20);
		frmSignup.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(117, 76, 46, 14);
		frmSignup.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(117, 132, 178, 14);
		frmSignup.getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(117, 157, 192, 20);
		frmSignup.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("SignUp");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 50));
		lblNewLabel_2.setBounds(131, 11, 178, 59);
		frmSignup.getContentPane().add(lblNewLabel_2);
		
		JButton btnSalvar = new JButton("SignUp");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "");
				String sql = "Insert into aluno(login, senha) values (?,?) ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, txtUser.getText());
				stmt.setString(2, txtPassword.getText());
				 JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
				TelaLogin abrir = new TelaLogin();
				abrir.setVisible(true);
				txtUser.setText(null);
				txtPassword.setText(null);
				stmt.execute();
				TelaLogin.main(null);
				stmt.close();
				con.close();
				abrir.setVisible(false);
				TelaCadNovoUsuario TelaCadNovoUsuario = new
				TelaCadNovoUsuario();
				TelaCadNovoUsuario.setVisible(false);
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				}
				});
		btnSalvar.setBounds(173, 227, 89, 23);
		frmSignup.getContentPane().add(btnSalvar);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}

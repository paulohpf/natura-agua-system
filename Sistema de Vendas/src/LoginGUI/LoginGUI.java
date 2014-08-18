package LoginGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Funcoes.Login;
import GUI.InsereClientes;
import GUI.ListaClientes;
import GUI.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(80, 50, 62, 14);
		contentPane.add(lblUsuario);
		
		userField = new JTextField();
		userField.setBounds(152, 47, 130, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha:");
		lblPassword.setBounds(80, 75, 46, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 72, 130, 20);
		contentPane.add(passwordField);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int verificalogin = Login.realizaLogin(userField.getText() ,passwordField.getPassword());
				
                                if(verificalogin==1){
                                    new Principal().setVisible(true);
                                    LoginGUI.this.dispose();

                                }
                                
			}
		});
		btnLogin.setBounds(292, 71, 89, 23);
		contentPane.add(btnLogin);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//Quando pressionado o Enter ele vai dar um click no botão Login
		userField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
        
	}
}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
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
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBorder(null);
		panel.setSize(new Dimension(10, 10));
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(160, 56, 280, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(37, 94, 191, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblNewLabel.setBounds(37, 130, 83, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblNewLabel_1.setBounds(37, 69, 83, 14);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(37, 153, 191, 25);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(94, 11, 88, 35);
		panel.add(lblNewLabel_2);
		
		JButton btnButtonCadastro = new JButton("REALIZAR CADASTRO");
		btnButtonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCadastroView cadastroView = new FormCadastroView();
				cadastroView.setVisible(true);
			}
		});
		btnButtonCadastro.setOpaque(false);
		btnButtonCadastro.setBackground(new Color(240, 240, 240));
		btnButtonCadastro.setForeground(new Color(255, 255, 255));
		btnButtonCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnButtonCadastro.setBorder(null);
		btnButtonCadastro.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		btnButtonCadastro.setBounds(37, 301, 191, 23);
		panel.add(btnButtonCadastro);
		
		JButton btnButtonLogin = new JButton("ENTRAR");
		btnButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuView menuView = new MenuView();
				menuView.setVisible(true);
			}
		});
		btnButtonLogin.setContentAreaFilled(false);
		btnButtonLogin.setBorderPainted(false);
		btnButtonLogin.setOpaque(false);
		btnButtonLogin.setBorder(null);
		btnButtonLogin.setForeground(new Color(255, 255, 255));
		btnButtonLogin.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		btnButtonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnButtonLogin.setBounds(61, 234, 149, 25);
		panel.add(btnButtonLogin);
	}
}

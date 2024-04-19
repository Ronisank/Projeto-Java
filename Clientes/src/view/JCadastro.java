package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Cliente;

public class JCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPFCNPJ;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro(null, null);
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
	public JCadastro(Cliente clienteSelecionado, JPrincipal jPrincipal) {
		DAO dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 11, 46, 20);
		contentPane.add(lblNewLabel);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 36, 414, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CPF/CNPJ");
		lblNewLabel_1.setBounds(10, 67, 65, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(216, 67, 52, 20);
		contentPane.add(lblNewLabel_2);

		textFieldCPFCNPJ = new JTextField();
		textFieldCPFCNPJ.setBounds(10, 92, 196, 20);
		contentPane.add(textFieldCPFCNPJ);
		textFieldCPFCNPJ.setColumns(10);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(216, 92, 208, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(10, 123, 52, 20);
		contentPane.add(lblNewLabel_3);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 142, 414, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setBounds(10, 180, 65, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton = new JButton(clienteSelecionado == null ? "Incluir" : "Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					

				Cliente cliente = new Cliente(textFieldNome.getText(), textFieldCPFCNPJ.getText(),
						textFieldEmail.getText(), textFieldTelefone.getText(), textFieldEndereco.getText());

				if(clienteSelecionado == null) { 
					if(!"".equalsIgnoreCase(textFieldNome.getText()) && !"".equalsIgnoreCase(textFieldCPFCNPJ.getText())) {
						dao.cadastarCliente(cliente);
						//JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
						abrirTelaPrincipal(jPrincipal);
					}else {
						JOptionPane.showMessageDialog(null, "Confira os campos Nome e CPF/CNPJ");
					}

				} else {
					if(!"".equalsIgnoreCase(textFieldNome.getText()) && !"".equalsIgnoreCase(textFieldCPFCNPJ.getText())) {
						dao.alterarCliente(clienteSelecionado.getId(), cliente);
						//JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
						abrirTelaPrincipal(jPrincipal);
					}else {
						JOptionPane.showMessageDialog(null, "Confira os campos Nome e CPF/CNPJ");
					}
				}
			}
		});
		btnNewButton.setBounds(335, 294, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.excluirCliente(clienteSelecionado.getId());
				abrirTelaPrincipal(jPrincipal);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 294, 89, 23);
		btnNewButton_1.setVisible(false);
		contentPane.add(btnNewButton_1);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(10, 199, 414, 72);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);

		if(clienteSelecionado != null) { 
			preencherCampos(clienteSelecionado);
			btnNewButton_1.setVisible(true);
		}
	}
	private void preencherCampos(Cliente clienteSelecionado) {
		textFieldNome.setText(clienteSelecionado.getNome());
		textFieldCPFCNPJ.setText(clienteSelecionado.getCpfCnpj());
		textFieldEmail.setText(clienteSelecionado.getEmail());
		textFieldTelefone.setText(clienteSelecionado.getTelefone());
		textFieldEndereco.setText(clienteSelecionado.getEndereco());
	}
	private void abrirTelaPrincipal(JPrincipal jPrincipal) {
		jPrincipal.dispose();
		dispose();
		jPrincipal = new JPrincipal();
		jPrincipal.setLocationRelativeTo(jPrincipal);
		jPrincipal.setVisible(true);
	}
}

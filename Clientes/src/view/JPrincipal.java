package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ModeloTabela;

import javax.swing.JScrollPane;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ArrayList<Cliente> clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		clientes = new ArrayList<>();
		clientes.add(new Cliente("1", "Roni", "Roni@email.com", "999.999.999-99", "99999-9999", "Não informado"));
		clientes.add(new Cliente("2", "Arthur", "Arthur@email.com", "999.888.999-99", "99999-8888", "Não informado"));
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(10, 39, 195, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(227, 40, 423, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 640, 347);
		contentPane.add(scrollPane);
		
		ModeloTabela modeloTabela = new ModeloTabela(clientes);
		
		table = new JTable();
		table.setModel(modeloTabela);
		scrollPane.setViewportView(table);
		
	}
}

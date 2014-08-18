package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import Funcoes.Banco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JLabel lblEndereo;
	private JTextField enderecoField;
	private JLabel lblTelefone;
	private JTextField telefoneField;
	private JLabel lblBairro;
	private JTextField bairroField;
	private JLabel lblCpf;
	private JTextField cpfField;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JLabel lblDataDeNascimento;
	private JTextField nascimentoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoCliente frame = new NovoCliente();
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
	public NovoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label = new JLabel("Nome: ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		nomeField = new JTextField();
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.gridwidth = 2;
		gbc_nomeField.insets = new Insets(0, 0, 5, 0);
		gbc_nomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeField.gridx = 2;
		gbc_nomeField.gridy = 0;
		contentPane.add(nomeField, gbc_nomeField);
		nomeField.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o: ");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.WEST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 1;
		gbc_lblEndereo.gridy = 1;
		contentPane.add(lblEndereo, gbc_lblEndereo);
		
		enderecoField = new JTextField();
		GridBagConstraints gbc_enderecoField = new GridBagConstraints();
		gbc_enderecoField.gridwidth = 2;
		gbc_enderecoField.insets = new Insets(0, 0, 5, 0);
		gbc_enderecoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_enderecoField.gridx = 2;
		gbc_enderecoField.gridy = 1;
		contentPane.add(enderecoField, gbc_enderecoField);
		enderecoField.setColumns(10);
		
		lblBairro = new JLabel("Bairro: ");
		lblBairro.setToolTipText("");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.WEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 1;
		gbc_lblBairro.gridy = 2;
		contentPane.add(lblBairro, gbc_lblBairro);
		
		bairroField = new JTextField();
		GridBagConstraints gbc_bairroField = new GridBagConstraints();
		gbc_bairroField.gridwidth = 2;
		gbc_bairroField.insets = new Insets(0, 0, 5, 0);
		gbc_bairroField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bairroField.gridx = 2;
		gbc_bairroField.gridy = 2;
		contentPane.add(bairroField, gbc_bairroField);
		bairroField.setColumns(10);
		
		lblTelefone = new JLabel("Telefone: ");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.WEST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 3;
		contentPane.add(lblTelefone, gbc_lblTelefone);
		
		telefoneField = new JTextField();
		GridBagConstraints gbc_telefoneField = new GridBagConstraints();
		gbc_telefoneField.gridwidth = 2;
		gbc_telefoneField.insets = new Insets(0, 0, 5, 0);
		gbc_telefoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefoneField.gridx = 2;
		gbc_telefoneField.gridy = 3;
		contentPane.add(telefoneField, gbc_telefoneField);
		telefoneField.setColumns(10);
		
		lblCpf = new JLabel("CPF: ");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.WEST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 1;
		gbc_lblCpf.gridy = 4;
		contentPane.add(lblCpf, gbc_lblCpf);
		
		cpfField = new JTextField();
		GridBagConstraints gbc_cpfField = new GridBagConstraints();
		gbc_cpfField.gridwidth = 2;
		gbc_cpfField.insets = new Insets(0, 0, 5, 0);
		gbc_cpfField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpfField.gridx = 2;
		gbc_cpfField.gridy = 4;
		contentPane.add(cpfField, gbc_cpfField);
		cpfField.setColumns(10);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		GridBagConstraints gbc_lblDataDeNascimento = new GridBagConstraints();
		gbc_lblDataDeNascimento.anchor = GridBagConstraints.EAST;
		gbc_lblDataDeNascimento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDeNascimento.gridx = 1;
		gbc_lblDataDeNascimento.gridy = 5;
		contentPane.add(lblDataDeNascimento, gbc_lblDataDeNascimento);
		
		nascimentoField = new JTextField();
		GridBagConstraints gbc_nascimentoField = new GridBagConstraints();
		gbc_nascimentoField.gridwidth = 2;
		gbc_nascimentoField.insets = new Insets(0, 0, 5, 5);
		gbc_nascimentoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nascimentoField.gridx = 2;
		gbc_nascimentoField.gridy = 5;
		contentPane.add(nascimentoField, gbc_nascimentoField);
		nascimentoField.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Banco.insereCliente(nomeField.getText(), enderecoField.getText(), bairroField.getText(), telefoneField.getText(), cpfField.getText(), nascimentoField.getText());
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 9;
		contentPane.add(btnSalvar, gbc_btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 9;
		contentPane.add(btnCancelar, gbc_btnCancelar);
	}

}

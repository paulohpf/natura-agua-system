package GUI;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Funcoes.Banco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class InsereClientes extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField enderecoField;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JComboBox cidadeComboBox;
	private ArrayList<String> cidades;
	private ArrayList<String> rua;
	private DefaultComboBoxModel model2;
	private JLabel lblTelefone;
	private MaskFormatter ftmTel;
	private MaskFormatter ftmCel;
	private MaskFormatter ftmCPF;
	private MaskFormatter ftmNascimento;
	private MaskFormatter ftmCEP;
	private JLabel lblBairro;
	private JTextField bairroField;
	private JLabel lblCelular;
	private JLabel lblCPF;
	private JFormattedTextField formattedCEP;
	private JLabel lblNumero;
	private JTextField numeroField;
	private JLabel lblComplemento;
	private JTextField complementoField;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsereClientes frame = new InsereClientes();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setTitle("Cadastrar Novo Cliente");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InsereClientes() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(76, 8, 340, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 36, 59, 14);
		contentPane.add(lblTelefone);

		ftmTel = new MaskFormatter("(##)####-####");
		final JFormattedTextField formattedTel = new JFormattedTextField(ftmTel);
		formattedTel.setBounds(76, 33, 101, 20);
		contentPane.add(formattedTel);

		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(187, 36, 46, 14);
		contentPane.add(lblCelular);

		ftmCel = new MaskFormatter("(##)#####-####");
		final JFormattedTextField formattedCel = new JFormattedTextField(ftmCel);
		formattedCel.setBounds(243, 33, 101, 20);
		contentPane.add(formattedCel);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 61, 46, 14);
		contentPane.add(lblCpf);

		ftmCPF = new MaskFormatter("###.###.###-##");
		final JFormattedTextField formattedCPF = new JFormattedTextField(ftmCPF);
		formattedCPF.setBounds(76, 58, 101, 20);
		contentPane.add(formattedCPF);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 111, 59, 14);
		contentPane.add(lblEndereo);

		enderecoField = new JTextField();
		enderecoField.setBounds(76, 108, 340, 20);
		contentPane.add(enderecoField);
		enderecoField.setColumns(10);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(262, 189, 46, 14);
		contentPane.add(lblEstado);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 161, 46, 14);
		contentPane.add(lblBairro);

		bairroField = new JTextField();
		bairroField.setBounds(76, 158, 340, 20);
		contentPane.add(bairroField);
		bairroField.setColumns(10);

		// chamo o cidadeComboBox antes do estadoComboBox
		cidadeComboBox = new JComboBox();
		cidadeComboBox.setEnabled(false);

		final JComboBox estadoComboBox = new JComboBox();
		ArrayList<String> estados = new ArrayList<String>(
				Banco.retornaEstados());
		DefaultComboBoxModel model = new DefaultComboBoxModel(estados.toArray());
		estadoComboBox.setModel(model);
		estadoComboBox.setBounds(316, 183, 46, 26);
		estadoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cidades = new ArrayList<String>(Banco
						.retornaCidades(estadoComboBox.getSelectedItem()
								.toString()));
				model2 = new DefaultComboBoxModel(cidades.toArray());
				cidadeComboBox.setModel(model2);
				cidadeComboBox.setEnabled(true);
			}
		});
		contentPane.add(estadoComboBox);

		lblCidade = new JLabel("Cidade: ");
		lblCidade.setBounds(10, 186, 46, 14);
		contentPane.add(lblCidade);

		cidadeComboBox.setBounds(76, 182, 176, 22);
		contentPane.add(cidadeComboBox);

		lblCPF = new JLabel("CEP:");
		lblCPF.setBounds(187, 61, 46, 14);
		contentPane.add(lblCPF);

		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(10, 86, 76, 14);
		contentPane.add(lblNascimento);

		ftmNascimento = new MaskFormatter("##/##/####");
		final JFormattedTextField formattedNascimento;
		formattedNascimento = new JFormattedTextField(ftmNascimento);
		formattedNascimento.setBounds(86, 83, 101, 20);
		contentPane.add(formattedNascimento);

		ftmCEP = new MaskFormatter("#####-###");
		formattedCEP = new JFormattedTextField(ftmCEP);
		formattedCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rua = new ArrayList<String>(Banco.retornaCEP(formattedCEP
						.getText().toString()));
				enderecoField.setText(rua.get(0));
				bairroField.setText(rua.get(1));
				estadoComboBox.setSelectedItem(rua.get(2));
				cidadeComboBox.setSelectedItem(rua.get(3));
			}
		});
		formattedCEP.setBounds(243, 58, 101, 20);
		contentPane.add(formattedCEP);

		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 136, 59, 14);
		contentPane.add(lblNumero);

		numeroField = new JTextField();
		numeroField.setBounds(76, 133, 86, 20);
		contentPane.add(numeroField);
		numeroField.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(172, 136, 86, 14);
		contentPane.add(lblComplemento);

		complementoField = new JTextField();
		complementoField.setBounds(258, 133, 86, 20);
		contentPane.add(complementoField);
		complementoField.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(InsereClientes.class.getResource("/imagens/data_disk.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cidadeComboBox.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null,
							"Por Favor escolha uma cidade!",
							"Erro de validação", JOptionPane.ERROR_MESSAGE);
				} else {

					String cidade = (cidadeComboBox.getSelectedItem())
							.toString();
					String estado = (estadoComboBox.getSelectedItem())
							.toString();

					Banco.insereCliente(nomeField.getText(),
							formattedTel.getText(), formattedCel.getText(),
							formattedCPF.getText(),
							formattedNascimento.getText(),
							formattedCEP.getText(), enderecoField.getText(),
							numeroField.getText(), complementoField.getText(),
							bairroField.getText(), cidade, estado);
				}
				InsereClientes.this.dispose();
			}
		});
		btnCadastrar.setBounds(10, 239, 115, 23);
		contentPane.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(InsereClientes.class.getResource("/imagens/erro.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsereClientes.this.dispose();
			}
		});
		btnCancelar.setBounds(306, 239, 110, 23);
		contentPane.add(btnCancelar);

		JButton btnLimparTudo = new JButton("Limpar Tudo");
		btnLimparTudo.setIcon(new ImageIcon(InsereClientes.class.getResource("/imagens/clear.png")));
		btnLimparTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeField.setText("");
				formattedTel.setText("");
				formattedCel.setText("");
				formattedCPF.setText("");
				formattedNascimento.setText("");
				formattedCEP.setText("");
				enderecoField.setText("");
				numeroField.setText("");
				complementoField.setText("");
				bairroField.setText("");
			}
		});
		btnLimparTudo.setBounds(156, 239, 125, 23);
		contentPane.add(btnLimparTudo);

		JButton btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					rua = new ArrayList<String>(Banco.retornaCEP(formattedCEP
							.getText().toString()));
					enderecoField.setText(rua.get(0));
					bairroField.setText(rua.get(1));
					estadoComboBox.setSelectedItem(rua.get(2));
					cidadeComboBox.setSelectedItem(rua.get(3));

				}
		});
		btnConsultar
				.setIcon(new ImageIcon(InsereClientes.class.getResource("/imagens/consultar.png")));
		btnConsultar.setBounds(354, 58, 20, 20);
		contentPane.add(btnConsultar);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
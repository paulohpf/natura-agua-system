package GUI;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
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

public class ClientesMain extends JFrame {

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
	private MaskFormatter ftmCEP;
	private JLabel lblBairro;
	private JTextField bairroField;
	private JLabel lblCelular;
	private JTextField celularField;
	private JLabel lblCPF;
	private JFormattedTextField formattedCEP;
	private JLabel lblNumero;
	private JTextField numeroField;
	private JLabel lblComplemento;
	private JTextField complementoField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesMain frame = new ClientesMain();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClientesMain() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
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
		JFormattedTextField formattedTel = new JFormattedTextField(ftmTel);
		formattedTel.setBounds(76, 33, 101, 20);
		contentPane.add(formattedTel);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(187, 36, 46, 14);
		contentPane.add(lblCelular);
		
		ftmCel = new MaskFormatter("(##)#####-####");
		JFormattedTextField formattedCel = new JFormattedTextField(ftmCel);
		formattedCel.setBounds(243, 33, 101, 20);
		contentPane.add(formattedCel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 61, 46, 14);
		contentPane.add(lblCpf);
		
		ftmCPF = new MaskFormatter("###.###.###-##");
		JFormattedTextField formattedCPF = new JFormattedTextField(ftmCPF);
		formattedCPF.setBounds(76, 58, 101, 20);
		contentPane.add(formattedCPF);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 86, 59, 14);
		contentPane.add(lblEndereo);
		
		enderecoField = new JTextField();
		enderecoField.setBounds(76, 83, 340, 20);
		contentPane.add(enderecoField);
		enderecoField.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(262, 161, 46, 14);
		contentPane.add(lblEstado);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 136, 46, 14);
		contentPane.add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(76, 133, 340, 20);
		contentPane.add(bairroField);
		bairroField.setColumns(10);
		
		//chamo o cidadeComboBox antes do estadoComboBox
		cidadeComboBox = new JComboBox();
		cidadeComboBox.setEnabled(false);
		
		final JComboBox estadoComboBox = new JComboBox();
		ArrayList<String> estados = new ArrayList<String>(Banco.retornaEstados());
		DefaultComboBoxModel model = new DefaultComboBoxModel(estados.toArray());
		estadoComboBox.setModel(model);
		estadoComboBox.setBounds(318, 155, 46, 26);
		estadoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			cidades = new ArrayList<String>(Banco.retornaCidades(estadoComboBox.getSelectedItem().toString()));
			model2 = new DefaultComboBoxModel(cidades.toArray());
			cidadeComboBox.setModel(model2);
			cidadeComboBox.setEnabled(true);
			}
		});
		contentPane.add(estadoComboBox);
		
		lblCidade = new JLabel("Cidade: ");
		lblCidade.setBounds(10, 161, 46, 14);
		contentPane.add(lblCidade);
		
		cidadeComboBox.setBounds(76, 157, 176, 22);
		contentPane.add(cidadeComboBox);
		
		lblCPF = new JLabel("CEP:");
		lblCPF.setBounds(187, 61, 46, 14);
		contentPane.add(lblCPF);
		
		ftmCEP = new MaskFormatter("#####-###");
		formattedCEP = new JFormattedTextField(ftmCEP);
		formattedCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rua = new ArrayList<String>(Banco.retornaCEP(formattedCEP.getText().toString()));
				enderecoField.setText(rua.get(0));
				bairroField.setText(rua.get(1));
				estadoComboBox.setSelectedItem(rua.get(2));
				cidadeComboBox.setSelectedItem(rua.get(3));
				System.out.println(rua.get(0));
				System.out.println(rua.get(1));
				System.out.println(rua.get(2));
				System.out.println(rua.get(3));
			}
		});
		formattedCEP.setBounds(243, 58, 101, 20);
		contentPane.add(formattedCEP);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 111, 59, 14);
		contentPane.add(lblNumero);
		
		numeroField = new JTextField();
		numeroField.setBounds(76, 108, 86, 20);
		contentPane.add(numeroField);
		numeroField.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(187, 111, 86, 14);
		contentPane.add(lblComplemento);
		
		complementoField = new JTextField();
		complementoField.setBounds(278, 108, 86, 20);
		contentPane.add(complementoField);
		complementoField.setColumns(10);
	}
}

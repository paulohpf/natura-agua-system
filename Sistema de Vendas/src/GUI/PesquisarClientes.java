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
import java.awt.event.KeyListener;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PesquisarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField enderecoField;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JComboBox cidadeComboBox;
	private ArrayList<String> cidades;
	private DefaultComboBoxModel model2;
	private JLabel lblNewLabel;
	private MaskFormatter ftmTel;
	private MaskFormatter ftmCel;
	private JLabel lblBairro;
	private JTextField bairroField;
	private JLabel lblCelular;
	private JTextField celularField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesMain frame = new ClientesMain();
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
	public PesquisarClientes() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
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
		KeyListener l = null;
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 105, 59, 14);
		contentPane.add(lblEndereo);
		
		enderecoField = new JTextField();
		enderecoField.setBounds(76, 99, 340, 20);
		contentPane.add(enderecoField);
		enderecoField.setColumns(10);
		
		lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(10, 36, 59, 26);
		contentPane.add(lblNewLabel);
		
		ftmTel = new MaskFormatter("(##)####-####");
		JFormattedTextField formattedTel = new JFormattedTextField(ftmTel);
		formattedTel.setBounds(76, 39, 101, 20);
		contentPane.add(formattedTel);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 73, 46, 14);
		contentPane.add(lblCelular);
		
		ftmCel = new MaskFormatter("(##)#####-####");
		JFormattedTextField formattedCel = new JFormattedTextField(ftmCel);
		formattedCel.setBounds(76, 70, 101, 20);
		contentPane.add(formattedCel);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(262, 164, 46, 22);
		contentPane.add(lblEstado);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 130, 46, 27);
		contentPane.add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(76, 133, 340, 20);
		contentPane.add(bairroField);
		bairroField.setColumns(10);
		
		//chamo o cidadeComboBox antes do estadoComboBox
		cidadeComboBox = new JComboBox();
		cidadeComboBox.setEnabled(false);
		
		final JComboBox estadoComboBox = new JComboBox();
		estadoComboBox.setEditable(true);
		ArrayList<String> estados = new ArrayList<String>(Banco.retornaEstados());
		DefaultComboBoxModel model = new DefaultComboBoxModel(estados.toArray());
		estadoComboBox.setModel(model);
		estadoComboBox.setBounds(318, 162, 46, 26);
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
		lblCidade.setBounds(10, 168, 46, 14);
		contentPane.add(lblCidade);
		
		cidadeComboBox.setBounds(76, 164, 176, 22);
		contentPane.add(cidadeComboBox);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Funcoes.Banco;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ListaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField pesquisarField;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaClientes frame = new ListaClientes();
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
	public ListaClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null,
						null, null, null, null, null }, }, new String[] { "ID",
						"Nome", "Telefone", "Celular", "CPF", "Nascimento",
						"CEP", "Endereço", "Numero", "Complemento", "Bairro",
						"Cidade", "Estado" }) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		});
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// table.setBounds(10, 11, 612, 397);
		// contentPane.add(table);
		JScrollPane pictureScrollPane = new JScrollPane(table);
		pictureScrollPane.setBounds(10, 45, 612, 397);
		contentPane.add(pictureScrollPane);
		Banco.listaClientes(table);

		btnInserir = new JButton("Inserir Novo");
		btnInserir.setIcon(new ImageIcon(ListaClientes.class.getResource("/imagens/add.png")));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new InsereClientes().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInserir.setBounds(10, 453, 125, 23);
		contentPane.add(btnInserir);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ListaClientes.class.getResource("/imagens/update.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = table.getSelectedRow();
				int y = table.getSelectedColumn();
				System.out.println("Valor de X(Horizontal)= " + x);
				System.out.println("Valor de Y(Vertical)= " + y);
				if (x == -1) {
					JOptionPane.showMessageDialog(null,
							"Selecione um cliente para ser alterado!", "Erro!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						AlteraClientes alterar = new AlteraClientes();

						alterar.setId(table.getValueAt(x, 0).toString());

						alterar.main(null);

						// alterar.setVisible(true);

					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				// AlteraClientes(table.getValueAt(x, 0).toString(), table
				// .getValueAt(x, 1).toString(), table.getValueAt(x, 2)
				// .toString(), table.getValueAt(x, 3).toString(), table
				// .getValueAt(x, 4).toString(), table.getValueAt(x, 5)
				// .toString(), table.getValueAt(x, 6).toString(), table
				// .getValueAt(x, 7).toString(), table.getValueAt(x, 8)
				// .toString(), table.getValueAt(x, 9).toString(), table
				// .getValueAt(x, 10).toString(), table.getValueAt(x, 11)
				// .toString(), table.getValueAt(x, 12).toString());
			}
		});
		btnAlterar.setBounds(156, 453, 96, 23);
		contentPane.add(btnAlterar);

		btnCancelar = new JButton("Deletar");
		btnCancelar.setIcon(new ImageIcon(ListaClientes.class.getResource("/imagens/delete.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = 0;
				int x = table.getSelectedRow();
				if (x != -1) {
					opcao = JOptionPane.showConfirmDialog(null,
							"Deseja realmente excluir o cliente?");
					if (opcao == JOptionPane.YES_OPTION) {
						Banco.deletaCliente(table.getValueAt(x, 0).toString());
						Banco.listaClientes(table);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Selecione um cliente!",
							"Erro!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCancelar.setBounds(280, 453, 96, 23);
		contentPane.add(btnCancelar);
		
		pesquisarField = new JTextField();
		pesquisarField.setBounds(164, 12, 172, 20);
		contentPane.add(pesquisarField);
		pesquisarField.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pesquisarField.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null,
							"O campo de pesquisa está vazio!", "Erro!",
							JOptionPane.ERROR_MESSAGE);
				}else{
				Banco.PesquisaCliente(table, pesquisarField.getText().toString());
				}
			}
		});
		btnPesquisar.setIcon(new ImageIcon(ListaClientes.class.getResource("/imagens/consultar.png")));
		btnPesquisar.setBounds(346, 11, 115, 23);
		contentPane.add(btnPesquisar);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
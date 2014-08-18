package Funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Banco {

	public static Connection conexao() {

		Connection conn = null;

		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/vendas";
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			System.err.println("Não foi possível estabelecer conexão com o BD");
			JOptionPane.showMessageDialog(null, e, "alert",
					JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}

	public static ArrayList<String> retornaEstados() {

		Connection conn = Banco.conexao();

		ArrayList<String> estados = new ArrayList<String>();
		String query = "SELECT uf FROM tb_estados";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String uf = rs.getString("uf");
				// add group names to the array list
				estados.add(uf);
			}

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estados;
	}

	public static ArrayList<String> retornaCidades(String estado) {

		Connection conn = Banco.conexao();

		ArrayList<String> cidade = new ArrayList<String>();

		String query = "SELECT nome FROM tb_cidades WHERE uf = \"" + estado
				+ "\" ";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String nome = rs.getString("nome");
				// add group names to the array list
				cidade.add(nome);
			}

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cidade;
	}

	public static ArrayList<String> retornaCEP(String cep) {

		Connection conn = Banco.conexao();

		ArrayList<String> info = new ArrayList<String>();

		String query = "SELECT logradouro, bairro, cidade, estado FROM tb_cep WHERE cep = \""
				+ cep.replace("-", "") + "\"";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String logradouro = rs.getString("logradouro");
				String bairro = rs.getString("bairro");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");

				// add group names to the array list
				info.add(logradouro);
				info.add(bairro);
				info.add(estado);
				info.add(cidade);
			}

			rs.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	public static void insereCliente(String nome, String telefone,
			String celular, String cpf, String nascimento, String cep,
			String endereco, String numero, String complemento, String bairro,
			String cidade, String estado) {

		Connection conn = conexao();

		String sql = "INSERT into clientes (nome, telefone, celular, cpf, nascimento, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, telefone);
			stmt.setString(3, celular);
			stmt.setString(4, cpf);
			stmt.setString(5, nascimento);
			stmt.setString(6, cep);
			stmt.setString(7, endereco);
			stmt.setString(8, numero);
			stmt.setString(9, complemento);
			stmt.setString(10, bairro);
			stmt.setString(11, cidade);
			stmt.setString(12, estado);

			stmt.execute();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel adicionar",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);
			// e.printStackTrace();
		}
	}

	public static void PesquisaCliente(JTable table,String nome) {

		Connection conn = conexao();

		String sql = "SELECT * FROM clientes WHERE nome like '%"+nome+"%' ORDER BY id ASC";

		try {

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			javax.swing.table.DefaultTableModel dtm2 = (javax.swing.table.DefaultTableModel) table
					.getModel();
			dtm2.setNumRows(0);
			int x = 0;
			while (rs.next()) {
				dtm2.addRow(new Object[] { " ", " ", " ", " ", " ", " ", " ",
						" ", " ", " ", " ", " ", " " });
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setValueAt(rs.getString(1), x, 0);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.setValueAt(rs.getString(2), x, 1);
				table.getColumnModel().getColumn(1).setPreferredWidth(240);
				table.setValueAt(rs.getString(3), x, 2);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.setValueAt(rs.getString(4), x, 3);
				table.getColumnModel().getColumn(3).setPreferredWidth(100);
				table.setValueAt(rs.getString(5), x, 4);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.setValueAt(rs.getString(6), x, 5);
				table.getColumnModel().getColumn(5).setPreferredWidth(100);
				table.setValueAt(rs.getString(7), x, 6);
				table.getColumnModel().getColumn(6).setPreferredWidth(70);
				table.setValueAt(rs.getString(8), x, 7);
				table.getColumnModel().getColumn(7).setPreferredWidth(240);
				table.setValueAt(rs.getString(9), x, 8);
				table.setValueAt(rs.getString(10), x, 9);
				table.getColumnModel().getColumn(9).setPreferredWidth(100);
				table.setValueAt(rs.getString(11), x, 10);
				table.getColumnModel().getColumn(10).setPreferredWidth(200);
				table.setValueAt(rs.getString(12), x, 11);
				table.getColumnModel().getColumn(11).setPreferredWidth(140);
				table.setValueAt(rs.getString(13), x, 12);
				x++;
			}

			conn.close();
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listaClientes(JTable table) {

		Connection conn = conexao();

		String sql = "SELECT * from clientes ORDER BY id ASC";

		try {

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			javax.swing.table.DefaultTableModel dtm2 = (javax.swing.table.DefaultTableModel) table
					.getModel();
			dtm2.setNumRows(0);
			int x = 0;
			while (rs.next()) {
				dtm2.addRow(new Object[] { " ", " ", " ", " ", " ", " ", " ",
						" ", " ", " ", " ", " ", " " });
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setValueAt(rs.getString(1), x, 0);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.setValueAt(rs.getString(2), x, 1);
				table.getColumnModel().getColumn(1).setPreferredWidth(240);
				table.setValueAt(rs.getString(3), x, 2);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.setValueAt(rs.getString(4), x, 3);
				table.getColumnModel().getColumn(3).setPreferredWidth(100);
				table.setValueAt(rs.getString(5), x, 4);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.setValueAt(rs.getString(6), x, 5);
				table.getColumnModel().getColumn(5).setPreferredWidth(100);
				table.setValueAt(rs.getString(7), x, 6);
				table.getColumnModel().getColumn(6).setPreferredWidth(70);
				table.setValueAt(rs.getString(8), x, 7);
				table.getColumnModel().getColumn(7).setPreferredWidth(240);
				table.setValueAt(rs.getString(9), x, 8);
				table.setValueAt(rs.getString(10), x, 9);
				table.getColumnModel().getColumn(9).setPreferredWidth(100);
				table.setValueAt(rs.getString(11), x, 10);
				table.getColumnModel().getColumn(10).setPreferredWidth(200);
				table.setValueAt(rs.getString(12), x, 11);
				table.getColumnModel().getColumn(11).setPreferredWidth(140);
				table.setValueAt(rs.getString(13), x, 12);
				x++;
			}

			conn.close();
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String[] retornaClienteBD(String id){
		
		Connection conn = conexao();
		
		String sql = "Select * from clientes Where id = \""+ id + "\"";
		
		String[] clientebd = new String[13];
		
		try {
			PreparedStatement stmt = null; //= conn.prepareStatement(sql);
			
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				//Crio um array para armazenar as informações do cliente em apenas 1 variavel				
				clientebd[0] = rs.getString("nome");
				clientebd[1] = rs.getString("telefone");
				clientebd[2] = rs.getString("celular");
				clientebd[3] = rs.getString("cpf");
				clientebd[4] = rs.getString("nascimento");
				clientebd[5] = rs.getString("cep");
				clientebd[6] = rs.getString("endereco");
				clientebd[7] = rs.getString("numero");
				clientebd[8] = rs.getString("complemento");
				clientebd[9] = rs.getString("bairro");
				clientebd[10] = rs.getString("estado");
				clientebd[11] = rs.getString("cidade");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return clientebd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientebd;
		
	}

	public static void alteraCliente(String id, String nome, String telefone,
			String celular, String cpf, String nascimento, String cep,
			String endereco, String numero, String complemento, String bairro,
			String cidade, String estado) {

		Connection conn = conexao();

		String sql = "update clientes set nome=\"" + nome + "\", telefone=\""
				+ telefone + "\", celular=\"" + celular + "\", cpf=\"" + cpf
				+ "\", nascimento=\"" + nascimento + "\", cep=\"" + cep
				+ "\", endereco=\"" + endereco + "\", numero=\"" + numero
				+ "\", complemento=\"" + complemento + "\", bairro=\"" + bairro
				+ "\", cidade=\"" + cidade + "\", estado=\"" + estado
				+ "\" where id=" + id;

		System.out.println(sql);

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.execute();
			stmt.close();
			conn.close();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!",
					"Alterações salvas", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,
					"Não foi possivel realizar alteração!", "Erro!",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public static void deletaCliente(String id) {
		
		Connection conn = conexao();
		
		String sql = "delete from clientes where id=\""+ id +"\"";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.execute();
			stmt.close();
			conn.close();
			JOptionPane.showMessageDialog(null,
					"Cliente deletado com Sucesso!", "Alterações salvas",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
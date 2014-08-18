package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JSpinner;

public class TesteFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteFrame frame = new TesteFrame();
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
	public TesteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[][] data = {
				{"João", "Carlos", "Natação", new Integer(5)},
				{"Paulo Henrique", "Palmeira Franco", "Video Games", new Integer(5)},
				{"Paulo Henrique", "Palmeira Franco", "Video Games", new Integer(5)}
		};
		
		String[] colunas = {"Nome", "Sobrenome", "Esporte", "Prática (ano)"};
		
		DefaultTableModel tm = new DefaultTableModel(data, colunas);
		
		table = new JTable(tm);
		table.setRowSelectionAllowed(false);
		table.setBounds(10, 11, 422, 161);
		contentPane.add(table);
		
		String[][] lista = new String[2][2];
		
		lista[0][0]="Ola Mundo";
		lista[0][1]=" em Java!";
		lista[1][0]="Este é um teste ";
		lista[1][1]="de matriz!";
		
		System.out.println(lista[0][0]+lista[0][1]);
	
		System.out.println(lista[1][0]+lista[1][1]);
		
	}
}

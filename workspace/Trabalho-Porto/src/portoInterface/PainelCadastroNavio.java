package portoInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelCadastroNavio extends JPanel {
	private JTextField textMatricula;
	private JTextField textTransportadora;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelCadastroNavio() {
		setBackground(Color.YELLOW);
		setLayout(null);
		
		JLabel lblCadastroDeNavios = new JLabel("Cadastro de Navio");
		lblCadastroDeNavios.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblCadastroDeNavios.setBounds(10, 22, 356, 37);
		add(lblCadastroDeNavios);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula: *");
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatrcula.setBounds(10, 81, 79, 14);
		add(lblMatrcula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(167, 114, 155, 20);
		add(textMatricula);
		textMatricula.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(233, 145, 89, 23);
		add(btnSalvar);
		
		JLabel lblNomeTransportadora = new JLabel("Nome Transportadora: *");
		lblNomeTransportadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeTransportadora.setBounds(10, 120, 172, 14);
		add(lblNomeTransportadora);
		
		textTransportadora = new JTextField();
		textTransportadora.setBounds(167, 75, 155, 20);
		add(textTransportadora);
		textTransportadora.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 172, 387, 117);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matrícula", "Nome Transportadora"
			}
		));
		scrollPane.setViewportView(table);

	}
}

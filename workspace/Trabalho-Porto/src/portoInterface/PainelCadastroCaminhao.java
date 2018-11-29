package portoInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PainelCadastroCaminhao extends JPanel {
	private JTextField textPlaca;
	private JTable tableCadastroCaminhao;
	private JTextField textNomeTransportadora;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCaminhao() {
		setBackground(Color.RED);
		setLayout(null);
		
		JLabel lblCadastroDeCaminho = new JLabel("Cadastro de Caminh\u00E3o");
		lblCadastroDeCaminho.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblCadastroDeCaminho.setBounds(10, 25, 405, 51);
		add(lblCadastroDeCaminho);
		
		JLabel lblPlaca = new JLabel("Placa: *");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlaca.setBounds(20, 87, 136, 14);
		add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(184, 85, 178, 20);
		add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(273, 143, 89, 23);
		add(btnSalvar);
		
        String[] columns = new String[] {
                "Id", "Name", "Hourly Rate", "Part Time"
            };
             
            //actual data for the table in a 2d array
            Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
            };
            
		tableCadastroCaminhao = new JTable(data, columns);
		tableCadastroCaminhao.setVisible(true);
		tableCadastroCaminhao.setBackground(Color.CYAN);
		tableCadastroCaminhao.setBounds(380, 261, -333, -136);
		add(tableCadastroCaminhao);
		
		JLabel lblNewLabel = new JLabel("Nome Transportadora: *");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 114, 142, 14);
		add(lblNewLabel);
		
		textNomeTransportadora = new JTextField();
		textNomeTransportadora.setBounds(184, 112, 178, 20);
		add(textNomeTransportadora);
		textNomeTransportadora.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 189, 484, 151);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Placa", "Nome Transportadora"
			}
		));
		scrollPane.setViewportView(table);
		

	}
}

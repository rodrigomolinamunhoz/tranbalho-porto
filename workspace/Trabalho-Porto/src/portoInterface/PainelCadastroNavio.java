package portoInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import portoBackEnd.Caminhao;
import portoBackEnd.Navio;
import portoBackEnd.Patio;
import portoBackEnd.Transportadora;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastroNavio extends JPanel {
	private JTextField textTransportadora;
	private JTextField textMatricula;
	private JTable table;
	private Queue<Navio> navios = new LinkedList<Navio>();

	public Queue<Navio> getNavios() {
		return navios;
	}

	public void setNavios(Queue<Navio> navios) {
		this.navios = navios;
	}

	/**
	 * Create the panel.
	 */
	public PainelCadastroNavio(Patio patio) {
		setBackground(Color.YELLOW);
		setLayout(null);
		setSize(1200, 1800);

		JLabel lblCadastroDeNavios = new JLabel("Cadastro de Navio");
		lblCadastroDeNavios.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblCadastroDeNavios.setBounds(10, 22, 356, 37);
		add(lblCadastroDeNavios);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula: *");
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatrcula.setBounds(10, 81, 79, 14);
		add(lblMatrcula);

		textTransportadora = new JTextField();
		textTransportadora.setBounds(167, 114, 155, 20);
		add(textTransportadora);
		textTransportadora.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (isNullOrEmpty(textTransportadora.getText()) || isNullOrEmpty(textMatricula.getText())) {
						JOptionPane.showMessageDialog(null, "Matr�cula ou Transportadora n�o foram informados!",
								"Informa��o", JOptionPane.INFORMATION_MESSAGE);
					} else {
						int matricula = Integer.parseInt(textMatricula.getText());
						Transportadora transportadora = new Transportadora(textTransportadora.getText());
						navios.add(new Navio(matricula, transportadora));
						listarNavios(navios);
						patio.setNavios(navios);
						limparFormulario();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Algo de errado aconteceu, tente novamente!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(233, 145, 89, 23);
		add(btnSalvar);

		JLabel lblNomeTransportadora = new JLabel("Nome Transportadora: *");
		lblNomeTransportadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeTransportadora.setBounds(10, 120, 172, 14);
		add(lblNomeTransportadora);

		textMatricula = new JTextField();
		textMatricula.setBounds(167, 75, 155, 20);
		add(textMatricula);
		textMatricula.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 172, 387, 117);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Matr�cula", "Nome Transportadora" }) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		});
		scrollPane.setViewportView(table);
	}

	public void listarNavios(Queue<Navio> navios) {
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		clearTable(dt);
		for (Navio navio : navios) {
			dt.addRow(
					new String[] { String.valueOf(navio.getMatricula()), navio.getTransportadora().getRazaoSocial() });
		}
	}
	
	private void limparFormulario() {
		textMatricula.setText("");
		textTransportadora.setText("");
	}
	
	private boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	private void clearTable(DefaultTableModel dt) {
		dt.setRowCount(0);
	}
}

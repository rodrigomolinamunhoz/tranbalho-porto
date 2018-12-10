package portoInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import portoBackEnd.Caminhao;
import portoBackEnd.Container;
import portoBackEnd.Navio;
import portoBackEnd.OrigemRemetente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class PainelPatio extends JPanel {
	private JTable tableCaminhoes;
	private JTable tableNavios;
	private JTable tableContainers;

	/**
	 * Create the panel.
	 */
	public PainelPatio(PainelPorto porto) {
		setBackground(Color.CYAN);
		setLayout(null);
		setSize(1200, 1800);

		JLabel lblNewLabel = new JLabel("Lista de Caminh\u00F5es no P\u00E1tio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 334, 81);
		add(lblNewLabel);

		JScrollPane scrollPaneCaminhoes = new JScrollPane();
		scrollPaneCaminhoes.setBounds(10, 87, 326, 214);
		add(scrollPaneCaminhoes);

		tableCaminhoes = new JTable();
		tableCaminhoes.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Placa", "Transportadora" }));
		scrollPaneCaminhoes.setViewportView(tableCaminhoes);

		JButton btnCarregarCaminho = new JButton("Carregar Caminh\u00E3o");
		btnCarregarCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caminhao caminhao = porto.patio.getCaminhoes().peek();
				Container container = porto.patio.getContainers().peek();
				if (caminhao == null || container == null) {
					JOptionPane.showMessageDialog(null,
							"Verifique se existe o container ou caminh�o selecionado no p�tio!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else if (caminhao.getPlaca().equals(container.getCodigo())) {
					porto.patio.getCaminhoes().remove();
					porto.patio.getContainers().remove(container);
					listarCaminhoes(porto.patio.getCaminhoes());
					listarContainers(porto.patio.getContainers());
					JOptionPane.showMessageDialog(null, "Container carregado com sucesso!", "Informa��o",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "C�digo do Container com Placa n�o conferem!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCarregarCaminho.setBounds(50, 312, 201, 67);
		add(btnCarregarCaminho);

		JButton btnCarregar = new JButton("Descarregar Caminh\u00E3o");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				porto.painelCadastroContainer.setVisible(true);
				Caminhao caminhao = porto.patio.getCaminhoes().peek();
				porto.painelCadastroContainer.setCaminhao(caminhao);
				porto.painelCadastroContainer.setOrigemRemetente(OrigemRemetente.Caminhao);
				porto.painelCadastroContainer.atualizaInformacaoCaminhao();
				setVisible(false);
				porto.painelCadastroContainer.setVisible(true);
			}
		});
		btnCarregar.setBounds(50, 390, 201, 67);
		add(btnCarregar);

		JLabel lblListaDeNavios = new JLabel("Lista de Navios no P\u00E1tio:");
		lblListaDeNavios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListaDeNavios.setBounds(876, 11, 287, 81);
		add(lblListaDeNavios);

		JScrollPane scrollPaneNavios = new JScrollPane();
		scrollPaneNavios.setBounds(864, 87, 326, 214);
		add(scrollPaneNavios);

		tableNavios = new JTable();
		tableNavios.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Matr�cula", "Transportadora" }) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		});
		scrollPaneNavios.setViewportView(tableNavios);

		JButton bnCarregaNavio = new JButton("Carregar Navio");
		bnCarregaNavio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Navio navio = porto.patio.getNavios().peek();
				Container container = porto.patio.getContainers().peek();
				if (navio == null || container == null) {
					JOptionPane.showMessageDialog(null,
							"Verifique se existe o container ou navio selecionado no p�tio!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else if (String.valueOf(navio.getMatricula()).equals(container.getCodigo())) {
					porto.patio.getNavios().remove();
					porto.patio.getContainers().remove(container);
					listarNavios(porto.patio.getNavios());
					listarContainers(porto.patio.getContainers());
					JOptionPane.showMessageDialog(null, "Container carregado com sucesso!", "Informa��o",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "C�digo do Container com Placa n�o conferem!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		bnCarregaNavio.setBounds(966, 312, 197, 67);
		add(bnCarregaNavio);

		JButton btnDescarregaNavio = new JButton("Descarregar Navio");
		btnDescarregaNavio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Navio navio = porto.patio.getNavios().peek();
				porto.painelCadastroContainer.setNavio(navio);
				porto.painelCadastroContainer.setOrigemRemetente(OrigemRemetente.Navio);
				porto.painelCadastroContainer.atualizaInformacaoNavio();
				setVisible(false);
				porto.painelCadastroContainer.setVisible(true);

			}
		});
		btnDescarregaNavio.setBounds(966, 390, 197, 67);
		add(btnDescarregaNavio);

		JLabel lblListaDeContainers = new JLabel("Lista de Containers no P\u00E1tio:");
		lblListaDeContainers.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListaDeContainers.setBounds(431, 220, 334, 81);
		add(lblListaDeContainers);

		JScrollPane scrollPaneContainers = new JScrollPane();
		scrollPaneContainers.setBounds(261, 312, 695, 214);
		add(scrollPaneContainers);

		tableContainers = new JTable();
		tableContainers.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C�digo", "Remetente", "Destinat�rio", "Conte�do", "Data de Entrada" }) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		});
		scrollPaneContainers.setViewportView(tableContainers);
	}

	public void listarContainers(Stack<Container> containers) {
		DefaultTableModel dt = (DefaultTableModel) tableContainers.getModel();
		clearTable(dt);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
		for (Container container : containers) {
			dt.addRow(new String[] { container.getCodigo(), container.getRemetente().getRazaoSocial(),
					container.getDestinatario().getCodigo(), container.getConteudo(),
					format.format(container.getDataEntrada()) });
		}
	}

	public void listarNavios(Queue<Navio> navios) {
		DefaultTableModel dt = (DefaultTableModel) tableNavios.getModel();
		clearTable(dt);
		for (Navio navio : navios) {
			dt.addRow(
					new String[] { String.valueOf(navio.getMatricula()), navio.getTransportadora().getRazaoSocial() });
		}
	}

	public void listarCaminhoes(Queue<Caminhao> caminhoes) {
		DefaultTableModel dt = (DefaultTableModel) tableCaminhoes.getModel();
		clearTable(dt);
		for (Caminhao caminhao : caminhoes) {
			dt.addRow(new String[] { caminhao.getPlaca(), caminhao.getTransportadora().getRazaoSocial() });
		}
	}

	private void clearTable(DefaultTableModel dt) {
		dt.setRowCount(0);
	}
}

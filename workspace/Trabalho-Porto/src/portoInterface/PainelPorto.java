package portoInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import portoBackEnd.Patio;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PainelPorto {

	private JFrame frame;
	public PainelInicio painelInicio;
	public PainelCadastroCaminhao painelCadastroCaminhao;
	public PainelCadastroNavio painelCadastroNavio;
	public PainelPatio painelPatio;
	public PainelCadastroContainer painelCadastroContainer;
	public Patio patio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelPorto window = new PainelPorto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PainelPorto() {
		patio = new Patio();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel painelPorto = new JPanel();
		frame.getContentPane().add(painelPorto);
		painelPorto.setLayout(new CardLayout(0, 0));
		
		painelInicio = new PainelInicio();
		painelPorto.add(painelInicio, "name_156304225049472");
		
		painelCadastroCaminhao = new PainelCadastroCaminhao(patio);
		painelPorto.add(painelCadastroCaminhao, "name_156701038958973");
		painelCadastroCaminhao.setLayout(null);
		
		painelCadastroNavio = new PainelCadastroNavio(patio);
		painelPorto.add(painelCadastroNavio, "name_156822636675350");
		
		painelPatio = new PainelPatio(this);
		painelPorto.add(painelPatio, "name_163498134734542");
		
		painelCadastroContainer = new PainelCadastroContainer(this);
		painelPorto.add(painelCadastroContainer, "name_177029963865142");
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnIncio = new JMenu("In\u00EDcio");
		menuBar.add(mnIncio);
		
		JMenuItem mntmIr = new JMenuItem("Ver");
		mntmIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroCaminhao.setVisible(false);
				painelCadastroNavio.setVisible(false);
				painelInicio.setVisible(true);
				painelPatio.setVisible(false);
			}
		});
		mnIncio.add(mntmIr);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Caminh\u00E3o");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroCaminhao.setVisible(true);
				painelCadastroNavio.setVisible(false);
				painelInicio.setVisible(false);
				painelPatio.setVisible(false);
			}
		});
		mnCadastro.add(mntmCadastrar);
		
		JMenuItem mntmCadastrarNavio = new JMenuItem("Cadastrar Navio");
		mntmCadastrarNavio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroCaminhao.setVisible(false);
				painelCadastroNavio.setVisible(true);
				painelInicio.setVisible(false);
				painelPatio.setVisible(false);
			}
		});
		mnCadastro.add(mntmCadastrarNavio);
		
		JMenu mnPtio = new JMenu("P\u00E1tio");
		menuBar.add(mnPtio);
		
		JMenuItem mntmVer = new JMenuItem("Ver");
		mntmVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroCaminhao.setVisible(false);
				painelCadastroNavio.setVisible(false);
				painelInicio.setVisible(false);
				painelPatio.setVisible(true);
				painelPatio.listarCaminhoes(patio.getCaminhoes());
				painelPatio.listarNavios(patio.getNavios());
				painelPatio.listarContainers(patio.getContainers());
			}
		});
		mnPtio.add(mntmVer);
	}
}

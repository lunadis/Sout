package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DeskPanel  extends JFrame{
	
	private Connection conn;
	
	public DeskPanel(Connection conn) {
		this.conn = conn;
	}
	
	JDesktopPane pane = new JDesktopPane();
	
	JMenuBar barra = new JMenuBar();
	
	JMenu	mUsuario = new JMenu("Usuario");
	JMenu	mTarefa = new JMenu("Tarefa");
	JMenu	mInfluenciador = new JMenu("Influenciador");
	JMenu	mMetodologia = new JMenu("Metodologia");
	
	JMenuItem cadUsuario = new JMenuItem("Cadastro");
	JMenuItem cadTarefa = new JMenuItem("Cadastro");
	JMenuItem cadInfluenciador = new JMenuItem("Cadastro");
	JMenuItem cadMetodologia = new JMenuItem("Cadastro");
	
	JMenuItem conUsuario = new JMenuItem("Consultar");
	JMenuItem conTarefa = new JMenuItem("Consultar");
	JMenuItem conInfluenciador = new JMenuItem("Consultar");
	JMenuItem conMetodologia = new JMenuItem("Consultar");
	
	public DeskPanel(){
		
		super("Gerenciador de tarefas v0.0.1");
		
		this.setJMenuBar(barra);
		
		barra.add(mUsuario);
		barra.add(mMetodologia);
		barra.add(mInfluenciador);
		barra.add(mTarefa);
		
		mUsuario.add(cadUsuario);
		cadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadUsuario cadastroPessoa = new TelaCadUsuario();
				}
			});
		
		mMetodologia.add(cadMetodologia);
		cadMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadMetodologia cadastroMetodologia = new TelaCadMetodologia();
				}
			});
		
		mInfluenciador.add(cadInfluenciador);
		cadInfluenciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaCadInfluenciador cadastroInfluenciador = new TelaCadInfluenciador();
				}
			});
		
		mTarefa.add(cadTarefa);
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadTarefa cadastroTarefa = new TelaCadTarefa();
				}
			});
		
		mUsuario.add(conUsuario);
		mMetodologia.add(conMetodologia);
		mInfluenciador.add(conInfluenciador);
		mTarefa.add(conTarefa);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(false);
	}
	
	
}

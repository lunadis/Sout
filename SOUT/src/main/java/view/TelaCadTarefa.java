package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.InfluenciadorJdbDAO;
import controller.JdbUtil;
import controller.TarefaJdbDAO;
import controller.UsuarioJdbDAO;
import model.Influenciador;
import model.Tarefa;
import model.Usuario;

public class TelaCadTarefa extends JFrame {
	
	JLabel lblUsuario = new JLabel("Selecione o usuario:");
	JComboBox cboUsuario = new JComboBox();
	
	JLabel lblnmTarefa = new JLabel("Titulo:");
	JLabel lblid_metodolgia = new  JLabel("Metodologia:");
	JLabel lbldtPrazo = new  JLabel("Prazo:");
	JLabel lbldescricao = new  JLabel("Descricao:");
	
	JTextArea txtnmTarefa = new JTextArea();
	JTextArea txtid_metodolgia = new JTextArea();
	JTextArea txtdtPrazo = new JTextArea();
	JTextArea txtdescricao = new JTextArea();
	
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton("Limpar");

	public TelaCadTarefa() {
		// TODO Auto-generated constructor stub
		super("Cadastro de Tarefa");
Container pane = this.getContentPane();
		
		pane.add(lblUsuario);
		pane.add(cboUsuario);
		lblUsuario.setBounds(20, 30, 150, 20);
		cboUsuario.setBounds(20, 60, 50, 20);
		cboUsuario.addItem("");
		try {
				 Connection connection = JdbUtil.getConnection();
				 UsuarioJdbDAO usuario1 = new UsuarioJdbDAO(connection);
				 
				 List<Usuario> usu =  usuario1.listarUsuario();
				 for(int i=0;i<usu.size();i++) {
					 cboUsuario.addItem(usu.get(i).getId_usuario());					 
				 }
				 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblnmTarefa);
		pane.add(lblid_metodolgia);
		pane.add(lbldtPrazo);
		pane.add(lbldescricao);
		//textearea
		pane.add(txtnmTarefa);
		pane.add(txtid_metodolgia);
		pane.add(txtdtPrazo);
		pane.add(txtdescricao);
		pane.add(btnSalvar);
		pane.add(btnLimpar);
		
		
		
		lblnmTarefa.setBounds(20, 90, 80, 20);
		lblid_metodolgia.setBounds(20, 115, 80, 20);
		lbldtPrazo.setBounds(20,145,80,20);
		lbldescricao.setBounds(20, 170, 80, 20);
		
		txtnmTarefa.setBounds(95, 90, 80, 20);
		txtid_metodolgia.setBounds(95, 115, 35, 20);
		txtdtPrazo.setBounds(95,145,80,20);
		txtdescricao.setBounds(95, 170, 80, 80);
		
		btnSalvar.setBounds(230, 145, 80, 50);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					TarefaJdbDAO tarDAO = new TarefaJdbDAO(connection);
					
					Tarefa tef = new Tarefa();
					
					tef.setNmTarefa(txtnmTarefa.getText());
					tef.setId_metodologia(Integer.parseInt(txtid_metodolgia.getText()));
					tef.setDtPrazo(txtdtPrazo.getText());
					tef.setDescricao(txtdescricao.getText());
					tef.setId_usuario(cboUsuario.getSelectedIndex());
					
					tarDAO.salvar(tef);
					
									
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

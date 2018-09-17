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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import controller.JdbUtil;
import controller.TarefaJdbDAO;
import controller.UsuarioJdbDAO;
import model.Tarefa;
import model.Usuario;

public class TelaConsulTarefa extends JFrame {
	
	JButton btnEditar = new JButton("Editar");
	JButton btnLimpar = new JButton("Limpar");
	JButton btnDeletar = new JButton("Deletar");
	

	JLabel lblnmTarefa = new JLabel("Titulo:");
	JLabel lblid_metodolgia = new  JLabel("Metodologia:");
	JLabel lbldtPrazo = new  JLabel("Prazo:");
	JLabel lbldescricao = new  JLabel("Descricao:");
	JLabel lblUsuario = new JLabel("Usuario:");
	
	JTextArea txtUsuario = new JTextArea("");
	JTextArea txtnmTarefa = new JTextArea();
	JTextArea txtid_metodolgia = new JTextArea();
	JTextArea txtdtPrazo = new JTextArea();
	JTextArea txtdescricao = new JTextArea();
	
	
	JLabel lblTarefa = new JLabel("Selecione a Tarefa:");
	JComboBox cboTarefa = new JComboBox();

	public TelaConsulTarefa() {
		super("Tela de consulta de tarefas");
		Container pane = this.getContentPane();
		
		pane.add(lblTarefa);
		pane.add(cboTarefa);
		lblTarefa.setBounds(20, 5, 150, 20);
		cboTarefa.setBounds(20, 25, 50, 20);
		try {
			Connection connection = JdbUtil.getConnection();
			TarefaJdbDAO tefDAO = new TarefaJdbDAO(connection);
			
			List<Tarefa> listaTarefa = tefDAO.listarTarefa();
			
			for(int i=0;i<listaTarefa.size();i++) {
				cboTarefa.addItem(listaTarefa.get(i).getId_tarefa());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		cboTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					TarefaJdbDAO tefDAO = new TarefaJdbDAO(connection);
					int i = cboTarefa.getSelectedIndex();
					List<Tarefa> preencher = tefDAO.listarTarefa();
					txtUsuario.setText(preencher.get(i).getId_usuario().toString());
					txtnmTarefa.setText(preencher.get(i).getNmTarefa());
					txtid_metodolgia.setText(preencher.get(i).getId_metodologia().toString());
					txtdtPrazo.setText(preencher.get(i).getDtPrazo());
					txtdescricao.setText(preencher.get(i).getDescricao()); 
						
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		pane.add(lblnmTarefa);
		pane.add(lblid_metodolgia);
		pane.add(lbldtPrazo);
		pane.add(lbldescricao);
		pane.add(lblUsuario);
		//textearea
		pane.add(txtnmTarefa);
		pane.add(txtid_metodolgia);
		pane.add(txtdtPrazo);
		pane.add(txtdescricao);
		pane.add(txtUsuario);
		
		lblUsuario.setBounds(20, 60, 50, 20);
		lblnmTarefa.setBounds(20, 90, 80, 20);
		lblid_metodolgia.setBounds(20, 115, 80, 20);
		lbldtPrazo.setBounds(20,145,80,20);
		lbldescricao.setBounds(20, 170, 80, 20);
		
		txtUsuario.setBounds(70, 60, 30, 20);
		txtUsuario.setEditable(false);
		txtnmTarefa.setBounds(95, 90, 80, 20);
		txtid_metodolgia.setBounds(95, 115, 35, 20);
		txtdtPrazo.setBounds(95,145,80,20);
		txtdescricao.setBounds(95, 170, 150, 80);
		
		pane.add(btnEditar);
		pane.add(btnDeletar);
		pane.add(btnLimpar);
		btnDeletar.setBounds(250, 80, 75, 30);
		btnEditar.setBounds(250, 115, 75, 30);
		btnLimpar.setBounds(250, 150, 75, 30);
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					TarefaJdbDAO tefDAO = new TarefaJdbDAO(connection);
					int i = Integer.parseInt(cboTarefa.getSelectedItem().toString());
					tefDAO.delete(i);
					dispose();
									
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
			
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					TarefaJdbDAO tefDAO = new TarefaJdbDAO(connection);
					
					Tarefa tef = new Tarefa();
					
					int i = Integer.parseInt(cboTarefa.getSelectedItem().toString());
					
					
					tef.setDescricao(txtdescricao.getText());
					tef.setDtPrazo(txtdtPrazo.getText());
					tef.setId_metodologia(Integer.parseInt(txtid_metodolgia.getText()));
					tef.setId_usuario(Integer.parseInt(txtUsuario.getText()));
					tef.setNmTarefa(txtnmTarefa.getText());
					
					tefDAO.update(i, tef);
					dispose();
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboTarefa.setSelectedIndex(0);
				txtUsuario.setText("");
				txtUsuario.setText("");
				txtnmTarefa.setText("");
				txtid_metodolgia.setText("");
				txtdtPrazo.setText("");
				txtdescricao.setText("");
			}
		});
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

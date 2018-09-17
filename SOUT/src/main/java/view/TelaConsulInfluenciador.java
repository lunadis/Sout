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
import model.Influenciador;

public class TelaConsulInfluenciador extends JFrame {

	JButton btnEditar = new JButton("Editar");
	JButton btnLimpar = new JButton("Limpar");
	JButton btnDeletar = new JButton("Deletar");
	
	JLabel lbldata = new JLabel("Data:");
	JLabel lblNome = new JLabel("Nome:");
	JLabel lblUsuario = new JLabel("Usuario:");
	JTextArea txtUsuario = new JTextArea("");
	JTextArea txtnmInfluenciador = new JTextArea();
	JTextArea txtdtInfluenciador = new JTextArea();
	
	JLabel lblInfluenciador = new JLabel("Selecione o Influenciador:");
	JComboBox cboInfluenciador = new JComboBox();
	
	public TelaConsulInfluenciador() {
		super("Tela de consulta de influenciadores");
		
		Container pane = this.getContentPane();
	
		pane.add(lblInfluenciador);
		pane.add(cboInfluenciador);
		lblInfluenciador.setBounds(20, 5, 150, 20);
		cboInfluenciador.setBounds(20, 25, 50, 20);
		try {
			Connection connection = JdbUtil.getConnection();
			InfluenciadorJdbDAO infDAO = new InfluenciadorJdbDAO(connection);
			
			List<Influenciador> listaInfluenciador = infDAO.listarInfluenciador();
			for(int i=0;i<listaInfluenciador.size();i++) {
				cboInfluenciador.addItem(listaInfluenciador.get(i).getId_influenciador());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblNome);
		pane.add(lbldata);
		pane.add(lblUsuario);
		pane.add(txtUsuario);
		pane.add(txtnmInfluenciador);
		pane.add(txtdtInfluenciador);
		lblUsuario.setBounds(20, 60, 50, 20);
		lblNome.setBounds(20, 90, 50, 20);
		lbldata.setBounds(20, 115, 50, 20);
		txtUsuario.setBounds(70, 60, 30, 20);
		txtnmInfluenciador.setBounds(70, 90, 180, 20);
		txtdtInfluenciador.setBounds(70, 115, 80, 20);
		txtUsuario.setEditable(false);
		
		cboInfluenciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					InfluenciadorJdbDAO infDAO = new InfluenciadorJdbDAO(connection);
					
					int i = cboInfluenciador.getSelectedIndex();
					List<Influenciador> preencher = infDAO.listarInfluenciador();
					txtUsuario.setText(preencher.get(i).getId_usuario().toString()); // implementar aparecer nome do usuario
					txtnmInfluenciador.setText(preencher.get(i).getNmInfluenciador());
					txtdtInfluenciador.setText(preencher.get(i).getDtInfluenciador());
					
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		pane.add(btnEditar);
		pane.add(btnDeletar);
		pane.add(btnLimpar);
		btnDeletar.setBounds(20, 170, 75, 30);
		btnEditar.setBounds(100, 170, 70, 30);
		btnLimpar.setBounds(180, 170, 75, 30);
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					InfluenciadorJdbDAO infDAO = new InfluenciadorJdbDAO(connection);
					int i =  Integer.parseInt(cboInfluenciador.getSelectedItem().toString());
					infDAO.delete(i);
					dispose(); // poderia ser RAPAINT()?
									
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
			
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					InfluenciadorJdbDAO infDAO = new InfluenciadorJdbDAO(connection);
					
					Influenciador info = new Influenciador();
					info.setNmInfluenciador(txtnmInfluenciador.getText());
					info.setDtInfluenciador(txtdtInfluenciador.getText());
					info.setId_usuario(Integer.parseInt(txtUsuario.getText()));
					int i =  Integer.parseInt(cboInfluenciador.getSelectedItem().toString());
					infDAO.update(i, info);
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboInfluenciador.setSelectedIndex(0);
				txtnmInfluenciador.setText("");
				txtdtInfluenciador.setText("");
				txtUsuario.setText("");
				
			}
		});
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

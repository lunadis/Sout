package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.InfluenciadorJdbDAO;
import controller.JdbUtil;
import controller.MetodologiaJdbDAO;
import controller.UsuarioJdbDAO;
import model.Influenciador;
import model.Metodologia;
import model.Usuario;

public class TelaCadInfluenciador extends JFrame {
	
	JLabel lblUsuario = new JLabel("Selecione o cliente:");
	JComboBox cboUsuario = new JComboBox();
	
	JLabel lbldata = new JLabel("Data:");
	JLabel lblNome = new JLabel("Nome:");
	JTextArea txtnmInfluenciador = new JTextArea();
	JTextArea txtdtInfluenciador = new JTextArea();

	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton("Limpar");
	
	public TelaCadInfluenciador() {
		super("Cadastro de Influenciador");
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
		
		
		pane.add(lblNome);
		pane.add(lbldata);
		pane.add(txtnmInfluenciador);
		pane.add(txtdtInfluenciador);
		pane.add(btnSalvar);
		pane.add(btnLimpar);
		lblNome.setBounds(20, 90, 50, 20);
		lbldata.setBounds(20, 115, 50, 20);
		txtnmInfluenciador.setBounds(60, 90, 180, 20);
		txtdtInfluenciador.setBounds(60, 115, 80, 20);
		btnSalvar.setBounds(70, 160, 70, 30);
		btnLimpar.setBounds(150, 160, 75, 30);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					InfluenciadorJdbDAO infoDAO = new InfluenciadorJdbDAO(connection);
					
					Influenciador infu = new Influenciador();
					
					infu.setId_usuario(cboUsuario.getSelectedIndex());
					infu.setDtInfluenciador(txtdtInfluenciador.getText());
					infu.setNmInfluenciador(txtnmInfluenciador.getText());
					
					infoDAO.salvar(infu);
						
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnmInfluenciador.setText(null);
				txtdtInfluenciador.setText(null);
			}
		});
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

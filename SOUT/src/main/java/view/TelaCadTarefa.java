package view;

import java.awt.Container;
import java.sql.Connection;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.JdbUtil;
import controller.UsuarioJdbDAO;
import model.Usuario;

public class TelaCadTarefa extends JFrame {
	
	JLabel lblUsuario = new JLabel("Selecione o cliente:");
	JComboBox cboUsuario = new JComboBox();

	public TelaCadTarefa() {
		// TODO Auto-generated constructor stub
		super("Cadastro de Tarefa");
Container pane = this.getContentPane();
		
		pane.add(lblUsuario);
		pane.add(cboUsuario);
		lblUsuario.setBounds(20, 30, 150, 20);
		cboUsuario.setBounds(20, 60, 50, 20);
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
		
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

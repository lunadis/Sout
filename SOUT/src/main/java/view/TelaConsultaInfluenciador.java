package view;

import java.awt.Container;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.InfluenciadorJdbDAO;
import controller.JdbUtil;
import model.Usuario;

public class TelaConsultaInfluenciador extends JFrame {

	JLabel lblUsuario = new JLabel("Selecione o Influencia:");
	JComboBox cboUsuario = new JComboBox();
	
	JLabel lbldata = new JLabel("Data:");
	JLabel lblNome = new JLabel("Nome:");
	JTextArea txtnmInfluenciador = new JTextArea();
	JTextArea txtdtInfluenciador = new JTextArea();

	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton("Limpar");
	
	
	public TelaConsultaInfluenciador() {
		super("Tela de consulta");
		
		Container pane = this.getContentPane();
		
		pane.add(lblUsuario);
		pane.add(cboUsuario);
		lblUsuario.setBounds(20, 30, 150, 20);
		cboUsuario.setBounds(20, 60, 50, 20);
		cboUsuario.addItem("");
		try {
			 Connection connection = JdbUtil.getConnection();
			 InfluenciadorJdbDAO usuario1 = new InfluenciaJdbDAO(connection);
			 
			 List<Usuario> usu =  usuario1.listarUsuario();
			 for(int i=0;i<usu.size();i++) {
				 cboUsuario.addItem(usu.get(i).getId_usuario());					 
			 } 
	}catch(Exception e){
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated constructor stub
	}

}

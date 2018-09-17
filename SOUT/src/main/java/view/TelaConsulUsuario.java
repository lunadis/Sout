package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import controller.JdbUtil;
import controller.UsuarioJdbDAO;
import model.Usuario;

public class TelaConsulUsuario extends JFrame {
	
	JLabel lblnmUsuario = new JLabel("Nome:");
	JLabel lbldsEmail = new JLabel("Email:");
	JLabel lbldsSexo = new JLabel("Sexo:");
	
	JTextArea txtnmUsuario = new JTextArea();
	JTextArea txtdsEmail = new JTextArea();
	JTextArea txtnmSexo = new JTextArea();
	
	ButtonGroup radioGrup = new ButtonGroup();
	
	JRadioButton rdbMasculino = new JRadioButton("Maculino", false);
	JRadioButton rdbFeminino = new JRadioButton("feminino", false);
	
	JButton btnEditar = new JButton("Editar");
	JButton btnLimpar = new JButton("Limpar");
	JButton btnDeletar = new JButton("Deletar");
	
	JLabel lblUsuario = new JLabel("Selecione o usuario:");
	JComboBox cboUsuario = new JComboBox();

	public TelaConsulUsuario() {
super("Cadastro de Usuario");
		
		Container pane = this.getContentPane();
		
		pane.add(lblUsuario);
		pane.add(cboUsuario);
		lblUsuario.setBounds(20, 15, 150, 20);
		cboUsuario.setBounds(20, 35, 50, 20);
				
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
		
		cboUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Connection connection = JdbUtil.getConnection();
					 UsuarioJdbDAO usuario1 = new UsuarioJdbDAO(connection);
					 int i = cboUsuario.getSelectedIndex();
					List<Usuario> preencher = usuario1.listarUsuario();
					txtnmUsuario.setText(preencher.get(i).getNmUsuario());
					txtdsEmail.setText(preencher.get(i).getDsEmail());
					System.out.println(preencher.get(i).getDsSexo());
					if(preencher.get(i).getDsSexo().equals("Feminino")) {
					rdbFeminino.setSelected(true);
					rdbMasculino.setSelected(false);
					}else {
						rdbFeminino.setSelected(false);
						rdbMasculino.setSelected(true);
					}
					 
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		
		pane.add(lblnmUsuario);
		pane.add(txtnmUsuario);
		lblnmUsuario.setBounds(20, 60, 50, 20);
		txtnmUsuario.setBounds(60, 60, 150, 20);
		
		pane.add(lbldsEmail);
		pane.add(txtdsEmail);
		lbldsEmail.setBounds(20, 90, 50, 20);
		txtdsEmail.setBounds(60, 90, 150, 20);
		
		radioGrup.add(rdbMasculino);
		radioGrup.add(rdbFeminino);
				
		pane.add(lbldsSexo);
		pane.add(rdbFeminino);
		pane.add(rdbMasculino);
		lbldsSexo.setBounds(20, 110, 50, 20);
		rdbFeminino.setBounds(60, 110, 80, 20);
		rdbMasculino.setBounds(60, 140, 80, 20);
		
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
					UsuarioJdbDAO usuDAO = new UsuarioJdbDAO(connection);
						
					usuDAO.delete(cboUsuario.getSelectedIndex());
									
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				txtnmUsuario.setText(null);
				txtdsEmail.setText(null);
				rdbFeminino.setSelected(false);
				rdbMasculino.setSelected(false);
				dispose();
				
			}
			
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					UsuarioJdbDAO usuarioDAO = new UsuarioJdbDAO(connection); 
					
					Usuario user1 = new Usuario();
					user1.setNmUsuario(txtnmUsuario.getText());
					user1.setDsEmail(txtdsEmail.getText());
					
					int i = Integer.parseInt(cboUsuario.getSelectedItem().toString());
					
					if(rdbFeminino.isSelected()) {
					user1.setDsSexo("Feminino");
					usuarioDAO.update(i, user1);
					}else if(rdbMasculino.isSelected()) {
					user1.setDsSexo("Masculino");
					usuarioDAO.update(imn, user1);
					}else {
						JOptionPane.showMessageDialog(null,"Insira o sexo");
						}
					
					
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnmUsuario.setText(null);
				txtdsEmail.setText(null);
				rdbFeminino.setSelected(false);
				rdbMasculino.setSelected(true);
				
			}
		});
		
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	
	}

}

package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import controller.JdbUtil;
import controller.UsuarioJdbDAO;
import model.Usuario;

public class TelaCadUsuario extends JFrame {

	JLabel lblnmUsuario = new JLabel("Nome:");
	JLabel lbldsEmail = new JLabel("Email:");
	JLabel lbldsSexo = new JLabel("Sexo:");
	
	JTextArea txtnmUsuario = new JTextArea();
	JTextArea txtdsEmail = new JTextArea();
	JTextArea txtnmSexo = new JTextArea();
	
	ButtonGroup radioGrup = new ButtonGroup();
	
	JRadioButton rdbMasculino = new JRadioButton("Maculino", false);
	JRadioButton rdbFeminino = new JRadioButton("feminino", false);
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton("Limpar");
	
	
	public TelaCadUsuario() {	
		
		
		super("Cadastro de Usuario");
		
		Container pane = this.getContentPane();
		
		pane.add(lblnmUsuario);
		pane.add(txtnmUsuario);
		lblnmUsuario.setBounds(20, 30, 50, 20);
		txtnmUsuario.setBounds(60, 30, 150, 20);
		
		pane.add(lbldsEmail);
		pane.add(txtdsEmail);
		lbldsEmail.setBounds(20, 60, 50, 20);
		txtdsEmail.setBounds(60, 60, 150, 20);
		
		radioGrup.add(rdbMasculino);
		radioGrup.add(rdbFeminino);
				
		pane.add(lbldsSexo);
		pane.add(rdbFeminino);
		pane.add(rdbMasculino);
		lbldsSexo.setBounds(20, 90, 50, 20);
		rdbFeminino.setBounds(60, 90, 80, 20);
		rdbMasculino.setBounds(60, 110, 80, 20);
		
		pane.add(btnSalvar);
		pane.add(btnLimpar);
		btnSalvar.setBounds(70, 140, 70, 30);
		btnLimpar.setBounds(150, 140, 75, 30);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					UsuarioJdbDAO usuarioDAO = new UsuarioJdbDAO(connection); 
					
					Usuario user1 = new Usuario();
					user1.setNmUsuario(txtnmUsuario.getText());
					user1.setDsEmail(txtdsEmail.getText());
					if(rdbFeminino.isSelected()) {
					user1.setDsSexo("Feminino");
					JOptionPane.showMessageDialog(null,"Usuario Cadastrado");
					}else if(rdbMasculino.isSelected()) {
					user1.setDsSexo("Masculino");
					JOptionPane.showMessageDialog(null,"Usuario Cadastrado");
					}else {
						JOptionPane.showMessageDialog(null,"Insira o sexo");
						}
					usuarioDAO.salvar(user1);
					
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnmUsuario.setText(null);
				txtdsEmail.setText(null);
			}
		});
		
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	
	}
}

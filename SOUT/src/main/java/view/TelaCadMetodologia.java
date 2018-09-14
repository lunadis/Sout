package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import controller.JdbUtil;
import controller.MetodologiaJdbDAO;
import controller.UsuarioJdbDAO;
import model.Metodologia;
import model.Usuario;

public class TelaCadMetodologia extends JFrame {
	
	JLabel lblnmMetodologia = new JLabel("Titulo:");
	JTextArea txtnmMetodologia = new JTextArea();
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton("Limpar");
	
		
	public TelaCadMetodologia() {
		// TODO Auto-generated constructor stub
		super("Cadastro de Metodologia");
		
		Container pane = this.getContentPane();
		
		pane.add(lblnmMetodologia);
		pane.add(txtnmMetodologia);
		lblnmMetodologia.setBounds(20, 30, 50, 20);
		txtnmMetodologia.setBounds(60, 30, 150, 20);
		
		pane.add(btnSalvar);
		pane.add(btnLimpar);
		btnSalvar.setBounds(70, 140, 70, 30);
		btnLimpar.setBounds(150, 140, 75, 30);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbDAO metodologiaDAO = new MetodologiaJdbDAO(connection); 
					
					Metodologia met = new Metodologia();
					met.setNmMetodologia(txtnmMetodologia.getText());
					
					metodologiaDAO.salvar(met);	
						
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnmMetodologia.setText(null);
			}
		});
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

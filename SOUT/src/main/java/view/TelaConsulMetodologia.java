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

import controller.JdbUtil;
import controller.MetodologiaJdbDAO;
import model.Metodologia;

public class TelaConsulMetodologia extends JFrame {
	
	JLabel lblnmMetodologia = new JLabel("Titulo:");
	JTextArea txtnmMetodologia = new JTextArea();
	
	
	
	JButton btnEditar = new JButton("Editar");
	JButton btnLimpar = new JButton("Limpar");
	JButton btnDeletar = new JButton("Deletar");
	
	JLabel lblMetodologia = new JLabel("Selecione a Metodologia:");
	JComboBox cboMetodologia = new JComboBox();

	public TelaConsulMetodologia() {
		super("Tela de consulta de metodologia");
		Container pane = this.getContentPane();
		
		pane.add(lblMetodologia);
		pane.add(cboMetodologia);
		lblMetodologia.setBounds(20, 5, 150, 20);
		cboMetodologia.setBounds(20, 25, 50, 20);
		try {
			Connection connection = JdbUtil.getConnection();
			MetodologiaJdbDAO metDAO = new MetodologiaJdbDAO(connection);
			
			List<Metodologia> listaMetodo = metDAO.listaMetodologia();
			for(int i=0;i<listaMetodo.size();i++) {
				cboMetodologia.addItem(listaMetodo.get(i).getId_metodologia());
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		cboMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbDAO metDAO = new MetodologiaJdbDAO(connection);
					
					Metodologia meto = new Metodologia();
					int i = cboMetodologia.getSelectedIndex();
					List<Metodologia> listMetodo = metDAO.listaMetodologia();
					txtnmMetodologia.setText(listMetodo.get(i).getNmMetodologia());
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});

		pane.add(lblnmMetodologia);
		pane.add(txtnmMetodologia);
		lblnmMetodologia.setBounds(20, 60, 50, 20);
		txtnmMetodologia.setBounds(60, 60, 150, 20);
		
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
					MetodologiaJdbDAO metDAO = new MetodologiaJdbDAO(connection);
					int i =	Integer.parseInt(cboMetodologia.getSelectedItem().toString());
					metDAO.delete(i);
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
					MetodologiaJdbDAO metDAO = new MetodologiaJdbDAO(connection);
					Metodologia met = new Metodologia();
					int i = Integer.parseInt(cboMetodologia.getSelectedItem().toString());
					met.setNmMetodologia(txtnmMetodologia.getText());
					metDAO.update(i, met);
					cboMetodologia.setSelectedItem(0);
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboMetodologia.setSelectedItem(0);
				txtnmMetodologia.setText("");
			}
		});
		
		
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

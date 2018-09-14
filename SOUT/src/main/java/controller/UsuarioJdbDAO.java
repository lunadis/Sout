package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;
import model.Usuario;

public class UsuarioJdbDAO {
	
	private Connection conn;
	
	public UsuarioJdbDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar (Usuario c) throws SQLException{
		String sql="insert into usuario (nmUsuario, dsEmail, dsSexo) values ('"+c.getNmUsuario()+"','"+c.getDsEmail()+"','"+c.getDsSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM `usuario` WHERE `pessoas`.`id_Usuario` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	
	}
	public void update (int a, String string) throws SQLException{
		String sql="UPDATE `usuario` SET `nmUsuario` = '"+string+"' WHERE `usuario`.`id_usuario` = "+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Tarefa> listarUsuario(){
			String sql = "select * from usuario";
			System.out.println(sql);
			
			List<Tarefa> listaTarefa = new ArrayList<Tarefa>();
			
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					
					Usuario u = new Usuario();
					
					u.setId_usuario(rs.getInt("id_usuario"));
					u.setNmUsuario(rs.getString("nmUsuario"));
					u.setDsEmail(rs.getString("dsEmail"));
					u.setDsSexo(rs.getString("dsSexo"));
					
					listaUsuario.add(u);
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		return listaUsuario;
		
	}
	
	
}

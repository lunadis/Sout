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
		String sql="DELETE FROM `usuario` WHERE `usuario`.`id_Usuario` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	
	}
	public void update (int a, Usuario c) throws SQLException{
		String sql="UPDATE `usuario` SET `nmUsuario` = '"+c.getNmUsuario()+"', `dsEmail` = '"+c.getDsEmail()+"', `dsSexo` = '"+c.getDsSexo()+"' WHERE `usuario`.`id_usuario` = "+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Usuario> listarUsuario(){
			String sql = "select * from usuario";
			System.out.println(sql);
			
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			
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

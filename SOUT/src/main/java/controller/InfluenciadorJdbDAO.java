package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Influenciador;
import model.Tarefa;
import model.Usuario;

public class InfluenciadorJdbDAO {
	private Connection conn;
	
	public InfluenciadorJdbDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Influenciador c) throws SQLException{
		String sql="insert into influenciador (id_usuario, nmInfluenciador, dtInfluenciador) values ("+c.getId_usuario()+",'"+c.getNmInfluenciador()+"','"+c.getDtInfluenciador()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM `influenciador` WHERE `influenciador`.`id_influenciador` = "+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, Influenciador in) throws SQLException{
		String sql="UPDATE `influenciador` SET `id_usuario` = '"+in.getId_usuario()+"', `nmInfluenciador` = '"+in.getNmInfluenciador()+"', `dtInfluenciador` = '"+in.getDtInfluenciador()+"' WHERE `influenciador`.`id_influenciador` = "+b+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public List<Influenciador> listarInfluenciador(){
		String sql = "select * from influenciador";
		System.out.println(sql);
		
		List<Influenciador> listarInfluenciador = new ArrayList<Influenciador>(); 
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
				Influenciador i = new Influenciador();
				
				i.setId_influenciador(rs.getInt("id_influenciador"));
				i.setId_usuario(rs.getInt("id_usuario"));
				i.setDtInfluenciador(rs.getString("dtInfluenciador"));
				i.setNmInfluenciador(rs.getString("nmInfluenciador"));
				
						
				listarInfluenciador.add(i);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	return listarInfluenciador;
	
}
	
}

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Influenciador;

public class InfluenciadorJdbDAO {
	private Connection conn;
	
	public InfluenciadorJdbDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Influenciador c) throws SQLException{
		String sql="insert into influenciador (nmInfluenciador) values ('"+c.getNmInfluenciador()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeQuery();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELTE FROM 'INFLUENCIADOR' WHERE 'INFLUENCIADOR'.'ID'="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, String string) throws SQLException{
		String sql="UPDATE 'influenciador' SET 'nome'='"+string+"' WHERE 'influenciador'.'id' ="+b+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
}

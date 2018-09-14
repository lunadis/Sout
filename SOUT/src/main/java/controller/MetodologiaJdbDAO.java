package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Metodologia;

public class MetodologiaJdbDAO {
	private Connection conn;
	
	public MetodologiaJdbDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Metodologia c) throws SQLException{
		String sql="insert into metodologia (nmMetodologia) values ('"+c.getNmMetodologia()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM `metodologia` WHERE `metodologia`.`id` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, String string) throws SQLException{
		String sql="UPDATE `metodologia` SET `nome` = '"+string+"' WHERE `alunos`.`id` = "+b+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}


}

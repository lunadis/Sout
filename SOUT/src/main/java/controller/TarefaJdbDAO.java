package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Tarefa;

public class TarefaJdbDAO {
	
	private Connection conn;
	
	public TarefaJdbDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefa c) throws SQLException{
		String sql="INSERT INTO `tarefa` (`id_pessoa`, `id_metodologia`, `nmTarefa`, `descricao`, `dtPrazo`, `dtFinal`) VALUES ('"+c.getId_usuario()+"', '"+c.getId_metodologia()+"', '"+c.getNmTarefa()+"', '"+c.getDescricao()+"', '"+c.getDtPrazo()+"', '"+c.getDtFinal()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update(int b, String string) throws SQLException{
		String sql="Update 'terefa' SET 'titulo' = '"+string+"' WHERE 'terefa','id' = "+b+"";
		System.out.println();
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM 'terefa' WHERE 'tarefa','id' ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	
	
}

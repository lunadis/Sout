package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;

public class TarefaJdbDAO {
	
	private Connection conn;
	
	public TarefaJdbDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefa c) throws SQLException{
		String sql="INSERT INTO `tarefa` (`id_usuario`, `id_metodologia`, `nmTarefa`, `descricao`, `dtPrazo`) VALUES ('"+c.getId_usuario()+"', '"+c.getId_metodologia()+"', '"+c.getNmTarefa()+"', '"+c.getDescricao()+"', '"+c.getDtPrazo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update(int b, Tarefa t) throws SQLException{
		String sql="UPDATE `tarefa` SET `id_metodologia` = '"+t.getId_metodologia()+"', `nmTarefa` = '"+t.getNmTarefa()+"', `descricao` = '"+t.getDescricao()+"', `dtPrazo` = '"+t.getDtPrazo()+"', `dtFinal` = '"+t.getDtFinal()+"' WHERE `tarefa`.`id_tarefa` = "+b+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM `tarefa` WHERE `tarefa`.`id_tarefa` = "+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public List<Tarefa> listarTarefa(){
		String sql = "select * from tarefa";
		System.out.println(sql);
		
		List<Tarefa> listaTarefa = new ArrayList<Tarefa>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				Tarefa t = new Tarefa();
				
				t.setDescricao(rs.getString("descricao"));
				t.setDtFinal(rs.getString("dtFinal"));
				t.setDtPrazo(rs.getString("dtPrazo"));
				t.setId_metodologia(rs.getInt("id_metodologia"));
				t.setId_tarefa(rs.getInt("id_tarefa"));
				t.setId_usuario(rs.getInt("id_usuario"));
				t.setNmTarefa(rs.getString("nmTarefa"));
			
				listaTarefa.add(t);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return listaTarefa;
	}
	
	
	
}

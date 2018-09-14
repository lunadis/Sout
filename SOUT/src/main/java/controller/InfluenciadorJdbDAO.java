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
	public List<Tarefa> listarTarefa(){
		String sql = "select * from tarefa";
		System.out.println(sql);
		
		List<Tarefa> listaTarefa = new ArrayList<Tarefa>(); 
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
				Tarefa t = new Tarefa();
				
				t.setId_usuario(rs.getInt("id_usuario"));
				t.setNmTarefa(rs.getString("nmTarefa"));
				t.setId_metodologia(rs.getInt("id_metodologia"));
				t.setDtPrazo(rs.getString("dtPrazo"));
				t.setDescricao(rs.getString("descricao"));
				
				
				
				listaTarefa.add(t);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	return listaTarefa;
	
}
	
}

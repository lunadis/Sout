package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String sql="DELETE FROM `metodologia` WHERE `metodologia`.`id_metodologia` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, Metodologia m) throws SQLException{
		String sql="UPDATE `metodologia` SET `nmMetodologia` = '"+m.getNmMetodologia()+"' WHERE `metodologia`.`id_metodologia` = "+b+";";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public List<Metodologia> listaMetodologia(){
		String sql = "select * from metodologia";
		System.out.println(sql);
		
		List<Metodologia> listaMetodologia = new ArrayList<Metodologia>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()) {
				Metodologia m = new Metodologia();
				
				m.setId_metodologia(rs.getInt("id_metodologia"));
				m.setNmMetodologia(rs.getString("nmMetodologia"));
				
				listaMetodologia.add(m);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return listaMetodologia;
	}

}

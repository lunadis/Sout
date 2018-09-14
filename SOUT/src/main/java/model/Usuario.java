package model;

public class Usuario {
	
	private Integer id_usuario;
	private String nmUsuario;
	private String dsEmail;
	private String dsSexo;
	
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public String getDsSexo() {
		return dsSexo;
	}
	public void setDsSexo(String dsSexo) {
		this.dsSexo = dsSexo;
	}
	
	

}

package model;

public class Tarefa {
	
	private Integer id_tarefa;
	private Integer id_usuario;
	private Integer id_metodologia;
	private String nmTarefa;
	private String descricao;
	private String dtPrazo;
	private String dtFinal;
	
	public Integer getId_tarefa() {
		return id_tarefa;
	}
	public void setId_tarefa(Integer id_tarefa) {
		this.id_tarefa = id_tarefa;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_metodologia() {
		return id_metodologia;
	}
	public void setId_metodologia(Integer id_metodologia) {
		this.id_metodologia = id_metodologia;
	}
	public String getNmTarefa() {
		return nmTarefa;
	}
	public void setNmTarefa(String nmTarefa) {
		this.nmTarefa = nmTarefa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDtPrazo() {
		return dtPrazo;
	}
	public void setDtPrazo(String dtPrazo) {
		this.dtPrazo = dtPrazo;
	}
	public String getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(String dtFinal) {
		this.dtFinal = dtFinal;
	}
	

}

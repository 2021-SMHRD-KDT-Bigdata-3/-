package DTO;

public class recomDTO {
	private int recom_num;
	private String id;
	private String game_name;
	public recomDTO(int recom_num, String id, String game_name) {
		super();
		this.recom_num = recom_num;
		this.id = id;
		this.game_name = game_name;
	}
	public int getRecom_num() {
		return recom_num;
	}
	public String getId() {
		return id;
	}
	public String getGame_name() {
		return game_name;
	}
	
	
}

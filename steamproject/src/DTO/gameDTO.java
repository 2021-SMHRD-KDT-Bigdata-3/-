package DTO;

public class gameDTO {

	private String game_name;
	private String genre;
	private int graphic;
	private String thema;
	private String atmos;
	private int multi;
	private int price;
	private int lv;
	private int playtime;
	private int score;
	public gameDTO(String game_name, String genre, int graphic, String thema, String atmos, int multi, int price,
			int lv, int playtime, int score) {
		super();
		this.game_name = game_name;
		this.genre = genre;
		this.graphic = graphic;
		this.thema = thema;
		this.atmos = atmos;
		this.multi = multi;
		this.price = price;
		this.lv = lv;
		this.playtime = playtime;
		this.score = score;
	}
	public String getGame_name() {
		return game_name;
	}
	public String getGenre() {
		return genre;
	}
	public int getGraphic() {
		return graphic;
	}
	public String getThema() {
		return thema;
	}
	public String getAtmos() {
		return atmos;
	}
	public int getMulti() {
		return multi;
	}
	public int getPrice() {
		return price;
	}
	public int getLv() {
		return lv;
	}
	public int getPlaytime() {
		return playtime;
	}
	public int getScore() {
		return score;
	}
	
}

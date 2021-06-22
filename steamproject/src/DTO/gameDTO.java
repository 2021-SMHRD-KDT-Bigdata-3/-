package DTO;

public class gameDTO {

	private int game_num;
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
	private String image;
	public gameDTO(int game_num,String game_name, String genre, int graphic, String thema, String atmos, int multi, int price,
			int lv, int playtime, int score, String image) {
		super();
		this.game_num = game_num;
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
		this.image = image;
	}
	public gameDTO(String game_name2, String genre2, int graphic2, String thema2, String atmos2, int multi2, int price2,
			int lv2, int playtime2, int score2, String image2) {
		this.game_name = game_name2;
		this.genre = genre2;
		this.graphic = graphic2;
		this.thema = thema2;
		this.atmos = atmos2;
		this.multi = multi2;
		this.price = price2;
		this.lv = lv2;
		this.playtime = playtime2;
		this.score = score2;
		this.image = image2;
	}
	public int getGame_num() {
		return game_num;
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
	public String getImage() {
		return image;
	}
	
}

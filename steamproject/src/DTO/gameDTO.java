package DTO;

public class gameDTO {

	private int game_num;
	private String game_name;
	private String genre;
	private int graphic;
	private String thema;
	private int atmos;
	private int multi;
	private int price;
	private int lv;
	private int playtime;
	private int score;
	private String image;
	private int group_num;
	
	
	
	public gameDTO(int game_num, String game_name, String genre, int graphic, String thema, int atmos, int multi,
			int price, int lv, int playtime, int score, String image) {
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

	public gameDTO(int game_num, String game_name, String genre, int graphic, String thema, int atmos, int multi,
			int price, int lv, int playtime, int score, String image, int group_num) {
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
		this.group_num = group_num;
	}

	public int getGame_num() {
		return game_num;
	}

	public void setGame_num(int game_num) {
		this.game_num = game_num;
	}

	public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getGraphic() {
		return graphic;
	}

	public void setGraphic(int graphic) {
		this.graphic = graphic;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public int getAtmos() {
		return atmos;
	}

	public void setAtmos(int atmos) {
		this.atmos = atmos;
	}

	public int getMulti() {
		return multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getPlaytime() {
		return playtime;
	}

	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getGroup_num() {
		return group_num;
	}

	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	
	
	
	
	
}

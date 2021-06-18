package DTO;

public class tendDTO {

	private int tend_num;
	private String id;
	private String genre;
	private int graphic;
	private String thema;
	private String atmos;
	private int multi;
	private int price;
	private int lv;
	public tendDTO(int tend_num, String id, String genre, int graphic, String thema, String atmos, int multi, int price,
			int lv) {
		super();
		this.tend_num = tend_num;
		this.id = id;
		this.genre = genre;
		this.graphic = graphic;
		this.thema = thema;
		this.atmos = atmos;
		this.multi = multi;
		this.price = price;
		this.lv = lv;
	}
	public int getTend_num() {
		return tend_num;
	}
	public String getId() {
		return id;
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
	
}


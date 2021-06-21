package DTO;

public class boardDTO {

	private int board_num;
	private String id;
	private String title;
	private String text;
	private String img;
	private String board_date;
	private int count_num;
	private int board_recom;
	public boardDTO(String id, String title, String text, String img) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.img = img;
	}
	public boardDTO(int board_num, String id, String title, String text, String img, String board_date, int count_num,
			int board_recom) {
		super();
		this.board_num = board_num;
		this.id = id;
		this.title = title;
		this.text = text;
		this.img = img;
		this.board_date = board_date;
		this.count_num = count_num;
		this.board_recom = board_recom;
	}
	public boardDTO(String id2, String title2, String text2) {
	}
	public int getBoard_num() {
		return board_num;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getText() {
		return text;
	}
	public String getImg() {
		return img;
	}
	public String getBoard_date() {
		return board_date;
	}
	public int getCount_num() {
		return count_num;
	}
	public int getBoard_recom() {
		return board_recom;
	}
	
}

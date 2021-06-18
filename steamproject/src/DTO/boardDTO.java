package DTO;

public class boardDTO {

	private int board_num;
	private String id;
	private String title;
	private String text;
	private String img;
	private String board_date;
	public boardDTO(int board_num, String id, String title, String text, String img, String board_date) {
		super();
		this.board_num = board_num;
		this.id = id;
		this.title = title;
		this.text = text;
		this.img = img;
		this.board_date = board_date;
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
	
	
}

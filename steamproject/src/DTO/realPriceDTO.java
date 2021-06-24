package DTO;

public class realPriceDTO {
	private int game_num;
	private int real_price;
	public realPriceDTO(int game_num, int real_price) {
		super();
		this.game_num = game_num;
		this.real_price = real_price;
	}
	public int getGame_num() {
		return game_num;
	}
	public void setGame_num(int game_num) {
		this.game_num = game_num;
	}
	public int getReal_price() {
		return real_price;
	}
	public void setReal_price(int real_price) {
		this.real_price = real_price;
	}
	
	
}

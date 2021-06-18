package DTO;

public class memberDTO {
	private String id;
	private String pw;
	private String name;
	private int age;
	private String gender;
	private String tel;
	
	public memberDTO(String id, String pw, String name, int age, String gender, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getTel() {
		return tel;
	}


}

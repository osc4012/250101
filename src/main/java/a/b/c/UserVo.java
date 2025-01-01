package a.b.c;

import lombok.Data;

@Data
public class UserVo {
	private String id;
	private String pw;
	private String name;
	
	private String search_select;
	private String search_text;
}

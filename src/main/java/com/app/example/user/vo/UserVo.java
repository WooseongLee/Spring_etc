package com.app.example.user.vo;

public class UserVo {
	private String userId;
	private String pwd;
	private String name;
	private String insdate;
	private String useyn;
	
	public UserVo() {}

	public UserVo(String userId, String pwd, String name, String insdate, String useyn) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.insdate = insdate;
		this.useyn = useyn;
	}

	public String getId() {
		return userId;
	}

	public void setId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pwd;
	}

	public void setPw(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsdate() {
		return insdate;
	}

	public void setInsdate(String insdate) {
		this.insdate = insdate;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
}
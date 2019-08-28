package com.app.example.code.vo;

public class CodeVo {

	private String cdno;
	private int cdlvl;
	private String upcd;
	private String cdname;
	private String insuser;
	private String insdate;
	private String useyn;
	
	public CodeVo() {}
	
	public CodeVo(String cdno, int cdlvl, String upcd, String cdname, String insuser, String insdate, String useyn) {
		super();
		this.cdno = cdno;
		this.cdlvl = cdlvl;
		this.upcd = upcd;
		this.cdname = cdname;
		this.insuser = insuser;
		this.insdate = insdate;
		this.useyn = useyn;
	}

	public String getCdno() {
		return cdno;
	}
	public void setCdno(String cdno) {
		this.cdno = cdno;
	}
	public int getCdlvl() {
		return cdlvl;
	}
	public void setCdlvl(int cdlvl) {
		this.cdlvl = cdlvl;
	}
	public String getUpcd() {
		return upcd;
	}
	public void setUpcd(String upcd) {
		this.upcd = upcd;
	}
	public String getCdname() {
		return cdname;
	}
	public void setCdname(String cdname) {
		this.cdname = cdname;
	}
	public String getInsuser() {
		return insuser;
	}
	public void setInsuser(String insuser) {
		this.insuser = insuser;
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
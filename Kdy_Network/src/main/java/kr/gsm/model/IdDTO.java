package kr.gsm.model;

public class IdDTO {
	private String webid;
	private String snsid;
	private String gameid;
	private String pwd;
	private String platform;
	private String joindate;

	public IdDTO() {
	}

	public IdDTO(String webid, String snsid, String gameid, String pwd, String platform, String joindate) {
		super();
		this.webid = webid;
		this.snsid = snsid;
		this.gameid = gameid;
		this.pwd = pwd;
		this.platform = platform;
		this.joindate = joindate;
	}
	


	public String getWebid() {
		return webid;
	}

	public void setWebid(String webid) {
		this.webid = webid;
	}

	public String getSnsid() {
		return snsid;
	}

	public void setSnsid(String snsid) {
		this.snsid = snsid;
	}

	public String getGameid() {
		return gameid;
	}

	public void setGameid(String gameid) {
		this.gameid = gameid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

}

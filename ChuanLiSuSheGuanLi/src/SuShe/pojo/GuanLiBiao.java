package SuShe.pojo;

/**
 * GuanLiBiao entity. @author MyEclipse Persistence Tools
 */

public class GuanLiBiao implements java.io.Serializable {

	// Fields

	private Integer guanliId;
	private String guanliname;
	private String password;

	// Constructors

	/** default constructor */
	public GuanLiBiao() {
	}

	/** full constructor */
	public GuanLiBiao(String guanliname, String password) {
		this.guanliname = guanliname;
		this.password = password;
	}

	// Property accessors

	public Integer getGuanliId() {
		return this.guanliId;
	}

	public void setGuanliId(Integer guanliId) {
		this.guanliId = guanliId;
	}

	public String getGuanliname() {
		return this.guanliname;
	}

	public void setGuanliname(String guanliname) {
		this.guanliname = guanliname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
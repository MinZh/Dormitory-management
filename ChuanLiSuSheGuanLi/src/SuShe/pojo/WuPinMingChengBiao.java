package SuShe.pojo;

/**
 * WuPinMingChengBiao entity. @author MyEclipse Persistence Tools
 */

public class WuPinMingChengBiao implements java.io.Serializable {

	// Fields

	private Integer wupinmingchengId;
	private String wupinmingchengname;

	// Constructors

	/** default constructor */
	public WuPinMingChengBiao() {
	}

	/** full constructor */
	public WuPinMingChengBiao(String wupinmingchengname) {
		this.wupinmingchengname = wupinmingchengname;
	}

	// Property accessors

	public Integer getWupinmingchengId() {
		return this.wupinmingchengId;
	}

	public void setWupinmingchengId(Integer wupinmingchengId) {
		this.wupinmingchengId = wupinmingchengId;
	}

	public String getWupinmingchengname() {
		return this.wupinmingchengname;
	}

	public void setWupinmingchengname(String wupinmingchengname) {
		this.wupinmingchengname = wupinmingchengname;
	}

}
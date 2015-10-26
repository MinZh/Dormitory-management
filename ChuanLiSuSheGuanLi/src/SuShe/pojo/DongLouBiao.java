package SuShe.pojo;

/**
 * DongLouBiao entity. @author MyEclipse Persistence Tools
 */

public class DongLouBiao implements java.io.Serializable {

	// Fields

	private Integer donglouId;
	private String donglouname;
	private Integer quyuId;

	// Constructors

	/** default constructor */
	public DongLouBiao() {
	}

	/** minimal constructor */
	public DongLouBiao(Integer quyuId) {
		this.quyuId = quyuId;
	}

	/** full constructor */
	public DongLouBiao(String donglouname, Integer quyuId) {
		this.donglouname = donglouname;
		this.quyuId = quyuId;
	}

	// Property accessors

	public Integer getDonglouId() {
		return this.donglouId;
	}

	public void setDonglouId(Integer donglouId) {
		this.donglouId = donglouId;
	}

	public String getDonglouname() {
		return this.donglouname;
	}

	public void setDonglouname(String donglouname) {
		this.donglouname = donglouname;
	}

	public Integer getQuyuId() {
		return this.quyuId;
	}

	public void setQuyuId(Integer quyuId) {
		this.quyuId = quyuId;
	}

}
package SuShe.pojo;

/**
 * QuYuBiao entity. @author MyEclipse Persistence Tools
 */

public class QuYuBiao implements java.io.Serializable {

	// Fields

	private Integer quyuId;
	private String quyuname;

	// Constructors

	/** default constructor */
	public QuYuBiao() {
	}

	/** full constructor */
	public QuYuBiao(String quyuname) {
		this.quyuname = quyuname;
	}

	// Property accessors

	public Integer getQuyuId() {
		return this.quyuId;
	}

	public void setQuyuId(Integer quyuId) {
		this.quyuId = quyuId;
	}

	public String getQuyuname() {
		return this.quyuname;
	}

	public void setQuyuname(String quyuname) {
		this.quyuname = quyuname;
	}

}
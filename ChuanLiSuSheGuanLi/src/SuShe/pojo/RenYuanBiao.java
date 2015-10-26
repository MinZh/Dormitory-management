package SuShe.pojo;

/**
 * RenYuanBiao entity. @author MyEclipse Persistence Tools
 */

public class RenYuanBiao implements java.io.Serializable {

	// Fields

	private Integer renyuanId;
	private String xingming;
	private Integer qingshihaoId;

	// Constructors

	/** default constructor */
	public RenYuanBiao() {
	}

	/** minimal constructor */
	public RenYuanBiao(Integer qingshihaoId) {
		this.qingshihaoId = qingshihaoId;
	}

	/** full constructor */
	public RenYuanBiao(String xingming, Integer qingshihaoId) {
		this.xingming = xingming;
		this.qingshihaoId = qingshihaoId;
	}

	// Property accessors

	public Integer getRenyuanId() {
		return this.renyuanId;
	}

	public void setRenyuanId(Integer renyuanId) {
		this.renyuanId = renyuanId;
	}

	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public Integer getQingshihaoId() {
		return this.qingshihaoId;
	}

	public void setQingshihaoId(Integer qingshihaoId) {
		this.qingshihaoId = qingshihaoId;
	}

}
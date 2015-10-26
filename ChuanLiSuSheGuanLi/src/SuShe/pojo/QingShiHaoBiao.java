package SuShe.pojo;

/**
 * QingShiHaoBiao entity. @author MyEclipse Persistence Tools
 */

public class QingShiHaoBiao implements java.io.Serializable {

	// Fields

	private Integer qingshihaoId;
	private String qingshihaoname;
	private Integer donglouId;

	// Constructors

	/** default constructor */
	public QingShiHaoBiao() {
	}

	/** minimal constructor */
	public QingShiHaoBiao(Integer donglouId) {
		this.donglouId = donglouId;
	}

	/** full constructor */
	public QingShiHaoBiao(String qingshihaoname, Integer donglouId) {
		this.qingshihaoname = qingshihaoname;
		this.donglouId = donglouId;
	}

	// Property accessors

	public Integer getQingshihaoId() {
		return this.qingshihaoId;
	}

	public void setQingshihaoId(Integer qingshihaoId) {
		this.qingshihaoId = qingshihaoId;
	}

	public String getQingshihaoname() {
		return this.qingshihaoname;
	}

	public void setQingshihaoname(String qingshihaoname) {
		this.qingshihaoname = qingshihaoname;
	}

	public Integer getDonglouId() {
		return this.donglouId;
	}

	public void setDonglouId(Integer donglouId) {
		this.donglouId = donglouId;
	}

}
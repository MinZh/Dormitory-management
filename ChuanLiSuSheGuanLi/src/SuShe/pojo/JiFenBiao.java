package SuShe.pojo;

/**
 * JiFenBiao entity. @author MyEclipse Persistence Tools
 */

public class JiFenBiao implements java.io.Serializable {

	// Fields

	private Integer jifenId;
	private Integer qingshihaoId;
	private String zhoushu;
	private String dengji;
	private String beizhu;

	// Constructors

	/** default constructor */
	public JiFenBiao() {
	}

	/** full constructor */
	public JiFenBiao(Integer qingshihaoId, String zhoushu, String dengji,
			String beizhu) {
		this.qingshihaoId = qingshihaoId;
		this.zhoushu = zhoushu;
		this.dengji = dengji;
		this.beizhu = beizhu;
	}

	// Property accessors

	public Integer getJifenId() {
		return this.jifenId;
	}

	public void setJifenId(Integer jifenId) {
		this.jifenId = jifenId;
	}

	public Integer getQingshihaoId() {
		return this.qingshihaoId;
	}

	public void setQingshihaoId(Integer qingshihaoId) {
		this.qingshihaoId = qingshihaoId;
	}

	public String getZhoushu() {
		return this.zhoushu;
	}

	public void setZhoushu(String zhoushu) {
		this.zhoushu = zhoushu;
	}

	public String getDengji() {
		return this.dengji;
	}

	public void setDengji(String dengji) {
		this.dengji = dengji;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}
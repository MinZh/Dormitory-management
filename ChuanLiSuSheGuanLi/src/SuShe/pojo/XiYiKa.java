package SuShe.pojo;

/**
 * XiYiKa entity. @author MyEclipse Persistence Tools
 */

public class XiYiKa implements java.io.Serializable {

	// Fields

	private Integer xiyikaId;
	private Integer renyuanId;
	private String yuE;
	private String kahao;
	private Boolean zuofeifou;

	// Constructors

	/** default constructor */
	public XiYiKa() {
	}

	/** full constructor */
	public XiYiKa(Integer renyuanId, String yuE, String kahao, Boolean zuofeifou) {
		this.renyuanId = renyuanId;
		this.yuE = yuE;
		this.kahao = kahao;
		this.zuofeifou = zuofeifou;
	}

	// Property accessors

	public Integer getXiyikaId() {
		return this.xiyikaId;
	}

	public void setXiyikaId(Integer xiyikaId) {
		this.xiyikaId = xiyikaId;
	}

	public Integer getRenyuanId() {
		return this.renyuanId;
	}

	public void setRenyuanId(Integer renyuanId) {
		this.renyuanId = renyuanId;
	}

	public String getYuE() {
		return this.yuE;
	}

	public void setYuE(String yuE) {
		this.yuE = yuE;
	}

	public String getKahao() {
		return this.kahao;
	}

	public void setKahao(String kahao) {
		this.kahao = kahao;
	}

	public Boolean getZuofeifou() {
		return this.zuofeifou;
	}

	public void setZuofeifou(Boolean zuofeifou) {
		this.zuofeifou = zuofeifou;
	}

}
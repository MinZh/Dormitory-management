package SuShe.pojo;

/**
 * WuPinBiao entity. @author MyEclipse Persistence Tools
 */

public class WuPinBiao implements java.io.Serializable {

	// Fields

	private Integer wupinId;
	private Integer qingshihaoId;
	private Integer wupinmingchengId;
	private Boolean baoxiufou;
	private Boolean baofeifou;
	private String yajin;
	private String beizhu;

	// Constructors

	/** default constructor */
	public WuPinBiao() {
	}

	/** full constructor */
	public WuPinBiao(Integer qingshihaoId, Integer wupinmingchengId,
			Boolean baoxiufou, Boolean baofeifou, String yajin, String beizhu) {
		this.qingshihaoId = qingshihaoId;
		this.wupinmingchengId = wupinmingchengId;
		this.baoxiufou = baoxiufou;
		this.baofeifou = baofeifou;
		this.yajin = yajin;
		this.beizhu = beizhu;
	}

	// Property accessors

	public Integer getWupinId() {
		return this.wupinId;
	}

	public void setWupinId(Integer wupinId) {
		this.wupinId = wupinId;
	}

	public Integer getQingshihaoId() {
		return this.qingshihaoId;
	}

	public void setQingshihaoId(Integer qingshihaoId) {
		this.qingshihaoId = qingshihaoId;
	}

	public Integer getWupinmingchengId() {
		return this.wupinmingchengId;
	}

	public void setWupinmingchengId(Integer wupinmingchengId) {
		this.wupinmingchengId = wupinmingchengId;
	}

	public Boolean getBaoxiufou() {
		return this.baoxiufou;
	}

	public void setBaoxiufou(Boolean baoxiufou) {
		this.baoxiufou = baoxiufou;
	}

	public Boolean getBaofeifou() {
		return this.baofeifou;
	}

	public void setBaofeifou(Boolean baofeifou) {
		this.baofeifou = baofeifou;
	}

	public String getYajin() {
		return this.yajin;
	}

	public void setYajin(String yajin) {
		this.yajin = yajin;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}
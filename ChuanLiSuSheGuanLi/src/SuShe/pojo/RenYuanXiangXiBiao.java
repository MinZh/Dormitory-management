package SuShe.pojo;

/**
 * RenYuanXiangXiBiao entity. @author MyEclipse Persistence Tools
 */

public class RenYuanXiangXiBiao implements java.io.Serializable {

	// Fields

	private Integer renyuanxiangxiId;
	private Integer renyuanId;
	private String xingbie;
	private String touxiang;
	private String shengfenzheng;
	private String xuehao;
	private String dianhua;
	private String beizhu;

	// Constructors

	/** default constructor */
	public RenYuanXiangXiBiao() {
	}

	/** minimal constructor */
	public RenYuanXiangXiBiao(Integer renyuanId) {
		this.renyuanId = renyuanId;
	}

	/** full constructor */
	public RenYuanXiangXiBiao(Integer renyuanId, String xingbie,
			String touxiang, String shengfenzheng, String xuehao,
			String dianhua, String beizhu) {
		this.renyuanId = renyuanId;
		this.xingbie = xingbie;
		this.touxiang = touxiang;
		this.shengfenzheng = shengfenzheng;
		this.xuehao = xuehao;
		this.dianhua = dianhua;
		this.beizhu = beizhu;
	}

	// Property accessors

	public Integer getRenyuanxiangxiId() {
		return this.renyuanxiangxiId;
	}

	public void setRenyuanxiangxiId(Integer renyuanxiangxiId) {
		this.renyuanxiangxiId = renyuanxiangxiId;
	}

	public Integer getRenyuanId() {
		return this.renyuanId;
	}

	public void setRenyuanId(Integer renyuanId) {
		this.renyuanId = renyuanId;
	}

	public String getXingbie() {
		return this.xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getTouxiang() {
		return this.touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public String getShengfenzheng() {
		return this.shengfenzheng;
	}

	public void setShengfenzheng(String shengfenzheng) {
		this.shengfenzheng = shengfenzheng;
	}

	public String getXuehao() {
		return this.xuehao;
	}

	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}

	public String getDianhua() {
		return this.dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}
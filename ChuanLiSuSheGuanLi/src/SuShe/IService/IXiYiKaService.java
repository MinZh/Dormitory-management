package SuShe.IService;

import java.util.List;
import SuShe.pojo.*;


public interface IXiYiKaService {
	public List QueryXiYiKaXinXi(String xingMing);
	public List QueryXiYiKaXinXiAll();
	public List Queryrenyuan(int renyuanId);
	public List Queryrenyuanxiangxi(int renyuanId);
	public List Queryxiyika(int renyuanId);
	public boolean modifyXiYiKa(XiYiKa  entity);
	public boolean modifyRenYuan(RenYuanBiao  entity);
	public boolean modifyRenYuanXiangXi(RenYuanXiangXiBiao  entity);
	public List Queryxiyikaxinxi(int xiyikaId);
	public int addXiYiKa(XiYiKa  entity);
	public List QueryaddXinXi(String xingMing);
}

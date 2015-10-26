package SuShe.IService;

import java.util.List;
import SuShe.pojo.*;


public interface IRenYuanService {

	 public List QueryQuYu();
	 public List QueryLouDong(int quyuId);
	 public List QueryQinShiHao(int loudongId);
	 public List QueryQinShi(int qinshihaoID);
	 public boolean deletePd(int PdId);
	 public int addRenYuan(RenYuanBiao ren);
	 public int addRenYuanXiangXi(RenYuanXiangXiBiao renyuanxiangxi);
	 public boolean editRenYuan(RenYuanBiao ren);
	 public boolean editRenYuanXiangXi(RenYuanXiangXiBiao renyuanxiangxi);
	 public boolean deletexiangXi(int PdId);

}






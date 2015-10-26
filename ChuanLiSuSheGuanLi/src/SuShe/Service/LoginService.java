package SuShe.Service;
import java.util.List;
import java.util.ArrayList;

import SuShe.IService.ILoginService;
import SuShe.pojo.*;
import SuShe.IDAO.IDAO;
public class LoginService implements ILoginService {
	private IDAO dao; //DATA ACCESS OBJECT     FOR MANIPULATE DATABASE

	public IDAO getDao() {
		return dao;
	}
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
	@Override
	public List Login(String dengluming, String password) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("FROM GuanLiBiao  as guanlibiao WHERE guanlibiao.guanliname = ? AND guanlibiao.password = ?");
		try {
			return this.dao.findByHql(query.toString(),new Object[]{dengluming,password});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}

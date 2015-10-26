package SuShe.Service;
import java.util.List;
import java.util.ArrayList;

import SuShe.pojo.*;
import SuShe.IDAO.IDAO;
import SuShe.IService.IXiYiKaService;

public class XiYiKaService implements IXiYiKaService{
	private IDAO dao; //DATA ACCESS OBJECT     FOR MANIPULATE DATABASE

	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List QueryXiYiKaXinXi(String xingMing) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT renyuanbiao.renyuanId,renyuanbiao.xingming,renyuanbiao.qingshihaoId, " +
				                           " qingshihaobiao.qingshihaoname,renyuanxinxibiao.renyuanxiangxiId,renyuanxinxibiao.xingbie," +
				                           " renyuanxinxibiao.shengfenzheng,renyuanxinxibiao.xuehao,renyuanxinxibiao.dianhua," +
				                           " xiyika.yuE,xiyika.kahao,xiyika.xiyikaId,xiyika.zuofeifou ");
		query.append(" FROM  RenYuanBiao AS renyuanbiao,QingShiHaoBiao AS qingshihaobiao,RenYuanXiangXiBiao AS renyuanxinxibiao,XiYiKa AS xiyika ");
		query.append(" WHERE renyuanbiao.renyuanId=renyuanxinxibiao.renyuanId  AND renyuanbiao.qingshihaoId=qingshihaobiao.qingshihaoId " +
				"AND renyuanbiao.xingming=? AND renyuanbiao.renyuanId=xiyika.renyuanId AND xiyika.zuofeifou='False' ");
		
		try {
				return this.dao.findByHql(query.toString(),new Object[]{xingMing});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
    }
	@Override
	public List QueryXiYiKaXinXiAll() {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT renyuanbiao.renyuanId,renyuanbiao.xingming,renyuanbiao.qingshihaoId, " +
				                           " qingshihaobiao.qingshihaoname,renyuanxinxibiao.renyuanxiangxiId,renyuanxinxibiao.xingbie," +
				                           " renyuanxinxibiao.shengfenzheng,renyuanxinxibiao.xuehao,renyuanxinxibiao.dianhua," +
				                           " xiyika.yuE,xiyika.kahao,xiyika.zuofeifou ");
		query.append(" FROM  RenYuanBiao AS renyuanbiao,QingShiHaoBiao AS qingshihaobiao,RenYuanXiangXiBiao AS renyuanxinxibiao,XiYiKa AS xiyika ");
		query.append(" WHERE renyuanbiao.renyuanId=renyuanxinxibiao.renyuanId  AND renyuanbiao.qingshihaoId=qingshihaobiao.qingshihaoId " +
				"AND renyuanbiao.renyuanId=xiyika.renyuanId ");
		
		try {
				return this.dao.findByHql(query.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
    }
	@Override
	public List Queryrenyuan(int renyuanId) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT renyuanbiao.renyuanId,renyuanbiao.xingming ");
		                                     query.append(" FROM  RenYuanBiao AS renyuanbiao ");
		          query.append(" WHERE renyuanbiao.renyuanId=? ");
		try {
				return this.dao.findByHql(query.toString(),new Object[]{renyuanId});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
    }
	
	@Override
	public List Queryrenyuanxiangxi(int renyuanId) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT renyuanxiangxibiao.renyuanxiangxiId,renyuanxiangxibiao.renyuanId,renyuanxiangxibiao.xingbie, " +
				                              " renyuanxiangxibiao.shengfenzheng,renyuanxiangxibiao.xuehao,renyuanxiangxibiao.dianhua ");
		                          query.append(" FROM  RenYuanXiangXiBiao AS renyuanxiangxibiao ");
		                          query.append(" WHERE renyuanxiangxibiao.renyuanId=? ");
		try {
				return this.dao.findByHql(query.toString(),new Object[]{renyuanId});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
    }
	
	@Override
	public List Queryxiyika(int renyuanId){
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT xiyika.renyuanId,xiyika.yuE,xiyika.kahao,xiyika.xiyikaId ");
		                          query.append(" FROM  XiYiKa AS xiyika ");
		                          query.append(" WHERE xiyika.renyuanId=? AND xiyika.zuofeifou=false ");               
		try {
				return this.dao.findByHql(query.toString(),new Object[]{renyuanId});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	
    }
	
	@Override
	public boolean modifyXiYiKa(XiYiKa  entity){
		 try{
		    return dao.edit(entity);
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
	
	@Override
	public boolean modifyRenYuan(RenYuanBiao  entity){
		 try{
		    return dao.edit(entity);
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
	@Override
	public boolean modifyRenYuanXiangXi(RenYuanXiangXiBiao  entity){
		 try{
		    return dao.edit(entity);
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
	
	
	@Override
	public List Queryxiyikaxinxi(int xiyikaId){
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT xiyika.renyuanId,xiyika.yuE,xiyika.kahao,xiyika.xiyikaId,xiyika.zuofeifou ");
		                          query.append(" FROM  XiYiKa AS xiyika ");
		                          query.append(" WHERE xiyika.xiyikaId=? ");               
		try {
				return this.dao.findByHql(query.toString(),new Object[]{xiyikaId});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	
    }
	
	
	@Override
	public int addXiYiKa(XiYiKa entity){
		 try{
		    return dao.addAndGetId4Integer(entity);
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		}
	
	@Override
//	public List QueryShangPinXinXi(int shangPinId,int lvl)
	public List QueryaddXinXi(String xingMing) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer(" SELECT renyuanbiao.renyuanId,renyuanbiao.xingming,renyuanbiao.qingshihaoId, " +
				                           " qingshihaobiao.qingshihaoname,renyuanxinxibiao.renyuanxiangxiId,renyuanxinxibiao.xingbie," +
				                           " renyuanxinxibiao.shengfenzheng,renyuanxinxibiao.xuehao,renyuanxinxibiao.dianhua," +
				                           " xiyika.yuE,xiyika.kahao,xiyika.xiyikaId,xiyika.zuofeifou ");
		query.append(" FROM  RenYuanBiao AS renyuanbiao,QingShiHaoBiao AS qingshihaobiao,RenYuanXiangXiBiao AS renyuanxinxibiao,XiYiKa AS xiyika ");
		query.append(" WHERE renyuanbiao.renyuanId=renyuanxinxibiao.renyuanId  AND renyuanbiao.qingshihaoId=qingshihaobiao.qingshihaoId " +
				"AND renyuanbiao.xingming=? AND renyuanbiao.renyuanId=xiyika.renyuanId ");
		
		try {
				return this.dao.findByHql(query.toString(),new Object[]{xingMing});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
    }
	
}

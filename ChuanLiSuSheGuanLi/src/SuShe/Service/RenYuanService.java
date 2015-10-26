package SuShe.Service;


import java.util.List;
import java.util.ArrayList;

import SuShe.pojo.*;
import SuShe.IDAO.IDAO;
import SuShe.IService.IRenYuanService;

public class RenYuanService implements IRenYuanService{
	private IDAO dao; //DATA ACCESS OBJECT     FOR MANIPULATE DATABASE

	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
		
	}
	
	@Override
	public List QueryQuYu(){
		try{
		    StringBuffer queryString=new StringBuffer();
		    queryString.append("SELECT quyu.quyuId,quyu.quyuname ");
		    queryString.append("FROM QuYuBiao AS quyu   ");
//		    queryString.append("WHERE  ");
			    return dao.findByHql(queryString.toString());
		}
		catch (Exception ex){
			return null;
		}
	}
	
	
	@Override
	public List QueryLouDong(int quyuId){
		try{
		    StringBuffer queryString=new StringBuffer();
		    queryString.append("SELECT lou.donglouId,lou.donglouname,lou.quyuId ");
		    queryString.append("FROM DongLouBiao AS lou,QuYuBiao AS quyu   ");
		    queryString.append("WHERE  lou.quyuId=quyu.quyuId AND lou.quyuId=?   ");
			    return dao.findByHql(queryString.toString(),new Object[]{quyuId});
		}catch (Exception ex){
			return null;
		}
	}
	
	@Override
	public List QueryQinShiHao(int loudongId){
		try{
		    StringBuffer queryString=new StringBuffer();
		    queryString.append("SELECT qinshi.qingshihaoId,qinshi.qingshihaoname,qinshi.donglouId  ");
		    queryString.append("FROM QingShiHaoBiao AS qinshi,DongLouBiao AS lou   ");
		    queryString.append("WHERE  qinshi.donglouId=lou.donglouId  AND qinshi.donglouId=?   ");
			    return dao.findByHql(queryString.toString(),new Object[]{loudongId});
		}catch (Exception ex){
			return null;
		}
	}
	
	@Override
    public List QueryQinShi(int qinshihaoID){
    	try{
		    StringBuffer queryString=new StringBuffer();
		    queryString.append("SELECT qinshi.qingshihaoId,qinshi.qingshihaoname,ren.xingming,ren.qingshihaoId,ren.renyuanId, " +
		    		"renyuanxiangxi.xingbie,renyuanxiangxi.shengfenzheng,renyuanxiangxi.xuehao,renyuanxiangxi.dianhua  ");
		    
		    queryString.append("FROM  QingShiHaoBiao AS qinshi,RenYuanBiao as ren,RenYuanXiangXiBiao as renyuanxiangxi  ");
		    queryString.append("WHERE   qinshi.qingshihaoId=ren.qingshihaoId and " +
		    		" ren.renyuanId = renyuanxiangxi.renyuanId and ren.qingshihaoId=?  ");
		    return dao.findByHql(queryString.toString(),new Object[]{qinshihaoID});
		}catch (Exception ex){
			return null;
		}
    }
	
	
	
    @Override
	public boolean deletePd(int PdId) {
    	
    	RenYuanBiao renyuan;
    	try {
			renyuan = dao.getById(RenYuanBiao.class, PdId);		
			return dao.remove(renyuan);		
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
    @Override
	public boolean deletexiangXi(int PdId) {
    	
    	RenYuanXiangXiBiao renyuanxiangxi;
    	try {
    		renyuanxiangxi = dao.getById(RenYuanXiangXiBiao.class, PdId);		
			return dao.remove(renyuanxiangxi);		
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public int addRenYuan(RenYuanBiao ren) {
		// TODO Auto-generated method stub
		try{
			return dao.addAndGetId4Integer(ren);
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	@Override
	public int addRenYuanXiangXi(RenYuanXiangXiBiao renyuanxiangxi) {
		// TODO Auto-generated method stub
		try{
			return dao.addAndGetId4Integer(renyuanxiangxi);
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public boolean editRenYuan(RenYuanBiao ren){//
		// TODO Auto-generated method stub
		try {
//			return dao.addAndGetId4Integer(shengChanRuKu);
			return dao.edit(ren);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean editRenYuanXiangXi(RenYuanXiangXiBiao renyuanxiangxi) {
		// TODO Auto-generated method stub
		try{
			return dao.edit(renyuanxiangxi);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
}

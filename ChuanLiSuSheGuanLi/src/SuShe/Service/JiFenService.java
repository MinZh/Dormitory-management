package SuShe.Service;


import java.util.List;
import java.util.ArrayList;

import SuShe.pojo.*;
import SuShe.IDAO.IDAO;
import SuShe.IService.IJiFenService;

public class JiFenService implements IJiFenService{
	private IDAO dao; //DATA ACCESS OBJECT     FOR MANIPULATE DATABASE

	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}


	@Override
	public List queryAllJiFen(int donglouID,String zhoushu) {
		// TODO Auto-generated method stub
		try{
			StringBuffer queryString=new StringBuffer();
			queryString.append("SELECT qsh.qingshihaoname,jfb.dengji ");
			queryString.append("FROM QingShiHaoBiao as qsh,JiFenBiao as jfb ");
			queryString.append("WHERE qsh.qingshihaoId=jfb.qingshihaoId and  qsh.donglouId=? and jfb.zhoushu=? ");
			return dao.findByHql(queryString.toString(), new Object[]{donglouID,zhoushu});
		}catch (Exception ex){
			return null;
	    }
	}

	@Override
	public List queryAllQuYu() {
		// TODO Auto-generated method stub
		try{
			StringBuffer queryString=new StringBuffer();
			queryString.append("SELECT qyb.quyuId,qyb.quyuname ");
			queryString.append("FROM QuYuBiao as qyb ");
			return dao.findByHql(queryString.toString());
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public List queryLouMingByQuYuId(int quyuid) {
		// TODO Auto-generated method stub
		try{
			StringBuffer queryString=new StringBuffer();
			queryString.append("SELECT dlb.donglouId,dlb.donglouname ");
			queryString.append("FROM DongLouBiao as dlb ");
			queryString.append("WHERE dlb.quyuId=? ");
			return dao.findByHql(queryString.toString(),new Object[]{quyuid});
			
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public List queryQinShiHaoByDongLouId(int donglouid) {
		// TODO Auto-generated method stub
		try{
			StringBuffer queryString=new StringBuffer();
			queryString.append("SELECT qsb.qingshihaoId,qsb.qingshihaoname ");
			queryString.append("FROM QingShiHaoBiao as qsb ");
			queryString.append("WHERE qsb.donglouId=? ");
			return dao.findByHql(queryString.toString(),new Object[]{donglouid});
			
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public int addQinShiDengJi(JiFenBiao jifenshuju) {
		// TODO Auto-generated method stub
		try{
			return dao.addAndGetId4Integer(jifenshuju);
		}catch(Exception ex){
			return 0;
		}
	}

	@Override
	public boolean editJiFenBiao(int qinshiid, String zhoushu, String dengji,
			String beizhu) {
		// TODO Auto-generated method stub
		try{
			JiFenBiao jifen=new JiFenBiao();
			StringBuffer str=new StringBuffer();
			str.append("SELECT jifen.jifenId,jifen.qingshihaoId,jifen.zhoushu,jifen.dengji,jifen.beizhu FROM JiFenBiao as jifen " + 
			    "WHERE jifen.qingshihaoId=? and jifen.zhoushu=? ");
			List jifenb=dao.findByHql(str.toString(),new Object[]{qinshiid,zhoushu});
			for(int i = 0;i<jifenb.size();i++){
				Object[] obj = (Object[])jifenb.get(i);
				jifen.setJifenId(Integer.parseInt(obj[0].toString().trim()));
				jifen.setQingshihaoId(Integer.parseInt(obj[1].toString().trim()));
				jifen.setZhoushu(obj[2].toString().trim());
				jifen.setDengji(dengji);
				jifen.setBeizhu(beizhu);
			}
			return dao.edit(jifen);
			
		}catch(Exception ex){
			return false;
		}
		
	}

	@Override
	public List queryQinShiWuPing(int qinshiid) {
		// TODO Auto-generated method stub
		try{
			StringBuffer str=new StringBuffer();
			str.append("SELECT qs.qingshihaoname,wpm.wupinmingchengname,wp.baoxiufou,wp.baofeifou,wp.yajin,wp.beizhu ");
			str.append("FROM QingShiHaoBiao as qs,WuPinBiao as wp,WuPinMingChengBiao as wpm ");
			str.append("WHERE qs.qingshihaoId=? and wp.qingshihaoId=qs.qingshihaoId and wp.wupinmingchengId=wpm.wupinmingchengId ");
			return dao.findByHql(str.toString(),new Object[]{qinshiid});
		}catch(Exception ex){
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package SuShe.IService;

import java.util.List;
import SuShe.pojo.*;


public interface IJiFenService {
	public List queryAllJiFen(int donglouID,String zhoushu); //查询一栋楼的所有寝室分数
	public List queryAllQuYu();//查询学校所有区域
    public List queryLouMingByQuYuId(int quyuid);//根据区域id查询楼名
    public List queryQinShiHaoByDongLouId(int donglouid);//根据栋楼id查询所有寝室
    public int addQinShiDengJi(JiFenBiao jifenshuju);//根据参数新增计分数据
    public boolean editJiFenBiao(int qinshiid,String zhoushu,String dengji,String beizhu);//修改寝室等级
    
    public List queryQinShiWuPing(int qinshiid);//查询一个寝室的物品所有状态
}






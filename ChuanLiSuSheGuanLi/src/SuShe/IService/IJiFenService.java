package SuShe.IService;

import java.util.List;
import SuShe.pojo.*;


public interface IJiFenService {
	public List queryAllJiFen(int donglouID,String zhoushu); //��ѯһ��¥���������ҷ���
	public List queryAllQuYu();//��ѯѧУ��������
    public List queryLouMingByQuYuId(int quyuid);//��������id��ѯ¥��
    public List queryQinShiHaoByDongLouId(int donglouid);//���ݶ�¥id��ѯ��������
    public int addQinShiDengJi(JiFenBiao jifenshuju);//���ݲ��������Ʒ�����
    public boolean editJiFenBiao(int qinshiid,String zhoushu,String dengji,String beizhu);//�޸����ҵȼ�
    
    public List queryQinShiWuPing(int qinshiid);//��ѯһ�����ҵ���Ʒ����״̬
}






package com.newlife.fitness.entity;

import java.util.List;

public class Page {

private int pagecount;//��ʾ�� ����� �� ��ҳ 
	
public int getPagecount() {
	return pagecount;
}

public void setPagecount(int pagecount) {
	this.pagecount = pagecount;
}

public int getPagesize() {
	return pagesize;
}

public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}

public int getPagesum() {
	return pagesum;
}

public void setPagesum(int pagesum) {
	if(pagesum>0){
	this.pagesum = pagesum;
	pagecount=this.pagesum%pagesize==0?(this.pagesum/pagesize):(this.pagesum/pagesize+1);
	// 48%5=3  ���� this.pagesum/pagesize+1     ����= 48/5+1 =8;
	//   �����pagesum ���� 0   ֮��ͻ��������  if����� ����  �ó� �������ʾ���� ҳ ��
	
	}
}

public int getDangqianpage() {
	return dangqianpage;
}
// ��servlet �� �Ҵ� һ��  ��ǰ�� ѡ�е�ҳ������ ������  �� ���� if �ж�  
// ���ڵ��� 0 �� �������� if
public void setDangqianpage(int dangqianpage) {
	if(dangqianpage>0){
		this.dangqianpage=dangqianpage;
		this.dangqianpage=(this.dangqianpage-1)*6;
		
		
		// ���� page ʵ���� д�� ��ʼҳ���  �� ҳ����-1 * ��ʾ����=��ʼҳ��
	}
		
		
	
	
}



private int  pagesize=6;	// ÿҳ��ʾ24���ֹ�����	 
//        48 ����5  =
	
private int pagesum; //�ܹ���������Ϣ
private int dangqianpage; //��ǰҳ�� Ҳ���ǵ�һҳ
	


	
}

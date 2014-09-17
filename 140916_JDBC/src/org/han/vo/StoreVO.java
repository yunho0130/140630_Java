package org.han.vo;

import java.sql.Date;

/**
 *sno number,
  sname varchar2(500) not null, -- null이 들어간 테이블은 인덱스를 태울 수 없다. 
  addr varchar2(500), 
  keyword varchar2(500) not null,
  tel varchar2(20), 
  sdesc varchar2(1000) not null, 
  regdate date default sysdate
  view cnt

 * @author Administrator
 *
 */

public class StoreVO {
	
	private Integer sno;
	private String sname;
	private String addr;
	private String keyword;
	private String tel;
	
	private String sdesc;
	private Date regdate;
	private int viewcnt;
	
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	@Override
	public String toString() {
		return "StoreVO [sno=" + sno + ", sname=" + sname + ", addr=" + addr
				+ ", keyword=" + keyword + ", tel=" + tel + ", sdesc=" + sdesc
				+ ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]";
	}

	

}

package org.thinker.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
	
	@Insert("insert into tbl_member(userid, userpw, username, phone, email)" + 
	"values(#{userid}, #{userpw}, #{username}, #{phone}, #{email})")
	public void create(MemberVO vo) throws Exception;
	
	@Select("select * from tbl_member where userid = #{userid}")
	public MemberVO read(String userid) throws Exception;
	
	
	public void delete(String userid) throws Exception;
}

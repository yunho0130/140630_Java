package org.han.dao;

import java.util.ArrayList;
import java.util.List;

import org.han.vo.MP3VO;

public class MP3DAOImpl implements MP3DAO {
   List<MP3VO> Mp3VO; 
   MP3VO tempVO;
   enum SQL {
      
         INSERT(" insert into tbl_mp3 (MNO,TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB)"
            + " values (seq_mp3.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
            SELECT(" select * from ( select /*+INDEX_DESC(tbl_mp3, pk_mp3) */ rownum rn, mno, title, art, img"
            + " from tbl_mp3 where mno>0 and rownum<= ? ) where rn >? "),
            UPDATE("  update tbl_mp3 set title = ? where mno = ?"),
          DELETE("   delete from tbl_mp3 where mno = ?");
         
         String value;
         
         SQL(String value) {
            this.value = value;
         }
   }

   @Override
   public void create(MP3VO vo) throws Exception {
      
      new SQLExecutor(){

         @Override
         protected void doJob() throws Exception {

            pstmt = con.prepareStatement(SQL.INSERT.value);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getFileName());
            pstmt.setString(3, vo.getDescCont());
            pstmt.setString(4, vo.getCate());
            pstmt.setString(5, vo.getUserID());
            pstmt.setInt(6, vo.getrCount());
            pstmt.setInt(7, vo.getvCount());
            pstmt.setString(8, vo.getArt());
            pstmt.setString(9, vo.getImg());
            pstmt.setString(10, vo.getAlb());
            
            int resultCount = pstmt.executeUpdate();
            
            if (resultCount < 1){
               throw new Exception("INSERT ERROR!!");
            } 
            
            
            //TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB
         }
         
      }.execute();

   }

   @Override
   public List<MP3VO> mainList(Integer maxNum, Integer minNum) throws Exception {
      
      Mp3VO = new ArrayList<MP3VO>(); 
      new SQLExecutor(){
         
         @Override
         protected void doJob() throws Exception{
            pstmt = con.prepareStatement(SQL.SELECT.value);
            pstmt.setInt(1, maxNum);
            pstmt.setInt(2, minNum);
            // sname, addr, keyword, tel, sdesc
            rs = pstmt.executeQuery();

            while(rs.next()){
               tempVO = new MP3VO();
               //mp3Vo를 이용해서 리스트를 넣어준다.
               //한줄씩 넘어가면서 널이 아닌값을 넣어줘야 한다.
               tempVO.setRn (rs.getInt(1));
               tempVO.setMno(rs.getInt(2));
               tempVO.setTitle(rs.getString(3));
               tempVO.setArt(rs.getString(4));
               tempVO.setImg(rs.getString(5));
               Mp3VO.add(tempVO);
            }
//            rownum rn, mno, title, art            //ART,IMG,ALB
            
//            tempVO.setCate(rs.getString(5));
//            tempVO.setUserID(rs.getString(6));
//            tempVO.setrCount(rs.getInt(7));
//            tempVO.setvCount(rs.getInt(8));
//            tempVO.setRegDate(rs.getDate(10));
//            tempVO.setArt(rs.getString(10));
//            tempVO.setImg(rs.getString(11));
//            tempVO.setAlb(rs.getString(12));

            if (tempVO == null){
               throw new Exception("READ ERROR");
            }
         }
      }.execute();
//      System.out.println(Mp3VO.toString());
      
      return Mp3VO;
     

   }

   @Override
   public void update(MP3VO vo) throws Exception {
      
      new SQLExecutor(){

         @Override
         protected void doJob() throws Exception {

            pstmt = con.prepareStatement(SQL.UPDATE.value);
            pstmt.setString(1, vo.getTitle());
            pstmt.setInt(2, vo.getMno());
            
            
            int resultCount = pstmt.executeUpdate();
            
            if (resultCount < 1){
               throw new Exception("UPDATE ERROR!!");
            }
         }
      }.execute();
   }

   @Override
   public void delete(Integer mno) throws Exception {

      new SQLExecutor(){

         @Override
         protected void doJob() throws Exception {

            pstmt = con.prepareStatement(SQL.DELETE.value);
            pstmt.setInt(1, mno);
            
            
            int resultCount = pstmt.executeUpdate();
            
            if (resultCount < 1){
               throw new Exception("DELETE ERROR!!");
            }
         }
      }.execute();

   }

//   List<MP3VO> Mp3VO2; 
//   MP3VO tempVO2;
//   public List<MP3VO> getTableList() {
//      //리스트
//
//      List<MP3VO> mp3List = new ArrayList<MP3VO>();
//      
//      mp3List = dao.read(16, 0);
////      System.out.println(vo.toString());
//      for (MP3VO mp3vo2 : mp3List) {
//         System.out.println(mp3vo2.toString());
//      }
//      return mp3List;
//   }
}

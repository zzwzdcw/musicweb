package com.musicweb.dao;

import com.musicweb.entity.CommitEntiy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;



@Mapper
public interface CommitDao {

    //返回本歌曲下所有的评论
    @Select("select name,img,content,creattime \n" +
            "from committb,user \n" +
            "where musicid = #{musicid} && committb.userid=user.id")
//    @Select("select name,img,content,creattime form commit where musicid=musicid")
    List<CommitEntiy> selectAllCommit(int musicid);

    @Insert("insert into committb (musicid,userid,content,creattime) values ('${musiceid}','${userid}','${content}','${creatTime}')")
    int addCommit(CommitEntiy commitEntiy);
}

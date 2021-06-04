package com.musicweb.service;

import com.musicweb.entity.CommitEntiy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommitServiceInterface {


    //返回本歌曲下所有的评论
    List<CommitEntiy> selectAllCommit(int musicid);

    int addCommit(CommitEntiy commitEntiy);
}

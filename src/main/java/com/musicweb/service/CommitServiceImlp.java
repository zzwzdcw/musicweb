package com.musicweb.service;

import com.musicweb.dao.CommitDao;
import com.musicweb.entity.CommitEntiy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CommitServiceImlp implements CommitServiceInterface {
    @Resource
    private CommitDao commitDao;


    @Override
    public List<CommitEntiy> selectAllCommit(int musicid) {
        System.out.println("查询评论中...");
        return  commitDao.selectAllCommit(musicid);
    }

    @Override
    public int addCommit(CommitEntiy commitEntiy) {
        return commitDao.addCommit(commitEntiy);

    }
}

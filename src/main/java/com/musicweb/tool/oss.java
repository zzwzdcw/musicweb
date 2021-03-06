package com.musicweb.tool;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class oss {
    //    //构造一个带指定 Region 对象的配置类
    static Configuration cfg = new Configuration(Region.region0());
    //...其他参数参考类注释
     static UploadManager uploadManager = new UploadManager(cfg);
    //...生成上传凭证，然后准备上传
    private final static String accessKey = "6ekVvLF072ugbrZkY5cb2gBj-SuEckW0dqjYgYG1";
    private final static String secretKey = "xMiYnXso4nHMkDqvbsgXMPdDnguumMN9rcuc5rE6";
    private final static String bucket = "10gstaticnqnyspace";
    private final static String prefix = "musicweb/music/";

    public static String musicFileSimpUp(String InputFile,String name) {
        System.out.println("这里是准备在七牛云上传的地方");
        System.out.println(InputFile);
        String key = prefix + name;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken=auth.uploadToken(bucket, key);
//        System.out.println(auth.uploadToken(bucket, key));
        try {
            Response response = uploadManager.put(InputFile, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return key;
    }

}


package com.musicweb.tool;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class oss{
    //构造一个带指定 Region 对象的配置类
    Configuration cfg = new Configuration(Region.region0());
//...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);
    //...生成上传凭证，然后准备上传
    private final String accessKey = "6ekVvLF072ugbrZkY5cb2gBj-SuEckW0dqjYgYG1";
    private final String secretKey = "xMiYnXso4nHMkDqvbsgXMPdDnguumMN9rcuc5rE6";
    private final String bucket = "10gstaticnqnyspace";
    //如果是Windows情况下，格式是 D:\\qiniu\\test.png
    private String localFilePath ;
    //默认不指定key的情况下，以文件内容的hash值作为文件名
    private String key;
    private Response response;
    private DefaultPutRet putRet;

    public String getLocalFilePath() {
        return localFilePath;
    }

    public void setLocalFilePath(String localFilePath) {
        this.localFilePath = localFilePath;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int fileUp() {

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);


        {
            try {
                response = uploadManager.put(localFilePath, key, upToken);
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }

        //解析上传成功的结果

        {
            try {
                putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            } catch (QiniuException ex) {
                System.out.println(putRet.key);
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }
        return 0;
    }

}


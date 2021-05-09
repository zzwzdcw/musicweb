package com.musicweb.controller;

import com.github.pagehelper.util.StringUtil;
import com.musicweb.entity.MusicEntiy;
import com.musicweb.service.MusicServiceInterface;

import com.qiniu.util.Auth;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.util.List;

@Controller
public class backstageController {
    @Resource
    private MusicServiceInterface musicServiceInterface;

    /**
     * 刷新后台主页面，展示所有的数据
     * @param model
     * @return
     */
    @RequestMapping("/background/backstage")
    public String hello(Model model){

        List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();

        model.addAttribute("musicEntiys",musicEntiys);

        return "backstage";

    }

    /**
     * 删除一个音乐，如果失败成功都通过 this.hello 返回后台
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/background/delonemusic")
    public String delOneMusic(int id,Model model){
        if (musicServiceInterface.delOneMusicByID(id)==0)
        {
            this.hello(model);
        }
            this.hello(model);
        return "backstage.html";//其实根本不从这里结束
    }

    /**
     * 跳转到backstageAddMusic.html
     * @param model
     * @return
     */
    @RequestMapping("/background/addmusic")
    public String addmusic(Model model){
        return "backstageAddMusic";
    }

    /**
     * 添加音乐文件到数据库以及oss中
     * TODO 得不到文件的具体路径，之后尝试一下用用看先传入服务器之后从服务器传到oss
     * @param name
     * @param time
     * @param multipartFile
     * @param author
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/background/Addmusic")
    public String AddMusic(String name,String time,String author,Model model,MultipartFile multipartFile) throws Exception {
        InputStream inputStream=multipartFile.getInputStream();
        File file = new File("/file/upload/"+name);

        FileOutputStream fileOutputStream = new FileOutputStream("/file/upload/"+name);
        fileOutputStream.write(inputStream.readAllBytes());
        musicServiceInterface.AddMusic(name,time,"/file/upload"+name,author);
        this.addmusic(model);
        return "backstageAddMusic";
    }


}

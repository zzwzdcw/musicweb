package com.musicweb.controller;

import com.github.pagehelper.util.StringUtil;
import com.musicweb.entity.MusicEntiy;
import com.musicweb.service.MusicServiceInterface;

import com.qiniu.util.Auth;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
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
import java.io.*;
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
     * 删除的页面控制器
     * @return
     */


    @RequestMapping("/background/DelOneMusic")
    public String DelOneMusic(Model model){
        List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();

        model.addAttribute("musicEntiys",musicEntiys);

        return "backstageDelMusic";
    }


    /**
     * 删除一个音乐，成功或者失败都会返回到删除界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/background/delonemusic")
    public String delOneMusic(int id,Model model){
        if (musicServiceInterface.delOneMusicByID(id)==0)
        {

            List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();

            model.addAttribute("musicEntiys",musicEntiys);

            return "backstageDelMusic";
        }
        List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();

        model.addAttribute("musicEntiys",musicEntiys);

        return "backstageDelMusic";
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
        String InputFilePat=this.getUploadPath()+"\\"+name;
        File file = new File(InputFilePat);
        model.addAttribute("stat","正在上传到服务器");
        System.out.println("应该上传到的位置是这里");
        System.out.println(InputFilePat);
        FileOutputStream fileOutputStream = new FileOutputStream(InputFilePat);
        fileOutputStream.write(inputStream.readAllBytes());
        fileOutputStream.close();
        System.out.println("文件上传成功！");
        model.addAttribute("stat","正在传输至oss");
        musicServiceInterface.AddMusic(name,time,InputFilePat,author);
        inputStream.close();
        if(file.delete()){
            System.out.println(file.getName() + " 文件已被删除！");
            model.addAttribute("stat","删除服务器暂存文件成功");

        }else{
            System.out.println(file.getName() + "文件删除失败！");
            model.addAttribute("stat","删除服务器暂存文件失败");

        }
        model.addAttribute("stat","完成上传！");

        this.addmusic(model);
        return "backstageAddMusic";
    }

    /**
     * 获取当前系统路径
     */
    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static/upload/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }


}

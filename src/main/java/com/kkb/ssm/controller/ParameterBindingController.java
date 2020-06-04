package com.kkb.ssm.controller;

import com.kkb.ssm.po.Item;
import com.kkb.ssm.po.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("parameterBinding")
@RestController
public class ParameterBindingController {
    //参数名与请求URL中参数名一致
    @RequestMapping("simpleParam")
    public String simpleParam(Integer id, String name, HttpServletRequest request){
        return "id :" + id + " name:" + name + " request:" + request.getParameter("id");
    }

    //@RequestParam：可以理解为request.getParameter("参数key")
    //【参数key】与请求URL中参数名一致
    @RequestMapping("requestParam")
    public String requestParam(@RequestParam("uid") Integer id){
        return "id : " + id;
    }

    //pojo
    @RequestMapping("pojoParam")
    public Item pojoParam(Item item){
        return item;
    }

    //string date
    @RequestMapping("stringDateParam")
    public String stringDateParam(String birthday){
        return birthday;
    }

    //Date
    //需要配置日期转换器
    @RequestMapping("dateParam")
    public String dateParam(Date birthday){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*try {
            return sdf.parse(sdf.format(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        return sdf.format(birthday);
    }

    //简单数组
    @RequestMapping("simpleArrayParam")
    public Integer[] simpleArrayParam(Integer[] id){
        return id;
    }

    @RequestMapping("simpleListParam")
    //No primary or default constructor found for interface java.util.List
    public List<Integer> simpleListParam(@RequestParam("id") List<Integer> id){
        return id;
    }

    @RequestMapping("simpleListInPojoParam")
    public List<Item> simpleListInPojoParam(Item item){
        List<Integer> uid = item.getUid();
        List<Item> list = new ArrayList<>();
        for(Integer id : uid){
            Item i = new Item();
            i.setId(id);
            list.add(i);
        }
        return list;
    }

    @RequestMapping("listAndMapInPojoParam")
    public User listAndMapInPojoParam(User user){
        return user;
    }

    //需要在配置文件中配置多部件解析器
    /*
    produces = "text/plain;charset=utf-8"
    解决：返回参数为String类型，页面显示？？？？的问题
     */
    @RequestMapping(value = "fileupload", produces = "text/plain;charset=utf-8")
    public String fileUpload(MultipartFile uploadFile) throws IOException {
        if(uploadFile == null) {
            return "上传失败";
        }
        String originalFilename = uploadFile.getOriginalFilename();
        if(originalFilename == null || originalFilename.length() <= 0 ){
            return "上传失败";
        }
        // 存放图片的物理路径
        String filePath = "D:\\";
        // 获取上传文件的扩展名
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 新文件的名称
        String newFileName = UUID.randomUUID() + extName;
        // 新的文件
        File newFile = new File(filePath + newFileName);
        // 把上传的文件保存成一个新的文件
        uploadFile.transferTo(newFile);
        // 同时需要把新的文件名更新到数据库中
        return "上传成功";
    }
}

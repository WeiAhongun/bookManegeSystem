package com.sm.cn.controller;

import com.github.pagehelper.util.StringUtil;
import com.sm.cn.entity.Book;
import com.sm.cn.vo.ResultJson;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@RestController
public class CommonController {

    @PostMapping("pages/upload")
    public ResultJson upload(HttpServletRequest req) throws IOException, ServletException {
        String path = req.getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        Part part = req.getPart("part");
        String cd = part.getHeader("Content-Disposition");
        //获得传来的文件名
        String filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
        //获得文件名后缀
        String extension = StringUtils.getFilenameExtension(filename);
        //生成新的文件名
        String fileName = System.currentTimeMillis()+"."+extension;
        //写入
        part.write(path+fileName);

        return ResultJson.success("http://localhost:8080/upload/"+fileName);
    }

}

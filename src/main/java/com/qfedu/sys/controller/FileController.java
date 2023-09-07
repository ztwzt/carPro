package com.qfedu.sys.controller;

import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.util.AppFileUtils;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("file")
public class FileController {
    //实现缩略图  /file/downloadShowFile.action?path=" + d.carimg
    @ResponseBody
    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse httpServletResponse) {
        return AppFileUtils.downloadFile(httpServletResponse, path, "");
    }

    //上传图片
    @RequestMapping("uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile mf) throws
            IllegalStateException, IOException {
        // ⽂件上传的⽗⽬录
        String parentPath = AppFileUtils.PATH;
        // 得到当前⽇期作为⽂件夹名称
        String dirName = RandomUtils.getCurrentDateForString();
        // 构造⽂件夹对象
        File dirFile = new File(parentPath, dirName);
        if (!dirFile.exists()) {
            dirFile.mkdirs();// 创建⽂件夹
        }
        // 得到⽂件原名
        String oldName = mf.getOriginalFilename();
        // 根据⽂件原名得到新名
        String newName =
                RandomUtils.createFileNameUseTime(oldName,
                        sysConstant.FILE_UPLOAD_TEMP);
        File dest = new File(dirFile, newName);
        mf.transferTo(dest);
        Map<String, Object> map = new HashMap<>();
        map.put("src", dirName + "/" + newName);
        return new DataGridView(map);
    }

}

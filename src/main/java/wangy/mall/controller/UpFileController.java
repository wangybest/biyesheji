package wangy.mall.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UpFileController {
   /* private String filePath="D:/project/mall/src/main/resources/static/img/photos/"; //定义上传文件的存放位置

    @PostMapping("upload")
    public String upLoadFile(MultipartFile uploadFile){


        //判断文件夹是否存在,不存在则创建
        File file=new File(filePath);

        if(!file.exists()){
            file.mkdirs();
        }
        String originalFileName = uploadFile.getOriginalFilename();//获取原始图片的扩展名
        String newFileName = UUID.randomUUID()+originalFileName;
        String newFilePath=filePath+newFileName; //新文件的路径

        try {
            uploadFile.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
            System.out.println("上传图片成功");
            return newFileName;
        }catch (IllegalStateException e ) {
            return "f1";
        }catch(IOException e1){
            return "failed";
        }
        //return newFilePath;
    }
*/
}

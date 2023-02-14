package com.supermarke.ssm.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UpploadPhoto {

    public static Map<String,String> uploadB(MultipartFile[] attachs, HttpServletRequest request){
        Map<String,String> pathMap = new HashMap<>();
        String idPicPath = "";
        String workPicPath = "";
        for (int i=0;i< attachs.length;i++){
            MultipartFile idPic = attachs[i];
            if (!idPic.isEmpty()){
                String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
                System.out.println("上传路径："+path);
                String oldName = idPic.getOriginalFilename();
                String prefix = FilenameUtils.getExtension(oldName);
                int filesize=5000000;
                if (idPic.getSize() > filesize){
                    request.setAttribute("uploadFileError","上传文件大小不得超过500kb");
                    pathMap.put("error","sysUser/add");
                    return pathMap;
                }
                if (prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("jpeg")||prefix.equalsIgnoreCase("pneg")
                        ||prefix.equalsIgnoreCase("png")){
                    String finallyName = UUID.randomUUID().toString() + "."+prefix;
                    System.out.println(finallyName);
                    File file = new File(path);
                    if (!file.exists()){
                        file.mkdirs();
                    }
                    try {
                        idPic.transferTo(new File(file,finallyName));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (i==0){
                        pathMap.put("idPicPath",idPicPath);
                    }
                    if (i ==1 ){
                        pathMap.put("workPicPath",workPicPath);
                    }
                }else {
                    request.setAttribute("uploadFileError","上传图片格式不正确");
                    pathMap.put("error","sysUser/add");
                    return pathMap;
                }
            }
        }
        return pathMap;
    }


    /**
     * 上传阿里云
     * @param file
     * @return
     */
//    public static String uploadA(MultipartFile file) {
//        OSS client = new OSSClientBuilder().build(ConstantPropertiesUtils.END_POIND,ConstantPropertiesUtils.ACCESS_KEY_ID,ConstantPropertiesUtils.ACCESS_KEY_SECRET);
//        try {
//            InputStream inputStream = file.getInputStream();
//            // 获取文件名称 01.jsp
//            String fileName = file.getOriginalFilename();
//            // 生成唯一的值，防止文件名重复  wdfehsosj01.jsp
//            String uuId = UUID.randomUUID().toString().replaceAll("-", "");
//            fileName = uuId + fileName;
//
//            // 按照日期进行分类 2022/12/29/wdfehsosj01.jsp
//            String datePth = new DateTime().toString("yyyy/MM/dd");
//            fileName = datePth+"/"+fileName;
//
//            String bucketName= ConstantPropertiesUtils.BUCKET_NAME.replaceAll(" ","");
//            // 创建PutObjectRequest对象。
//            client.putObject(bucketName, fileName, inputStream);
//            // https://edu--peng.oss-cn-shanghai.aliyuncs.com/2022/12/29/wdfehsosj01.jsp
//            String url = "https://"+bucketName+"."+ConstantPropertiesUtils.END_POIND+"/"+fileName;
//            return url;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

package com.xuyang.springcloud.server_file.controller;

import com.xuyang.springcloud.server_file.model.Files;
import com.xuyang.springcloud.server_file.service.FilesService;
import com.xuyang.springcloud.server_file.util.DateUtil;
import com.xuyang.springcloud.server_file.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 01:01
 * @Description:
 */
@Slf4j
@RestController
public class FileController {

    @Autowired
    private FilesService filesService;

    /**
     * 文件备份
     * @param files
     * @return
     */
    @RequestMapping(value = "copyFileController.do", method = RequestMethod.POST)
    public String copyFileController(@RequestBody Files files){

        try {
            String fileName = files.getFileName();
            String filePath = "D:\\file\\write\\" + DateUtil.getNowDate() + fileName;
            File filesInfo = new File(filePath);
            if(!filesInfo.exists()){
                return "需要备份文件不存在";
            }

            String copyPath = "D:\\file\\history\\" + DateUtil.getNowDate() + "\\" + fileName;

            String filePa = "D:\\file\\history\\" + DateUtil.getNowDate();
            File filePaUrl = new File(filePa);
            if (!filePaUrl.exists()) {
                filePaUrl.mkdir();
            }

            File copyFile = new File(copyPath);
            if (!copyFile.exists()) {
                copyFile.createNewFile();
            }
            //文件备份
            FileUtil.copyFile(filesInfo, copyFile);

            files.setFilePath(copyPath);
            //添加复制文件信息
            filesService.insertFiles(files);
            return "文件备份成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "createFileController.do", method = RequestMethod.POST)
    public String createFileController(@RequestBody Files files){

        try {
            String fileContext = files.getFileContext();
            String fileName = files.getFileName();
            String filePath = "D:\\file\\write\\" + DateUtil.getNowDate() + "\\" + fileName;
            File writeFile = new File(filePath);
            if (!writeFile.exists()) {
                writeFile.createNewFile();
            }
            //文件创建
            FileUtil.writeWordInfoFile(fileContext, filePath);
            files.setFilePath(filePath);
            //新增文件
            filesService.insertFiles(files);

            return "文件生成成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "zipFileController.do", method = RequestMethod.POST)
    public String zipFileController(@RequestBody Files files){

        log.info("文件打包服务");

        return "文件打包成功";
    }

    @RequestMapping(value = "fileListController.do", method = RequestMethod.POST)
    public List<Files> fileListController(@RequestBody Files files) {
        log.info("获取某个用户下的所有文件信息");
        try {
            List<Files> filesList = filesService.getFilesList(files);
            return filesList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

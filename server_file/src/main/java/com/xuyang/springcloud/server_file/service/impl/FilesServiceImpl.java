package com.xuyang.springcloud.server_file.service.impl;

import com.xuyang.springcloud.server_file.dao.FilesDao;
import com.xuyang.springcloud.server_file.model.Files;
import com.xuyang.springcloud.server_file.service.FilesService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/21 02:17
 * @Description:
 */
@Data
@Slf4j
@Service
@Transactional(transactionManager = "userTransactional", rollbackFor = Exception.class)
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao filesDao;

    @Override
    public List<Files> getFilesList(Files files) {
        log.info("获取文件列表");
        return filesDao.getFilesList(files);
    }

    @Override
    public Files getFilesInfo(Files files) {
        log.info("获取单个文件信息");
        return filesDao.getFilesInfo(files);
    }

    @Override
    public void insertFiles(Files files) {
        log.info("添加文件");
        filesDao.insertFiles(files);
    }
}

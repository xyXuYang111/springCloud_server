package com.xuyang.springcloud.server_file.service;

import com.xuyang.springcloud.server_file.model.Files;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/21 02:19
 * @Description:
 */
@Component
public interface FilesService {

    public List<Files> getFilesList(Files files);

    public Files getFilesInfo(Files files);

    public void insertFiles(Files files);
}

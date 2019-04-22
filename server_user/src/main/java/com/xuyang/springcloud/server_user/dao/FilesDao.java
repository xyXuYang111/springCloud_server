package com.xuyang.springcloud.server_user.dao;

import com.xuyang.springcloud.server_user.annotation.MyBatisDao;
import com.xuyang.springcloud.server_user.model.Files;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/21 02:12
 * @Description:
 */
@MyBatisDao
public interface FilesDao {

    public List<Files> getFilesList(Files files);

    public Files getFilesInfo(Files files);

    public void insertFiles(Files files);
}

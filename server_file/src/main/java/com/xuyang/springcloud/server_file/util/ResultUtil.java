package com.xuyang.springcloud.server_file.util;

import com.xuyang.springcloud.server_file.model.json.ResultJson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Auther: cypc
 * @Date: 2019-3-28 11:17
 * @Description:
 */
@Data
@Slf4j
public class ResultUtil {

    public static ResultJson successResult(String fileName){
        ResultJson resultJson = new ResultJson();
        resultJson.setState("200");
        resultJson.setResult("操作成功，文件名称：" + fileName);
        return resultJson;
    }

    public static ResultJson successResult(List<String> fileNameList){
        StringBuffer stringBuffer = new StringBuffer();
        for(String fileName : fileNameList){
            stringBuffer.append(fileName).append(",");
        }
        ResultJson resultJson = new ResultJson();
        resultJson.setState("200");
        resultJson.setResult("操作成功，文件名称：" + stringBuffer.toString());
        return resultJson;
    }

    public static ResultJson errorResult(String error){
        ResultJson resultJson = new ResultJson();
        resultJson.setState("500");
        resultJson.setResult("操作失败，失败原因：" + error);
        return resultJson;
    }
}

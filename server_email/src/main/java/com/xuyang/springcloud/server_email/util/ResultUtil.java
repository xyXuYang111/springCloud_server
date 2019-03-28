package com.xuyang.springcloud.server_email.util;

import com.xuyang.springcloud.server_email.model.ResultJson;
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

    public static ResultJson successResult(){
        ResultJson resultJson = new ResultJson();
        resultJson.setState("200");
        resultJson.setResult("邮件发送成功" );
        return resultJson;
    }

    public static ResultJson errorResult(String error){
        ResultJson resultJson = new ResultJson();
        resultJson.setState("500");
        resultJson.setResult("操作失败，失败原因：" + error);
        return resultJson;
    }
}

package com.xuyang.springcloud.server_cxf.service.impl;

import com.xuyang.springcloud.server_cxf.service.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @Auther: cypc
 * @Date: 2019-4-10 18:45
 * @Description:
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.xuyang.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.xuyang.springcloud.server_cxf.service.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {
    @Override
    public String sayHello(String name) {
        return "cxf服务发布成功";
    }
}

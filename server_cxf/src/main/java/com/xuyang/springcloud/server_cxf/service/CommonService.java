package com.xuyang.springcloud.server_cxf.service;

/**
 * @Auther: cypc
 * @Date: 2019-4-10 18:44
 * @Description:
 */

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://webservice.xuyang.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String sayHello(@WebParam(name = "userName") String name);
}

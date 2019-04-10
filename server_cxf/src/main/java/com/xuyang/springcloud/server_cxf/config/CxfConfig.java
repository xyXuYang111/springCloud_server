package com.xuyang.springcloud.server_cxf.config;

import com.xuyang.springcloud.server_cxf.service.CommonService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.Bus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Auther: cypc
 * @Date: 2019-4-10 18:43
 * @Description:
 */
@Data
@Slf4j
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private CommonService commonService;


    /**
     * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
     * @return
     */
    @Bean(name = "dispatcherServlet")
    public ServletRegistrationBean dispatcherServlet() {
        log.info("cxf服务发布增加前缀");
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }

    /** JAX-WS
     * 站点服务
     * **/
    @Bean(name = "endpoint")
    public Endpoint endpoint() {
        log.info("cxf服务发布，发布路径：http://127.0.0.1:8080/soap/user?wsdl");
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/user");
        return endpoint;
    }

}

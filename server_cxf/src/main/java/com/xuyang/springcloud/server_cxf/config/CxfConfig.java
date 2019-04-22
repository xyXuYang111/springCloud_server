package com.xuyang.springcloud.server_cxf.config;

import com.xuyang.springcloud.server_cxf.service.CommonService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.Bus;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * @Auther: cypc
 * @Date: 2019-4-10 18:43
 * @Description:
 */
@Data
@Slf4j
@Configuration
public class CxfConfig {

    @Resource(name = "cxf")
    private Bus bus;

    @Autowired
    private CommonService commonService;


    /**
     * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/file?wsdl
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
        log.info("cxf服务发布，发布路径：http://127.0.0.1:8080/soap/file?wsdl");
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/file");
        return endpoint;
    }

}

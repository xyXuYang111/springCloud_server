package com.xuyang.springcloud.note.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * freemarker
 *
 * @Auther: 许洋
 * @Date: 2018-12-7 10:19
 * @Description:
 */
@Slf4j
@Component
public class FreemarkerUtil {

    /**
     * 生成模板
     * @param dataMap 参数值
     * @param fileName 生成模板路径
     * @param templateName 模板名称
     * @throws UnsupportedEncodingException
     */
    public void createDoc(Map<String, Object> dataMap, String fileName, String templateName) throws Exception {
        log.info("生成模板方法");
        //定义对象
        Configuration configuration = new Configuration();
        //生成方法的对象 相对路径
        configuration.setClassForTemplateLoading(FreemarkerUtil.class, "/conf");
        //确定编码级
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassicCompatible(true);
        //数字格式化
        configuration.setNumberFormat("#");
        //要装载的模板
        Template t = configuration.getTemplate(templateName);
        //输出文档路径及名称
        File outFile = new File(fileName);
        FileOutputStream fos = new FileOutputStream(outFile);
        //设置编码级，不然存在编码错误,导致文件无法打开
        OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
        Writer out = new BufferedWriter(oWriter);
        t.process(dataMap, out);
        out.close();
        fos.close();
        log.info("文档生成功");
    }
}

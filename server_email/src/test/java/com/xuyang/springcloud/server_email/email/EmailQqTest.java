package com.xuyang.springcloud.server_email.email;

import com.xuyang.springcloud.server_email.model.Email;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailQqTest {

    @Test
    public void sendEmailQq() {
        Email email = new Email();
        email.setTitleName("qq邮件客户端开发测试");
        email.setMessage("QQ邮件测试");
        email.setSendName("许洋");
        email.setSendNumber("1824650783@qq.com");
        email.setReceiveNumber("许洋");
        email.setReceiveNumber("1824650783@qq.com");
        email.setReceivePassword("wjtbyokdodejbccj");

        EmailQq emailQq = new EmailQq();
        emailQq.sendEmailQq(email);
    }
}
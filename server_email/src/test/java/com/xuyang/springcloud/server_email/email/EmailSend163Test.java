package com.xuyang.springcloud.server_email.email;

import com.xuyang.springcloud.server_email.model.Email;
import org.junit.Test;

public class EmailSend163Test {

    @Test
    public void sendMail() {

        Email email = new Email();
        email.setSendNumber("15172399690@163.com");
        email.setSendPassword("xy1234qwer");
        email.setReceivePassword("xy1234qwer");
        email.setReceiveNumber("15172399690@163.com");
        email.setTitleName("网易邮箱集成测试");
        email.setMessage("网易邮箱测试文本");

        EmailSend163 emailSend163 = new EmailSend163();
        emailSend163.sendMail(email);
    }
}
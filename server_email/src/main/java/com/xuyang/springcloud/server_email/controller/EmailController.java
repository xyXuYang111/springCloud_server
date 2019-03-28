package com.xuyang.springcloud.server_email.controller;

import com.xuyang.springcloud.server_email.email.EmailQq;
import com.xuyang.springcloud.server_email.email.EmailSend163;
import com.xuyang.springcloud.server_email.model.Email;
import com.xuyang.springcloud.server_email.model.ResultJson;
import com.xuyang.springcloud.server_email.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xuy
 * @Date: 2019/3/29 01:29
 * @Description:
 */
@Slf4j
@RestController
public class EmailController {

    @Autowired
    private EmailQq emailQq;

    @Autowired
    private EmailSend163 emailSend163;

    @RequestMapping(value = "sendQqEmail", method = RequestMethod.GET)
    public ResultJson sendQqEmail(@RequestBody Email email){
        try {
            emailQq.sendEmailQq(email);
            return ResultUtil.successResult();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorResult(e.getMessage());
        }
    }

    @RequestMapping(value = "send163Email", method = RequestMethod.GET)
    public ResultJson send163Email(@RequestBody Email email){
        try {
            emailSend163.sendMail(email);
            return ResultUtil.successResult();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorResult(e.getMessage());
        }
    }
}

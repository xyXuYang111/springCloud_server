package com.xuyang.springcloud.note.controller;

import com.xuyang.springcloud.note.model.Note;
import com.xuyang.springcloud.note.util.FreemarkerUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: cypc
 * @Date: 2019-4-22 16:00
 * @Description:
 */
@Data
@Slf4j
@Controller
public class NoteController {

    @Autowired
    private FreemarkerUtil freemarkerUtil;

    @RequestMapping(value = "createNoteFile.do", method = RequestMethod.POST)
    @ResponseBody
    public String createNoteFile(@RequestBody Note note){
        String noteContext = note.getNoteContent();

        return "文件写入成功";
    }
}

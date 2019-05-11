package com.xuyang.springcloud.note.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Slf4j
@Data
@Component
public class DateUtil {

    public static String getNowDate(){
        SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar curdate = Calendar.getInstance(Locale.CHINESE);
        String dateTime = simpleDateTimeFormat.format(curdate.getTime());
        return dateTime;
    }
}

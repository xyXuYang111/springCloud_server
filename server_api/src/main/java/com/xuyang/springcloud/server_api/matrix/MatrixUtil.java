package com.xuyang.springcloud.server_api.matrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xuyang.springcloud.server_api.def.MatrixDef;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class MatrixUtil {

    /**
     * 生成二维码
     * 直接返回给前端
     * @param content
     */
    public static void createQrPhoto(String content) {

        //定义二维码内容参数
        HashMap hints = new HashMap();
        //设置字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //设置容错等级，在这里我们使用M级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置边框距
        hints.put(EncodeHintType.MARGIN, MatrixDef.SIZE);

        //生成二维码
        try {

            //获取response对象
            HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            //指定二维码内容
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, MatrixDef.WIDTH, MatrixDef.HEIGHT, hints);
            //生成二维码
            MatrixToImageWriter.writeToStream(bitMatrix, MatrixDef.FORMAT, httpServletResponse.getOutputStream());

            httpServletResponse.getOutputStream().flush();
            httpServletResponse.getOutputStream().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码
     * 本地生成二维码记录
     * @param content
     */
    public static String createQrPhotoLLocal(String content, String filePath){

        //定义二维码内容参数
        HashMap hints = new HashMap();
        //设置字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //设置容错等级，在这里我们使用M级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置边框距
        hints.put(EncodeHintType.MARGIN, MatrixDef.SIZE);

        //生成二维码
        try {

            //指定二维码内容
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, MatrixDef.WIDTH, MatrixDef.HEIGHT, hints);

            //指定生成图片的保存路径
            Path file = new File(filePath.toString()).toPath();

            //生成二维码：写到本地去
            MatrixToImageWriter.writeToPath(bitMatrix, MatrixDef.FORMAT, file);

            return filePath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

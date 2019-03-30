package com.xuyang.springcloud.server_api.def;

public class MatrixDef {

    /**
     * 二维码图片的宽度
     */
    public static final int WIDTH = 150;

    /**
     * 二维码图片的高度
     */
    public static final int HEIGHT = 150;

    /**
     * 二维码格式
     */
    public static final String FORMAT = "png";

    public static final String SIZE = "0";

    public static final String ORDER_MATRIX = "ORDER_MATRIX";  //订单信息二维码

    public static final String ORDER_LINE_MATRIX = "ORDER_LINE_MATRIX";  //订单行信息二维码

    public static final String ORDER_TRAFFIC_MATRIX = "ORDER_TRAFFIC_MATRIX"; //收货信息二维码

    public static final String ORDER_TRAFFIC_LINE_MATRIX = "ORDER_TRAFFIC_LINE_MATRIX";  //收货行信息二维码

    public static final String ORDER_CHECK_MATRIX = "ORDER_CHECK_MATRIX";   //验收信息二维码

    public static final String ORDER_CHECK_LINE_MATRIX = "ORDER_CHECK_LINE_MATRIX";  //验收行信息二维码
}

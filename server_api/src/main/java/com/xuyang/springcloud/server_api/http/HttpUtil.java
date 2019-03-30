package com.xuyang.springcloud.server_api.http;

import com.alibaba.fastjson.JSONObject;
import com.xuyang.springcloud.server_api.def.BaseDef;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Http形式的手动提交post和get请求
 */
public class HttpUtil {

    /**
     * get方式
     * @param url
     * @author www.yoodb.com
     * @return
     */
    public static String getHttp(String url) {
        String responseMsg = "";
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
        try {
            httpClient.executeMethod(getMethod);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = getMethod.getResponseBodyAsStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while((len=in.read(buf))!=-1){
                out.write(buf, 0, len);
            }
            responseMsg = out.toString(BaseDef.CHARSET_UTF_8);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放连接
            getMethod.releaseConnection();
        }
        return responseMsg;
    }

    /**
     * post方式
     * @param url
     * @author www.yoodb.com
     * @return
     */
    public static String postHttp(String url) {
        String responseMsg = "";
        HttpClient httpClient = new HttpClient();
        //设置编码集
        httpClient.getParams().setContentCharset(BaseDef.CHARSET_UTF_8);
        //请求路径
        PostMethod postMethod = new PostMethod(url);
        try {
            httpClient.executeMethod(postMethod);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = postMethod.getResponseBodyAsStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while((len=in.read(buf))!=-1){
                out.write(buf, 0, len);
            }
            responseMsg = out.toString(BaseDef.CHARSET_UTF_8);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }

    /**
     * http方式的restful
     * @param url  路径
     * @param way  方式
     *         get,post
     * @param json 内容
     * @return
     */
    public static String restFulHttp(String url ,String way, String json) {

        try {
            URL targetUrl = new URL(url);

            //连接
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod(way);
            httpConnection.setRequestProperty("Content-Type", "application/json");
            //传输
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(json.getBytes());
            outputStream.flush();
            //请求结果
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());
            }
            //结果内容
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));
            //结果集显示
            String output;
            System.out.println("Output from Server:\n");
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
            }

            httpConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * httpClient请求restful
     * @param url
     * @param json
     * @return
     */
    public static String httpClientRestful(String url, String json){

        try {
            org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse httpResponse = null;
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("content-type", "application/json");
            httpPost.addHeader("Accept", "application/json");
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);

            httpResponse = httpClient.execute(httpPost);
            String response = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post方式提交json代码
     * @throws Exception
     */
    public static String postJson(String url,String json) throws Exception{
        //创建默认的httpClient实例.
        CloseableHttpClient httpclient = null;
        //接收响应结果
        CloseableHttpResponse response = null;
        String result = "";
        //创建httppost
        httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
        //参数
        StringEntity se = new StringEntity(json);
        se.setContentEncoding("UTF-8");
        se.setContentType("application/json");//发送json需要设置contentType
        httpPost.setEntity(se);
        response = httpclient.execute(httpPost);
        //解析返结果
        HttpEntity entity = response.getEntity();
        if(entity != null){
            result = EntityUtils.toString(entity, "UTF-8");
        }
        httpclient.close();
        response.close();
        return result;
    }

    public static void main(String[] args) throws Exception {

        String uri = "www.baidu.com";
        String jsonStr = JSONObject.toJSONString(uri);

        System.out.println(postJson("http://localhost:8080/action/getIamAuthorize.htm", jsonStr));
    }

}

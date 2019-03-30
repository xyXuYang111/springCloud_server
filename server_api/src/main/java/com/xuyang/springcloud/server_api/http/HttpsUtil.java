package com.xuyang.springcloud.server_api.http;

import com.xuyang.springcloud.server_api.def.BaseDef;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsUtil {

    static class miTM implements TrustManager, X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }
    }

    /**
     * 根据请求的URL是https还是http请求数据
     *
     * @param sendUrl
     * @param param
     * @return
     * @throws Exception
     */
    public static String getPostRequest(String sendUrl, String param) throws Exception {

        if (sendUrl.startsWith(BaseDef.HTTPS)) {
            return HttpsUtil.getResultByHttps(sendUrl, param);
        }

        return HttpsUtil.getResultByHttp(sendUrl, param);
    }

    private static String getResultByHttps(String sendUrl, String param) throws Exception {
        OutputStream out = null;
        BufferedReader reader = null;
        String result = "";
        URL url = null;
        HttpsURLConnection conn = null;
        try {

            TrustManager[] trustAllCerts = new TrustManager[1];
            TrustManager tm = new miTM();
            trustAllCerts[0] = tm;
            SSLContext sc = SSLContext.getInstance("SSLv3");

            sc.init(null, trustAllCerts, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            };

            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);

            url = new URL(sendUrl);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(BaseDef.POST);
            conn.setRequestProperty(BaseDef.CONTENT_TYPE, BaseDef.APPLICATION);
            // 必须设置false，否则会自动redirect到重定向后的地址
            conn.setInstanceFollowRedirects(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty(BaseDef.CHARSET, BaseDef.CHARSET_UTF_8);
            conn.setRequestProperty(BaseDef.CONN, BaseDef.KEEP_ALIVE);
            conn.connect();
            out = conn.getOutputStream();
            out.write(param.getBytes());
            InputStream input = conn.getInputStream();
            Reader inputUtf8 = new InputStreamReader(input, BaseDef.CHARSET_UTF_8);
            reader = new BufferedReader(inputUtf8);
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
                if (out != null) {
                    out.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {

            }
        }
        return result;
    }

    private static String getResultByHttp(String sendUrl, String param) throws Exception {
        HttpURLConnection conn = null;
        OutputStream out = null;
        BufferedReader reader = null;
        String result = "";
        try {

            URL url = new URL(sendUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(BaseDef.POST);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty(BaseDef.CHARSET, BaseDef.CHARSET_UTF_8);
            conn.setRequestProperty(BaseDef.CONN, BaseDef.KEEP_ALIVE);
            conn.connect();
            out = conn.getOutputStream();
            out.write(param.getBytes());
            out.flush();
            out.close();
            InputStream input = conn.getInputStream();
            Reader inputUtf8 = new InputStreamReader(input, BaseDef.CHARSET_UTF_8);
            reader = new BufferedReader(inputUtf8);
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                out.close();
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}

package org.metahut.octopus.jobs.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {
    private static CloseableHttpClient httpClient = null;

    //get httpClient
    private static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (HttpUtils.class) {
                if (httpClient == null) {
                    httpClient = HttpClients.createDefault();
                }
            }

        }
        return httpClient;
    }

    //httpPost
    public static String post(String url, String msg) {
        String responseMsg = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
            httpPost.setConfig(config);
            StringEntity entity = new StringEntity(msg,"utf-8");
            httpPost.setEntity(entity);

            CloseableHttpResponse response = getHttpClient().execute(httpPost);
            if (response != null) {
                responseMsg = EntityUtils.toString(response.getEntity(),"utf-8");
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseMsg;
    }

    //httpGet
    public static String get(String url) {
        String responseMsg = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();
            httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
            httpGet.setConfig(config);

            CloseableHttpResponse response = getHttpClient().execute(httpGet);
            if (response != null) {
                responseMsg = EntityUtils.toString(response.getEntity(),"utf-8");
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseMsg;
    }

}

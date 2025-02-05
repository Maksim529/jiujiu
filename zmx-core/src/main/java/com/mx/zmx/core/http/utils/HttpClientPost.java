package com.mx.zmx.core.http.utils;

import com.mx.zmx.core.http.callback.OkNoSyncCallback;
import com.mx.zmx.core.http.dto.ReqHeader;
import com.mx.zmx.core.http.dto.ReqReturn;
import javafx.application.Platform;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.Set;

/**
 * Created by hzhedongyu on 2015/10/14.
 */
public class HttpClientPost implements IHttpClient {
    public static final MediaType JSON
        = MediaType.get("application/json; charset=utf-8");
    private static final HttpClientPost instance = new HttpClientPost();
    private HttpClientPost(){

    }

    public static HttpClientPost get(){
        return instance;
    }

    @Override
    public ReqReturn requestByJson(String reqUrl, String jsonReq) {
        return requestByJson(reqUrl,jsonReq,null);
    }
    @Override
    public ReqReturn requestByJson(String reqUrl, String jsonReq, ReqHeader reqHeader) {
        RequestBody body = RequestBody.create(JSON, jsonReq);
        ReqReturn reqReturn = new ReqReturn();
        Request request = new Request.Builder()
            .url(reqUrl)
            .post(body)
            .build();
        try {
            Call call = InitUtil.getOkHttpClient().newCall(request);
            Response response = call.execute();//执行
            reqReturn.setStatus(response.code()+"");
            reqReturn.setSuccess(response.isSuccessful());
            reqReturn.setBody(response.body().string());
            reqReturn.setHeaders(response.headers());
        }catch (SocketTimeoutException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reqReturn;
    }

    @Override
    public ReqReturn request(String reqUrl) {
        return request(reqUrl,null,null,null);
    }

    @Override
    public ReqReturn request(String reqUrl, Map<String, String[]> reqMap) {
        return request(reqUrl,reqMap,null,null);
    }

    @Override
    public ReqReturn request(String reqUrl, Map<String, String[]> reqMap, ReqHeader reqHeader) {
       return request(reqUrl,reqMap,null,reqHeader);
    }

    @Override
    public ReqReturn request(String reqUrl, Map<String, String[]> reqMap, Map<String, File> fileMap, ReqHeader reqHeader) {
        ReqReturn reqReturn = new ReqReturn();
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if(reqMap!=null && !reqMap.isEmpty()){
            Set<String> keys = reqMap.keySet();
            for(String key:keys){
                String[] value = reqMap.get(key);
                for (String v:value){
                    bodyBuilder.add(key,v);
                }
            }
        }
        Request.Builder builder = new Request.Builder()
            .url(reqUrl)
            .post(bodyBuilder.build());
        if(reqHeader!=null){
            Map<String,String> headerMap = reqHeader.getHeaderMap();
            if(headerMap!=null && !headerMap.isEmpty()){
                Set<String> keys = headerMap.keySet();
                for(String key:keys){
                    builder.addHeader(key,headerMap.get(key));
                }
            }
        }
        try {
            Call call = InitUtil.getOkHttpClient().newCall(builder.build());
            Response response = call.execute();//执行
            reqReturn.setStatus(response.code()+"");
            reqReturn.setSuccess(response.isSuccessful());
            reqReturn.setBody(response.body().string());
            reqReturn.setHeaders(response.headers());
        }catch (SocketTimeoutException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reqReturn;
    }

    @Override
    public void noSyncRequestByJson(String reqUrl, String jsonReq, OkNoSyncCallback callback) {
        throw new RuntimeException("get 不支持");
    }

    @Override
    public void noSyncRequestByJson(String reqUrl, String jsonReq, ReqHeader reqHeader, OkNoSyncCallback callback) {
        RequestBody body = RequestBody.create(JSON, jsonReq);
        ReqReturn reqReturn = new ReqReturn();
        Request.Builder builder = new Request.Builder()
            .url(reqUrl)
            .post(body);
        if(reqHeader!=null){
            Map<String,String> headerMap = reqHeader.getHeaderMap();
            if(headerMap!=null && !headerMap.isEmpty()){
                Set<String> keys = headerMap.keySet();
                for(String key:keys){
                    builder.addHeader(key,headerMap.get(key));
                }
            }
        }
        try {
            Call call = InitUtil.getOkHttpClient().newCall(builder.build());
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onFailure();
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    reqReturn.setStatus(response.code()+"");
                    reqReturn.setSuccess(response.isSuccessful());
                    reqReturn.setBody(response.body().string());
                    reqReturn.setHeaders(response.headers());
                    Platform.runLater(() -> {//这里一般是更新主线程操作 必须用线程 否则会提示非主线程
                        callback.onResponse(reqReturn);
                    });
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void noSyncRequest(String reqUrl, OkNoSyncCallback callback) {
        noSyncRequest(reqUrl, null, null,null, callback);
    }

    @Override
    public void noSyncRequest(String reqUrl, Map<String, String[]> reqMap, OkNoSyncCallback callback) {
        noSyncRequest(reqUrl, reqMap, null,null, callback);
    }

    @Override
    public void noSyncRequest(String reqUrl, Map<String, String[]> reqMap, ReqHeader reqHeader, OkNoSyncCallback callback) {
        noSyncRequest(reqUrl, reqMap, null,reqHeader, callback);
    }

    @Override
    public void noSyncRequest(String reqUrl, Map<String, String[]> reqMap, Map<String, File> fileMap, ReqHeader reqHeader, OkNoSyncCallback callback) {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if(reqMap!=null && !reqMap.isEmpty()){
            Set<String> keys = reqMap.keySet();
            for(String key:keys){
                String[] value = reqMap.get(key);
                for (String v:value){
                    bodyBuilder.add(key,v);
                }
            }
        }
        Request.Builder builder = new Request.Builder()
            .url(reqUrl)
            .post(bodyBuilder.build());
        if(reqHeader!=null){
            Map<String,String> headerMap = reqHeader.getHeaderMap();
            if(headerMap!=null && !headerMap.isEmpty()){
                Set<String> keys = headerMap.keySet();
                for(String key:keys){
                    builder.addHeader(key,headerMap.get(key));
                }
            }
        }
        try {
            Call call = InitUtil.getOkHttpClient().newCall(builder.build());
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onFailure();
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    ReqReturn reqReturn = new ReqReturn();
                    reqReturn.setStatus(response.code()+"");
                    reqReturn.setSuccess(response.isSuccessful());
                    reqReturn.setBody(response.body().string());
                    reqReturn.setHeaders(response.headers());
                    Platform.runLater(() -> {//这里一般是更新主线程操作 必须用线程 否则会提示非主线程
                        callback.onResponse(reqReturn);
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void noSyncSimpleRequest(String reqUrl, Map<String, String> reqMap, OkNoSyncCallback callback) {
        noSyncRequest(reqUrl,InitUtil.coverMap(reqMap),callback);
    }

    @Override
    public void noSyncSimpleRequest(String reqUrl, Map<String, String> reqMap, ReqHeader reqHeader, OkNoSyncCallback callback) {
        noSyncRequest(reqUrl,InitUtil.coverMap(reqMap),reqHeader,callback);
    }

    @Override
    public void noSyncSimpleRequest(String reqUrl, Map<String, String> reqMap, Map<String, File> fileMap, ReqHeader reqHeader, OkNoSyncCallback callback) {
        noSyncRequest(reqUrl,InitUtil.coverMap(reqMap),fileMap,reqHeader,callback);
    }
}

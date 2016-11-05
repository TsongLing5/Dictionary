package com.example.tsongling5.dictionary;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TsongLing5 on 2016/10/8.
 */
public class HttpHelper {

//    private OkHttpClient okhttp = new OkHttpClient();

//    private static String url;
//    public String json;
//    public static final int SHOW_RESPONSE=0;

//    private Handler handler=new Handler(){
//        public void handleMessage(Message msg){
//            switch(msg.what){
//                case SHOW_RESPONSE:
//                    json =(String)msg.obj;
//
//            }
//        }
//    };


//    public  HttpHelper(String url){
//        this.url=url;
//    }


//    public String GetJson(){
//        sendRequestWithOKHttp();
//        return this.json;
//    }
//    public String requestByGetSync() {
//        Request request = new Request.Builder().url(this.url).build();
//        try {
//            Response response = okhttp.newCall(request).execute();//同步请求
//            if (!response.isSuccessful()) {
//                throw new IOException("Unexpected code" + response);
//            }
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void sendRequestWithOKHttp(final String url,final HttpCallbackListener listener){
        new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub

                GetURL example = new GetURL();

                try{


                    String response = example.run(url);
                    Log.i("WY","打印GET响应的数据：" + response);


                    if(listener != null){
                        listener.onFinish(response);
                    }
//                    Message msg=new Message();
//                    msg.what=SHOW_RESPONSE;
//                    msg.obj=response;
//                    handler.sendMessage(msg);



                }catch(Exception e){
                    if(listener != null){
                        listener.onError(e);
                    }
                }finally {

                }
            }

        }).start();
    }

public TranslateResult paraJSON(String json){
    TranslateResult result=new TranslateResult();

    try {
        JSONObject jsonObject=new JSONObject(json);
        result.setWord(jsonObject.getString("word"));
        JSONObject pro=jsonObject.getJSONObject("pronunciation");
        result.setPronunciation(pro.getString("AmE"),pro.getString("BrE"));
        result.setPronunciationVocal(pro.getString("AmEmp3"),pro.getString("BrEmp3"));
        JSONArray means=jsonObject.getJSONArray("defs");
        for(int i=0;i<means.length();i++){
           JSONObject jsonObject_means= means.getJSONObject(i);

                result.setMeans(i,jsonObject_means.getString("pos"),jsonObject_means.getString("def"));

//
//
        }


//        return result;
    }catch(JSONException e){
        e.printStackTrace();
    }



    return result;

}


    public class GetURL {
        OkHttpClient client = new OkHttpClient();

        @TargetApi(Build.VERSION_CODES.KITKAT)
        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }
    }


    public interface HttpCallbackListener{
        void onFinish(String response);
        void onError(Exception e);
    }

}

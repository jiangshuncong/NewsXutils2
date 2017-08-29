package com.example.newsxutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import app.AppUrl;
import bean.BeanJson;
import bean.BeanMsg;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.lv_listview)
    ListView lv;
    private List<BeanMsg> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        x.view().inject(this);
        RequestParams params = new RequestParams(AppUrl.url);
        params.addQueryStringParameter("key",AppUrl.key);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                BeanJson beanJson = gson.fromJson(result, BeanJson.class);

                List<BeanJson.Result.Data> data = beanJson.result.data;
                for (BeanJson.Result.Data data2:data
                     ) {
                    String title = data2.title;
                    String thumbnail_pic_s = data2.thumbnail_pic_s;

                    list.add(new BeanMsg(title,thumbnail_pic_s));
                }

                System.out.println("================================="+list.get(1).getTitle());
                lv.setAdapter(new MyAdapter());


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }


    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;

            if(view == null){
                holder = new ViewHolder();
                view = View.inflate(MainActivity.this,R.layout.item,null);

                holder.icon = view.findViewById(R.id.iv_icon);
                holder.msg = view.findViewById(R.id.tv_msg);

                view.setTag(holder);
            }else{
                holder = (ViewHolder) view.getTag();
            }

            ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holder.icon);
            holder.msg.setText(list.get(i).getTitle());

            System.out.println(list.get(1).getTitle());
            return view;
        }
    }

    public class ViewHolder{
        ImageView icon;
        TextView msg;
    }

}

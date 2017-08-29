package app;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by 蒋順聪 on 2017/8/29.
 */

public class LoadXutils extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initxutils();

        initimageloader();
    }

    private void initimageloader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(configuration);

    }

    private void initxutils() {
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}

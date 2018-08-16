package base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.tencent.smtt.sdk.QbSdk;

import java.io.File;
import java.util.Stack;

import model.bean.FindCompanyYearFinanceBean;
import model.bean.FindFinanceBean;
import model.bean.LoginBean;
import tools.ToastUtils;

/**
 * Created by kk on 2018/5/16.
 */

public class MyApplication extends Application{
    private static Stack<Activity> atyStack = new Stack<Activity>();
    private static DisplayImageOptions options;
    private static DisplayImageOptions.Builder builder;
    public static LoginBean loginBean;
    public static FindFinanceBean findFinanceBean;
    public static FindCompanyYearFinanceBean findCompanyYearFinanceBean;

    @Override
    public void onCreate() {
        super.onCreate();
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        initSimpleOption();
        ToastUtils.init(this);
        initImageLoader(getApplicationContext());
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }

    public static void push(Activity aty) {
        atyStack.push(aty);
    }



    private void initSimpleOption() {
        builder = new DisplayImageOptions.Builder();
        builder.cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .resetViewBeforeLoading(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(Bitmap.Config.RGB_565);
    }

    public static DisplayImageOptions getSimpleOptions(Integer fallbackResource, Integer loadingResource) {
        options = builder.showImageOnLoading(loadingResource).
                showImageForEmptyUri(fallbackResource).build();
        return options;
    }
    public static DisplayImageOptions getRoundImage(Integer fallbackResource, Integer loadingResource) {
        builder.cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .resetViewBeforeLoading(true).displayer(new RoundedBitmapDisplayer(10)).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(Bitmap.Config.RGB_565);// ����ͼƬ�Ľ�������//
        options = builder.showImageOnLoading(loadingResource).
                showImageForEmptyUri(fallbackResource).build();
        return options;
    }

    public static void pop(Activity aty) {
        atyStack.remove(aty);
    }

    @SuppressWarnings("deprecation")
    public void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "edu/image");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheSize(50 * 480 * 800)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .discCacheFileCount(100) //缓存的文件数量
                .discCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        ImageLoader.getInstance().init(config);
    }

    public static void remove() {
        for (int i=0;i<atyStack.size();i++){
            atyStack.get(i).finish();
        }
    }
}


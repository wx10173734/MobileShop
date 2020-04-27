package test.administrator.example.com.mobileshop.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Handler;
import android.view.View;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import test.administrator.example.com.mobileshop.R;

public class ImageLoaderManager {
    private static ImageLoaderManager mInstance;
    public static ImageLoaderManager getInstance(){
        if (mInstance == null){
            synchronized (ImageLoaderManager.class){
                if (mInstance == null)
                    mInstance = new ImageLoaderManager();
            }
        }
        return mInstance;
    }

    /**
     * 调用相关设置
     * 添加了图片加载管理类,需要实例化管理类
     */
    public ImageLoaderManager(){
        if (mInstance == null){
            //采用自定义配置
            ImageLoader.getInstance().init(customImageLoaderConfig(MyApplication.getContext()));
            //采用默认配置的话,这里使用自定义设置,更为灵活
//            ImageLoader.getInstance().init(defaultImageLoaderConfig());
        }
    }

    private ImageLoaderConfiguration defaultImageLoaderConfig(){
        return ImageLoaderConfiguration.createDefault(MyApplication.getContext());
    }

    public ImageLoaderConfiguration customImageLoaderConfig(Context context) {
        File cacheDir = StorageUtils.getCacheDirectory(context); //缓存文件夹路径
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) //内存文件的最大长度
                .memoryCacheSize(2 * 1024 * 1024) //内存缓存的最大值
                .memoryCacheSizePercentage(13)
                .diskCacheSize(5 * 1024 * 1024) //设置SDK缓存大小
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .threadPoolSize(3) //线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY-2) //设置当前线程的优先级
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(context))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple().createSimple())
                .writeDebugLogs()
                .build();
        return config;
    }

    public static DisplayImageOptions product_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading) //设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.image_empty)//设置图片url为空或错误时显示的图片
            .showImageOnFail(R.drawable.image_error)//这是图片加载或者解码过程中错误的图片
            .resetViewBeforeLoading(false)//设置图片在加载前是否重置、复位
            .delayBeforeLoading(1000)//下载前的延时时间
            .cacheInMemory(false)//设置下载的图片是否缓存到内存
            .cacheOnDisk(false)//设置下载的图片是否缓存到sd卡中
            .considerExifParams(false)//
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//设置图片的编码格式
            .bitmapConfig(Bitmap.Config.ARGB_8888)//设置图片的解码类型
            .displayer(new SimpleBitmapDisplayer())//设置图片的圆角还是默认格式, newRoundedBitmapDisplayer(20)为设置圆角
            .handler(new Handler())//
            .build();

    /**
     * 添加设置时,可根据不同场景进行设置,参数可能一样,复制粘贴即可
     */
    public static DisplayImageOptions user_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading) //设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.face_default)//设置图片url为空或错误时显示的图片
            .showImageOnFail(R.drawable.face_default)//这是图片加载或者解码过程中错误的图片
            .resetViewBeforeLoading(false)//设置图片在加载前是否重置、复位
            .delayBeforeLoading(1000)//下载前的延时时间
            .cacheInMemory(false)//设置下载的图片是否缓存到内存
            .cacheOnDisk(false)//设置下载的图片是否缓存到sd卡中
            .considerExifParams(false)//
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//设置图片的编码格式
            .bitmapConfig(Bitmap.Config.ARGB_8888)//设置图片的解码类型
            .displayer(new SimpleBitmapDisplayer())//设置图片的圆角还是默认格式, newRoundedBitmapDisplayer(20)为设置圆角
            .handler(new Handler())//
            .build();
/**
 * 通过按键监听调用下一方法,根据实际情况来使用
 */
    /**
     * 清理内存缓存
     */
    public void onClearMemoryClick(View view){
        ImageLoader.getInstance().clearMemoryCache();
    }

    /**
     * 清理本地缓存
     */
    public void onClearDiskClick(){
        ImageLoader.getInstance().clearMemoryCache();
    }
}

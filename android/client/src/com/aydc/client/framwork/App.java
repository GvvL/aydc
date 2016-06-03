package com.aydc.client.framwork;



import java.util.ArrayList;

import com.aydc.client.utils.LocationManager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;



/**
 * 主程序
 */
public class App extends Application{
	private final static String AYPREFERENCES="aydcRP";

	private static App instance;
	private static ArrayList<Activity> activitystack;// activity启动栈，记录栈中的activity实例


	
	public static boolean islogin=false;
	public static boolean isfirst=false;
	public static boolean issafe=false;

	
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		activitystack = new ArrayList<Activity>();//历史栈
		MyCrashHandler handler = MyCrashHandler.getInstance();
		handler.init(getApplicationContext());
	}




	/**
	 * 程序安全退出
	 */
	@Override
	public void onTerminate() {
//		MobclickAgent.onKillProcess(getApplicationContext());
		for (Activity activity : activitystack) {
			activity.finish();
		}
		activitystack.clear();
		super.onTerminate();
	}
	
	/**
	 * 将应用程序的任务栈中的一activity实例添加到activitystack中
	 * 
	 * @param activity
	 *            一个activity实例
	 */
	public static void addActivity2Stack(Activity activity) {
		App.activitystack.add(activity);
	}
	
	/**
	 * 经activity实例从activitystack中移除
	 * 
	 * @param activity
	 *            一个activity实例
	 */
	public static void removeActivityFromStack(Activity activity) {
		App.activitystack.remove(activity);
	}
	
	/**
	 * 单例
	 * @return 
	 */
	public static App getInstance() {		
		 return instance;
	}
	
	/**
	 * 获取首选项	
	 */
	public static SharedPreferences getSharedPrefences(Context context) {
		return context.getSharedPreferences(AYPREFERENCES, Context.MODE_PRIVATE);

	}

	/*
	 * 初始
	 */
	/*
	public static void initImageLoader(Context context) {
        //缓存文件的目录
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "imageloader/Cache"); 
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽 
                .threadPoolSize(3) //线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) //你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
                .diskCacheSize(30 * 1024 * 1024)  // 50 Mb sd卡(本地)缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径  
                .imageDownloader(new BaseImageDownloader(context, 1 * 1000, 1 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间  
                .writeDebugLogs() // Remove for release app
                .build();
        //全局初始化此配置  
        ImageLoader.getInstance().init(config);
    }
    */
	//获取版本号
	public int getVersion() {
		     try {
		         PackageManager manager = this.getPackageManager();
		         PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
		         int version = info.versionCode;
		         return  version;
		    } catch (Exception e) {
		         e.printStackTrace();
		        return 0;
		    }
		 }


	


}

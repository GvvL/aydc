package com.aydc.client.framwork;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;











import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by giw on 2016/2/21.
 */
public abstract class ActP<T extends ViewDelegate> extends Activity {
    protected T viewDelegate;


    @SuppressWarnings("unchecked")
	public ActP() {

        try {
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            Class<T> entityClass = (Class<T>) params[0];
            viewDelegate =entityClass.newInstance();
//            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());
        viewDelegate.initWidget();
        preliminary();
        bindEvenListener();
        App.addActivity2Stack(this);
    }
    /**
     * 事件绑定
     */
    protected void bindEvenListener() {
    }
    /**
     * 数据准备
     */
    protected void preliminary(){
    	
    }

    @SuppressWarnings("unchecked")
	@Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                Type genType = getClass().getGenericSuperclass();
                Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
                Class<T> entityClass = (Class<T>) params[0];
                viewDelegate =entityClass.newInstance();
//                viewDelegate = getDelegateClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create IView error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IView error");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        viewDelegate.deinitWidget();
        viewDelegate = null;
        super.onDestroy();
    }
//    protected abstract Class<T> getDelegateClass();

}

package com.aydc.client.widgets;  
  
import android.annotation.SuppressLint;
import android.content.Context;  
import android.os.Handler;  
import android.util.AttributeSet;  
import android.view.MotionEvent;  
import android.widget.ScrollView;  

@SuppressLint("HandlerLeak")
public class MScrollViewExtend extends ScrollView {  
    private OnScrollListener onScrollListener;  

    private int lastScrollY;  
      
    public MScrollViewExtend(Context context) {  
        this(context, null);  
    }  
      
    public MScrollViewExtend(Context context, AttributeSet attrs) {  
        this(context, attrs, 0);  
    }  
  
    public MScrollViewExtend(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
    }  
      
    /** 
     * @param onScrollListener 
     */  
    public void setOnScrollListener(OnScrollListener onScrollListener) {  
        this.onScrollListener = onScrollListener;  
    }  
  
  
 
    @SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {  
  
        public void handleMessage(android.os.Message msg) {  
            int scrollY = MScrollViewExtend.this.getScrollY();  
              
            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息  
            if(lastScrollY != scrollY){  
                lastScrollY = scrollY;  
                handler.sendMessageDelayed(handler.obtainMessage(), 5);    
            }  
            if(onScrollListener != null){  
                onScrollListener.onScroll(scrollY);  
            }  
              
        };  
  
    };   
  
 
    @SuppressLint("ClickableViewAccessibility")
	@Override  
    public boolean onTouchEvent(MotionEvent ev) {  
        if(onScrollListener != null){  
            onScrollListener.onScroll(lastScrollY = this.getScrollY());  
        }  
        switch(ev.getAction()){  
        case MotionEvent.ACTION_UP:  
             handler.sendMessageDelayed(handler.obtainMessage(), 5);    
            break;  
        }  
        return super.onTouchEvent(ev);  
    }  
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
    	super.onScrollChanged(l, t, oldl, oldt);
    	onScrollListener.scrolling(t);
    }
  
  
 
    public interface OnScrollListener{  
        /** 
         * 回调方法， 返回MyScrollView滑动的Y方向距离 
         * @param scrollY 
         *              、 
         */  
        public void onScroll(int scrollY);  
        public void scrolling(int scY);
    }  
      
      
  
}  
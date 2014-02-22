package com.example.mymusicplayer;


import android.graphics.Canvas;
import android.os.Bundle;  
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;  
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
  
public class MainActivity extends SlidingFragmentActivity {  
    //private SlidingMenu menu;  
    
    private CanvasTransformer mTransformer;
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
                          
        //设置标题  
        setTitle("Zoom");  
        initAnimation();
  
        //初始化滑动菜单  
        initSlidingMenu();  
        
        getActionBar().setDisplayHomeAsUpEnabled(true);  
    }  
    
    
    //初始化动画效果
    private void initAnimation() {
		
    	mTransformer= new  CanvasTransformer(){
    		@Override
    		public void transformCanvas(Canvas canvas, float percentOpen) {
    			
    			float scale = (float) (percentOpen*0.25 + 0.75);  
                canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
    			
    		}
    	};
		
	}

	/** 
     * 初始化滑动菜单 
     */  
    private void initSlidingMenu() {  
        // 设置主界面视图  
        setContentView(R.layout.content_frame);  
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();  
  
        //设置滑动菜单视图
        
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new SampleListFragment()).commit();
        
        // 设置滑动菜单的属性值  
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.shadow_width); 
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
        sm.setBehindScrollScale(0.0f);  
        sm.setBehindCanvasTransformer(mTransformer);
        
        
        setSlidingActionBarEnabled(true);  
        // 设置滑动菜单的视图界面  
        //menu.setMenu(R.layout.menu_frame);    
        //getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new SampleListFragment()).commit();  
    }  
      
    @Override  
    public void onBackPressed() {  
        //点击返回键关闭滑动菜单  
        /*if (menu.isMenuShowing()) {  
            menu.showContent();  
        } else {  
            super.onBackPressed();  
        }  */
    	super.onBackPressed(); 
    }  
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
    	return super.onOptionsItemSelected(item);
    	
    }
  
}  
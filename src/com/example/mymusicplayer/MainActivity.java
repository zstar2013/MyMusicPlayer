package com.example.mymusicplayer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.os.Bundle;  
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

import com.example.entry.AppConstant;
import com.example.entry.Mp3Info;
import com.example.utils.MediaUtil;
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
        
        setListAdpter(MediaUtil.getMp3Infos(this));
        
        
        getActionBar().setDisplayHomeAsUpEnabled(true);  
    }  
    
    
    
    //初始化动画效果
    private void initAnimation() {
		
    	mTransformer= new  CanvasTransformer(){
    		@Override
    		public void transformCanvas(Canvas canvas, float percentOpen) {
    			
    			
    			//动画3
    			canvas.translate(0, canvas.getHeight() * (1 - interp.getInterpolation(percentOpen)));       
    			
    			//动画2
    			//canvas.scale(percentOpen, 1, 0, 0);   
    			
    			//动画1
    			/*float scale = (float) (percentOpen*0.25 + 0.75);  
                canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);*/
    			
    		}
    	};
		
	}
    
    private static Interpolator interp = new Interpolator() {  
        @Override  
        public float getInterpolation(float t) {  
            t -= 1.0f;  
            return t * t * t + 1.0f;  
        }         
    }; 

	/** 
     * 初始化滑动菜单 
     */  
    private void initSlidingMenu() {  
        // 设置主界面视图  
        setContentView(R.layout.content_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, musicList).commit();  
  
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
    
    private class MusicListItemClickListener implements OnItemClickListener {
    	
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			if(mp3Infos != null) {
    			Mp3Info mp3Info = mp3Infos.get(arg2);
    			Log.d("mp3Info-->", mp3Info.toString());
    			Intent intent = new Intent();
    			intent.putExtra("url", mp3Info.getUrl());		
    			intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
    			intent.setClass(MainActivity.this, PlayerService.class);
    			startService(intent);		//启动服务
    		}
			
		}
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
    
    
    List<Mp3Info> mp3Infos;
	
	private SimpleAdapter mAdapter;
	
	private MusicListFragment musicList=new MusicListFragment(){
		public void onViewCreated(View view, Bundle savedInstanceState) {
			musicList.getListView().setOnItemClickListener(new MusicListItemClickListener());
			
		};
	};
	
	/**
	 * 填充列表
	 * @param mp3Infos
	 */
	public void setListAdpter(List<Mp3Info> mp3Infos) {
		List<HashMap<String, String>> mp3list =MediaUtil.getMusicMaps(mp3Infos);		
		mAdapter = new SimpleAdapter(this, mp3list,
				R.layout.row_of_music, new String[] { "title", "Artist", "duration" },
				new int[] { R.id.music_title, R.id.music_Artist, R.id.music_duration });
		musicList.setListAdapter(mAdapter);	
	}

  
}  
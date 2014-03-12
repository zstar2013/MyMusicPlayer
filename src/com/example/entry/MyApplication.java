/**
 * app.java
 * com.example.entry
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2014-3-1 		zhangx
 *
 * Copyright (c) 2014, TNT All Rights Reserved.
*/

package com.example.entry;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
/**
 * ClassName:app
 *
 * @author   zhangx
 * @version  
 * @since    Ver 1.1
 * @Date	 2014-3-1		上午10:39:05
 *
 * @see 	 
 */


public class MyApplication extends Application{
    private static MyApplication mcontext;
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mcontext=this;
    }
    public static Context getAppContext(){
        return mcontext;
    }
    public static Resources getAppResources(){
        return getAppResources();
    }
}
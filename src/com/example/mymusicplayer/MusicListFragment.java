/**
 * MusicListFragment.java
 * com.example.mymusicplayer
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2014-2-27 		zhangx
 *
 * Copyright (c) 2014, TNT All Rights Reserved.
*/

package com.example.mymusicplayer;

import com.example.entry.MyApplication;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * ClassName:MusicListFragment
 *
 * @author   zhangx
 * @version  
 * @since    Ver 1.1
 * @Date	 2014-2-27		下午6:48:36
 *
 * @see 	 
 */
public class MusicListFragment extends ListFragment {


	public void onActivityCreated(android.os.Bundle savedInstanceState) {	
		super.onActivityCreated(savedInstanceState);
	};
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		Log.v("musicplayer", "---------------sub onViewCreated");
		
		
	}
	
	
	
}


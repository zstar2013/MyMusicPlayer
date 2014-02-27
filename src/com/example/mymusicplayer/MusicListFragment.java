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

import android.support.v4.app.ListFragment;
import android.util.Log;

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
		
		Log.v("musicplayer", "---------------sub create");
	};
	
	
	
}


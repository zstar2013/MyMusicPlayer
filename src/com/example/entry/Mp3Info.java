/**
 * Mp3Info.java
 * com.example.entry
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2014-2-27 		zhangx
 *
 * Copyright (c) 2014, TNT All Rights Reserved.
 */

package com.example.entry;

import android.provider.MediaStore;

/**
 * ClassName:Mp3Info
 * 
 * @author zhangx
 * @version
 * @since Ver 1.1
 * @Date 2014-2-27 下午6:32:25
 * 
 * @see
 */
public class Mp3Info {
	// 音乐id
	private long id;
	// 音乐标题
	private String title;
	// 艺术家
	private String artist;
	// 时长
	private long duration;
	// 文件大小
	private long size;
	// 文件路径
	private String url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

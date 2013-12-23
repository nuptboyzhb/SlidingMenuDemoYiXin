/*
 * $filename: AboutActivity.java,v $
 * $Date: 2013-12-23  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.activity;




import edu.njupt.zhb.slidemenu.R;
import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-12-23  Nanjing,njupt,China
 */
public class AboutActivity extends Activity implements OnClickListener{

	private ImageButton aboutTitleBtnLeft;
	private ImageButton aboutTitleBtnRight;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		aboutTitleBtnLeft = (ImageButton)findViewById(R.id.aboutTitleBtnLeft);
		aboutTitleBtnRight = (ImageButton)findViewById(R.id.aboutTitleBtnRight);
		aboutTitleBtnLeft.setOnClickListener(this);
		aboutTitleBtnRight.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.aboutTitleBtnLeft:
			this.finish();
			break;
		case R.id.aboutTitleBtnRight:
			
			break;
		default:
			break;
		}
	}
	
}

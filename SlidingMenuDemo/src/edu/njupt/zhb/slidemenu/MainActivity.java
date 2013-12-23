package edu.njupt.zhb.slidemenu;
import edu.njupt.zhb.slidemenu.R;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends SlidingFragmentActivity implements OnClickListener{
	protected SlidingMenu leftRightSlidingMenu;
	private ImageButton ivTitleBtnLeft;
	private ImageButton ivTitleBtnRight;
	private Fragment mContent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLeftRightSlidingMenu();
		setContentView(R.layout.activity_main);
		initView();
	}
	
	
	private void initView() {
		ivTitleBtnLeft = (ImageButton)this.findViewById(R.id.ivTitleBtnLeft);
		ivTitleBtnLeft.setOnClickListener(this);
		ivTitleBtnRight = (ImageButton)this.findViewById(R.id.ivTitleBtnRight);
		ivTitleBtnRight.setOnClickListener(this);
	}

	private void initLeftRightSlidingMenu() {
		mContent = new FragmentDefaultMain();
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();
		setBehindContentView(R.layout.main_left_layout);
		FragmentTransaction leftFragementTransaction = getSupportFragmentManager().beginTransaction();
		Fragment leftFrag = new LeftSlidingMenuFragment();
		leftFragementTransaction.replace(R.id.main_left_fragment, leftFrag);
		leftFragementTransaction.commit();
		// customize the SlidingMenu
		leftRightSlidingMenu = getSlidingMenu();
		leftRightSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);// 设置是左滑还是右滑，还是左右都可以滑，我这里只做了左滑
		leftRightSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置菜单宽度
		leftRightSlidingMenu.setFadeDegree(0.35f);// 设置淡入淡出的比例
		leftRightSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置手势模式
		leftRightSlidingMenu.setShadowDrawable(R.drawable.shadow);// 设置左菜单阴影图片
		leftRightSlidingMenu.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
		leftRightSlidingMenu.setBehindScrollScale(0.333f);// 设置滑动时拖拽效果
		
		leftRightSlidingMenu.setSecondaryMenu(R.layout.main_right_layout);
		FragmentTransaction rightFragementTransaction = getSupportFragmentManager().beginTransaction();
		Fragment rightFrag = new RightSlidingMenuFragment();
		leftFragementTransaction.replace(R.id.main_right_fragment, rightFrag);
		rightFragementTransaction.commit();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ivTitleBtnLeft:
			leftRightSlidingMenu.showMenu();
			break;
		case R.id.ivTitleBtnRight:
			leftRightSlidingMenu.showSecondaryMenu(true);
			break;
		default:
			break;
		}
		
	}
 

	/**
	 *    左侧菜单点击切换首页的内容
	 */
	
	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		getSlidingMenu().showContent();
	}
	
	
}

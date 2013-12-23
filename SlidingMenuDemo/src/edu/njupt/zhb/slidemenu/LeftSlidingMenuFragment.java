package edu.njupt.zhb.slidemenu;

import edu.njupt.zhb.activity.AboutActivity;
import edu.njupt.zhb.slidemenu.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
/**
 * 主要控制左边按钮点击事件
 * @author Administrator
 *
 */
public class LeftSlidingMenuFragment extends Fragment implements OnClickListener{
	private View yixinBtnLayout;
	private View circleBtnLayout;
	private View settingBtnLayout;
	private View groupBtnLayout;
	private View listBtnLayout;
	private RoundedImageView roundedImageView;
     @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    }
     
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	 View view = inflater.inflate(R.layout.main_left_fragment, container,false);
    	  yixinBtnLayout = view.findViewById(R.id.yixinBtnLayout);
    	  yixinBtnLayout.setOnClickListener(this);
    	  circleBtnLayout = view.findViewById(R.id.circleBtnLayout);
    	  circleBtnLayout.setOnClickListener(this);
    	  groupBtnLayout = view.findViewById(R.id.groupBtnLayout);
    	  groupBtnLayout.setOnClickListener(this);
    	  settingBtnLayout = view.findViewById(R.id.settingBtnLayout);
    	  settingBtnLayout.setOnClickListener(this);
    	  roundedImageView = (RoundedImageView)view.findViewById(R.id.headImageView);
    	  roundedImageView.setOnClickListener(this);
    	  listBtnLayout = view.findViewById(R.id.listBtnLayout);
    	  listBtnLayout.setOnClickListener(this);
 		System.out.println();
    	return view;
    }

	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		switch (v.getId()) {
		case R.id.yixinBtnLayout:
			newContent = new FragmentDefaultMain();
			yixinBtnLayout.setSelected(true);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(false);
			groupBtnLayout.setSelected(false);
			listBtnLayout.setSelected(false);
			break;
		case R.id.circleBtnLayout:
			newContent = new FragmentFriend();
			yixinBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(true);
			settingBtnLayout.setSelected(false);
			groupBtnLayout.setSelected(false);
			listBtnLayout.setSelected(false);
			break;
		case R.id.settingBtnLayout:
			newContent = new FragmentSetting();
			yixinBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(true);
			groupBtnLayout.setSelected(false);
			listBtnLayout.setSelected(false);
		    break;
		case R.id.groupBtnLayout:
			newContent = new FragmentGroup();
			groupBtnLayout.setSelected(true);
			yixinBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(false);
			listBtnLayout.setSelected(false);
		    break;
		case R.id.listBtnLayout:
			newContent = new FragmentList();
			listBtnLayout.setSelected(true);
			groupBtnLayout.setSelected(false);
			yixinBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(false);
		    break;
		case R.id.headImageView:
			//Toast.makeText(getActivity(), "点击头像", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(getActivity(),AboutActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		
		if (newContent != null)
			switchFragment(newContent);
		
	}
	
	
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
			MainActivity ra = (MainActivity) getActivity();
			ra.switchContent(fragment);
		
	}
}

package edu.njupt.zhb.slidemenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * 主要控制右边按钮点击事件
 * @author Administrator
 *
 */
public class RightSlidingMenuFragment extends Fragment implements OnClickListener{
	private View nearbyBtnLayout;
	private View circleBtnLayout;
	private View settingBtnLayout;
	private View groupBtnLayout;
     @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	 View view = inflater.inflate(R.layout.main_rigth_fragment, container,false);
    	  nearbyBtnLayout = view.findViewById(R.id.nearbyBtnLayout);
    	  nearbyBtnLayout.setOnClickListener(this);
    	  circleBtnLayout = view.findViewById(R.id.circleBtnLayout);
    	  circleBtnLayout.setOnClickListener(this);
    	  groupBtnLayout = view.findViewById(R.id.groupBtnLayout);
    	  groupBtnLayout.setOnClickListener(this);
    	  settingBtnLayout = view.findViewById(R.id.settingBtnLayout);
    	  settingBtnLayout.setOnClickListener(this);
    	return view;
    }
	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		switch (v.getId()) {
		case R.id.nearbyBtnLayout:
			newContent = new FragmentDefaultMain();
			nearbyBtnLayout.setSelected(true);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(false);
			groupBtnLayout.setSelected(false);
			break;
		case R.id.circleBtnLayout:
			newContent = new FragmentFriend();
			nearbyBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(true);
			settingBtnLayout.setSelected(false);
			groupBtnLayout.setSelected(false);
			break;
		case R.id.settingBtnLayout:
			newContent = new FragmentSetting();
			nearbyBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(true);
			groupBtnLayout.setSelected(false);
		    break;
		case R.id.groupBtnLayout:
			newContent = new FragmentGroup();
			groupBtnLayout.setSelected(true);
			nearbyBtnLayout.setSelected(false);
			circleBtnLayout.setSelected(false);
			settingBtnLayout.setSelected(false);
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

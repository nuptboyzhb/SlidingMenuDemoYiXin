package edu.njupt.zhb.slidemenu;

import edu.njupt.zhb.slidemenu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 朋友圈页面
 * @author Administrator
 *
 */
public class FragmentFriend extends Fragment{
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.fragment_friend, container, false);
    	return view;
    }
}

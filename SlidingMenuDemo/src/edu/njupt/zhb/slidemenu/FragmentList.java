package edu.njupt.zhb.slidemenu;

import java.util.LinkedList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import edu.njupt.zhb.view.MyListView;
import edu.njupt.zhb.view.MyListView.OnRefreshListener;
/**
 * ListView
 * @author Administrator
 *
 */
public class FragmentList extends Fragment{
	private LinkedList<String> data;
	private BaseAdapter adapter;
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.fragment_list, container, false);

		data = new LinkedList<String>();
	    for(int i=0;i<10;i++){
	    	data.add(String.valueOf(i));
	    }

		final MyListView listView = (MyListView) view.findViewById(R.id.listView);
		adapter = new BaseAdapter() {
			public View getView(int position, View convertView, ViewGroup parent) {
				 convertView=LayoutInflater.from(getActivity()).inflate(R.layout.listview_item, null);
				TextView textView = (TextView) convertView.findViewById(R.id.textView_item);
				textView.setText(data.get(position));
				return convertView;
			}

			public long getItemId(int position) {
				return position;
			}

			public Object getItem(int position) {
				return data.get(position);
			}

			public int getCount() {
				return data.size();
			}
		};
		listView.setAdapter(adapter);

		listView.setonRefreshListener(new OnRefreshListener() {
			public void onRefresh() {
				new AsyncTask<Void, Void, Void>() {
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						data.addFirst("刷新后的内容");
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						adapter.notifyDataSetChanged();
						listView.onRefreshComplete();
					}

				}.execute(null,null,null);
			}
		});
    	return view;
    }
}

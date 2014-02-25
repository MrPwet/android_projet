package fr.iutbm.horube.android_projet;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GtsModeleAdapter extends ArrayAdapter<GtsModele> {
	List<GtsModele> lstGts;
	LayoutInflater mInflater;
	
	public GtsModeleAdapter(Context context, List<GtsModele> lstGts) {
		super(context, R.layout.row_list, lstGts);
		this.lstGts = lstGts;
		this.mInflater = LayoutInflater.from(context);
	}
	
	public static class ViewHolder {
		public TextView nameView;
		public ImageView iconView;
	}
	
	@Override
	public View getView(int postion, View convertView, ViewGroup parent) {
		ViewHolder holder;
		View rowView = convertView;
		
		if(rowView == null) {
			rowView = mInflater.inflate(R.layout.row_list, null);
			
			holder = new ViewHolder();
			holder.nameView = (TextView)rowView.findViewById(R.id.name);
			holder.iconView = (ImageView)rowView.findViewById(R.id.icon);
			
			rowView.setTag(holder);
		}
		else {
			holder = (ViewHolder)rowView.getTag();
		}
		
		GtsModele gtsModel = lstGts.get(postion);
		
		holder.nameView.setText(gtsModel.getName());
		holder.iconView.setImageResource(gtsModel.getIcon());
		
		return rowView;
	}
	
	@Override
	public int getCount() {
		return lstGts.size();
	}
}

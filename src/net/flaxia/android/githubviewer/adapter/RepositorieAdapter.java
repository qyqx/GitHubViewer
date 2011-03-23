package net.flaxia.android.githubviewer.adapter;

import net.flaxia.android.githubviewer.model.Repositorie;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RepositorieAdapter extends ArrayAdapter<Repositorie> {
    private LayoutInflater mInflater;

    public RepositorieAdapter(Context context, int textViewResourceId, Repositorie[] repositories) {
        super(context, textViewResourceId, repositories);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (null == convertView) ? mInflater.inflate(android.R.layout.simple_list_item_2,
                null) : convertView;
        Repositorie repositorie = getItem(position);
        ((TextView) view.findViewById(android.R.id.text1)).setText(repositorie.get("name"));
        ((TextView) view.findViewById(android.R.id.text2)).setText(repositorie.get("description"));
        return view;
    }
}
package br.com.liveo.tabletrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rudsonlive on 25/03/15.
 */
public class TabletAdapter extends RecyclerView.Adapter<TabletAdapter.ViewHolder> {

    private ArrayList<String> mListTablet;
    private static OnItemClickListener onItemClickListener;

    public TabletAdapter(ArrayList<String> tablet){
        this.mListTablet = tablet;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        TabletAdapter.onItemClickListener = onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtTitle;

        public ViewHolder(View v) {
            super(v);

            mTxtTitle = (TextView) v.findViewById(R.id.txtTitle);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }

    @Override
    public TabletAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_item, viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTxtTitle.setText(mListTablet.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return (mListTablet == null ? 0 : mListTablet.size());
    }
}

package br.com.liveo.tabletrecyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mListTablet = new ArrayList<>();
    private static final String OBJ_LIST = "OBJ_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        if (savedInstanceState == null){
            montArrayList();
        }else{
            mListTablet = savedInstanceState.getStringArrayList(OBJ_LIST);
            setResultAdapter(mListTablet);
        }
    }

    private void montArrayList(){
        for (int i = 0; i < 300; i++) {
            mListTablet.add("Mesa " + i);
        }
        setResultAdapter(mListTablet);
    }

    private void setResultAdapter(ArrayList<String> listTablet){

        TabletAdapter adapter = new TabletAdapter(listTablet);
        adapter.setOnItemClickListener(onItemClick);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(OBJ_LIST, mListTablet);
    }

    private OnItemClickListener onItemClick = new OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(getApplicationContext(), mListTablet.get(position), Toast.LENGTH_SHORT).show();
        }
    };
}

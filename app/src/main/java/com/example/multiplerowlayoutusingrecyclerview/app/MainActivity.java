package com.example.multiplerowlayoutusingrecyclerview.app;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.multiplerowlayoutusingrecyclerview.R;
import com.example.multiplerowlayoutusingrecyclerview.adapter.RecyclerAdapter;
import com.example.multiplerowlayoutusingrecyclerview.model.Landscape;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpDrawer();
        setUpRecyclerView();
    }

    private void setUpToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Multiple Rows Layout Demo");
        toolbar.inflateMenu(R.menu.menu_main);
    }

    private void setUpDrawer() {

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this); // (Context context, int spanCount)
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator()); // Even if we don't use it then also our items shows default animation. #Check Docs
    }
}

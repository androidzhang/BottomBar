package com.zlx.btnabar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.zlx.bottombar.BottomTabBar;
import com.zlx.btnabar.fragment.FourFragment;
import com.zlx.btnabar.fragment.OneFragment;
import com.zlx.btnabar.fragment.ThreeFragment;
import com.zlx.btnabar.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_main);

        mBottomBar = (BottomTabBar) findViewById(R.id.bottom_bar);

        mBottomBar.init(getSupportFragmentManager()).setImgSize(90, 90).setFontSize(12).setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.BLACK)
                .addTabItem("首页", R.mipmap.ic_launcher, OneFragment.class)
                .addTabItem("消息", R.mipmap.ic_launcher, TwoFragment.class)
                .addTabItem("发现", R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("我的", R.mipmap.ic_launcher, FourFragment.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}

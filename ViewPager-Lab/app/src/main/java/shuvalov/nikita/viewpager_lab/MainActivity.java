package shuvalov.nikita.viewpager_lab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyFragments> mFragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentArrayList = new ArrayList<>();

        MyFragments pictureFragment = new PictureFragment();
        MyFragments personalInfoFragment = new PersonalinfoFragment();
        MyFragments contactInfoFragment = new UserContactFragment();

        mFragmentArrayList.add(pictureFragment);
        mFragmentArrayList.add(personalInfoFragment);
        mFragmentArrayList.add(contactInfoFragment);


        FragmentManager fragmentManager = getSupportFragmentManager();
        ProfileFragmentAdapter profileFragmentAdapter = new ProfileFragmentAdapter(fragmentManager, mFragmentArrayList);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(profileFragmentAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}

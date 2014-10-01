package com.example.scrollabletabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity {

	ViewPager viewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    FragmentManager fman = getSupportFragmentManager();
    viewPager.setAdapter(new MyAdapter(fman));
    
    }

}



class MyAdapter extends FragmentStatePagerAdapter{

	public MyAdapter(FragmentManager fm) {
		super(fm);
		
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = new Fragment();
		
		if (i== 0){
			fragment = new Frag1();
		}
		if (i== 1){
			fragment = new Frag2();
		}
		if (i== 2){
			fragment = new Frag3();
		}
		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		if (position ==0){
			
			return "Tab 1";
		}
		if (position ==1){
			
			return "Tab 2";
		}
		if (position ==2){
	
			return "Tab 3";
		}
		return null;
	}
	
}
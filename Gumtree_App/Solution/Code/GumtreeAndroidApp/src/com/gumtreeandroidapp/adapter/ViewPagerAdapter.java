package com.gumtreeandroidapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.gumtreeandroidapp.fragment.PictureFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	private static final int NUM_PAGES = 9;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {

		Log.d("Status", "I am at " + ViewPagerAdapter.class.getSimpleName());

		return new PictureFragment(position);
	}

	@Override
	public int getCount() {
		return NUM_PAGES;
	}
}
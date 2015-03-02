package com.gumtreeandroidapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.gumtreeandroidapp.adapter.ItemListAdapter;
import com.gumtreeandroidapp.model.ItemModel;

public class ViewItemActivity extends FragmentActivity {

	private ShareActionProvider mShareActionProvider;
	private ListView mListView;
	private List<ItemModel> mList;
	private Button btn_Call,btn_Email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_view_item);

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		mListView = (ListView) findViewById(R.id.itemList);
		btn_Call =(Button)findViewById(R.id.btnCall);
		btn_Email =(Button)findViewById(R.id.btnEmail);
		mList = getItemDescriptionList();

		BaseAdapter adapter = new ItemListAdapter(getApplicationContext(),
				mList, getSupportFragmentManager());

		mListView.setAdapter(adapter);
		mListView.setOnTouchListener(new AdapterView.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				mListView.getParent().requestDisallowInterceptTouchEvent(true);
				return false;
			}
		});

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ItemModel item = (ItemModel) arg0.getItemAtPosition(arg2);
				if (item.getType().equals("loc-price")) {
					Intent intent = new Intent(
							android.content.Intent.ACTION_VIEW,
							Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
					startActivity(intent);
				}
			}
		});

		//Call Button
		btn_Call.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(Intent.ACTION_CALL);
				String phNum = "tel:" + "1234567890";
				myIntent.setData(Uri.parse(phNum));
				startActivity( myIntent ) ;

			}
		});

		//Email Button
		btn_Email.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
				i.putExtra(Intent.EXTRA_SUBJECT, "Buy the call");
				i.putExtra(Intent.EXTRA_TEXT   , "I am interrested ");
				try {
				    startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(ViewItemActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private List<ItemModel> getItemDescriptionList() {
		List<ItemModel> mList = new ArrayList<ItemModel>();
		ItemModel mItemModel = null;
		/**
		 * This loop helps to populate item Listview with various layouts for a
		 * specific item
		 */
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				mItemModel = new ItemModel();
				mItemModel.setType("pager");
			} else if (i == 1) {
				mItemModel = new ItemModel();
				mItemModel.setType("title");
			} else if (i == 2) {
				mItemModel = new ItemModel();
				mItemModel.setType("loc-price");
			} else if (i == 3) {
				mItemModel = new ItemModel();
				mItemModel.setType("date");
			} else if (i == 4) {
				mItemModel = new ItemModel();
				mItemModel.setType("desc-title");
			} else if (i == 5) {
				mItemModel = new ItemModel();
				mItemModel.setType("description");
			} else if (i == 6) {
				mItemModel = new ItemModel();
				mItemModel.setType("map");
			}
			mList.add(mItemModel);
		}

		return mList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		MenuItem item = menu.findItem(R.id.action_share);

		mShareActionProvider = (ShareActionProvider) item.getActionProvider();
		mShareActionProvider.setShareIntent(getDefaultShareIntent());

		invalidateOptionsMenu();

		// Return true to display menu
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			ViewItemActivity.super.onBackPressed();
			return true;
		case R.id.action_favourite:
			Toast.makeText(getApplicationContext(),
					"Favourite checked: " + item.isChecked(),
					Toast.LENGTH_SHORT).show();
			item.setChecked(!item.isChecked());
			item.setIcon(item.isChecked() ? R.drawable.ic_bookmark
					: R.drawable.ic_no_bookmark);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/** Returns a share intent */
	private Intent getDefaultShareIntent() {

		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "");
		intent.putExtra(Intent.EXTRA_TEXT, "");
		return intent;
	}

}
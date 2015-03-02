package com.gumtreeandroidapp.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gumtreeandroidapp.R;
import com.gumtreeandroidapp.model.ItemModel;

public class ItemListAdapter extends BaseAdapter {

	private final List<ItemModel> mList;
	private final Context mContext;
	private final FragmentManager mFragmentManager;
	private final LayoutInflater mLayoutInflater;

	public ItemListAdapter(Context context, List<ItemModel> list,
			FragmentManager fragmentManager) {
		mContext = context;
		mList = list;
		mFragmentManager = fragmentManager;
		mLayoutInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItemViewType(int position) {

		ItemModel model = mList.get(position);
		int currentLayoutType = -1;

		if (model.getType().equals("pager")) {
			currentLayoutType = 0;
		} else if (model.getType().equals("title")) {
			currentLayoutType = 1;
		} else if (model.getType().equals("loc-price")) {
			currentLayoutType = 2;
		} else if (model.getType().equals("date")) {
			currentLayoutType = 3;
		} else if (model.getType().equals("desc-title")) {
			currentLayoutType = 4;
		} else if (model.getType().equals("description")) {
			currentLayoutType = 5;
		} else if (model.getType().equals("map")) {
			currentLayoutType = 6;
		}

		return currentLayoutType;

	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		View convertView = view;
		ViewPagerHolder mViewPagerHolder;
		ViewTitleHolder mViewTitleHolder;
		ViewPlacePriceHolder mViewPlacePriceHolder;
		ViewDescriptionHolder mViewDescriptionHolder;

		if (getItemViewType(position) == 0) {

			if (convertView == null) {

				mViewPagerHolder = new ViewPagerHolder();

				convertView = mLayoutInflater.inflate(R.layout.pager_row_item,
						null);

				ViewPager mPager = (ViewPager) convertView
						.findViewById(R.id.list_pager);

				mPager.setBackground(mContext.getResources().getDrawable(
						R.drawable.image1));

				PagerAdapter mPagerAdapter = new ViewPagerAdapter(
						mFragmentManager);

				mPager.setAdapter(mPagerAdapter);

				mViewPagerHolder.mButton = (Button) convertView
						.findViewById(R.id.itemPicBtn);
				mViewPagerHolder.mViewPager = (ViewPager) convertView
						.findViewById(R.id.list_pager);

				convertView.setTag(mViewPagerHolder);
				convertView.setTag(R.id.itemPicBtn, mViewPagerHolder.mButton);
				convertView
						.setTag(R.id.list_pager, mViewPagerHolder.mViewPager);

			} else {
				mViewPagerHolder = (ViewPagerHolder) convertView.getTag();
			}
		} else if (getItemViewType(position) == 1) {

			if (convertView == null) {

				mViewTitleHolder = new ViewTitleHolder();

				convertView = mLayoutInflater.inflate(R.layout.title_row_item,
						null);

				TextView title = (TextView) convertView
						.findViewById(R.id.itemTitle);

				title.setText("1991 FERRARI 348 TS V8 IN ROSSO RED, 355 UPGRADE"
						+ ", LHD, MOT JULY, PX SWAP DOWN");
				convertView.setTag(mViewTitleHolder);
				convertView.setTag(R.id.itemTitle, mViewTitleHolder.mTextView);

			} else {
				mViewTitleHolder = (ViewTitleHolder) convertView.getTag();
			}

		} else if (getItemViewType(position) == 2) {

			if (convertView == null) {

				mViewPlacePriceHolder = new ViewPlacePriceHolder();

				convertView = mLayoutInflater.inflate(
						R.layout.place_price_row_item, null);

				ImageView icon = (ImageView) convertView
						.findViewById(R.id.itemMapIcon);
				TextView location = (TextView) convertView
						.findViewById(R.id.itemLocation);
				TextView price = (TextView) convertView
						.findViewById(R.id.itemPrice);

				icon.setImageResource(R.drawable.ic_loc);
				location.setText("Peeterly, County Durham");
				price.setText("�26,995");

				convertView.setTag(mViewPlacePriceHolder);
				convertView.setTag(R.id.itemMapIcon,
						mViewPlacePriceHolder.mImageView);
				convertView.setTag(R.id.itemLocation,
						mViewPlacePriceHolder.mPlace);
				convertView
						.setTag(R.id.itemPrice, mViewPlacePriceHolder.mPrice);

			} else {
				mViewPlacePriceHolder = (ViewPlacePriceHolder) convertView
						.getTag();
			}

		} else if (getItemViewType(position) == 3) {

			if (convertView == null) {

				mViewTitleHolder = new ViewTitleHolder();

				convertView = mLayoutInflater.inflate(
						R.layout.date_posted_row_item, null);

				TextView date = (TextView) convertView
						.findViewById(R.id.itemDatePosted);

				date.setText("23/02/2015");

				convertView.setTag(mViewTitleHolder);
				convertView.setTag(R.id.itemDatePosted,
						mViewTitleHolder.mTextView);
				convertView.setTag(R.id.itemDatePosted,
						mViewTitleHolder.mTextView);

			} else {
				mViewTitleHolder = (ViewTitleHolder) convertView
						.getTag();
			}

		}

		else if (getItemViewType(position) == 4) {
			if (convertView == null) {

				mViewTitleHolder = new ViewTitleHolder();

				convertView = mLayoutInflater.inflate(
						R.layout.desc_title_item_row, null);

				TextView descTitle = (TextView) convertView
						.findViewById(R.id.itemDescrTitle);

				descTitle.setText("Description");

				convertView.setTag(mViewTitleHolder);
				convertView.setTag(R.id.itemDescrTitle,
						mViewTitleHolder.mTextView);
				convertView.setTag(R.id.itemDescrTitle,
						mViewTitleHolder.mTextView);

			} else {
				mViewTitleHolder = (ViewTitleHolder) convertView
						.getTag();
			}

		} else if (getItemViewType(position) == 5) {

			if (convertView == null) {

				mViewDescriptionHolder = new ViewDescriptionHolder();

				convertView = mLayoutInflater.inflate(R.layout.desc_row_item,
						null);

				TextView title = (TextView) convertView
						.findViewById(R.id.itemDescription);

				title.setText("P"
						+ new String(
								"hone:0792 5386802 POSSIBLE PX OR SWAP EITHER"
										+ " WAY.  AT �26,995 FOR A WORKING MOT'D FERRARI 348 THIS"
										+ " MUST BE THE BEST VALUE EXAMPLE AVAILABLE.  1991 FERRARI"
										+ " 348 TS IN RED. BODY UPGRADE TO 355 GIVING IT STUNNING"
										+ " LOOKS. FIRST REGISTERED 1991 IN ITALY THEN IMPORTED INTO"
										+ " THE UK IN 1998, SO LEFT HAND DRIVE. 48300 RECORDED KM'S,"
										+ " NO PROOF THAT IT IS CORRECT. MOT UNTIL JULY 2015, V5 LOG BOOK"
										+ " IS PRESENT BUT NO OTHER PAPERWORK AND IT ALSO HAD AN INSURANCE"
										+ " CLAIM AGAINST IT BACK IN 2000 HENCE THE REASON IT IS �15,000+"
										+ " LESS THAN NORMAL. JUST HAD A FULL SERVICE, TYRE'S, VALET ETC. "
										+ "DRIVES VERY WELL, NO DRAMA'S, NO WARNING LIGHTS, NO NASTY NOISES OR"
										+ " SIGNS OF TROUBLE. NOT PRISTINEBUT A VERY TIDY USABLE EXAMPLE OF A"
										+ " 348 THAT LOOKS STUNNING AND IS PRICED LIKE A MONDIAL, THIS CAR LOOKS"
										+ " �45,000. USUAL LOVELY SPEC INCLUDING A REMOVABLE TARGA ROOF ELECTRIC"
										+ " PACK ETC. PLEASE NO TEST PILOTS, DREAMERS OR BIDDERS, IF YOU WANT TO"
										+ " OFFER A PART EXCHANGE OR SWAP PLEASE EMAIL ME WITH YOUR VEHICLES FULL"
										+ " DETAILS AND HOW MUCH YOU WANT FOR IT, IF YOU DON'T SAY HOW MUCH YOU WANT"
										+ " FOR IT I WONT REPLY, PLEASE NOTE THAT I AM ONLY INTERESTED IN REASONABLY"
										+ " PRICED VEHICLES SO IF YOU WANT SHOWROOM PRICES FOR IT PLEASE DON'T BOTHER"
										+ " ASKING. UNDER OUR NEW COMPANY SELLING PRACTICES AND FOR THE REASON THAT WE"
										+ " OFFER NO WARRANTY ON ANY OF OUR CARS REGARDLESS OF PRICE, AGE AND MILEAGE"
										+ " THIS CAR IS SOLD SOLELY FOR THE PURPOSE OF SPARES OR REPAIRS, YOU MAY COME,"
										+ " VIEW, INSPECT ETC, YOU CAN TAKE ALL DAY IF YOU WISH, WE WELCOME ANY RAC OR AA"
										+ " INSPECTION ETC BUT ONCE YOU PURCHASE THE VEHICLE WE WILL NOT ENTERTAIN ANY"
										+ " COMEBACK WHATSOEVER DUE TO THE FACT THAT THIS CAR IS SOLD AS SPARES OR REPAIRS"
										+ " WITH SUCH A LARGE DISCOUNT, PLEASE CALL US IF YOU REQUIRE ANY FURTHER"
										+ " INFORMATION. ").toLowerCase());

				convertView.setTag(mViewDescriptionHolder);
				convertView.setTag(R.id.itemDescription,
						mViewDescriptionHolder.mTextView);

			} else {
				mViewTitleHolder = (ViewTitleHolder) convertView.getTag();
			}

		}

		return convertView;
	}

	public static class ViewPagerHolder {
		public ViewPager mViewPager;
		public Button mButton;

	}

	public static class ViewTitleHolder {
		public TextView mTextView;
	}

	public static class ViewPlacePriceHolder {
		public ImageView mImageView;
		public TextView mPlace;
		public TextView mPrice;
	}

	public static class ViewDescriptionHolder {
		public TextView mTextView;
	}
}

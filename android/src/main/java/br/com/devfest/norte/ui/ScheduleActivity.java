/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.devfest.norte.ui;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import br.com.devfest.norte.R;

public class ScheduleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);

        if (!isTablet){
            ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
            viewPager.setAdapter(new ScheduleTrackAdapter(getSupportFragmentManager()));
        }
    }

    private class ScheduleTrackAdapter extends FragmentPagerAdapter {

        public ScheduleTrackAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pageIndex) {
            Fragment fragment = null;
            switch (pageIndex){
                case 0:{
                    fragment = new WebCloudScheduleFragment();
                    break;
                }

                case 1:{
                    fragment = new MobileScheduleFragment();
                    break;
                }
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String pageTitle = null;
            switch (position){
                case 0:{
                    pageTitle = "Web & Cloud";
                    break;
                }
                case 1:{
                    pageTitle = "Mobile";
                    break;
                }
            }
            return pageTitle;
        }
    }

//        final WeakReference<ScheduleActivity> weakRefToParent;
//        final Handler handler;
//        final int today;
//
//        public UpdateUIRunnable(ScheduleActivity activity, int today, Handler handler) {
//            weakRefToParent = new WeakReference<ScheduleActivity>(activity);
//            this.handler = handler;
//            this.today = today;
//        }
//
//        public void scheduleNextRun() {
//            handler.postDelayed(this, INTERVAL_TO_REDRAW_UI);
//        }
//
//        @Override
//        public void run() {
//            ScheduleActivity activity = weakRefToParent.get();
//            if (activity == null || activity.hasBeenDestroyed()) {
//                LOGD(TAG, "Ativity is not valid anymore. Stopping UI Updater");
//                return;
//            }
//            LOGD(TAG, "Running MySchedule UI updater (now=" +
//                    new Date(UIUtils.getCurrentTime(activity)) + ")");
//            if (activity.mScheduleAdapters != null
//                    && activity.mScheduleAdapters.length > today
//                    && activity.mScheduleAdapters[today] != null) {
//                try {
//                    activity.mScheduleAdapters[today].forceUpdate();
//                } finally {
//                    // schedule again
//                    this.scheduleNextRun();
//                }
//            }
//        }
//    }


    @Override
    protected void onNavDrawerStateChanged(boolean isOpen, boolean isAnimating) {
        super.onNavDrawerStateChanged(isOpen, isAnimating);
        updateActionBarNavigation();
    }

    private void updateActionBarNavigation() {
        boolean show = !isNavDrawerOpen();
        if (getLPreviewUtils().shouldChangeActionBarForDrawer()) {
            ActionBar ab = getActionBar();
            ab.setDisplayShowTitleEnabled(show);
            ab.setDisplayUseLogoEnabled(!show);
        }
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_ITEM_MY_SCHEDULE;
    }
//
}

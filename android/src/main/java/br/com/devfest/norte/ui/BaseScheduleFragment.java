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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.devfest.norte.R;
import br.com.devfest.norte.model.BaseScheduleItem;

import java.util.List;

/**
 * A list fragment that shows items from Schedule.
 * To use, call setListAdapter(), passing it an instance of your MyScheduleAdapter.
 */
public abstract class BaseScheduleFragment extends Fragment {

    ListView listViewSchedule;
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my_schedule, null);
        configureScheduleListView();
        return v;
    }

    private void configureScheduleListView() {
        listViewSchedule = (ListView) v.findViewById(R.id.list_schedule);
        listViewSchedule.setAdapter(new ScheduleAdapter(getActivity(), createScheduleItems()));
    }

    // subclass must override this method in order to provide list of
    // schedule items
    protected abstract List<BaseScheduleItem> createScheduleItems();
}

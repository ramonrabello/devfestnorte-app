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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.devfest.norte.R;
import br.com.devfest.norte.model.BaseScheduleItem;
import br.com.devfest.norte.model.SpeakerScheduleItem;
import br.com.devfest.norte.ui.widget.BezelImageView;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Adapter that produces views to render (one day of) the "My Schedule" screen.
 */
public class ScheduleAdapter extends BaseAdapter {

    private List<BaseScheduleItem> items;
    private Context context;

    private static final int TYPE_ITEM_FREE = 0;

    private static final int TYPE_ITEM_SPEAKER = 1;

    private static final int TYPE_MAX_COUNT = TYPE_ITEM_SPEAKER + 1;

    public ScheduleAdapter(Context context, List<BaseScheduleItem> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (items.get(position) instanceof SpeakerScheduleItem){
            return TYPE_ITEM_SPEAKER;
        } else {
            return TYPE_ITEM_FREE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);

        TextView textViewStartTimeHours;
        TextView textViewStartTimeMinutes;
        TextView textViewEndTimeHours;
        TextView textViewEndTimeMinutes;
        TextView textViewSlotTitle;
        ImageView imageViewScheduleItemHeader;

        View view = convertView;
        if (view == null){

            switch(type){

                case TYPE_ITEM_FREE:{
                    view = LayoutInflater.from(context).inflate(R.layout.my_base_schedule_item, null);
                    break;
                }
                case TYPE_ITEM_SPEAKER:{
                    view = LayoutInflater.from(context).inflate(R.layout.speaker_schedule_item, null);
                    break;
                }
            }
        }

        BaseScheduleItem item = items.get(position);

        if (type == TYPE_ITEM_SPEAKER){

            SpeakerScheduleItem speakerScheduleItem = (SpeakerScheduleItem) item;
            TextView textViewSpeakerName = (TextView) view.findViewById(R.id.slot_speaker_name);
            TextView textViewSpeakerCompany = (TextView) view.findViewById(R.id.slot_speaker_company);
            BezelImageView imageViewSpeakerProfileImage = (BezelImageView) view.findViewById(R.id.speaker_image);

            // set speakers info
            textViewSpeakerName.setText(speakerScheduleItem.getSpeakerName());
            textViewSpeakerCompany.setText(speakerScheduleItem.getSpeakerCcompany());
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), speakerScheduleItem.getSpeakerPlusProfileImage());
            imageViewSpeakerProfileImage.setImageBitmap(bitmap);
        }

        StringTokenizer tokenizer = new StringTokenizer(item.getStart(), ":");
        String startTimeHours = tokenizer.nextToken();
        String startTimeMinutes = tokenizer.nextToken();

        tokenizer = new StringTokenizer(item.getEnd(), ":");
        String endTimeHours = tokenizer.nextToken();
        String endTimeMinutes = tokenizer.nextToken();

        imageViewScheduleItemHeader = (ImageView) view.findViewById(R.id.header_schedule_item);

        if(item.getSessionType().equals("free")){
            imageViewScheduleItemHeader.setImageDrawable(context.getResources().getDrawable(R.drawable.free_schedule_item_header));

        } else if (item.getSessionType().equals("keynote") || item.getSessionType().equals("web_cloud")){
            imageViewScheduleItemHeader.setImageDrawable(context.getResources().getDrawable(R.drawable.web_cloud_schedule_item_header));

        } else if (item.getSessionType().equals("mobile")){
            imageViewScheduleItemHeader.setImageDrawable(context.getResources().getDrawable(R.drawable.mobile_schedule_item_header));
        }

        textViewStartTimeHours = (TextView) view.findViewById(R.id.start_time_hours);
        textViewStartTimeMinutes = (TextView) view.findViewById(R.id.start_time_minutes);
        textViewEndTimeHours = (TextView) view.findViewById(R.id.end_time_hours);
        textViewEndTimeMinutes = (TextView) view.findViewById(R.id.end_time_minutes);
        textViewSlotTitle = (TextView) view.findViewById(R.id.slot_title);

        textViewSlotTitle.setText(item.getDescription());
        textViewStartTimeHours.setText(startTimeHours);
        textViewStartTimeMinutes.setText(startTimeMinutes);
        textViewEndTimeHours.setText(endTimeHours);
        textViewEndTimeMinutes.setText(endTimeMinutes);

        return view;
    }
}
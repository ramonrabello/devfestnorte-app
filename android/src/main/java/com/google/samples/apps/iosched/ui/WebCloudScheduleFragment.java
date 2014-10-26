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

package com.google.samples.apps.iosched.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.samples.apps.iosched.R;
import com.google.samples.apps.iosched.model.BaseScheduleItem;
import com.google.samples.apps.iosched.model.SpeakerScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class WebCloudScheduleFragment extends BaseScheduleFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected List<BaseScheduleItem> createScheduleItems(){

        List<BaseScheduleItem> items = new ArrayList<BaseScheduleItem>();

        // Credenciamento
        BaseScheduleItem scheduleItem = new BaseScheduleItem();
        scheduleItem.setDescription("Credenciamento");
        scheduleItem.setStart("08:00");
        scheduleItem.setEnd("09:00");
        scheduleItem.setEnd("09:00");
        scheduleItem.setSessionType("free");
        items.add(scheduleItem);

        // Vinicius Gracia (EasyTaxi)
        SpeakerScheduleItem speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("O desafio do desenvolvimento do app nos 33 países");
        speakerScheduleItem.setSpeakerName("Vinícius Gracia");
        speakerScheduleItem.setSpeakerCcompany("Easy Taxi");
        speakerScheduleItem.setStart("09:00");
        speakerScheduleItem.setEnd("10:00");
        speakerScheduleItem.setSessionType("keynote");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_vini);
        items.add(speakerScheduleItem);

        // Café
        scheduleItem = new BaseScheduleItem();
        scheduleItem.setDescription("Café");
        scheduleItem.setStart("10:00");
        scheduleItem.setEnd("10:30");
        scheduleItem.setSessionType("free");
        items.add(scheduleItem);

        // Evaldo Barbosa (PHP Maranhão)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Angular JS: aspectos práticos visando a rapidez");
        speakerScheduleItem.setSpeakerName("Evaldo Barbosa");
        speakerScheduleItem.setSpeakerCcompany("PHP Maranhão");
        speakerScheduleItem.setStart("10:30");
        speakerScheduleItem.setEnd("11:30");
        speakerScheduleItem.setSessionType("web_cloud");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_evaldo);
        items.add(speakerScheduleItem);

        // Hiarison Gigante (PHP Maranhão)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Conhecendo Go");
        speakerScheduleItem.setSpeakerName("Hiarison Gigante");
        speakerScheduleItem.setSpeakerCcompany("PHP Maranhão");
        speakerScheduleItem.setStart("11:30");
        speakerScheduleItem.setEnd("12:30");
        speakerScheduleItem.setSessionType("web_cloud");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_gigante);
        items.add(speakerScheduleItem);

        // Almoço
        scheduleItem = new BaseScheduleItem();
        scheduleItem.setDescription("Almoço");
        scheduleItem.setStart("12:30");
        scheduleItem.setEnd("13:30");
        scheduleItem.setSessionType("free");
        items.add(scheduleItem);

        // Felipe Iketani (Gistia)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Desenvolvimento Orientado a Testes com AngularJS");
        speakerScheduleItem.setSpeakerName("Felipe Iketani");
        speakerScheduleItem.setSpeakerCcompany("Gistia");
        speakerScheduleItem.setStart("13:30");
        speakerScheduleItem.setEnd("14:30");
        speakerScheduleItem.setSessionType("web_cloud");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_ike);
        items.add(speakerScheduleItem);

        // Aldrin Leal (Ingenieux Labs)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Go para Microserviços");
        speakerScheduleItem.setSpeakerName("Aldrin Leal");
        speakerScheduleItem.setSpeakerCcompany("Ingenieux Labs");
        speakerScheduleItem.setStart("14:30");
        speakerScheduleItem.setEnd("15:30");
        speakerScheduleItem.setSessionType("web_cloud");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_aldrin);
        items.add(speakerScheduleItem);

        // Café (Tarde)
        scheduleItem = new BaseScheduleItem();
        scheduleItem.setDescription("Café");
        scheduleItem.setStart("15:30");
        scheduleItem.setEnd("16:00");
        scheduleItem.setSessionType("free");
        items.add(scheduleItem);

        // Paulo Moura (Tá Safo)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("WebRTC: transmissão de áudio e vídeo real-time com HTML5");
        speakerScheduleItem.setSpeakerName("Paulo Moura");
        speakerScheduleItem.setSpeakerCcompany("Tá Safo");
        speakerScheduleItem.setStart("16:00");
        speakerScheduleItem.setEnd("17:30");
        speakerScheduleItem.setSessionType("web_cloud");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_paulomoura);
        items.add(speakerScheduleItem);

        // Ale Borba (Google)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Um overview sobre as novidades e tudo o que o Google tem para desenvolvedores.");
        speakerScheduleItem.setSpeakerName("Ale Borba");
        speakerScheduleItem.setSpeakerCcompany("Google");
        speakerScheduleItem.setStart("17:00");
        speakerScheduleItem.setEnd("18:00");
        speakerScheduleItem.setSessionType("keynote");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_aleborba);
        items.add(speakerScheduleItem);
        return items;
    }
}

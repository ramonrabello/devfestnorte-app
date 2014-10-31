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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.devfest.norte.R;
import br.com.devfest.norte.model.BaseScheduleItem;
import br.com.devfest.norte.model.SpeakerScheduleItem;

public class MobileScheduleFragment extends BaseScheduleFragment {

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

        // Ramon Rabello (Tá Safo)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("O caminho de um desenvolvedor Android");
        speakerScheduleItem.setSpeakerName("Ramon Rabello");
        speakerScheduleItem.setSpeakerCcompany("Tá Safo");
        speakerScheduleItem.setStart("10:30");
        speakerScheduleItem.setEnd("11:30");
        speakerScheduleItem.setSessionType("mobile");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_ramon);
        items.add(speakerScheduleItem);

        // Lucas Mousinho (Jambu Tecnologia)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Desenvolvimento de Jogos para Android");
        speakerScheduleItem.setSpeakerName("Lucas Mousinho");
        speakerScheduleItem.setSpeakerCcompany("Jambu Tecnologia");
        speakerScheduleItem.setStart("11:30");
        speakerScheduleItem.setEnd("12:30");
        speakerScheduleItem.setSessionType("mobile");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_lucas);
        items.add(speakerScheduleItem);

        // Almoço
        scheduleItem = new BaseScheduleItem();
        scheduleItem.setDescription("Almoço");
        scheduleItem.setStart("12:30");
        scheduleItem.setEnd("13:30");
        scheduleItem.setSessionType("free");
        items.add(scheduleItem);

        // Santhyago Gallão (Samsung)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Animando a UI: entregue uma experiência, não apenas um aplicativo");
        speakerScheduleItem.setSpeakerName("Santhyago Gallão");
        speakerScheduleItem.setSpeakerCcompany("Samsung");
        speakerScheduleItem.setStart("13:30");
        speakerScheduleItem.setEnd("14:30");
        speakerScheduleItem.setSessionType("mobile");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_1santiago);
        items.add(speakerScheduleItem);

        // Gabriel Castro (UNA-SUS/UFMA)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Ionic Framework: aplicações móveis híbridas com HTML5 e Angular JS");
        speakerScheduleItem.setSpeakerName("Gabriel Castro");
        speakerScheduleItem.setSpeakerCcompany("UNA-SUS/UFMA");
        speakerScheduleItem.setStart("14:30");
        speakerScheduleItem.setEnd("15:30");
        speakerScheduleItem.setSessionType("mobile");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_1gabrielcastro);
        items.add(speakerScheduleItem);

        // Café (Tarde)
        scheduleItem = new BaseScheduleItem();
        scheduleItem.setDescription("Café");
        scheduleItem.setStart("15:30");
        scheduleItem.setEnd("16:00");
        scheduleItem.setSessionType("free");
        items.add(scheduleItem);

        // Bryan Ollivie (Tá Safo)
        speakerScheduleItem = new SpeakerScheduleItem();
        speakerScheduleItem.setDescription("Android L: conheça as novidades e tendências.");
        speakerScheduleItem.setSpeakerName("Bryan Ollivie");
        speakerScheduleItem.setSpeakerCcompany("Tá Safo");
        speakerScheduleItem.setStart("16:00");
        speakerScheduleItem.setEnd("17:00");
        speakerScheduleItem.setSessionType("mobile");
        speakerScheduleItem.setSpeakerPlusProfileImage(R.drawable.rsz_bryan);
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

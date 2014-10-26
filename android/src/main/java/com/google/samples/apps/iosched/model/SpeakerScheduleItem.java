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
package com.google.samples.apps.iosched.model;

public class SpeakerScheduleItem extends BaseScheduleItem {

    private String speakerName;
    private String speakerCcompany;
    private int speakerPlusProfileImage;

    public int getSpeakerPlusProfileImage() {
        return speakerPlusProfileImage;
    }

    public void setSpeakerPlusProfileImage(int speakerPlusProfileImage) {
        this.speakerPlusProfileImage = speakerPlusProfileImage;
    }

    public String getSpeakerCcompany() {
        return speakerCcompany;
    }

    public void setSpeakerCcompany(String speakerCcompany) {
        this.speakerCcompany = speakerCcompany;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}

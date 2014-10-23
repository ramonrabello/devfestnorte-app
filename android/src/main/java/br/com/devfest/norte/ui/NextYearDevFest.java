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
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import br.com.devfest.norte.R;

/**
 * Activity for customizing app settings.
 */
public class NextYearDevFest extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
	    setContentView(R.layout.activity_next_year_devfest);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

	private void submitVote(String outcome) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("https://docs.google.com/forms/d/1CaWxF1hM0VZTn2d1iMPWGSKdNRUfH7_X38bFMQpoXiI/formResponse");

		String vote = "Manaus - AM";
		List<BasicNameValuePair> results = new ArrayList<BasicNameValuePair>();
		results.add(new BasicNameValuePair("entry.1558182261", vote));

		try {
			post.setEntity(new UrlEncodedFormEntity(results));
		} catch (UnsupportedEncodingException e) {
			// Auto-generated catch block
			Log.e("YOUR_TAG", "An error has occurred", e);
		}
		try {
			HttpResponse httpResponse = client.execute(post);
			Log.e("RESPONSE", "info: " + httpResponse);

			BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String line;
			while ((line = rd.readLine()) != null) {
				Log.i("words", line);
			}

			/*Intent intent = new Intent(this, ReadingView.class);
			intent.putExtra("html", line);
			startActivity(intent);*/
		} catch (ClientProtocolException e) {
			// Auto-generated catch block
			Log.e("YOUR_TAG", "client protocol exception", e);
		} catch (IOException e) {
			// Auto-generated catch block
			Log.e("YOUR_TAG", "io exception", e);
		}
	}

}

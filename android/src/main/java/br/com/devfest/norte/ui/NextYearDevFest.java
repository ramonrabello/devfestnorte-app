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

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import br.com.devfest.norte.R;

/**
 * Activity for customizing app settings.
 */
public class NextYearDevFest extends BaseActivity {
	private static final String THE_DAY = "01/11/2014"; // (DD/MM/YYYY)
	ImageView IV_Manaus, IV_SaoLuis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

	    if (todayIsTheDay()) {
		    setContentView(R.layout.activity_next_year_devfest);

		    IV_Manaus = (ImageView) findViewById(R.id.IV_Manaus);
		    IV_Manaus.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View view) {
				    new SubmitPoll().execute("Manaus - AM");
				    setImageViewAlpha();
			    }
		    });

		    IV_SaoLuis = (ImageView) findViewById(R.id.IV_SaoLuis);
		    IV_SaoLuis.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View view) {
				    new SubmitPoll().execute("São Luis - MA");
				    setImageViewAlpha();
			    }
		    });
	    } else {
		    setContentView(R.layout.activity_next_year_devfest_otherday);
	    }
    }

	private void setImageViewAlpha() {
		IV_Manaus.animate().alpha(0.4f).setDuration(200);
		IV_SaoLuis.animate().alpha(0.4f).setDuration(200);
	}

	private boolean todayIsTheDay() {
		Calendar today = Calendar.getInstance(TimeZone.getTimeZone("GMT-2"));
		int today_d = today.get(Calendar.DAY_OF_MONTH);
		int today_m = (today.get(Calendar.MONTH) + 1);
		int today_y = today.get(Calendar.YEAR);
		int today_h = today.get(Calendar.HOUR_OF_DAY);

		if ((today_d + "/" + today_m + "/" + today_y).equals(THE_DAY)) {
			if (today_h > 8 && today_h < 19) {
				return true;
			}
		}
		return false;
	}

	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

	private class SubmitPoll extends AsyncTask<String, Void, Boolean> {
		String strPostURL = "https://docs.google.com/forms/d/1SDfTi2_Q4I4XmdTmO9zUyv6QRQZIO9KJ78aZBKT-NmM/formResponse";

		HttpClient client = new DefaultHttpClient();
		HttpPost post     = new HttpPost(strPostURL);

		String vote;

		Boolean Erro = true;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(String... strings) {
			vote = strings[0];
			List<BasicNameValuePair> results = new ArrayList<BasicNameValuePair>();
			results.add(new BasicNameValuePair("entry.189362962", vote));

			try {
				post.setEntity(new UrlEncodedFormEntity(results, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// Auto-generated catch block
				Log.e("DevFestPoll", "An error has occurred", e);
			}
			try {
				HttpResponse httpResponse = client.execute(post);
			} catch (ClientProtocolException e) {
				// Auto-generated catch block
				Log.e("DevFestPoll", "client protocol exception", e);
			} catch (IOException e) {
				// Auto-generated catch block
				Log.e("DevFestPoll", "io exception", e);
			}

			return Erro;
		}

		@Override
		protected void onPostExecute(Boolean aBoolean) {
			super.onPostExecute(aBoolean);
			Toast.makeText(NextYearDevFest.this, "Seu voto em " + vote + ", foi registrado com sucesso!", Toast.LENGTH_LONG).show();
		}
	}
}

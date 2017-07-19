package aleisamo.github.com.gceapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.amage.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class FetchJoke extends AsyncTask<Void, Void, String> {

    private final Context context;
    private final FetchJokeListener mFetchJokeListener;

    private MyApi myApiService;

    public FetchJoke(Context context, FetchJokeListener mFetchJokeListener) {
        this.context = context;
        this.mFetchJokeListener = mFetchJokeListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(context.getString(R.string.httpIp))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "Failed to tell joke", e);
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        mFetchJokeListener.onJoke(s);
    }
}


package aleisamo.github.com.gceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import aleisamo.github.com.mylibrary.LibActivity;

import static aleisamo.github.com.mylibrary.LibActivity.JOKE;

public class MainActivity extends AppCompatActivity implements FetchJokeListener {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void clickJoke(View view) {
        new FetchJoke(this, this).execute();
        spinner.setVisibility(View.VISIBLE);
    }

    // implement interface to test AsyncTask

    @Override
    public void onJoke(String joke) {
        spinner.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, LibActivity.class);
        intent.putExtra(JOKE, joke);
        startActivity(intent);
    }
}

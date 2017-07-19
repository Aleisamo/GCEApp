package aleisamo.github.com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_activity);

        String joke = getIntent().getStringExtra(JOKE);
        TextView displayJoke = (TextView) findViewById(R.id.displayjoke);
        displayJoke.setText(joke);
    }
}

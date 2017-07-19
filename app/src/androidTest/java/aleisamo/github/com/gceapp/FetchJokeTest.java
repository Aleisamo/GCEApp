package aleisamo.github.com.gceapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class FetchJokeTest implements FetchJokeListener {

    private FetchJoke fetchJoke;

    private String joke;
    private CountDownLatch signal;

    @Before
    public void setUp() throws Exception {
        signal = new CountDownLatch(1);
        fetchJoke = new FetchJoke(InstrumentationRegistry.getTargetContext(), this);
    }

    @Test
    public void checkAsync() throws Exception {
        fetchJoke.execute();
        signal.await(5, TimeUnit.SECONDS);

        assertFalse(joke == null);
        assertFalse(joke.isEmpty());
        System.out.println("####################" + joke);
    }

    @Override
    public void onJoke(String joke) {
        signal.countDown();
        this.joke = joke;
    }
}

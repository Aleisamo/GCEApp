package com.example.amage.myapplication.backend;

import com.example.JavaJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.amage.example.com",
                ownerName = "backend.myapplication.amage.example.com"
        )
)
public class MyEndpoint {

    private final JavaJoke javaJoke = new JavaJoke();

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        response.setData(javaJoke.tellJoke());
        return response;
    }
}

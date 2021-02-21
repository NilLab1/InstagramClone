package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Luvzmxj6qDxN614Vl3M9C2LG3zi3TSMgmV1GaOwZ")
                .clientKey("tpWYHY74UCFDVF8ZdQIGJdkp494JWH7PQPbMOhvo")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

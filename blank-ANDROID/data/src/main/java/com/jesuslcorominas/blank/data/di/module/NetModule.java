package com.jesuslcorominas.blank.data.di.module;

import com.google.gson.Gson;
import com.jesuslcorominas.blank.data.net.interceptor.AddCookiesInterceptor;
import com.jesuslcorominas.blank.data.net.interceptor.AddHeaderInterceptor;
import com.jesuslcorominas.blank.data.net.interceptor.NetInterceptor;
import com.jesuslcorominas.blank.data.net.interceptor.ReceivedCookiesInterceptor;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {GsonModule.class, MapperModule.class})
public class NetModule {

    private static final int READ_TIMEOUT = 10;
    private static final int CONNECT_TIMEOUT = 3;

    private static NetModule instance;

    private String endPoint;

    private NetModule(String endPoint) {
        this.endPoint = endPoint;
    }

    public static NetModule getInstance(String endPoint) {
        if (instance == null) {
            instance = new NetModule(endPoint);
        }

        return instance;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    @Provides
    ReceivedCookiesInterceptor provideReceivedCookiesInterceptor(PreferencesHelper preferencesHelper) {
        return new ReceivedCookiesInterceptor(preferencesHelper);
    }

    @Provides
    AddCookiesInterceptor provideAddCookiesInterceptor(PreferencesHelper preferencesHelper) {
        return new AddCookiesInterceptor(preferencesHelper);
    }

    @Provides
    NetInterceptor provideNetInterceptor() {
        return new NetInterceptor();
    }

    @Provides
    AddHeaderInterceptor provideAddHeaderTokenInterceptor(PreferencesHelper preferencesHelper) {
        return new AddHeaderInterceptor(preferencesHelper);
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor,
                                     ReceivedCookiesInterceptor receivedCookiesInterceptor,
                                     AddCookiesInterceptor addCookiesInterceptor,
                                     NetInterceptor netInterceptor,
                                     AddHeaderInterceptor addHeaderInterceptor) {
        return new OkHttpClient.Builder().
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).
                addInterceptor(receivedCookiesInterceptor).
                addInterceptor(addCookiesInterceptor).
                addInterceptor(loggingInterceptor).
                addInterceptor(netInterceptor).
                addInterceptor(addHeaderInterceptor).
                build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }

}

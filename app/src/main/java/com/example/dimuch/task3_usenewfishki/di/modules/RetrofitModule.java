package com.example.dimuch.task3_usenewfishki.di.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Dimuch on 02.10.2017.
 */
@Module public class RetrofitModule {

  //@Provides Retrofit provideRetrofit() {
  //  return new Retrofit.Builder()
  //      .baseUrl(Constants.WEATHER_BASE_URL) //Базовая часть адреса
  //      .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
  //      .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
  //      .build();
  //}
}

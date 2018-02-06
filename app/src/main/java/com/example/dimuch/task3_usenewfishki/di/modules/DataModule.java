package com.example.dimuch.task3_usenewfishki.di.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Dimuch on 02.10.2017.
 */
@Module (includes = { RetrofitModule.class }) public class DataModule {

  //@Provides WeatherApi provideWeatherApi(Retrofit retrofit) {
  //  return retrofit.create(WeatherApi.class);
  //}

  //@Provides RestApi provideRestApi(WeatherApi weatherApi) {
  //  return new RestApi(weatherApi);
  //}

  //@Provides DataManager provideDataManager(RestApi restApi) {
  //  return new DataManager(restApi);
  //}

  @Provides String provideTestMessage() {
    return new String("test message");
  }
}

package com.appkolik.tarihtebugun.di

import com.appkolik.tarihtebugun.data.remote.Api
import com.appkolik.tarihtebugun.data.repository.TodayHistoryRepositoryImpl
import com.appkolik.tarihtebugun.domain.repository.TodayHistoryRepository
import com.appkolik.tarihtebugun.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            /*.client(OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build())*/
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideTodayHistory(api: Api): TodayHistoryRepository {
        return TodayHistoryRepositoryImpl(api)
    }


}
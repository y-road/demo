package com.song.app.demointro2.di.module

import com.song.app.demointro2.BuildConfig
import com.song.app.demointro2.data.network.TokenAPIService
import com.song.app.demointro2.data.url.Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Gson
    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    // OkHttp
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY // 요청 및 응답 본문까지 모두 로깅
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE // 로깅 비활성화
        }
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    // Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(Url.API_SERVER_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()

    // TokenAPIService
    @Singleton
    @Provides
    fun provideTokenAPIService(retrofit: Retrofit): TokenAPIService =
        retrofit.create(TokenAPIService::class.java)

}

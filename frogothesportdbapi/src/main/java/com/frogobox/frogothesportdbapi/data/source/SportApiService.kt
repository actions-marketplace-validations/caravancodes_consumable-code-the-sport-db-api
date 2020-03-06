package com.frogobox.frogothesportdbapi.data.source

import android.content.Context
import com.frogobox.frogothesportdbapi.BuildConfig
import com.frogobox.frogothesportdbapi.data.response.Events
import com.frogobox.frogothesportdbapi.data.response.Players
import com.frogobox.frogothesportdbapi.data.response.Teams
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * TheSportDBApi
 * Copyright (C) 26/01/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogothesportdbapi.source
 *
 */

interface SportApiService {

    // Search for team by name
    @GET(BuildConfig.SPORTDB_URL_SEARCH_FOR_TEAM)
    fun searchForTeamByName(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_TEAM_NAME) teamName: String
    ): Observable<Teams>

    // Search for team short code
    @GET(BuildConfig.SPORTDB_URL_SEARCH_FOR_TEAM)
    fun searchForTeamByShortCode(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_SHORT_CODE_NAME) shortCode: String
    ): Observable<Teams>

    // Search for all players from team *Patreon ONLY*
    @GET(BuildConfig.SPORTDB_URL_PATREON_SEARCH_FOR_ALL_PLAYERS_FROM_TEAMS)
    fun searchForAllPlayer(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_TEAM_NAME) teamName: String
    ): Observable<Players>

    // Search for players by player name
    @GET(BuildConfig.SPORTDB_URL_PATREON_SEARCH_FOR_ALL_PLAYERS_FROM_TEAMS)
    fun searchForPlayer(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_PLAYER_NAME) playerName: String
    ): Observable<Players>

    // Search for players by player name and team name
    @GET(BuildConfig.SPORTDB_URL_PATREON_SEARCH_FOR_ALL_PLAYERS_FROM_TEAMS)
    fun searchForPlayer(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_PLAYER_NAME) playerName: String,
        @Query(BuildConfig.QUERY_TEAM_NAME) teamName: String
    ): Observable<Players>

    // Search for event by event name
    @GET(BuildConfig.SPORTDB_URL_SEARCH_FOR_EVENT)
    fun searchForEvent(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_EVENT_NAME) eventName: String
    ): Observable<Events>

    // Search For event by event name and season
    @GET(BuildConfig.SPORTDB_URL_SEARCH_FOR_EVENT)
    fun searchForEvent(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_EVENT_NAME) eventName: String,
        @Query(BuildConfig.QUERY_SEASON) season: String
    ): Observable<Events>

    // Search for event by event file name
    @GET(BuildConfig.SPORTDB_URL_SEARCH_FOR_EVENT_FILE_NAME)
    fun searchForEventFileName(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_EVENT_NAME) eventFileName: String
    ): Observable<Events>

    // List all Teams in a League
    @GET(BuildConfig.SPORTDB_URL_SEARCH_ALL_TEAMS)
    fun searchAllTeamByLeague(
        @Path(BuildConfig.PATH_API_KEY) apiKey: String,
        @Query(BuildConfig.QUERY_LEAGUE_NAME) league: String
    ): Observable<Teams>

    companion object Factory {

        var isUsingChuckInterceptor = false
        lateinit var context: Context

        fun usingChuckInterceptor(context: Context){
            isUsingChuckInterceptor = true
            this.context = context
        }

        val getApiService: SportApiService by lazy {
            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = if (isUsingChuckInterceptor) {
                OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .addInterceptor(ChuckInterceptor(context))
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            }

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.SPORTDB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build()

            mRetrofit.create(SportApiService::class.java)
        }
    }

}
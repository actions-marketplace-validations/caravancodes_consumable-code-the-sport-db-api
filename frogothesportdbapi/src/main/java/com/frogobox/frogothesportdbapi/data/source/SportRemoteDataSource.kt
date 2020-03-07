package com.frogobox.frogothesportdbapi.data.source

import android.content.Context
import com.frogobox.frogothesportdbapi.data.response.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


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
object SportRemoteDataSource :
    SportDataSource {

    private val sportApiService = SportApiService

    override fun usingChuckInterceptor(context: Context) {
        sportApiService.usingChuckInterceptor(context)
    }

    override fun searchForTeamByName(
        apiKey: String,
        teamName: String,
        callback: SportDataSource.GetRemoteCallback<Teams>
    ) {
        sportApiService.getApiService
            .searchForTeamByName(apiKey, teamName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Teams>() {
                override fun onSuccess(model: Teams) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForTeamByShortCode(
        apiKey: String,
        shortCode: String,
        callback: SportDataSource.GetRemoteCallback<Teams>
    ) {
        sportApiService.getApiService
            .searchForTeamByShortCode(apiKey, shortCode)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Teams>() {
                override fun onSuccess(model: Teams) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForAllPlayer(
        apiKey: String,
        teamName: String,
        callback: SportDataSource.GetRemoteCallback<Players>
    ) {
        sportApiService.getApiService
            .searchForAllPlayer(apiKey, teamName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Players>() {
                override fun onSuccess(model: Players) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForPlayer(
        apiKey: String,
        playerName: String,
        callback: SportDataSource.GetRemoteCallback<Players>
    ) {
        sportApiService.getApiService
            .searchForPlayer(apiKey, playerName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Players>() {
                override fun onSuccess(model: Players) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForPlayer(
        apiKey: String,
        playerName: String,
        teamName: String,
        callback: SportDataSource.GetRemoteCallback<Players>
    ) {
        sportApiService.getApiService
            .searchForPlayer(apiKey, playerName, teamName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Players>() {
                override fun onSuccess(model: Players) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForEvent(
        apiKey: String,
        eventName: String,
        callback: SportDataSource.GetRemoteCallback<Events>
    ) {
        sportApiService.getApiService
            .searchForEvent(apiKey, eventName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Events>() {
                override fun onSuccess(model: Events) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForEvent(
        apiKey: String,
        eventName: String,
        season: String,
        callback: SportDataSource.GetRemoteCallback<Events>
    ) {
        sportApiService.getApiService
            .searchForEvent(apiKey, eventName, season)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Events>() {
                override fun onSuccess(model: Events) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchForEventFileName(
        apiKey: String,
        eventFileName: String,
        callback: SportDataSource.GetRemoteCallback<Events>
    ) {
        sportApiService.getApiService
            .searchForEventFileName(apiKey, eventFileName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Events>() {
                override fun onSuccess(model: Events) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun getAllSports(apiKey: String, callback: SportDataSource.GetRemoteCallback<Sports>) {
        sportApiService.getApiService.getAllSports(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Sports>() {
                override fun onSuccess(model: Sports) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun getAllLeagues(
        apiKey: String,
        callback: SportDataSource.GetRemoteCallback<Leagues>
    ) {
        sportApiService.getApiService.getAllLeagues(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Leagues>() {
                override fun onSuccess(model: Leagues) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchAllLeagues(
        apiKey: String,
        countryName: String,
        callback: SportDataSource.GetRemoteCallback<Countrys>
    ) {
        sportApiService.getApiService.searchAllLeagues(apiKey, countryName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Countrys>() {
                override fun onSuccess(model: Countrys) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchAllLeagues(
        apiKey: String,
        countryName: String,
        sportName: String,
        callback: SportDataSource.GetRemoteCallback<Countrys>
    ) {
        sportApiService.getApiService.searchAllLeagues(apiKey, countryName, sportName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Countrys>() {
                override fun onSuccess(model: Countrys) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchAllSeasons(
        apiKey: String,
        idTeam: String,
        callback: SportDataSource.GetRemoteCallback<Seasons>
    ) {
        sportApiService.getApiService.searchAllSeasons(apiKey, idTeam)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Seasons>() {
                override fun onSuccess(model: Seasons) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchAllTeam(
        apiKey: String,
        league: String,
        callback: SportDataSource.GetRemoteCallback<Teams>
    ) {
        sportApiService.getApiService
            .searchAllTeam(apiKey, league)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Teams>() {
                override fun onSuccess(model: Teams) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchAllTeam(
        apiKey: String,
        sportName: String,
        countryName: String,
        callback: SportDataSource.GetRemoteCallback<Teams>
    ) {
        sportApiService.getApiService
            .searchAllTeam(apiKey, sportName, countryName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Teams>() {
                override fun onSuccess(model: Teams) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun lookupAllTeam(
        apiKey: String,
        idLeague: String,
        callback: SportDataSource.GetRemoteCallback<Teams>
    ) {
        sportApiService.getApiService
            .lookupAllTeam(apiKey, idLeague)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Teams>() {
                override fun onSuccess(model: Teams) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun lookupAllPlayer(
        apiKey: String,
        idTeam: String,
        callback: SportDataSource.GetRemoteCallback<Players>
    ) {
        sportApiService.getApiService
            .lookupAllPlayer(apiKey, idTeam)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Players>() {
                override fun onSuccess(model: Players) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun searchLoves(
        apiKey: String,
        userName: String,
        callback: SportDataSource.GetRemoteCallback<Users>
    ) {
        sportApiService.getApiService
            .searchLoves(apiKey, userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SportApiCallback<Users>() {
                override fun onSuccess(model: Users) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }
}
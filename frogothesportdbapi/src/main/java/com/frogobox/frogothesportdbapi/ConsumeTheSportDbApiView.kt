package com.frogobox.frogothesportdbapi

import android.content.Context
import com.frogobox.frogothesportdbapi.callback.SportResultCallback
import com.frogobox.frogothesportdbapi.data.response.*

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * TheSportDBApi
 * Copyright (C) 04/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogothesportdbapi.util
 *
 */
interface ConsumeTheSportDbApiView {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search for team by name
    fun searchForTeamByName(teamName: String, sportResultCallback: SportResultCallback<Teams>)

    // Search for team short code
    fun searchForTeamByShortCode(shortCode: String, sportResultCallback: SportResultCallback<Teams>)

    // Search for all players from team *Patreon ONLY*
    fun searchForAllPlayer(teamName: String, sportResultCallback: SportResultCallback<Players>)

    // Search for players by player name
    fun searchForPlayer(playerName: String, sportResultCallback: SportResultCallback<Players>)

    // Search for players by player name and team name
    fun searchForPlayer(playerName: String, teamName: String, sportResultCallback: SportResultCallback<Players>)

    // Search for event by event name
    fun searchForEvent(eventName: String, sportResultCallback: SportResultCallback<Events>)

    // Search For event by event name and season
    fun searchForEvent(eventName: String, season: String, sportResultCallback: SportResultCallback<Events>)

    // Search for event by event file name
    fun searchForEventFileName(eventFileName: String, sportResultCallback: SportResultCallback<Events>)

    // List all sports
    fun getAllSports(sportResultCallback: SportResultCallback<Sports>)

    // List all leagues
    fun getAllLeagues(sportResultCallback: SportResultCallback<Leagues>)

    // List all Leagues in a country
    fun searchAllLeagues(countryName: String, sportResultCallback: SportResultCallback<Countrys>)

    // List all Leagues in a country specific by sport
    fun searchAllLeagues(countryName: String, sportName: String, sportResultCallback: SportResultCallback<Countrys>)

    // List all Seasons in a League
    fun searchAllSeasons(idTeam: String, sportResultCallback: SportResultCallback<Seasons>)

    // List all Teams in a League
    fun searchAllTeam(league: String, sportResultCallback: SportResultCallback<Teams>)

    // List all Teams in Sportname & Country Name
    fun searchAllTeam(sportName: String, countryName: String, sportResultCallback: SportResultCallback<Teams>)

    // List All teams details in a league by Id
    fun lookupAllTeam(idLeague: String, sportResultCallback: SportResultCallback<Teams>)

    // List All players in a team by Team Id *Patreon ONLY*
    fun lookupAllPlayer(idTeam: String, sportResultCallback: SportResultCallback<Players>)

    // List all users loved teams and players
    fun searchLoves(userName: String, sportResultCallback: SportResultCallback<Users>)

}
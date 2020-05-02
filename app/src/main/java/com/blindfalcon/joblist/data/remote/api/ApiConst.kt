package com.blindfalcon.joblist.data.remote.api

const val API_KEY = ""
const val API_ENDPOINT = "https://api.superjob.ru/2.27/vacancies/"

const val APP_ID_HEADER = "X-Api-App-Id"

const val GET_VACANCY_LIST = "?t=4"
const val GET_VACANCY = "{id_vacancy}"

const val KEYWORD = "keyword"
const val ID_VACANCY = "id_vacancy"

//Vacancy
const val OBJECTS = "objects"
const val TOTAL = "total"
const val MORE = "more"
const val ID = "id"
const val ID_CLIENT = "id_client"
const val PROFESSION = "profession"
const val METRO = "metro"
const val DATE_PUBLISHED = "date_published"
const val WORK = "work"
const val COMPENSATION = "compensation"
const val CANDIDAT = "candidat"
const val CLIENT = "client"
const val PAYMENT_FROM = "payment_from"
const val PAYMENT_TO = "payment_to"

//Metro
const val TITLE = "title"
const val ID_METRO_LINE = "id_metro_line"

//Client
const val CLIENT_ID = "clientId"
const val CLIENT_TITLE = "clientTitle"
const val CLIENT_LOGO = "client_logo"

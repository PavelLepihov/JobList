package com.blindfalcon.joblist.data.remote.api

const val API_KEY = "v3.r.130939476.ad8bfdf2da356192056233a3bc847db15cffe884.35b4f9d522c3ba3d2fa75b1e556a57f1cbb67bb5"
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
const val METRO_ID = "id"
const val METRO_TITLE = "title"
const val ID_METRO_LINE = "id_metro_line"

//Client
const val CLIENT_ID = "id"
const val CLIENT_TITLE = "title"
const val CLIENT_LOGO = "client_logo"

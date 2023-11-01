package com.sceleton.featurelocalstorage

interface Dao {
    fun daoSecure(): LocaleDAOSecure
    fun daoEntry(): LocaleDaoEntry
}
package br.com.progdeelite.kmmprogdeelite.database

import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidApp.applicationContext, "common.db")
}
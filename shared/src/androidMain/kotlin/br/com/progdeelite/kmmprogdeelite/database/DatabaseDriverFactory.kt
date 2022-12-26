package br.com.progdeelite.kmmprogdeelite.database

import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidMainApp.applicationContext, "common.db")
}
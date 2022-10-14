package br.com.progdeelite.kmmprogdeelite.database

import br.com.progdeelite.utils.AndroidApplication
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidApplication.context, "common.db")
}
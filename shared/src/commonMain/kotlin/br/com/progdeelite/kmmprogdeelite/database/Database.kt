package br.com.progdeelite.kmmprogdeelite.database

import br.com.progdeelite.kmmprogdeelite.models.Story
import br.com.progdeelite.kmmprogdeelite.models.StoryMedia
import com.squareup.sqldelight.db.SqlDriver

class Database(driver: SqlDriver, clearDatabase: Boolean = false) {
    private val database = CommonDatabase(driver)
    private val dbQuery = database.appDatabaseQueries

    init {
        if (clearDatabase) {
            clearDatabase()
        }
    }

    fun clearDatabase() {
        dbQuery.transaction {
            // nome que especificamos no schema
            dbQuery.removeAllStory()
        }
    }

    fun getAllStories(): List<Story> {
        // nome que especificamos no schema
        return dbQuery.selectAllStories(::mapStories).executeAsList()
    }

    fun insertStories(stories: List<Story>) {
        if (stories.isNotEmpty()) {
            dbQuery.transaction {
                stories.forEach { dbQuery.insertStory(id = it.id, body = it.name) }
            }
        }
    }

    // Aprender a mapear caso o banco tenha nomes diferentes
    private fun mapStories(
        id: String,
        body: String
    ): Story {
        return Story(
            id = id,
            name = body,
            StoryMedia(
                name = "test",
                imgUrl = "uri",
                mimeType = "image/png"
            ),
            slides = emptyList()
        )
    }
}
package br.com.progdeelite.kmmprogdeelite.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.progdeelite.kmmprogdeelite.models.Story
import br.com.progdeelite.kmmprogdeelite.models.StoryMedia
import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var database: Database

    @Before
    fun prepareTest() {
        AndroidMainApp.applicationContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Database(createSqlDriver())
        database.clearDatabase()
    }

    @After
    fun cleanupTest() {
        database.clearDatabase()
    }

    @Test
    fun clearDatabase() {
        assertEquals(0, database.getAllStories().size)
    }

    @Test
    fun getAllStories() {
        val stories = listOf(
            createStory("1", "Story1"),
            createStory("2", "Story2"),
        )
        database.insertStories(stories)
        val source = database.getAllStories()
        assertEquals(2, source.size)
    }

    @Test
    fun insertStories() {
        val stories = listOf(
            createStory("1", "Story1"),
            createStory("2", "Story2"),
            createStory("3", "Story3"),
            createStory("4", "Story4"),
        )
        database.insertStories(stories)
        val source = database.getAllStories()
        assertEquals(4, source.size)
    }

    private fun createStory(
        id: String,
        name: String
    ): Story {
        return Story(
            id = id,
            name = name,
            storyMedia = StoryMedia(
                name = "Test",
                imgUrl = "none",
                mimeType = "image/jpg"
            ),
            slides = emptyList()
        )
    }
}
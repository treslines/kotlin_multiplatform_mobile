package br.com.progdeelite.kmmprogdeelite.viewmodels

import br.com.progdeelite.kmmprogdeelite.models.Story
import br.com.progdeelite.kmmprogdeelite.models.StoryMedia
import br.com.progdeelite.kmmprogdeelite.providers.DataSourceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/** Reference common view model implementation as a staring point */
class SampleViewModel : BaseSharedViewModel() {
    // Your business logic and states goes here...

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>>
        get() {
            return _stories
        }

    private val _error = MutableStateFlow<Boolean>(false)
    val error: StateFlow<Boolean>
        get() {
            return _error
        }

    private val dataSourceProvider = DataSourceProvider()

    fun loadStories() {
        scope.launch {
            kotlin.runCatching {
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.insertStories(mockStories())
                db.getAllStories()
            }.onSuccess {
                _stories.emit(it)
            }.onFailure {
                _error.emit(true)
            }
        }
    }

    fun clearStories(){
        scope.launch {
            kotlin.runCatching {
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.getAllStories()
            }.onSuccess {
                _stories.emit(it)
            }.onFailure {
                _error.emit(true)
            }
        }
    }

    private fun mockStories(): List<Story> {
        return listOf(
            createStory("1", "Story1"),
            createStory("2", "Story2"),
            createStory("2", "Story2")
        )
    }

    private fun createStory(id: String, name: String): Story {
        return Story(
            id = id,
            name = name,
            StoryMedia(
                name = "test",
                imgUrl = "uri",
                mimeType = "image/png"
            ),
            slides = emptyList()
        )
    }
}
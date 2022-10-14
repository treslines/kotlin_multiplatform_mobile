package br.com.progdeelite.kmmprogdeelite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Story(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("media")
    val storyMedia: StoryMedia,
    @SerialName("slides")
    val slides: List<Slide>
)

@Serializable
data class StoryMedia(
    @SerialName("name")
    val name: String,
    @SerialName("imgurl")
    val imgUrl: String,
    @SerialName("mimetype")
    val mimeType: String
)

@Serializable
data class Slide(
    @SerialName("id")
    val id: String,
)



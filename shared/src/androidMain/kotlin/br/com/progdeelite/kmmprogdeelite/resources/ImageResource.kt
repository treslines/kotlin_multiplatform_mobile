package br.com.progdeelite.kmmprogdeelite.resources

import android.annotation.SuppressLint
import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp

actual class ImageResource actual constructor(private val name: String) {

    private var _id: Int = -1 //only set by android preview
    val id: Int by lazy { getDrawableRes() }

    @SuppressLint("DiscouragedApi")
    private fun getDrawableRes(): Int {
        return if(_id == -1){
            with(AndroidApp.applicationContext) {
                resources.getIdentifier(name, "drawable", packageName)
            }
        } else return _id
    }

    /** internal cause only used in shared code by getPreviewImageResource bellow */
    internal fun setPreviewId(id: Int){
        _id = id
    }
}

/**
 * call this function whenever you need to preview views on android
 * @param id any R.drawable.your_id to be able to preview screens on android while developing
 */
fun getPreviewImageResource(id: Int): ImageResource {
    val preview = ImageResource("")
    preview.setPreviewId(id)
    return preview
}
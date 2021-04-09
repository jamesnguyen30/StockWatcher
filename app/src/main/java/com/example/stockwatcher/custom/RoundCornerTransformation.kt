package com.example.stockwatcher.custom

import android.graphics.*
import android.provider.SyncStateContract.Helpers.update
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest

class RoundCornerTransformation(var radius: Float): BitmapTransformation() {
    companion object{
        @JvmStatic
        val VERSION = 1;
        @JvmStatic
        val ID = "com.example.stockwatcher.custom.roundedcornertransformation${VERSION}"
        @JvmStatic
        val ID_BYTES = ID.toByteArray(Key.CHARSET)
        @JvmStatic
        val HASH_CODE = ID.hashCode()
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID_BYTES)
    }

    override fun equals(other: Any?): Boolean {
        return (other is RoundCornerTransformation) && (other.radius == radius)
    }

    override fun hashCode(): Int {
        return HASH_CODE
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {

        println(toTransform.toString())
        var width = toTransform.width
        var height = toTransform.height

        var bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888)

        bitmap.setHasAlpha(true)

        var canvas = Canvas(bitmap)
        var paint = Paint()
        paint.isAntiAlias = true
        paint.shader = BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        canvas.drawRoundRect(RectF(0f,0f,width.toFloat(), height.toFloat()), radius, radius, paint)

        return bitmap
    }
}
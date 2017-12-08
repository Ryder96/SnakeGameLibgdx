package it.dryconic.andres.utils

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import java.awt.geom.Point2D

class SpriteSheet(textureName: String?) {

    private val batch = SpriteBatch()
    private val texture = Texture(textureName)
    private val textureRegion = TextureRegion(texture)

    fun updateRegion(index : Int, row : Int, width : Int, height : Int) {
        textureRegion.setRegion(index,row,width,height)
    }

    fun render(point : Point2D.Float) {
        batch.begin()
        batch.draw(textureRegion,point.x,point.y)
        batch.end()
    }

    fun dispose() {
        texture.dispose()
        batch.dispose()
    }

}
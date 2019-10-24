package com.github.yuxiliu1995.wigner.poincare.functions.draw

import com.github.yuxiliu1995.wigner.poincare.util.ConfigProvider.config
import com.github.yuxiliu1995.wigner.{CanvasDim, Point}
import org.scalajs.dom

import scala.math.Pi

/** Contains functions used to update the canvas. */
object DrawFunctions {
  
  /** Radius of the large circle, in pixels. */
  private val largeRadius: Int = config.getInt("size.largeRadius")
  
  /** Colour of the large circle. */
  private val largeCircleColour: String = config.getString("colour.largeCircle")
  
  /** Draws a filled-in circle on the canvas.
    *
    * @param ctx    Rendering context for the canvas.
    * @param centre Position of the centre of the circle on the canvas.
    * @param radius Radius of the circle, in pixels.
    * @param colour Colour of the circle.
    */
  private def drawCircle(ctx: dom.CanvasRenderingContext2D, centre: Point, radius: Int, colour: String): Unit = {
    ctx.fillStyle = colour
    
    ctx.beginPath()
    ctx.arc(centre.x, centre.y, radius, 0, 2 * Pi)
    ctx.fill()
  }
  
  /** Draws a large circle, centred on the canvas centroid.
    *
    * @param ctx       Rendering context for the canvas.
    * @param canvasDim Canvas dimensions.
    */
  def draw(ctx: dom.CanvasRenderingContext2D, canvasDim: CanvasDim): Unit = {
    drawCircle(ctx, canvasDim.centroid, largeRadius, largeCircleColour)
  }
}

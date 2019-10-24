package com.github.yuxiliu1995.wigner.poincare.functions.draw

import com.github.yuxiliu1995.wigner.poincare.JsExport.{getLargeCentre, largeRadius, smallRadius}
import com.github.yuxiliu1995.wigner.poincare.util.ConfigProvider.config
import com.github.yuxiliu1995.wigner.{CanvasDim, Point}
import org.scalajs.dom

import scala.math.Pi

/** Contains functions used to update the canvas. */
object DrawFunctions {
  
  /** Colour of the large circle. */
  private val largeCircleColour: String = config.getString("colour.largeCircle")
  
  /** Colour of the small circle. */
  private val smallCircleColour: String = config.getString("colour.smallCircle")
  
  /** Clears the canvas.
    *
    * @param ctx       Rendering context for the canvas.
    * @param canvasDim Canvas dimensions.
    */
  private def clear(ctx: dom.CanvasRenderingContext2D, canvasDim: CanvasDim): Unit = {
    import canvasDim.{height, width}
    ctx.clearRect(0, 0, width, height)
  }
  
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
    * @param cursor    Position of the cursor on the canvas, to the nearest pixel.
    */
  def draw(ctx: dom.CanvasRenderingContext2D, canvasDim: CanvasDim, cursor: Point): Unit = {
    val largeCentre: Point = getLargeCentre(canvasDim)
    
    clear(ctx, canvasDim)
    drawCircle(ctx, largeCentre, largeRadius, largeCircleColour)
    drawCircle(ctx, cursor, smallRadius, smallCircleColour)
  }
}

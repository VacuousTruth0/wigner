package com.github.yuxiliu1995.wigner.poincare

import com.github.yuxiliu1995.wigner.{CanvasDim, Point}
import com.github.yuxiliu1995.wigner.poincare.functions.draw.DrawFunctions
import org.scalajs.dom
import org.scalajs.dom.{html, raw}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Poincare")
object JsExport {
  
  /** Returns the position of the mouse on the canvas, to the nearest pixel.
    *
    * @param event Event caused by the user moving the mouse.
    * @param rect  Canvas size and position relative to the browser viewport.
    */
  private def getCursor(event: dom.MouseEvent, rect: raw.ClientRect): Point = {
    val canvasX: Double = event.clientX - rect.left
    val canvasY: Double = event.clientY - rect.top
    Point(canvasX, canvasY)
  }
  
  /** Main method. This will be called in the HTML page.
    *
    * @param canvas HTML canvas element.
    */
  @JSExport
  def main(canvas: html.Canvas): Unit = {
    
    val ctx: dom.CanvasRenderingContext2D = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    val canvasDim: CanvasDim = CanvasDim(canvas.width, canvas.height)
    val rect: raw.ClientRect = canvas.getBoundingClientRect
    
    // Initialise the canvas
    DrawFunctions.draw(ctx, canvasDim, canvasDim.centroid)
    
    canvas.onmousedown = (_: dom.MouseEvent) => ()
    canvas.onmouseup = (_: dom.MouseEvent) => ()
    
    // When the mouse moves, re-draw the canvas with the small circle under the cursor
    canvas.onmousemove = (event: dom.MouseEvent) => {
      val cursor: Point = getCursor(event, rect)
      DrawFunctions.draw(ctx, canvasDim, cursor)
    }
  }
}

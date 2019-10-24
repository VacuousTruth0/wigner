package com.github.yuxiliu1995.wigner.poincare

import com.github.yuxiliu1995.wigner.{CanvasDim, Point}
import com.github.yuxiliu1995.wigner.poincare.functions.draw.DrawFunctions
import com.github.yuxiliu1995.wigner.poincare.functions.state.StateFunctions
import com.github.yuxiliu1995.wigner.poincare.functions.state.StateFunctions.{dragState, smallCentre}
import com.github.yuxiliu1995.wigner.poincare.util.ConfigProvider.config
import org.scalajs.dom
import org.scalajs.dom.{html, raw}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Poincare")
object JsExport {
  
  /** Radius of the small circle, in pixels. */
  val smallRadius: Int = config.getInt("size.smallRadius")
  
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
    StateFunctions.initialiseSmallCentre(canvasDim)
    DrawFunctions.draw(ctx, canvasDim, smallCentre)
    
    // Start dragging the small circle when the mouse begins to be held down while the cursor is on it
    canvas.onmousedown = (event: dom.MouseEvent) => {
      val cursor: Point = getCursor(event, rect)
      StateFunctions.updateMouseDown(cursor)
    }
    
    // Stop dragging the small circle when the mouse is released
    canvas.onmouseup = (_: dom.MouseEvent) => StateFunctions.updateMouseUp()
    
    // When the mouse moves while the small circle is being dragged,
    // re-draw the canvas with the small circle under the cursor
    canvas.onmousemove = (event: dom.MouseEvent) => if (dragState) {
      val cursor: Point = getCursor(event, rect)
      StateFunctions.updateSmallCentre(cursor)
      DrawFunctions.draw(ctx, canvasDim, smallCentre)
    }
  }
}

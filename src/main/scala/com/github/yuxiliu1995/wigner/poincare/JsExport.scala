package com.github.yuxiliu1995.wigner.poincare

import com.github.yuxiliu1995.wigner.CanvasDim
import com.github.yuxiliu1995.wigner.poincare.functions.draw.DrawFunctions
import org.scalajs.dom
import org.scalajs.dom.html

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Poincare")
object JsExport {
  
  /** Main method. This will be called in the HTML page.
    *
    * @param canvas HTML canvas element.
    */
  @JSExport
  def main(canvas: html.Canvas): Unit = {
    
    val ctx: dom.CanvasRenderingContext2D = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    val canvasDim: CanvasDim = CanvasDim(canvas.width, canvas.height)
    
    // Initialise the canvas
    DrawFunctions.draw(ctx, canvasDim)
    
    canvas.onmousedown = (_: dom.MouseEvent) => ()
    canvas.onmouseup = (_: dom.MouseEvent) => ()
    
    canvas.onmousemove = (_: dom.MouseEvent) => ()
  }
}

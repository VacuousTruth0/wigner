package com.github.yuxiliu1995.wigner.poincare

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
    
    canvas.onmousedown = (_: dom.MouseEvent) => ()
    canvas.onmouseup = (_: dom.MouseEvent) => ()
    
    canvas.onmousemove = (_: dom.MouseEvent) => ()
  }
}

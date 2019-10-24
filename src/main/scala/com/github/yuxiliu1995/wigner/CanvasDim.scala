package com.github.yuxiliu1995.wigner

/** Dimensions for a HTML canvas element.
  *
  * @param width  Canvas width, in pixels.
  * @param height Canvas height, in pixels.
  */
case class CanvasDim(width: Int, height: Int) {
  
  /** Position of the centre of the canvas. */
  val centroid: Point = Point(width / 2, height / 2)
}

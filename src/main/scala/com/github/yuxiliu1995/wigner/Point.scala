package com.github.yuxiliu1995.wigner

/** Co-ordinates of a pixel on the canvas.
  *
  * @param x Horizontal position (x-value), in pixels.
  * @param y Vertical position (y-value), in pixels.
  */
case class Point(x: Int, y: Int)

object Point {
  
  /** Constructor that returns the co-ordinates of the pixel that contains an arbitrary position on the canvas.
    *
    * @param x Horizontal position (x-value) on the canvas, in pixels.
    * @param y Vertical position (y-value) on the canvas, in pixels.
    */
  def apply(x: Double, y: Double): Point = Point(x.toInt, y.toInt)
}

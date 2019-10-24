package com.github.yuxiliu1995.wigner

/** Co-ordinates of a pixel on the canvas.
  *
  * @param x Horizontal position (x-value), in pixels.
  * @param y Vertical position (y-value), in pixels.
  */
case class Point(x: Int, y: Int) {
  
  /** Returns the result when this position is translated by the input position (interpreted as a vector).
    *
    * The values of the corresponding co-ordinates in the two positions are added together.
    *
    * @param p Input position.
    */
  def +(p: Point): Point = Point(x + p.x, y + p.y)
  
  /** Returns the result when this position is translated by the negative of the input position (interpreted as a vector).
    *
    * The values of the corresponding co-ordinates in the two positions are subtracted.
    *
    * @param p Input position.
    */
  def -(p: Point): Point = Point(x - p.x, y - p.y)
  
  /** Returns the result when this position (interpreted as a vector) is scaled by the input number.
    *
    * Each co-ordinate is scaled by the input number.
    *
    * @param num Input number.
    */
  def *(num: Double): Point = Point(x * num, y * num)
  
  /** Returns the result when this position (interpreted as a vector) is scaled by the reciprocal of the input number.
    *
    * Each co-ordinate is scaled by the reciprocal of the input number.
    *
    * @param num Input number.
    */
  def /(num: Double): Point = Point(x / num, y / num)
}

object Point {
  
  /** Constructor that returns the co-ordinates of the pixel that contains an arbitrary position on the canvas.
    *
    * @param x Horizontal position (x-value) on the canvas, in pixels.
    * @param y Vertical position (y-value) on the canvas, in pixels.
    */
  def apply(x: Double, y: Double): Point = Point(x.toInt, y.toInt)
}

package com.github.yuxiliu1995.wigner.poincare.functions.state

import com.github.yuxiliu1995.wigner.Point

import scala.math.{pow, sqrt}

/** Contains functions that are used in updating the program state but cannot access the state directly. */
private[state] object StateHelperFunctions {
  
  /** Returns the distance between two points on the canvas, in pixels.
    *
    * @param p First point on the canvas.
    * @param q Second point on the canvas.
    */
  def distance(p: Point, q: Point): Double = {
    
    val xDiff = p.x - q.x
    val yDiff = p.y - q.y
    
    val distanceSquared = Seq(xDiff, yDiff).map(pow(_, 2)).sum
    sqrt(distanceSquared)
  }
}

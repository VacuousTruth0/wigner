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
  
  /** Returns the nearest point on a circle to the input point.
    *
    * This will be the input point if it is on the circle.
    *
    * Otherwise, the distance from the centre of the circle to the input point
    * is scaled to the radius of the circle.
    *
    * @param p      Point on the canvas.
    * @param centre Centre of the circle.
    * @param radius Radius of the circle.
    */
  def nearestCirclePoint(p: Point, centre: Point, radius: Int): Point = {
    val distanceFromCentre = distance(p, centre)
    if (distanceFromCentre <= radius) p else {
      val fromCentre = (p - centre) * (radius / distanceFromCentre)
      fromCentre + centre
    }
  }
}

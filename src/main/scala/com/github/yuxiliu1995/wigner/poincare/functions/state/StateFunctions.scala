package com.github.yuxiliu1995.wigner.poincare.functions.state

import com.github.yuxiliu1995.wigner.poincare.JsExport.{getLargeCentre, largeRadius, smallRadius}
import com.github.yuxiliu1995.wigner.poincare.functions.state.StateHelperFunctions.{distance, nearestCirclePoint}
import com.github.yuxiliu1995.wigner.{CanvasDim, Point}

/** Contains the program state, and functions used to access and update it. */
object StateFunctions {
  
  /** Program state. */
  private object State {
    
    /** Drag state. True if the small circle is currently being dragged and false otherwise. */
    var drag: Boolean = false
    
    /** Position of the centre of the small circle on the canvas. */
    var smallCentre: Point = _
  }
  
  import State.drag
  
  /** Returns true if the input point is on the small circle and false otherwise.
    *
    * @param p Position on the canvas.
    */
  private def onSmallCircle(p: Point): Boolean = distance(p, smallCentre) < smallRadius
  
  /** Sets the initial position of the centre of the small circle to the canvas centroid.
    *
    * @param canvasDim Canvas dimensions.
    */
  def initialiseSmallCentre(canvasDim: CanvasDim): Unit = {
    State.smallCentre = canvasDim.centroid
  }
  
  /** Update the position of the centre of the small circle.
    *
    * Its new position will be at the nearest point on the large circle to the cursor.
    *
    * @param cursor    Position of the cursor on the canvas.
    * @param canvasDim Canvas dimensions.
    */
  def updateSmallCentre(cursor: Point, canvasDim: CanvasDim): Unit = {
    val largeCentre: Point = getLargeCentre(canvasDim)
    State.smallCentre = nearestCirclePoint(cursor, largeCentre, largeRadius)
  }
  
  /** Updates the drag state when the mouse begins to be held down while the cursor is on the small circle. */
  def updateMouseDown(cursor: Point): Unit = if (onSmallCircle(cursor)) {
    drag = true
  }
  
  /** Updates the drag state when the mouse is released. */
  def updateMouseUp(): Unit = {
    drag = false
  }
  
  /** Returns the current drag state. */
  def dragState: Boolean = drag
  
  /** Returns the current position of the centre of the small circle on the canvas. */
  def smallCentre: Point = State.smallCentre
}

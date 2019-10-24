package com.github.yuxiliu1995.wigner.poincare.functions.state

/** Contains the program state, and functions used to access and update it. */
object StateFunctions {
  
  /** Program state. */
  private object State {
    
    /** Drag state. True if the small circle is currently being dragged and false otherwise. */
    var drag: Boolean = false
  }
  
  import State.drag
  
  /** Updates the drag state when the mouse begins to be held down. */
  def updateMouseDown(): Unit = {
    drag = true
  }
  
  /** Updates the drag state when the mouse is released. */
  def updateMouseUp(): Unit = {
    drag = false
  }
  
  /** Returns the current drag state. */
  def dragState: Boolean = drag
}

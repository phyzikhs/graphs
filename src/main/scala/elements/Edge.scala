package com.maths.graphs
package elements

sealed trait Edge {
  val v1: Vertex
  val v2: Vertex

  def == (e: Edge): Boolean

  override def equals(obj: Any): Boolean = {
    obj match {
      case e: Edge => e match {
        case l: Loop      => l == this
        case w: Weighted  => w == this
        case d: Directed => d == this
      }
      case _ => false
    }
  }

}

/** Simple un-directed, unweighted loop (when a vertex is adjacent to itself) */
case class Loop(v: Vertex) extends Edge {
  override val v1: Vertex = v
  override val v2: Vertex = v

  override def ==(e: Edge): Boolean = {
    e.v1 == v1 && e.v2 == v2 && (e match {
      case _: Loop => true
      case _ => false
    })
  }
}

/** un-directed, weighted loop (when a vertex is adjacent to itself) */
case class WeightedLoop(override val v: Vertex, weight: Double) extends Loop(v) {

  override def ==(e: Edge): Boolean = {
    e.v1 == v1 && e.v2 == v2 && (e match {
      case wl: WeightedLoop => wl.weight == weight
      case _ => false
    })
  }
}

/** Directed, weighted loop (when a vertex is adjacent to itself) */
case class DiWeightedLoop(
                           override val v: Vertex,
                           override val weight: Double,
                           direction: EdgeDirection.type)
  extends WeightedLoop(v, weight) {

  override def ==(e: Edge): Boolean = {
    e.v1 == v1 && e.v2 == v2 && (e match {
      case dwl: DiWeightedLoop => dwl.weight == weight
      case _ => false
    })
  }
}

/** Un-directed, weighted edge */
case class Weighted(v1: Vertex,
                  v2: Vertex,
                  weight: Double)
  extends Edge {

  override def ==(e: Edge): Boolean = {
    e.v1 == v1 && e.v2 == v2 && (e match {
      case w: Weighted => w.weight == weight
      case _ => false
    })
  }
}

/** Directed, weighted edge */
case class DiWeighted(
                           override val v1: Vertex,
                           override val v2: Vertex,
                           override val weight: Double,
                           direction: EdgeDirection.type)
  extends Weighted(v1, v2, weight) {

  override def ==(e: Edge): Boolean = {
    super.==(e) && (e match {
      case dw: DiWeighted => dw.direction == direction
      case _ => false
    })
  }
}

/** Directed edge */
case class Directed(v1: Vertex,
                     v2: Vertex,
                     direction: EdgeDirection.type)
  extends Edge {

  override def ==(e: Edge): Boolean = {
    super.==(e) && (e match {
      case dw: Directed => dw.direction == direction
      case _ => false
    })
  }
}
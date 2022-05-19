package com.maths.graphs
package elements

case class Vertex(name: String) {

  override def equals(obj: Any): Boolean = {
    obj match {
      case vert: Vertex => vert.name == name
      case _ => false
    }
  }

  def == (v: Vertex): Boolean = equals(v)

}

package com.maths.graphs
package elements

/** A simple graph G is a pair (V(G), E(G)) where
 * V(G) = {v1, v2, ..., vn} is a vertex set,
 * E(G) = {(u, v): u in V(G), v in V(G)} is the edge set.
 * u is adjacent to v (or vise versa) if uv in E(G)
 */
case class Graph() {

  private val vertexSet: Set[Vertex] = Set.empty[Vertex]
  private val edgeSet:   Set[Edge]   = Set.empty[Edge]

  def V: Set[Vertex] = vertexSet
  def E: Set[Edge] = edgeSet


  def size(g: Graph = this): Int =
    g.E.size

  def order(g: Graph = this): Int =
    g.V.size

  def addVertex(v: Vertex): Unit =
    this.vertexSet ++= v

  def addVertices(v: Set[Vertex]): Unit =
    this.vertexSet += v

  def addEdge(e: Edge): Unit = {
    this.vertexSet += Set(e.v1, e.v2)
    this.edgeSet ++= e
  }
  def addEdges(es: Set[Edge]): Unit = {
    this.vertexSet += es.map(_.v1)
    this.vertexSet += es.map(_.v2)
    this.edgeSet   += es
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case graph: Graph => V.equals(graph.V) && E.equals(graph.E)
      case _ => false
    }
  }
  def == (g: Graph): Boolean = equals(g)
}

case object Nul extends Graph() {}
case class Empty(vertexSet: Set[Vertex]) extends Graph() {
  addVertices(vertexSet)
}

object Graph {
}
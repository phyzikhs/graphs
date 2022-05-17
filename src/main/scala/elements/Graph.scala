package com.maths.graphs
package elements

import elements.Graph.{Edge, Vertex}
/** A simple graph G is a pair (V(G), E(G)) where
 * V(G) = {v1, v2, ..., vn} is a vertex set,
 * E(G) = {(u, v): u in V(G), v in V(G)} is the edge set.
 * u is adjacent to v (or vise versa) if uv in E(G)
 */
final case class Graph(V: List[Vertex], E: List[Edge]) {
  def size: Int = ??? // TODO returns the size of a Graph, the number of edges

  def addVertex(v: Vertex): Unit = ??? // TODO adds a vertex to the graph G

  def addEdge(e: Edge): Unit = ??? // TODO adds an element to the edge set, vertices must/may be in the graph G
}

object Graph {

  final case class Vertex(name: String) {

    override def equals(obj: Any): Boolean = {
      obj match {
        case vert: Vertex => vert.name == name
        case _ => false
      }
    }

    def == (v: Vertex): Boolean = equals(v)

  }

  final case class Edge(v1: Vertex, v2: Vertex) {
    override def equals(obj: Any): Boolean = {
      obj match {
        case e: Edge => e.v1 == e.v2
        case _ => false
      }
    }

    def == (e: Edge): Boolean = equals(e)
  }
}
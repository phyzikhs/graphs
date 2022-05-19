package com.maths.graphs
package elements

/** A simple graph G is a pair (V(G), E(G)) where
 * V(G) = {v1, v2, ..., vn} is a vertex set,
 * E(G) = {(u, v): u in V(G), v in V(G)} is the edge set.
 * u is adjacent to v (or vise versa) if uv in E(G)
 */
sealed trait Graph {

  private val vertexSet: Set[Vertex] = Set.empty[Vertex]
  private val edgeSet: Set[Edge] = Set.empty[Edge]

  def V: Set[Vertex] = vertexSet

  def E: Set[Edge] = edgeSet


  def size(g: Graph = this): Int =
    g.E.size

  def order(g: Graph = this): Int =
    g.V.size

  def addVertex(v: Vertex): Unit =
    this.vertexSet ++= v
  def +(v: Vertex): Unit =
    addVertex(v)

  def addVertices(vs: Set[Vertex]): Unit =
    this.vertexSet += vs
  def +(vs: Set[Vertex]): Unit =
    addVertices(vs)

  def isEmpty: Boolean = E.isEmpty

  def isNull: Boolean = isEmpty && V.isEmpty

  /** So far, adding edge(s) is more efficient than adding a vertex and then its edge(s). */
  def addEdge(e: Edge): Unit = {
    this.vertexSet += Set(e.v1, e.v2)
    this.edgeSet ++= e
  }
  def +(e: Edge): Unit =
    addEdge(e)

  def addEdges(es: Set[Edge]): Graph = {
    this.vertexSet += es.map(_.v1)
    this.vertexSet += es.map(_.v2)
    this.edgeSet += es
    Graph(this.E)
  }
  def +=(es: Set[Edge]): Graph =
    addEdges(es)

  /** Graph operations (GxH) as defined in the content */
  def *(graph: Graph): Graph = ???

  /** Graph operations (G+H) as defined in the content */
  def +(graph: Graph): Graph = {
    val newVertexSet = this.V + graph.V
    val newEgdeSet = this.E + graph.E
    Graph(newEgdeSet)
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case graph: Graph => V.equals(graph.V) && E.equals(graph.E)
      case _ => false
    }
  }

  def ==(g: Graph): Boolean = equals(g)

  /** Given 2 vertices, determines all possible paths */
  def paths(v1: Vertex, v2: Vertex): List[Path]

  /** Given 2 vertices, determines shortest path(s) */
  def shortestPaths(v1: Vertex, v2: Vertex): List[Path]

  /** Given 2 vertices, determines the shortest distance (cost of shortest path) */
  def distance(v1: Vertex, v2: Vertex): Option[Double]
}

/** In certain scripts, Null graphs are not considered graphs */
case object Nul extends Empty(Set.empty) {
  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = List.empty

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = List.empty

  /** Given 2 vertices, determines the shortest distance (cost of shortest path) */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = None
}

/**
 * Sometimes Null graphs are also considered as empty graphs,
 * but for now let's use this convention as to null graphs
 * being nothing and empty graphs being a non-empty vertex
 * set having an empty edge set.
 */
case class Empty(vertexSet: Set[Vertex]) extends Graph {
  addVertices(vertexSet)

  /** Given 2 vertices, determines the shortest distance */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = None

  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = List.empty

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = List.empty
}

/** Simple graph (un-directed, unweighted and not multi-graph) */
case object Graph extends Graph {
  def apply(es: Set[Edge]): Graph = Graph.addEdges(es)


  /** Given 2 vertices, determines the shortest distance */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = ???

  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = ???

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = ???
}

/** Directed graph */
case object Digraph extends Graph {

  /** Given 2 vertices, determines the shortest distance */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = ???

  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = ???

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = ???

}

/** Directed and weighted graph */
case object DiWeightedGraph extends Graph {

  /** Given 2 vertices, determines the shortest distance */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = ???

  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = ???

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = ???
}

/** Weighted graph */
case object WeightedGraph extends Graph {

  /** Given 2 vertices, determines the shortest distance */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = ???

  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = ???

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = ???
}

/** Connected graph */
case object Connected extends Graph {

  /** Given 2 vertices, determines the shortest distance */
  override def distance(v1: Vertex, v2: Vertex): Option[Double] = ???

  /** Given 2 vertices, determines all possible paths */
  override def paths(v1: Vertex, v2: Vertex): List[Path] = ???

  /** Given 2 vertices, determines shortest path(s) */
  override def shortestPaths(v1: Vertex, v2: Vertex): List[Path] = ???
}
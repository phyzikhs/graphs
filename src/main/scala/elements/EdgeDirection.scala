package com.maths.graphs
package elements

/**
 * FORWARD means v1 is adjacent to v2. Or v2 is adjacent from v1
 * BACKWARD means v1 is adjacent from v2. Or v2 is adjacent to v1
 */
object EdgeDirection extends Enumeration {
  val FORWARD: Int = -1
  val BACKWARD: Int = 1
}

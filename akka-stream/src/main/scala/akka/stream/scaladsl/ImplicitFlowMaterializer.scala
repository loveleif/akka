/**
 * Copyright (C) 2014 Typesafe Inc. <http://www.typesafe.com>
 */
package akka.stream.scaladsl

import akka.actor.Actor
import akka.stream.FlowMaterializer
import akka.stream.MaterializerSettings

/**
 * Mix this trait into your [[akka.actor.Actor]] if you need an implicit
 * [[akka.stream.FlowMaterializer]] in scope.
 *
 * Subclass may override [[#flowMaterializerSettings]] to define custom
 * [[akka.stream.MaterializerSettings]] for the `FlowMaterializer`.
 */
trait ImplicitFlowMaterializer { this: Actor ⇒
  /**
   * Subclass may override this to define custom
   * [[akka.stream.MaterializerSettings]] for the `FlowMaterializer`.
   */
  def flowMaterializerSettings: MaterializerSettings = MaterializerSettings()

  final implicit val flowMaterializer: FlowMaterializer = FlowMaterializer(flowMaterializerSettings)
}
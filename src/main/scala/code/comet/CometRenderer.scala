package code.comet

import scala.xml._
import net.liftweb.http.S
import net.liftweb.builtin.snippet.Comet
import scala.collection.mutable
import net.liftweb.common.Loggable

case class CometComponent(ns: NodeSeq, cometId: String, when: Long)

object CometRenderer extends Loggable {

  def apply(cometType: String, cometName: String, kids: NodeSeq): CometComponent = {
    val cometNS = S.withAttrs(new UnprefixedAttribute("type", cometType, new UnprefixedAttribute("name", cometName, Null)))(
      Comet.render(kids)
    )
    val outer = cometNS match {
      case e: Elem =>
        val children = e.child match {
          case g: mutable.WrappedArray[Node] => g.array(0).asInstanceOf[Group].nodes
          case c =>
            logger.warn("Comet-element's child is of type: " + c.getClass.getName)
            c
        }
        e.copy(child = children)
      case e => e
    }
    val id = outer \ "div" \ "@id"
    val attrs = (outer \ "div")(0).attributes
    val when = attrs.collect{case p: PrefixedAttribute if p.pre == "lift" && p.key == "when" => p.value.text.toLong}.head
    CometComponent(outer, id.text, when)
  }

}

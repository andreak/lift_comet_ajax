package code.snippet

import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.http.js._
import scala.xml.NodeSeq
import net.liftweb.util.Helpers._
import code.comet.CometRenderer
import code.view.RegisterComet

object AddCounter extends Loggable {

  val cometBody = <div>
    <span>Comet Name</span>
    <span id="name"></span>
    <span>Counter</span>
    <span id="number"></span>
  </div>

  def render = SHtml.ajaxButton("Add Counter", () => RegisterComet("counter", CometRenderer("Counter", nextFuncName, cometBody)))

}

package code.comet

import net.liftweb.http.{RenderOut, CometActor}
import net.liftweb.common.Loggable

class Snabel extends CometActor with Loggable {
  def render: RenderOut = {
    <div>Hi</div>
  }
}

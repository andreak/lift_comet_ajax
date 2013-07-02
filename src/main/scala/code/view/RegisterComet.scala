package code.view

import net.liftweb.http.js.{JE, JsCmd}
import net.liftweb.util.Helpers._
import net.liftweb.http.js.JsCmds.Replace
import code.comet.CometComponent

case class RegisterComet(id: String, comet: CometComponent) extends JsCmd {
  override val toJsCmd = {
    (Replace(id, comet.ns) & JE.JsRaw("""lift_toWatch[%s] = %s""".format( comet.cometId.encJs, comet.when.toString.encJs)).cmd).toJsCmd
  }
}

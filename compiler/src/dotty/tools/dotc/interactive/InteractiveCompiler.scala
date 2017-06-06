package dotty.tools
package dotc
package interactive

import core._
import Phases._
import typer._
import Contexts._

class InteractiveCompiler extends Compiler {
  // TODO: Figure out what phases should be run in IDEs
  // More phases increase latency but allow us to report more errors.
  // This could be improved by reporting errors back to the IDE
  // after each phase group instead of waiting for the pipeline to finish.
  override def phases: List[List[Phase]] = List(
    List(new FrontEnd)
  )

  override def rootContext(implicit ctx: Context) =
    super.rootContext.fresh.addMode(Mode.Interactive)
}

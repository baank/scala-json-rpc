package io.github.shogowada.scala.jsonrpc.example.e2e.integrationtest

import io.github.shogowada.scala.jsonrpc.example.e2e.ElementIds
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.{Chrome, Firefox}
import org.scalatest.{Matchers, path}

class EchoTest extends path.FreeSpec
    with Matchers
    with Eventually
    with Chrome {

  "given I am on the echo page" - {
    go to Target.url

    "when I typed in something" - {
      val text = "Hello, server!"

      textField(ElementIds.EchoText).value = text

      "then it should echo the text" in {
        eventually {
          find(ElementIds.EchoEchoedText).get.text should equal(text)
        }
      }
    }
  }

  quit()
}

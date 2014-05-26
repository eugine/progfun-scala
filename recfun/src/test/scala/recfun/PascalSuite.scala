package recfun

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.util.NoSuchElementException

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
	  assert(pascal(1,3) === 3)
  }
  
  test("pascal: col=3,row=4") {
	  assert(pascal(3,4) === 4)
  }

  test("pascal: col=4,row=7") {
	  assert(pascal(4,7) === 35)
  }

  test("pascal: col=6,row=6") {
	  assert(pascal(6,6) === 1)
  }
  
  test("pascal: col=1,row=7") {
	  assert(pascal(1,7) === 7)
  }
}

package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2,5,10,25,50)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }

  test("countChange: 17 US cents") {
    assert(countChange(17,List(5,10,25,50,1)) === 6)
  }

  test("countChange: 11 US cents") {
    assert(countChange(11,List(5,10,25,50,1)) === 4)
  }

  test("countChange: 4 US cents") {
    assert(countChange(4,List(5,10,25,1,50)) === 1)
  }
  
  test("countChange: only 1 option for 0 money") {
    assert(countChange(0,List(5,10,25,1,50)) === 1)
  }
  
  test("countChange: no options for empty coins list and non zero money") {
    assert(countChange(2,List()) === 0)
  }
  
  
}

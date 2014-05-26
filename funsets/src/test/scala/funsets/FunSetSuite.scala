package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val r12 = rangeSet(1, 2)
    val r13 = rangeSet(1, 3)
    val r39 = rangeSet(3,9)
  }

  test("singletonSet(1) contains 1") {
    new TestSets {
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("singletonSet(2) doesn't contain 1 and 3") {
    new TestSets {
      assert(!contains(s2, 1), "Singleton not contains 1")
      assert(!contains(s2, 3), "Singleton not contains 3")
    }
  }
  
  test("rangeSet(1,2) constains 1, 2 and not contains 0 and 3") {
    new TestSets {
      assert(contains(r12, 1), "RangeSet constains 1")
      assert(contains(r12, 2), "RangeSet constains 2")
      assert(!contains(r12, 0), "RangeSet doesn't constain 0")
      assert(!contains(r12, 3), "RangeSet doesn't constain 3")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect contains only common elements") {
    new TestSets {
      val s = intersect(s1, r12)
      assert(contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect  3")
    }
  }  
  
  test("diff contains only unique elements from first set") {
    new TestSets {
      val s = diff(r13, r12)
      assert(!contains(s, 1), "Diff 1")
      assert(!contains(s, 2), "Diff 2")
      assert(contains(s, 3), "Diff  3")
    }
  }    
  
 test("filtering range 1-3 with x > 2 contains only 3") {
    new TestSets {
      val s = filter(r13, x => x > 2)
      assert(!contains(s, 1), "Filtering 1")
      assert(!contains(s, 2), "Filtering 2")
      assert(contains(s, 3), "Filtering  3")
    }
  }      
 
 test("forall works") {
    new TestSets {
      assert(forall(r13, x => x > 0), "Forall r13 > 0")
      assert(!forall(r13, x => x > 1), "Forall r13 > 1")
      assert(forall(r12, x => x < 3), "Forall r12 < 3")
    }
  }  
 
  test("exists elements") {
    new TestSets {
      assert(!exists(r13, x => x == 0), "Exist 0")
      assert(exists(r13, x => x == 1), "Exist 1")
      assert(!exists(r13, x => x == 4), "Exist 4")
    }
  }  
  
 test("map elements") {
    new TestSets {
      val r46 = map(r13, x => x+3)
      assert(contains(r46, 4), "Map 4")
      assert(contains(r46, 5), "Map 5")
      assert(!contains(r46, 7), "Map 7")
    }
  }   

 test("map doubling elements contain only even numbers") {
    new TestSets {
      val rdoubled = map(r39, x => 2*x)
      assert(forall(rdoubled, x => (x % 2) == 0))
    }
  }   

}

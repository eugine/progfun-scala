package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) { case (block, move) => move match {
        case Left => block.left
        case Right => block.right
        case Up => block.up
        case Down => block.down
      }
    }
  }

  trait Level1 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0,0)), "0,0")
      assert(!terrain(Pos(4,11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1,1))
    }
  }

  test("standing function") {
    new Level1 {
      assert(Block(Pos(1,1), Pos(1,1)).isStanding)
      assert(!Block(Pos(0,1), Pos(1,1)).isStanding)
    }
  }
  
  test("legal function") {
    new Level1 {
      assert(Block(Pos(1,1), Pos(1,1)).isLegal)
      assert(!Block(Pos(1,7), Pos(1,8)).isLegal)
    }
  }

  test("legal neighbors function") {
    new Level1 {
      assert(Block(Pos(1,0), Pos(1,0)).legalNeighbors === List((Block(Pos(1,1), Pos(1,2)), Right)))
      assert(Block(Pos(0,0), Pos(0,1)).legalNeighbors === 
        List(
    		  (Block(Pos(0,2), Pos(0,2)), Right), 
    		  (Block(Pos(1,0), Pos(1,1)), Down)
    		))
    }
  }
  
  test("done function") {
    new Level1 {
      assert(done(Block(Pos(4, 7), Pos(4, 7))))
    }
  }

  test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }
  
  test("String parser terrian") {
    new Level1 {
      val ll = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
      assert(terrainFunction(ll)(Pos(2,1)))
    }
  }
}

package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val bits: List[Bit] = List(1, 1, 1, 0, 0, 0, 1)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }
  
  test("weight 2 of a larger tree") {
    new TestTrees {
      assert(weight(t2) === 9)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("char of a leaf") {
    new TestTrees {
      assert(chars(new Leaf('a', 2)) === List('a'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("create code tree") {
    val tree = createCodeTree("ababbcd".toList)
    assert(chars(tree) === "bcda".toList)
    assert(weight(tree) === 7)
  }
  
  test("sub trees 1") {
    new TestTrees {
      assert(chars(subTree(t1, false)) === "b".toList)
    }
  }
  
  test("sub trees 2") {
    new TestTrees {
      assert(chars(subTree(t2, true)) == "ab".toList)
    }
  }
  
  test("decode 1") {
    new TestTrees {
	  assert(decode(t1, bits) === "bbbaaab".toList)
    }
  }

  test("decode 2") {
    new TestTrees {
      assert(decode(t2, bits) === "dddab".toList)
    }
  }

  test("decode huffman est cool") {
    new TestTrees {
      assert(decodedSecret === "huffmanestcool".toList)
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and quickencode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("encode and quickencode are same") {
    new TestTrees {
      assert(encode(t1)("ab".toList) === quickEncode(t1)("ab".toList))
    }
  }
}

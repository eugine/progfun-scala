package week6

import forcomp.Anagrams._

object Anagrams {

  val word: Word = "eat"                          //> word  : forcomp.Anagrams.Word = eat
  
  val sent = List("Linux", "rulez")               //> sent  : List[String] = List(Linux, rulez)

	val occ = sentenceOccurrences(sent)       //> occ  : forcomp.Anagrams.Occurrences = List((e,1), (i,1), (l,2), (n,1), (r,1)
                                                  //| , (u,2), (x,1), (z,1))
  val comb = combinations(occ)                    //> comb  : List[forcomp.Anagrams.Occurrences] = List(List(), List((z,1)), List(
                                                  //| (x,1)), List((x,1), (z,1)), List((u,1)), List((u,1), (z,1)), List((u,1), (x,
                                                  //| 1)), List((u,1), (x,1), (z,1)), List((u,2)), List((u,2), (z,1)), List((u,2),
                                                  //|  (x,1)), List((u,2), (x,1), (z,1)), List((r,1)), List((r,1), (z,1)), List((r
                                                  //| ,1), (x,1)), List((r,1), (x,1), (z,1)), List((r,1), (u,1)), List((r,1), (u,1
                                                  //| ), (z,1)), List((r,1), (u,1), (x,1)), List((r,1), (u,1), (x,1), (z,1)), List
                                                  //| ((r,1), (u,2)), List((r,1), (u,2), (z,1)), List((r,1), (u,2), (x,1)), List((
                                                  //| r,1), (u,2), (x,1), (z,1)), List((n,1)), List((n,1), (z,1)), List((n,1), (x,
                                                  //| 1)), List((n,1), (x,1), (z,1)), List((n,1), (u,1)), List((n,1), (u,1), (z,1)
                                                  //| ), List((n,1), (u,1), (x,1)), List((n,1), (u,1), (x,1), (z,1)), List((n,1), 
                                                  //| (u,2)), List((n,1), (u,2), (z,1)), List((n,1), (u,2), (x,1)), List((n,1), (u
                                                  //| ,2), (x,1), (z,1)), List((n,1), (r,1)), List((n,1), (r,1), (z,1)), List((n,1
                                                  //| ), (r,1), (x,1)), List((
                                                  //| Output exceeds cutoff limit.
  comb.head.mkString                              //> res0: String = ""
	
  }
package rational

object rational {
  val x = new Rational(1, 3)                      //> x  : rational.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : rational.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : rational.Rational = 3/2
  
  x.sub(y).sub(z)                                 //> res0: rational.Rational = -79/42
  y.add(y)                                        //> res1: rational.Rational = 10/7
  x.less(z)                                       //> res2: Boolean = true
  
  new Rational(3)                                 //> res3: rational.Rational = 3/1
  
}

class Rational(x: Int, y: Int) {
  require(y != 0, "Denom can't be 0")
  
  def this(x: Int) = this(x, 1)

	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	val numer = x
	val denom = y
	
	def add(that: Rational) =
		new Rational(
					this.numer * that.denom + that.numer * denom,
					denom * that.denom);
	
	def less(that: Rational) = this.numer * that.denom < that.numer * denom
	
	def max(that: Rational) = if (this.less(that)) that else this
	
	def neg: Rational = new Rational(-numer, denom)
	
	def sub(that: Rational) = add(that.neg)
					
	override def toString = {
		val g = gcd(numer, denom)
		
		numer / g + "/" + denom / g
		}
}
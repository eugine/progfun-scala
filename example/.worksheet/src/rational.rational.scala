package rational

object rational {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  val x = new Rational(1, 3);System.out.println("""x  : rational.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : rational.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : rational.Rational = """ + $show(z ));$skip(21); val res$0 = 
  
  x.sub(y).sub(z);System.out.println("""res0: rational.Rational = """ + $show(res$0));$skip(11); val res$1 = 
  y.add(y);System.out.println("""res1: rational.Rational = """ + $show(res$1));$skip(12); val res$2 = 
  x.less(z);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(21); val res$3 = 
  
  new Rational(3);System.out.println("""res3: rational.Rational = """ + $show(res$3))}
  
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

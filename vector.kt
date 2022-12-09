import kotlin.math.pow
import kotlin.math.sqrt

class Vec2d(var x: Double, var y: Double){
    operator fun plus(p:Vec2d)=Vec2d(x+p.x,y+p.y)
    operator fun minus(p:Vec2d)=Vec2d(x-p.x,y-p.y)
    fun dotProduct(another:Vec2d)=x*another.x+y*another.y
    private fun magnitude()= sqrt(x.toDouble().pow(2)+y.toDouble().pow(2))
    fun normalise()=Vec2d(x/magnitude().toFloat(),y/magnitude().toFloat())
    fun weight(proportion:Float)=Vec2d(x*proportion,y*proportion)
    fun m(another: Vec2d)=(y-another.y)/(x-another.x)
    fun c(another: Vec2d)=y-m(another)*x
}
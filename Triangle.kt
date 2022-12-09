class Triangle(private val first:Vec2d, private val second:Vec2d, private val third:Vec2d){
    val tris= arrayOf(first,second,third)
    fun isInside(test:Vec2d): Int {
        var ab=second-first
        var ac=third-first
        val ap=test-first
        if(ab.x==0.0 || ac.y==0.0){
            return 2
        }
        else if(ab.y==0.0) {
            ab = third - second
        }
        else if (ac.y==0.0){
            ac=third-second
        }
        val w1=(first.x*ac.y+ap.y*ac.x-test.x*ac.y)/(ab.y*ac.x-ab.x*ac.y)
        val w2=(ap.y-w1*ab.y)/ac.y
        return if(w1>=0 && w2>=0 && w1+w2<=1)
            1
        else 0
    }
}
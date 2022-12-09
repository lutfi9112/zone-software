abstract class Zone {
    val points=ArrayList<Vec2d>()
    val triangles=ArrayList<Triangle>()
    var center=Vec2d(0.0,0.0)

    fun addElement(point:Vec2d){
        points.add(point)
    }
    fun minLongitude():Vec2d{
        val temp=points.sortedBy { points->points.y}
        return temp[0]
    }
    fun maxLongitude():Vec2d{
        val max=points.sortedByDescending { points->points.y }
        return max[0]
    }
    fun minLatitude():Vec2d{
        val min=points.sortedBy { points->points.x }
        return min[0]
    }
    fun maxLatitude():Vec2d{
        val max=points.sortedByDescending { points->points.x }
        return max[0]
    }
    fun getCenter(){
        val minLongitude=minLongitude()
        val maxLongitude=maxLongitude()
        val minLatitude=minLatitude()
        val maxLatitude=maxLatitude()
        center.x=((minLatitude+maxLatitude).x/2)+0.001f
        center.y=((minLongitude+maxLongitude).y/2)+0.001f
    }
    fun init_triangles(){
        for(i in 1..points.lastIndex){
            var j=i-1
            triangles.add(Triangle(center,points[j],points[i]))
        }
    }
    fun isInside(test:Vec2d):Boolean{
        val local=ArrayList<Int>()
        for (i in triangles){
            val o=i.isInside(test)
            local.add(o)
        }
        for(i in 1..local.lastIndex){
            var j=i-1
            if(local[i]==1 && local[j]==1)
                local[i]*=local[j]
            local[i]+=local[j]
        }
        if(local[local.lastIndex]==1)
            return true
        return false
    }
}
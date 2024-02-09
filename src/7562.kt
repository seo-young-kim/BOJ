import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val Tc = Integer.parseInt(br.readLine())

    val move = arrayOf(arrayOf(-1,-2), arrayOf(-2,-1),arrayOf(-2,1), arrayOf(-1,2),
                        arrayOf(1,-2), arrayOf(2,-1),arrayOf(2,1), arrayOf(1,2))

    for (i in 1..Tc){
        //init
        val L = Integer.parseInt(br.readLine())
        var st = StringTokenizer(br.readLine())
        val sx = Integer.parseInt(st.nextToken())
        val sy = Integer.parseInt(st.nextToken())
        val start = Pair(sx,sy)
        st = StringTokenizer(br.readLine())
        val tx = Integer.parseInt(st.nextToken())
        val ty = Integer.parseInt(st.nextToken())
        val target = Pair(tx,ty)

        //bfs
        var visited = Array(L) { BooleanArray(L) { false } }
        var answer = 0
        var queue : Queue<Pair<Int,Int>> = LinkedList()
        queue.offer(start)
        visited[start.first][start.second]=true
        if(sx==tx && sy==ty){
            println(answer)
            break
        }

outer@ while(queue.isNotEmpty()){

            val size = queue.size
            answer++
            for(j in 1..size){
                val now = queue.poll()
                for ((x,y) in move){
                    var nx = now.first + x
                    var ny = now.second + y
                    if (nx<0 || ny<0 || nx>=L || ny>=L || visited[nx][ny]) continue
                    if (nx==target.first && ny==target.second)
                        break@outer
                    queue.offer(Pair(nx,ny))
                    visited[nx][ny]=true
                }
            }
        }
        println(answer)
    }
}
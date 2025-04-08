package practice.FoodOrder

import practice.SocialMedia.Post

fun main(){
    val dish:Meal= Meal("burger",200.0)
    val seconddish:Meal= Meal("kabab",300.0)
    val day:weekDays=weekDays.Wednesday
println(dish)
println(dish==seconddish)
    println(day.dayNameInArabic)
    println(day)

}
enum class weekDays(val dayNameInArabic:String){
    Saturday("السبت"),
    Sunday("الأحد"),
    Monday("الإثنين"),
    Tuesday("الثلاثاء"),
    Wednesday("الأربعاء"),
    Thursday("الخميس"),
    Friday("الجمعة"),
}

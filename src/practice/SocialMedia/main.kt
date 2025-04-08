package practice.SocialMedia



fun main(){
    val post:Post=ImagePost("ahmed",
        "hello my friends ", imageurl = "https:/image.png")
    val reel:ReelPost=ReelPost("mohammed","this my content ", hdvediourl = "hd", fullhdvediourl = "fullhd")
   val postwithmedia:Post=Post(
       publishername = "mohammed", content = "this my content ", mediaContent = MediaContent(
           hdVediourl = "this my hd vedio url",
           fullHdVediourl = "this my hd vedio url",
       )
   )
    val spcialpost:Post=Post("mohammed","my content")
    val listofposts:List<String> = listOf(spcialpost.content,spcialpost.content)
    val homescreenstate: ScreenState = Success(listofposts)
    when(homescreenstate){
        is Loading -> println("Homescreenstate is loading...")
        is Success -> println("Homescreenstate is loaded ${homescreenstate.posts}")
        is Erorr -> println("Homescreenstate is error: ${homescreenstate.reson}")
    }
    println(post.content)
    post.like()
    post.like()
    println("this post has ${post.likecount} like")
    post.dislike()
    println("this post has ${post.likecount}like")
    reel.like()
    reel.like()
    println("this reel post has ${reel.likecount}like")
    println("this the conent of the post conatin mediacontent ${postwithmedia.content}")

}
sealed class ScreenState()
class Success(val posts:List<String>):ScreenState()
class Loading():ScreenState()
class Erorr(val reson:String):ScreenState()

//sealed مناسب لما يكون عندك اكثر من خيار كل واحد بداتا تايب مختلف
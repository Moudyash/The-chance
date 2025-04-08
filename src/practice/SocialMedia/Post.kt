package practice.SocialMedia

open class Post(
    val publishername: String,
    val content: String,
    private val allowcomments: Boolean=true,
    val mediaContent:MediaContent?=null,
) {
    var likecount:Int=0
        private set//ما بتقدر تعدل على عدد اللابكات من الخارج
    var comments:MutableList<Comment> = mutableListOf()
        private set
    fun like()= likecount++
    fun dislike()= likecount--
    fun addComment(comment:Comment){

        if(allowcomments){
          //  comments.addComment(comment)
        }
    }
}
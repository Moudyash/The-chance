package practice.SocialMedia


class ImagePost(
    publishername: String, content: String, allowcomments: Boolean=true,
    val imageurl: String=""

) : Post(publishername, content, allowcomments) {
}
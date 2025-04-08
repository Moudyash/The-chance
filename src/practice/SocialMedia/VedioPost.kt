package practice.SocialMedia




open class VedioPost(
    publishername: String, content: String, allowcomments: Boolean=true,



) : Post(publishername, content, allowcomments) {
   open fun uploadvedio(url:String){
        println("Uploading $url")
    }

}
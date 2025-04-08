package practice.SocialMedia

class ReelPost(
    publishername:String,
    content:String,
    hdvediourl:String,
    fullhdvediourl:String,
    allowedcomments:Boolean=true
):VedioPost(
    publishername = publishername,
    content=content,
    allowcomments = allowedcomments
) {
    override fun uploadvedio(url: String) {

        super.uploadvedio(url)//will call the uploadvedio fun from vediopost class ypu can remove it
        println("Uploaded Ree; $url")
    }
}

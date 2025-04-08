package practice.Downloader

class UrlDownloader(private val fileUrl:String):Downloader {
    override fun download() {
    println("Downloading File From Url$fileUrl")
    }

}
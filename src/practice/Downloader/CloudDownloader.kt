package practice.Downloader

class CloudDownloader(private val cloudPath:String):Downloader {
    override fun download() {
    println("Downloading From Cloud Path $cloudPath")
    }
}
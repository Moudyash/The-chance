package practice.Downloader

class TorrentDownloader(private val torrentFile:String):Downloader {
    override fun download() {
    println("Downloading From Torrent $torrentFile")
    }
}
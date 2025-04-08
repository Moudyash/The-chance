package practice.Downloader

fun main() {
    val fileToDownload: List<Downloader> = listOf(
        UrlDownloader("https://www.googleapis.com/oauth2/v4/token"),
        TorrentDownloader("file.torrent"),
        CloudDownloader("https://www.googleapis.com/oauth2/v4/token"),

        )
    fileToDownload.forEach{file ->
        file.download()
    }
}
import java.lang.Exception
import java.net.URL
import java.util.*

abstract class Video(val title: String)

enum class MovieGenre {
    COMEDY,
    DRAMA,
    CRIMINAL,
    ACTION,
    CARTOON,
    WESTERN,
    HORROR,
    THRILLER
}

class Movie(title: String, val genre: MovieGenre, val date: String) : Video(title)

class YoutubeVideo(title: String, val url: URL) : Video(title)

class TvShowEpisode(title: String, val season: Int, val series: Int) : Video(title)

class PlayList() {
    private var videos: MutableList<Video> = mutableListOf()

    fun addVideo(video: Video) {
        videos.add(video)
    }

    fun playNext() {
        if (videos.isNotEmpty()) {
                println("Playing next video")
                println("Now playing ${videos[0].title}")
                videos.removeAt(0)
        } else {
            println("Playlist is empty")
        }
    }

    fun getAllVideos()  {
        if (videos.isNotEmpty()) {
            println("Playlist:")
            videos.forEach { video ->
                println(video.title)
            }
        }else {
            println("Playlist is empty")}
    }
}

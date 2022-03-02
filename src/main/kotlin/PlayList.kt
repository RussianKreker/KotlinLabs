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
    private val videos: MutableList<Video> = mutableListOf()

    fun addVideo(video: Video) {
        videos.add(video)
    }

    fun playNext() {
        if (videos.isNotEmpty()) {
            videos.removeAt(0)
        } else {
            throw Exception("Playlist is empty")
        }
    }

    fun getAllVideos(): MutableList<Video> {
        return videos
    }
}
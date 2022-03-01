import java.net.URL

fun main() {
//Lab1
//    val text = "Значимость этих проблем настолько очевидна, " +
//            "что постоянное информационно-пропагандистское обеспечение " +
//            "нашей деятельности играет важную роль в формировании систем массового участия. Идейные соображения высшего порядка, " +
//            "а также консультация с широким активом позволяет оценить значение модели развития. Значимость этих проблем настолько очевидна, " +
//            "что начало повседневной работы по формированию позиции позволяет выполнять важные задания по разработке новых предложений. " +
//            "Идейные соображения высшего порядка, а также консультация с широким активом в значительной степени обуславливает создание " +
//            "соответствующий условий активизации. Разнообразный и богатый опыт консультация с широким активом влечет за собой процесс " +
//            "внедрения и модернизации направлений прогрессивного развития."
//
//    println(alignText(text, 120, Alignment.LEFT))
//    println("========================================")
//    println(alignText(text, 120, Alignment.RIGHT))
//    println("========================================")
//    println(alignText(text, 120, Alignment.CENTER))
//=================================================================================================================================================
//task to mark 3
    val movie1 = Movie("Зеленая миля", MovieGenre.DRAMA, "18.04.2000")
    val movie2 = Movie("Криминальное чтиво", MovieGenre.CRIMINAL, "29.09.1995")
    val youTube1 = YoutubeVideo(
        "Американский психопат (вырезанная сцена)",
        URL("https://www.youtube.com/watch?v=lVGqydZpR50&list=FL6WkAzOUR1HTmBmTH2pGS-A&index=6&ab_channel=Sulfate")
    )
    val youTube2 = YoutubeVideo(
        "ПОДБОРКА СТАРЫХ ТРЕКОВ В СТИЛЕ PHONK",
        URL("https://www.youtube.com/watch?v=qvAQGO0K7SY&list=PLOdyl6shVQ0070g4AiXyR_W11EGuqvRsk&index=3&ab_channel=Narashvat")
    )
    val series1 = TvShowEpisode("Рик и Морти", 1, 1)
    val series2 = TvShowEpisode("Голяк", 1, 1)

    val playList = PlayList()
    playList.addVideo(movie1)
    playList.addVideo(movie2)
    playList.addVideo(youTube1)
    playList.addVideo(youTube2)
    playList.addVideo(series1)
    playList.addVideo(series2)

    playList.getAllVideos()
    println("=======================")
    playList.playNext()
    playList.getAllVideos()
    println("=======================")
    playList.playNext()
    playList.getAllVideos()
    println("=======================")
    playList.playNext()
    println("=======================")
    playList.playNext()
    println("=======================")
    playList.playNext()
    playList.getAllVideos()
    println("=======================")
    playList.playNext()
    playList.getAllVideos()
    println("=======================")
    playList.playNext()
}
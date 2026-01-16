class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000
    
    fun printSongInfo() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main() {
    
    val songOne = Song("Scientist", "Coldplay", 2002, 51000)
    songOne.printSongInfo()
    println("Popular: ${songOne.isPopular}.")
}
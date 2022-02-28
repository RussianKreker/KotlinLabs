enum class Alignment {
    LEFT,
    RIGHT,
    CENTER
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String {
    if (lineWidth < 1)
        throw IllegalArgumentException("String width must be more than 0")
    if (text.isEmpty())
        throw IllegalArgumentException("String is empty")
    return when (alignment) {
        Alignment.LEFT -> alignTextLeft(text, lineWidth)
        Alignment.RIGHT -> alignTextRight(text, lineWidth)
        Alignment.CENTER -> alignTextCenter(text, lineWidth)
    }
}

private fun alignTextLeft(
    text: String,
    lineWidth: Int = 120
): String {
    var newText = ""
    val oneLineText = text.replace('\n', ' ')
    var tempString = ""
    var stringComplete = false
    for (word in oneLineText.split(' ')) {
        //if we can add word at the end of line
        if (tempString.isNotEmpty() && word == oneLineText.split(' ')
                .last() && tempString.length + word.length > lineWidth
        ) {
            tempString += " ".repeat((lineWidth - tempString.length))
            tempString += '\n'
            newText += tempString
            tempString = ""
        }
        if ((tempString.length + word.length) <= lineWidth) {
            tempString += if ((tempString.length + word.length) == lineWidth) {
                word
                //not at the end
            } else {
                "$word "
            }
            //we can't add word at the line (it is full)
        } else if (lineWidth - (tempString.length + word.length) < 0 && word.length < lineWidth) {
            stringComplete = true
        }
        //word wider than line width
        if (word.length > lineWidth) {
            //if line is not empty, we're adding it in new next
            if (tempString.isNotEmpty()) {
                tempString += " ".repeat((lineWidth - tempString.length))
                tempString += '\n'
                newText += tempString
                tempString = ""
            }
            //if line is empty start adding symbols
            if (tempString.isEmpty()) {
                word.forEach { symbol ->
                    if (tempString.length + 1 < lineWidth) {
                        tempString += symbol
                    } else {
                        tempString += symbol
                        tempString += '\n'
                        newText += tempString
                        tempString = ""
                    }
                }
            }
            if (tempString.isNotEmpty() && tempString.length < lineWidth) {
                tempString += ' '
            }
        }
        if (tempString.length == lineWidth) {
            tempString += " ".repeat((lineWidth - tempString.length))
            tempString += '\n'
            newText += tempString
            tempString = ""
        }
        //if (tempString.isNotEmpty()&& word==oneLineText.split(' ').last()) {stringComplite=true}
        //if (tempString.isNotEmpty()&& newText.split(' ')+tempString.split(' ')==oneLineText.split(' ')) {stringComplite=true}
        if (stringComplete) {
            tempString += " ".repeat((lineWidth - tempString.length))
            tempString += '\n'
            newText += tempString
            tempString = ""
            tempString += "$word "
            stringComplete = false
        }
    }
    if (tempString.isNotEmpty()) {
        tempString += " ".repeat((lineWidth - tempString.length))
        //tempString += '\n'
        newText += tempString
        tempString = ""
    }
    return newText
}

private fun alignTextRight(
    text: String,
    lineWidth: Int = 120
): String {
    var newText = ""
    val oneLineText = text.replace('\n', ' ')
    var tempString = ""
    var stringComplete = false
    for (word in oneLineText.split(' ')) {
        //if we can add word at the end of line
        if (tempString.isNotEmpty() && word == oneLineText.split(' ')
                .last() && tempString.length + word.length > lineWidth
        ) {
            //tempString += " ".repeat((lineWidth - tempString.length))
            tempString = " ".repeat((lineWidth - tempString.length)) + tempString
            tempString += '\n'
            newText += tempString
            tempString = ""
        }
        if ((tempString.length + word.length) <= lineWidth) {
            if ((tempString.length + word.length) == lineWidth) {
                //word

                stringComplete = true
                //not at the end
            } else {
                tempString += " $word"
            }
            //we can't add word at the line (it is full)
        } else if (lineWidth - (tempString.length + word.length) < 0 && word.length < lineWidth) {
            stringComplete = true
        }
        //word wider than line width
        if (word.length > lineWidth) {
            //if line is not empty, we're adding it in new next
            if (tempString.isNotEmpty()) {
                //tempString += " ".repeat((lineWidth - tempString.length))
                tempString = " ".repeat((lineWidth - tempString.length)) + tempString
                tempString += '\n'
                newText += tempString
                tempString = ""
            }
            //if line is empty start adding symbols
            if (tempString.isEmpty()) {
                word.forEach { symbol ->
                    if (tempString.length + 1 < lineWidth) {
                        tempString += symbol
                    } else {
                        tempString += symbol
                        tempString += '\n'
                        newText += tempString
                        tempString = ""
                    }
                }
            }
            if (tempString.isNotEmpty() && tempString.length < lineWidth) {
                tempString += ' '
            }
        }
        if (tempString.length == lineWidth) {
            //tempString += " ".repeat((lineWidth - tempString.length))
            tempString = " ".repeat((lineWidth - tempString.length)) + tempString
            tempString += '\n'
            newText += tempString
            tempString = ""
        }
        //if (tempString.isNotEmpty()&& word==oneLineText.split(' ').last()) {stringComplite=true}
        //if (tempString.isNotEmpty()&& newText.split(' ')+tempString.split(' ')==oneLineText.split(' ')) {stringComplite=true}
        if (stringComplete) {
            //tempString += " ".repeat((lineWidth - tempString.length))
            tempString = " ".repeat((lineWidth - tempString.length)) + tempString
            tempString += '\n'
            newText += tempString
            tempString = ""
            tempString += " $word"
            stringComplete = false
        }
    }
    if (tempString.isNotEmpty()) {
        tempString = " ".repeat((lineWidth - tempString.length)) + tempString
        //tempString += '\n'
        newText += tempString
        tempString = ""
    }
    return newText
}

private fun alignTextCenter(
    text: String,
    lineWidth: Int = 120
): String {
    var newText = ""
    val oneLineText = text.replace('\n', ' ')
    var tempString = ""
    var stringComplete = false
    for (word in oneLineText.split(' ')) {
        //if we can add word at the end of line
        if (tempString.isNotEmpty() && word == oneLineText.split(' ')
                .last() && tempString.length + word.length > lineWidth
        ) {
            //tempString += " ".repeat((lineWidth - tempString.length))
            //tempString= " ".repeat((lineWidth - tempString.length)) + tempString
            if (lineWidth % tempString.length == 0) {
                tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat((lineWidth - tempString.length)/2)
            } else {
                tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat(1+(lineWidth - tempString.length)/2)
            }
            tempString += '\n'
            newText += tempString
            tempString = ""
        }
        if ((tempString.length + word.length) <= lineWidth) {
            if ((tempString.length + word.length) == lineWidth) {
                //word

                stringComplete = true
                //not at the end
            } else {
                tempString += " $word"
            }
            //we can't add word at the line (it is full)
        } else if (lineWidth - (tempString.length + word.length) < 0 && word.length < lineWidth) {
            stringComplete = true
        }
        //word wider than line width
        if (word.length > lineWidth) {
            //if line is not empty, we're adding it in new next
            if (tempString.isNotEmpty()) {
                //tempString += " ".repeat((lineWidth - tempString.length))
                //tempString= " ".repeat((lineWidth - tempString.length)) + tempString
                if (lineWidth % tempString.length == 0) {
                    tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat((lineWidth - tempString.length)/2)
                } else {
                    tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat(1+(lineWidth - tempString.length)/2)
                }
                tempString += '\n'
                newText += tempString
                tempString = ""
            }
            //if line is empty start adding symbols
            if (tempString.isEmpty()) {
                word.forEach { symbol ->
                    if (tempString.length + 1 < lineWidth) {
                        tempString += symbol
                    } else {
                        tempString += symbol
                        tempString += '\n'
                        newText += tempString
                        tempString = ""
                    }
                }
            }
            if (tempString.isNotEmpty() && tempString.length < lineWidth) {
                tempString += ' '
            }
        }
        if (tempString.length == lineWidth) {
            //tempString += " ".repeat((lineWidth - tempString.length))
            //tempString= " ".repeat((lineWidth - tempString.length)) + tempString
            if (lineWidth % tempString.length == 0) {
                tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat((lineWidth - tempString.length)/2)
            } else {
                tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat(1+(lineWidth - tempString.length)/2)
            }
            tempString += '\n'
            newText += tempString
            tempString = ""
        }
        if (stringComplete) {
            //tempString += " ".repeat((lineWidth - tempString.length))
            //tempString= " ".repeat((lineWidth - tempString.length)) + tempString
            if (lineWidth % tempString.length == 0) {
                tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat((lineWidth - tempString.length)/2)
            } else {
                tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat(1+(lineWidth - tempString.length)/2)
            }
            tempString += '\n'
            newText += tempString
            tempString = ""
            tempString += " $word"
            stringComplete = false
        }
    }
    if (tempString.isNotEmpty()) {
        //tempString = " ".repeat((lineWidth - tempString.length)) + tempString
        if (lineWidth % tempString.length == 0) {
            tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat((lineWidth - tempString.length)/2)
        } else {
            tempString = " ".repeat((lineWidth - tempString.length)/2)+tempString+" ".repeat(1+(lineWidth - tempString.length)/2)
        }
        //tempString += '\n'
        newText += tempString
        tempString = ""
    }
    return newText
}
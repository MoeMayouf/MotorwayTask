package com.mayouf.motorwaytest.utils

fun String.countWords(): Int {
    //Split String by Space
    val strArray = this.split(" ".toRegex()).toTypedArray() // Spilt String by Space
    var count = 0

    //iterate String array
    for (s in strArray) {
        if (s != "") {
            //Increase Word Counter
            count++
        }
    }
    return count
}
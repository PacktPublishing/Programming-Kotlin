package com.programming.kotlin.chapter03

class Rectangular : Shape() {
    override fun isHit(x: Int, y: Int): Boolean {
        return x >= XLocation && x <= (XLocation + Width) && y >= YLocation && y <= YLocation + Height
    }
}
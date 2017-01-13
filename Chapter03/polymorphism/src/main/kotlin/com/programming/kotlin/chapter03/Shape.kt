package com.programming.kotlin.chapter03

abstract class Shape protected constructor() {
    private var _xLocation:Int = 0
    private var _yLocation:Int = 0
    private var _width:Int = 0
    private var _height:Int = 0

    var XLocation: Int
        get() = this._xLocation
        set(value: Int) {
            this._xLocation = value
        }

    var YLocation: Int
        get() = this._yLocation
        set(value: Int) {
            this._yLocation = value
        }

    var Width: Int
        get() = this._width
        set(value: Int) {
            this._width = value
        }

    var Height: Int
        get() = this._height
        set(value: Int) {
            this._height = value
        }

    abstract fun isHit(x: Int, y: Int): Boolean

}
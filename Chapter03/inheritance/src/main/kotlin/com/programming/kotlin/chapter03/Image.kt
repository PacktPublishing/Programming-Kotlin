package com.programming.kotlin.chapter03

import java.io.OutputStream

open class Image {
    open fun save(output: OutputStream) {
        println("Some logic to save an image")
    }
}

interface VendorImage {
    fun save(output: OutputStream) {
        println("Vendor saving an image")
    }
}

class PNGImage : Image(), VendorImage {
    override fun save(output: OutputStream) {
        super<VendorImage>.save(output)
        super<Image>.save(output)
    }
}
package com.furkan.marvel.utils

import com.furkan.marvel.models.Comics


public class Globals {

    companion object {
        private var instance: Globals? = null

        val shared: Globals
            get() {
                if (instance == null) {
                    instance = Globals()
                }

                return instance!!
            }
    }


    var Comics : Comics? = null
}
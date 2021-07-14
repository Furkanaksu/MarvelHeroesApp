package com.furkan.marvel.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkan.marvel.models.User
import com.furkan.marvel.service.RetrofitInstance
import com.furkan.marvel.service.callback
import com.google.gson.Gson
import kotlinx.coroutines.launch

private const val TAG = "User View Model"
private const val API_KEY = "7608f465047baeb5b3241b656e69c654"
private const val HASH = "0c37b1ce6b7745eaa3760a76d5b431bc"
private const val TS = "1"
private const val LIMIT_CHARACTERS = "30"
private const val LIMIT_COMICS = "10"
private var offset = 0
class UserViewModel : ViewModel() {

    private var _users = MutableLiveData<User>()
    val users: LiveData<User>
        get() = _users

    fun getData() {
        viewModelScope.launch {
            try {
                val call = RetrofitInstance.Run().getCharacters(TS, API_KEY, HASH, LIMIT_CHARACTERS, offset)
                call?.enqueue(callback({ response ->

                    response?.body()?.let {
                        Log.e("plainBody" ,"${it}")

                        val plainBody = it
                        val responseConvert: User = Gson().fromJson(plainBody, User::class.java)
                        _users.value = responseConvert
                    }
                },
                    { throwable ->
                        throwable?.let {
                            var errors = ArrayList<String>()
                            errors.add(it.localizedMessage)
                        }
                    }
                ))
            } catch (e: Exception) {
                Log.e("denemeee2" ,"${e.message}")
            }
        }
    }
}
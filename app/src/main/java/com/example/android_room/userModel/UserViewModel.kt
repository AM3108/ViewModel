package com.example.android_room.userModel

import android.app.Application
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android_room.model.User
import com.example.android_room.data.UserDatabase
import com.example.android_room.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random


class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(
            application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }


    //Colour

    private val colorArray = arrayOf(
        Color.BLACK,
        Color.BLUE,
        Color.DKGRAY,
        Color.GRAY,
        Color.GREEN,
        Color.MAGENTA
    )

    var colour = colorArray[0]


    //Setting Background
    fun changeBackgroundColor() {
        colour = colorArray[randomNumberGenerator()]
    }

    // Generate random number
    private fun randomNumberGenerator(): Int {
        val startRange = 0
        val endRange = colorArray.size
        return Random.nextInt(startRange, endRange)
    }



}
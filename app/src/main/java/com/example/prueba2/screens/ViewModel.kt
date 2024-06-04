package com.example.prueba2.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba2.Network.Api

import com.example.prueba2.model.FactsQuery
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.awaitResponse



class MarsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */

    var factsQueryResult by mutableStateOf<FactsQuery?>(null)
        private set
    private val _textList = mutableStateListOf<String>()

    val listFav: SnapshotStateList<String> get() = _textList
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {

    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun addText(text: String) {
        if (text.isNotEmpty()&& !_textList.contains(text)) {
            _textList.add(text)
        }
    }
    fun getTextList(): List<String> {
        return _textList.toList()
    }

    fun fetchJokes(query: String) {
        viewModelScope.launch {
            try {
                val response = Api.retrofitService.getUsers(query).awaitResponse()
                if (response.isSuccessful) {
                    factsQueryResult = response.body()
                } else {
                    // Manejar error de la respuesta
                }
            } catch (e: Exception) {
                // Manejar error de la llamada
            }
        }
    }
}

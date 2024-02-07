package com.example.analayzermobile.design

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class PlacesScreenViewModel: ViewModel() {

    private val _titulo = MutableStateFlow("")
    val titulo: StateFlow<String> = _titulo

    fun cuandoClickeEnUnElemento(nombre: String){
        _titulo.value = nombre
    }

}
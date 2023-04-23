package org.apphatchery.training.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.apphatchery.training.data.local.MessageEntity
import org.apphatchery.training.domain.repository.Repository
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun delete(messageEntity: MessageEntity) {
        viewModelScope.launch {
            repository.delete(messageEntity)
        }
    }

    fun upsert(messageEntity: MessageEntity) {
        viewModelScope.launch {
            repository.upsert(messageEntity)
        }
    }

    fun query() {
        viewModelScope.launch {
            repository.query()
        }
    }

}
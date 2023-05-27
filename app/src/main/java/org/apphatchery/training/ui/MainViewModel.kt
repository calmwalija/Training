package org.apphatchery.training.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.apphatchery.training.data.local.comment.CommentEntity
import org.apphatchery.training.data.local.comment.CommentRepositoryImpl
import org.apphatchery.training.domain.repository.BaseRepo
import org.apphatchery.training.domain.repository.Repository
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: BaseRepo
) : ViewModel() {

    private val repository = repo.p0

    fun delete(p0: CommentEntity) {
        viewModelScope.launch {
            repository.delete(p0)
        }
    }

    fun upsert(p0: CommentEntity) {
        viewModelScope.launch {
            repository.upsert(p0)
        }
    }

    val query = repository.query()

}
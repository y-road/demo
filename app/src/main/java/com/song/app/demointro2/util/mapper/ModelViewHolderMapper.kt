package com.song.app.demointro2.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.song.app.demointro2.databinding.ViewholderEmptyBinding
import com.song.app.demointro2.model.CellType
import com.song.app.demointro2.model.Model
import com.song.app.demointro2.screen.base.BaseViewModel
import com.song.app.demointro2.util.provider.ResourcesProvider
import com.song.app.demointro2.widget.adapter.viewholder.EmptyViewHolder
import com.song.app.demointro2.widget.adapter.viewholder.ModelViewHolder

object ModelViewHolderMapper {
    @Suppress("UNCHECKED_CAST")
    fun <M: Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
    ): ModelViewHolder<M> {
       val inflater = LayoutInflater.from(parent.context)
       val viewHolder = when(type) {
           CellType.EMPTY_CELL -> EmptyViewHolder(
               ViewholderEmptyBinding.inflate(inflater, parent, false),
               viewModel,
               resourcesProvider
           )
       }
        return viewHolder as ModelViewHolder<M>
    }
}

package guri.projects.a7minworkout

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history-table")
data class HistoryEntity(
    @PrimaryKey
    val dat:String
)

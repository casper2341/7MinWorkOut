package guri.projects.a7minworkout

import android.app.Application

class WorkOutApp: Application()
{
    val db by lazy{
        HistoryDatabase.getInstance(this)
    }
}
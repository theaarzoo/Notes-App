package com.kotlinproject.notes.mvp.model

import com.kotlinproject.notes.utils.formatDate
import com.reactiveandroid.Model
import com.reactiveandroid.annotation.Column
import com.reactiveandroid.annotation.PrimaryKey
import com.reactiveandroid.annotation.Table
import java.util.*

@Table(name = "Notes", database = AppDatabase::class)
class Note : Model {

    @PrimaryKey
    var id: Long = 0
    @Column(name = "title")
    var title: String? = null
    @Column(name = "text")
    var text: String? = null
    @Column(name = "created_at")
    var createAt: Date? = null
    @Column(name = "change_at")
    var changedAt: Date? = null
    @Column(name = "for_date")
    var forDate: Date? = null

    constructor(title: String, createDate: Date, forDate: Date) {
        this.title = title
        this.createAt = createDate
        this.changedAt = createDate
        this.forDate = forDate
    }

    constructor()

    fun getInfo(): String = "Title: $title\n" +
            "Date: ${formatDate(forDate)}"

}
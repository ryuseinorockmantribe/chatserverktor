package com.plcoding.di

import com.plcoding.data.MessageDataSource
import com.plcoding.data.MessageDataSourceImpl
import com.plcoding.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo



val connectionString = "mongodb://naisho:naisho2011@172.16.0.1:27017"


val mainModule = module {
    single {
        KMongo.createClient(connectionString)
            .coroutine
            .getDatabase("message_db_yt")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}
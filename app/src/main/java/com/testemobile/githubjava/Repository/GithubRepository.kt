package com.testemobile.githubjava.Repository

import android.content.Context
import com.testemobile.githubjava.Model.ItemsModelRepo

class GithubRepository(context: Context) {

    private val base = AppDataBase.getDatabase(context).ItemDAO()

    fun save (items: ItemsModelRepo):Boolean{
        return base.save(items)>0
    }

     fun update(id: ItemsModelRepo): Int {
       return base.update(id)
    }

//     fun get(id: Int): Int {
//         return base.update(id)
//    }

         fun listAll(): List<ItemsModelRepo> {
         return base.listAll()
    }

}
package br.com.progdeelite.kmmprogdeelite.providers

import br.com.progdeelite.kmmprogdeelite.database.Database
import br.com.progdeelite.kmmprogdeelite.database.createSqlDriver

class DataSourceProvider {
    private val database = Database(createSqlDriver())

    fun getLocalCommonDatabase() = database

//    Outros provedores de dados que voce poderia ter aqui mais pra frente
//    fun getXyzRepository()
//    fun getXyzUseCase()
}
package br.com.progdeelite.kmmprogdeelite.utils

// 1) COMO CRIAR UM LOGGER CUSTOMIZADO EM KMM
// 2) COMO IMPLEMENTAR EXPECT/ACTUAL EM INTERFACE
// 3) COMO DISPONIBILIZAR A CLASSE IMPL
// 4) COMO USAR NA PRÁTICA DENTRO DO VIEW MODEL
expect interface CommonLogger {
    open fun log(message:String, type: LogType)
}
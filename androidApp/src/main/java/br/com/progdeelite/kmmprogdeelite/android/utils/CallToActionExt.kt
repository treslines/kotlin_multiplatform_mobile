package br.com.progdeelite.kmmprogdeelite.android.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import br.com.progdeelite.kmmprogdeelite.utils.CallToAction

// 1) COMO CRIAR UMA CLASSE DE CALL TO ACTION COMPARTILHADA
// 2) COMO ABRIR APENAS AS OPCÕES DE EMAIL INSTALADOS NO APP
// 3) COMO SIMPLIFICAR UM TRY-CATCH EM KOTLIN

fun openEmail(context: Context, emailContext: CallToAction.Email, errorMessage: String) {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailContext.address.localized))
    intent.putExtra(Intent.EXTRA_SUBJECT, emailContext.subject.localized)
    // COMO SIMPLIFICAR ISSO AQUI EM KOTLIN? EXTRAIR MÉTODO?
    runCatching {
        context.startActivity(Intent.createChooser(intent, "Email"))
    }.onFailure { _: Throwable ->
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }
}

fun callSupport(context: Context, callContext: CallToAction.Call, errorMessage: String) {
    val phoneUri = Uri.parse("tel:${callContext.number.localized}")
    val phoneIntent = Intent(Intent.ACTION_DIAL, phoneUri)
    runCatching {
        context.startActivity(phoneIntent)
    }.onFailure { _: Throwable ->
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }
}

// PARA RE-USAR EM NOS MÉTODOS ACIMA
private fun runCatching(
    context: Context,
    intentTitle:String? = null,
    intent:Intent,
    errorMessage:String
){
    runCatching {
        when(intentTitle){
            null -> context.startActivity(intent)
            else -> context.startActivity(Intent.createChooser(intent, intentTitle))
        }
    }.onFailure {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }
}
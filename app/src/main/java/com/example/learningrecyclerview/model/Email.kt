package com.example.learningrecyclerview.model

//Classe construtora dos emails.
data class Email(
    val user: String,
    val subject: String,
    val preview: String,
    val date: String,
    val stared: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

//Responsavel por criar modelo dos emails.
class EmailBuilder{

    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var date: String = ""
    var stared: Boolean = false
    var unread: Boolean = false


    fun build(): Email = Email(user, subject, preview, date, stared, unread, false)
}

//função para gerenciar e prover os emails.
fun email(block: EmailBuilder.() -> Unit): Email =  EmailBuilder().apply(block).build()

//Função com os emails falsos gerados para aplicar na recyclerView
fun fakeEmails(): MutableList<Email> = mutableListOf(
    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para voce conseguir"
        preview = "Olá tiago, você precisa ver esse site para"
        date = "01 Out"
        stared = false
    }, email {
        user = "Facebook"
        subject = "Um amigo quer que você curta uma Página dele"
        preview = "Fulano convidou você para curtir a sua página"
        date = "02 Out"
        stared = false
    }, email {
        user = "YouTube"
        subject = "Tiago Aguiar acabou de enviar um video"
        preview = "Tiago Aguiar enviou ANDROID: GOOGLE MAPS, LOCATION"
        date = "04 Out"
        stared = false
    }, email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais"
        preview = "Olá tiago, você precisa ver esse site para"
        date = "09 Out"
        stared = false
    },    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para voce conseguir"
        preview = "Olá tiago, você precisa ver esse site para"
        date = "01 Out"
        stared = false
    }, email {
        user = "Facebook"
        subject = "Um amigo quer que você curta uma Página dele"
        preview = "Fulano convidou você para curtir a sua página"
        date = "02 Out"
        stared = false
    }, email {
        user = "YouTube"
        subject = "Tiago Aguiar acabou de enviar um video"
        preview = "Tiago Aguiar enviou ANDROID: GOOGLE MAPS, LOCATION"
        date = "04 Out"
        stared = false
    }, email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais"
        preview = "Olá tiago, você precisa ver esse site para"
        date = "09 Out"
        stared = false
    }
)




package com.example.learningrecyclerview

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.learningrecyclerview.model.Email

class EmailAdapter(val emails: MutableList<Email>): RecyclerView.Adapter<EmailAdapter.EmailViewHolder>(){


    //Metodo que vai inflar o Layout XML ja criado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    //Metodo para manipular a posição da lista e manipular
    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    //Quantidade de elementos da minha lista
    override fun getItemCount(): Int = emails.size

    inner class EmailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      fun bind(email: Email){
          with(email){
              val hash = user.hashCode()
              val icon = itemView.findViewById<TextView>(R.id.txt_icon)

              icon.text = user.first().toString()
              icon.background = itemView.oval(Color.rgb(hash, hash / 2 , 0))
              itemView.findViewById<TextView>(R.id.txt_user).text = user
              itemView.findViewById<TextView>(R.id.txt_subject).text = subject
              itemView.findViewById<TextView>(R.id.txt_preview).text = preview
              itemView.findViewById<TextView>(R.id.txt_date).text = date

              itemView.findViewById<TextView>(R.id.txt_user).setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)
              itemView.findViewById<TextView>(R.id.txt_subject).setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)
              itemView.findViewById<TextView>(R.id.txt_date).setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)

              itemView.findViewById<ImageView>(R.id.img_star).setImageResource(
                  if (stared) R.drawable.ic_baseline_star_24
                    else R.drawable.ic_baseline_star_border_24)
          }
      }
    }

}

fun View.oval(@ColorInt color: Int): ShapeDrawable{
    val oval = ShapeDrawable(OvalShape())
    with(oval){
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}
package com.example.a30daysofcartips.data

import com.example.a30daysofcartips.R
import com.example.a30daysofcartips.model.Tip

class Datasource {
    fun loadTips(): List<Tip> {
        return listOf(
            Tip(
                R.string.tip1_day,
                R.string.tip1_titulo,
                R.string.tip1_conteudo,
                R.drawable.tip1
            ),
            Tip(
                R.string.tip2_day,
                R.string.tip2_titulo,
                R.string.tip2_conteudo,
                R.drawable.tip2
            ),
            Tip(
                R.string.tip3_day,
                R.string.tip3_titulo,
                R.string.tip3_conteudo,
                R.drawable.tip3
            ),
            Tip(
                R.string.tip4_day,
                R.string.tip4_titulo,
                R.string.tip4_conteudo,
                R.drawable.tip4
            ),
            Tip(
                R.string.tip5_day,
                R.string.tip5_titulo,
                R.string.tip5_conteudo,
                R.drawable.tip5
            ),
            Tip(
                R.string.tip6_day,
                R.string.tip6_titulo,
                R.string.tip6_conteudo,
                R.drawable.tip6
            ),
            Tip(
                R.string.tip7_day,
                R.string.tip7_titulo,
                R.string.tip7_conteudo,
                R.drawable.tip7
            ),
            Tip(
                R.string.tip8_day,
                R.string.tip8_titulo,
                R.string.tip8_conteudo,
                R.drawable.tip8
            ),
            Tip(
                R.string.tip9_day,
                R.string.tip9_titulo,
                R.string.tip9_conteudo,
                R.drawable.tip9
            ),
            Tip(
                R.string.tip10_day,
                R.string.tip10_titulo,
                R.string.tip10_conteudo,
                R.drawable.tip10
            ),
        )
    }
}
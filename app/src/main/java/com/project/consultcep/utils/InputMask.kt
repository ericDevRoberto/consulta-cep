package com.project.consultcep.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Coloca os pontos e traços desejados
 * Aplicação dos simbolos: "(", ")", ".", "/", "*", "-"
 * Em Res.Values.String tem os tipos disponiveis e a possibilidade de adicionar mais outros
 */
const val MASK_CEP = "#####-###"

class InputMask {

    companion object {

        fun mask(mask: String, etCpf: EditText, action: (() -> Unit)? = null): TextWatcher =
            object : TextWatcher {
                var isUpdating: Boolean = false
                var oldString: String = ""
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val str = replaceChars(s.toString())
                    var cpfWithMask = ""

                    if (count == 0)
                        isUpdating = true

                    if (isUpdating) {
                        oldString = str
                        isUpdating = false
                        return
                    }

                    var i = 0
                    for (m: Char in mask.toCharArray()) {
                        if (m != '#' && str.length > oldString.length) {
                            cpfWithMask += m
                            continue
                        }
                        try {
                            cpfWithMask += str[i]
                        } catch (e: Exception) {
                            break
                        }
                        i++
                    }

                    isUpdating = true
                    etCpf.setText(cpfWithMask)
                    etCpf.setSelection(cpfWithMask.length)
                    if (s.length == 9)
                        action?.invoke()
                }

                override fun afterTextChanged(editable: Editable) {}
            }

        private fun replaceChars(cpfFull: String): String = cpfFull
            .replace(".", "").replace("-", "")
            .replace("(", "").replace(")", "")
            .replace("/", "").replace(" ", "")
            .replace("*", "")
    }
}
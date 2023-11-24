package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.ap2_devmobile_faculdade.MainActivity3
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val perguntas = arrayOf("Por quanto tempo você pretende deixar seu dinheiro investido?", " Qual o objetivo desse investimento? ", "Qual das alternativas melhor classi\u001Fca sua formação e experiência com\n" +
            " o mercado financeiro?", "Como está distribuído o seu patrimônio?", "Em relação as aplicações e rendimentos, em qual dessas situações você\n" +
            " se enquadra?", "Qual sua faixa de renda mensal média?")
    private val respostas = arrayOf(arrayOf("Menos de 6 meses", "Entre 6 meses e 1 ano", "Entre 1 ano e 3 anos", "Acima de 3 anos"), arrayOf("Preservação do capital para não perder valor ao longo do tempo assumindo baixos riscos de perdas",
        "Aumento gradual do capital ao longo do tempo, assumindo riscos moderados", "Aumento do capital acima da taxa de retorno média do mercado, mesmo que isso implique assumir riscos de perdas elevadas", "Obter no curto prazo retornos elevados e significativamente acima da taxa de retorno média do mercado, assumindo riscos elevados"),
        arrayOf("Não possuo formação acadêmica ou conhecimento do mercado financeiro",
            "Possuo formação acadêmica na área financeira, mas não tenho experiência",
            "com o mercado financeiro",
            "Possuo formação acadêmica em outra área, mas possuo conhecimento do mercado financeiro",
            "Possuo formação acadêmica na área financeira ou pleno conhecimento do mercado financeiro"), arrayOf("Meu patrimônio não está aplicado ou está todo aplicado em renda fixa e/ou imóveis", "Menos de 25% em renda variável e o restante em renda fixa e/ou imóveis", "Entre 25,01 e 50% aplicado em renda variável e o restante em renda fixa e/ou imóveis", "Acima de 50% em renda variável "),
        arrayOf("Conto com o rendimento dessas aplicações para complementar minha renda mensal",
            "Eventualmente posso resgatar parte das aplicações para fazer frente aos meus gastos. Contudo, não tenho intenção de resgatar no curto prazo e pretendo fazer aplicações regulares",
            "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar novas aplicações",
            "d Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer aplicações regulares"), arrayOf("Até R$ 1.000", "De R$ 1.001 até R$ 5.000", "De R$ 5.001 até R$ 10.000",
            "Acima de R$ 10.000"))
    private val valorRespostas = arrayOf(0, 2, 3, 4)

    private var perguntaAtual = 0

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayPerguntas()

        binding.button.setOnClickListener{
            checarResposta(0)
        }

        binding.button2.setOnClickListener {
            checarResposta(1)
        }

        binding.button3.setOnClickListener {
            checarResposta(2)
        }

        binding.button4.setOnClickListener {
            checarResposta(3)
        }


    }

    private fun displayPerguntas() {
        binding.textView.text = perguntas[perguntaAtual]
        binding.button.text = respostas[perguntaAtual][0]
        binding.button2.text = respostas[perguntaAtual][1]
        binding.button3.text = respostas[perguntaAtual][2]
        binding.button4.text = respostas[perguntaAtual][3]
    }

    private fun testePerfil(): String{
        if (score <= 7) {
            return "conservador"
        } else if (score >= 8 && score > 18) {
            return "moderado"
        } else {
            return "Arrojado"
        }
    }

    private fun mostrarResultados() {
        Toast.makeText(this, "Sua pontuação é: $score. Você é um investidos ${testePerfil()}.", Toast.LENGTH_LONG).show()
    }

    private fun checarResposta(resposta: Int) {
        score += valorRespostas[resposta]
        if (perguntaAtual < perguntas.size - 1 ) {
            perguntaAtual++
            binding.textView.postDelayed({displayPerguntas()}, 1000)
        } else {
            mostrarResultados()
            val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }
        }
    }
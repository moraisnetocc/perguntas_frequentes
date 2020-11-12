package br.com.scuad.snowtest.data

import br.com.scuad.snowtest.domain.models.Query

class FakeQueryRepository() {

    fun loadInitialQueries() = listOf(
        Query(
            "Em qual data foi fundada a Snowman Labs?",
            "A Snowman Labs foi fundada no dia 9 de agosto de 2012.",
            Query.COLOR.GREEN
        ),
        Query(
            "Qual foi o primeiro cliente/ projeto que a Snow teve?",
            "O primeiro cliente que a Snow teve foi um candidato a deputado federal e fizemos o projeto dos santinhos digitais. Foi entregue em setembro de 2012.",
            Query.COLOR.YELLOW
        ),
        Query(
            "Por que foi escolhido o nome Snowman Labs?",
            "Por conta da neve em Curitiba que ocorreu em 2013. Queríamos um mascote e a partir dele, surgiu o nome (foi a primeira coisa que pensamos na época).",
            Query.COLOR.BLUE
        ),
        Query(
            "Quantos funcionários a Snow tinha no primeiro ano de existência?",
            "Em nosso primeiro ano éramos apenas 7 funcionários.",
            Query.COLOR.YELLOW
        ),
        Query(
            "Qual é o propósito da Snowman Labs?",
            "Servir e impactar pessoas através de tecnologia e design.",
            Query.COLOR.RED
        ),
        Query(
            "Qual é a missão da Snowman Labs?",
            "Criar soluções que promovam a transformação e evolução digital dos nossos clientes, gerando negócios, resultados e impactando positivamente pessoas e processos.",
            Query.COLOR.BLUE
        ),
        Query(
            "Qual é a visão da Snowman Labs?",
            "Ampliar exponencialmente o potencial das empresas e das pessoas através de design e tecnologia.",
            Query.COLOR.BLUE
        ),
        Query(
            "Quais são os princípios e valores da Snowman Labs?",
            "Fé - que guia as nossas ações \n Qualidade - que nos move sempre a darmos o nosso melhor \n Transparência - que constrói a confiança \n Respeito - que honra as pessoas \nRelacionamento - que nos torna uma família \nComprometimento - que nos faz andar mais uma milha \nImpacto - que cria esperança",
            Query.COLOR.RED
        ),
        Query(
            "Quais stacks são utilizadas na Snowman Labs?",
            "A Snow trabalha com diferentes stacks e tecnologias, entre elas estão Java/Kotlin para Android nativo, Swift para iOS, Flutter/Dart, Python, .NET, VueJS, NodeJS…",
            Query.COLOR.BLUE
        ),
        Query(
            "A Snow é aberta à novas idéias e tecnologias?",
            "Sim! A Snow está sempre buscando se manter atualizada sobre novas tecnologias e sempre está aberta à novas ideias e sugestões. Fomos umas das primeiras em Curitiba a adotar o Flutter para projetos em produção e estamos sempre buscando por inovações e melhorias.)",
            Query.COLOR.GREEN
        )
    )

}
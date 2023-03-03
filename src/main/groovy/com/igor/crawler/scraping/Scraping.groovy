package com.igor.crawler.scraping

import groovy.transform.TypeChecked
import groovyx.net.http.HttpBuilder
import groovyx.net.http.optional.Download
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

@TypeChecked
class Scraping {
    static Document pegaPagina(String url) {
        return HttpBuilder.configure {
            request.uri = url
        }.get() as Document
    }

    static void downloadArquivo(String url, String nomeArquivo) {

        // Cria pasta Downloads
        File downloads = new File("./Downloads")
        downloads.mkdir()
        // Cria arquivo
        File arquivo = new File("./Downloads/${nomeArquivo}")

        // Baixa arquivo
        HttpBuilder.configure {
            request.uri = url
        }.get { Download.toFile(delegate, arquivo) }
    }

    static List<Map> tabelaHistoricoVersoes() {
        // Pega pagina
        Document pagina = pegaPagina(PegaLink.historicoVersoes())
        // Pega tabela
        Element tabela = pagina.getElementById('parent-fieldname-text')
        // Pega linhas
        List<Element> linhas = tabela.getElementsByTag('tr')
        linhas.remove(0)

        List<Map> dados = []

        // Pega dados
        linhas.each { linha ->
            // Pega colunas
            List<Element> colunas = linha.getElementsByTag('td')
            // Competencia
            String competencia = colunas[0].text()
            // Pegar ano
            int ano = competencia.split('/')[1].toInteger()
            if (ano >= 2016) {
                // Publicacao
                String publicacao = colunas[1].text()
                // Inicio de Vigencia
                String inicioVigencia = colunas[2].text()

                // Adiciona dados
                dados.add([
                    competencia: competencia,
                    publicacao: publicacao,
                    inicioVigencia: inicioVigencia
                ])
            }
        }
        return dados
    }
}
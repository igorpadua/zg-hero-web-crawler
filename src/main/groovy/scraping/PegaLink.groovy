package scraping

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class PegaLink {

    String linkTiss() {
        // Pega a página do site da ANS
        Document page = Scraping.pegaPagina('https://www.gov.br/ans/pt-br')
        // Pega a div que tem o Espaço do Prestador de Serviços de Saúde
        Element element = page.getElementById('ce89116a-3e62-47ac-9325-ebec8ea95473')
        // Pega o link do Espaço do Prestador de Serviços de Saúde
        String link = element.getElementsByTag('a').attr('href')

        // Pega a página do Espaço do Prestador de Serviços de Saúde
        Document page2 = Scraping.pegaPagina(link)
        // Pega a div que tem o link do TISS
        Element element2 = page2.getElementsByClass('card').first()
        // Pega o link do TISS
        String link2 = element2.getElementsByTag('a').attr('href')

        return link2
    }
}

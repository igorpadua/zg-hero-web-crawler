package com.igor.crawler

import com.igor.crawler.scraping.PegaLink
import groovy.transform.TypeChecked
import com.igor.crawler.scraping.Scraping
import com.igor.crawler.DAO.criaCSV

@TypeChecked
static void main(String[] args) {
    // 1. Baixa arquivo Componente de Comunicação
    Scraping.downloadArquivo(PegaLink.linkVersaoMesAno(), 'padrao-de-comunicao-TISS.zip')
    // 2. Tabela histórico de versões
    List<Map> tabelaHistoricoVersoes = Scraping.tabelaHistoricoVersoes()
    // Criar CSV
    criaCSV.historicoCsv(tabelaHistoricoVersoes)
    // 3. Baixa tabela de erros no envio para a ANS
    Scraping.downloadArquivo(PegaLink.tabelaRelacionaisErrosAns(), 'padrao-tiss-tabela-erros-envio-para-ans-padrao-tiss-08022019.xlsx')
}

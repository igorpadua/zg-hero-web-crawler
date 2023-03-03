package com.igor.crawler

import groovy.transform.TypeChecked
import com.igor.crawler.scraping.Scraping
import com.igor.crawler.DAO.criaCSV

@TypeChecked
static void main(String[] args) {
    // 1. Baixa arquivo Componente de Comunicação
    // Scraping.downloadArquivo(PegaLink.linkVersaoMesAno(), 'PadroTISSComunicacao202301.zip')
    // 2. Tabela histórico de versões
    List<Map> tabelaHistoricoVersoes = Scraping.tabelaHistoricoVersoes()
    // Criar CSV
    criaCSV.historicoCsv(tabelaHistoricoVersoes)
}

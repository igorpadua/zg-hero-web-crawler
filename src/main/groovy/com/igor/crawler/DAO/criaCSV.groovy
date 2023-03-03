package com.igor.crawler.DAO

class criaCSV {
    static void historicoCsv(List dados) {
        // Cria pasta CSV
        File csv = new File("./Downloads")
        csv.mkdir()
        // Cria arquivo
        File arquivo = new File("./Downloads/HistoricoVersoes.csv")
        // Cria CSV
        arquivo.withWriter { writer ->
            writer << "Competencia,Publicacao,Inicio de Vigencia"
            dados.each { dado ->
                writer << "\n${dado.competencia},${dado.publicacao},${dado.inicioVigencia}"
            }
        }
    }
}

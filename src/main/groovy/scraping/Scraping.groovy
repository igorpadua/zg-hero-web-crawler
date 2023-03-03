package scraping

import groovy.transform.TypeChecked
import groovyx.net.http.HttpBuilder
import groovyx.net.http.optional.Download
import org.jsoup.nodes.Document

@TypeChecked
class Scraping {
    static Document pegaPagina(String url) {
        return HttpBuilder.configure {
            request.uri = url
        }.get() as Document
    }

    static void downloadArquivo(String url, String nomeArquivo) {

        File downloads = new File("./Downloads")
        downloads.mkdir()
        File arquivo = new File("./Downloads/${nomeArquivo}")

        HttpBuilder.configure {
            request.uri = url
        }.get { Download.toFile(delegate, arquivo)}
    }

}

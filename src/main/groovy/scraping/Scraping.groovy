package scraping

import groovy.transform.TypeChecked
import groovyx.net.http.HttpBuilder
import org.jsoup.nodes.Document

@TypeChecked
class Scraping {
    static Document pegaPagina(String url) {
        return HttpBuilder.configure {
            request.uri = url
        }.get() as Document
    }

}

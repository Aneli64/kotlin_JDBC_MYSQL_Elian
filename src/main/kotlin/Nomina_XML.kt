import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

class Nomina_XML {
    companion object{
        fun guardarDocumentoXML(doc: Document, nombreArchivo: String) {
            val transformerFactory = TransformerFactory.newInstance()
            val transformer: Transformer = transformerFactory.newTransformer()
            transformer.setOutputProperty("indent", "yes") // Habilitar la indentación
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2") // Espacios de indentación
            val source = DOMSource(doc)
            val result = StreamResult(File(nombreArchivo))
            transformer.transform(source, result)
            println("Archivo XML guardado como $nombreArchivo")
        }

        fun objetosToXML(listaNominas: MutableList<Nomina>, doc: Document){
            val rootElement: Element = doc.createElement("nomina")
            doc.appendChild(rootElement)

            val root = doc.documentElement
            val elementos = root.getElementsByTagName("barcos")


            val elemento1: Element = doc.createElement("elemento1")
            elemento1.setAttribute("atributo", "valor1")
            elemento1.appendChild(doc.createTextNode("Contenido del elemento 1"))
            rootElement.appendChild(elemento1)

        }
    }
}
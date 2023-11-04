import org.w3c.dom.Document
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

class Nomina_XML {
    companion object {
        private fun guardarDocumentoXML(doc: Document, nombreArchivo: String) {
            val transformerFactory = TransformerFactory.newInstance()
            val transformer: Transformer = transformerFactory.newTransformer()
            transformer.setOutputProperty("indent", "yes") // Habilitar la indentación
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2") // Espacios de indentación
            val source = DOMSource(doc)
            val result = StreamResult(File(nombreArchivo))
            transformer.transform(source, result)
            println("Archivo XML guardado como $nombreArchivo")
        }

        fun objetosToXML(listaNominas: MutableList<Nomina>) {
            //Datos necesarios para crear nuestro File
            val xml = File("Nomina.xml")
            val instancia = DocumentBuilderFactory.newInstance()
            val constr = instancia.newDocumentBuilder()
            val doc = constr.parse(xml)

            val nombEmp = doc.createElement("nomb_emp")
            val apeEmp = doc.createElement("ape_emp")
            val nEmp = doc.createElement("n_emp")
            val salBase = doc.createElement("sal_base")
            val hsTrab = doc.createElement("hs_trab")
            val deducc = doc.createElement("deducc")
            val fechPag = doc.createElement("fech_pag")

            //val listaAtrib = listOf(nombEmp, apeEmp, nEmp, salBase, hsTrab, deducc, fechPag)

            for (i in listaNominas.indices) {
                //Etiquetas de nuestro file que hacen referencia al objeto Nomina()
                val nominaElm = doc.createElement("nomina")
                doc.documentElement.appendChild(nominaElm)

                /*nominaElm.appendChild(nombEmp)
                nombEmp.textContent = listaNominas[i].nomb_emp*/


            }





            guardarDocumentoXML(doc, "Nomina.xml")


        }
    }
}
package Controlador

import Modelo.Nomina
import org.w3c.dom.Document
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

class Nomina_XML {
    companion object {
        private fun guardarDocumentoXML(doc: Document, fileName: String) {
            val transformerFactory = TransformerFactory.newInstance()
            val transformer: Transformer = transformerFactory.newTransformer()
            transformer.setOutputProperty("indent", "yes") // Habilitar la indentación
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2") // Espacios de indentación
            val source = DOMSource(doc)
            val result = StreamResult(File(fileName))
            transformer.transform(source, result)
            println("Archivo XML guardado como $fileName")
        }

        fun objetosToXML(listaNominas: MutableList<Nomina>) {
            //Datos necesarios para crear nuestro File
            val xml = File("Modelo.Nomina.xml")
            val instancia = DocumentBuilderFactory.newInstance()
            val constr = instancia.newDocumentBuilder()
            val doc = constr.parse(xml)

            //creación de etiquetas para su uso en nuestro XML
            val nombEmp = doc.createElement("nombEmp")
            val apeEmp = doc.createElement("apeEmp")
            val nEmp = doc.createElement("nEmp")
            val salBase = doc.createElement("salBase")
            val hsTrab = doc.createElement("hsTrab")
            val deducc = doc.createElement("deducc")
            val fechPag = doc.createElement("fechPag")

            //lista de atributos creados anteriormente, utilizados para iterar en ellos
            val listaAtrib = listOf(nombEmp, apeEmp, nEmp, salBase, hsTrab, deducc, fechPag)

            for (i in listaNominas.indices) {
                //Etiquetas de nuestro file que hacen referencia al objeto Modelo.Nomina()
                val nominaElm = doc.createElement("nomina")
                doc.documentElement.appendChild(nominaElm)

                //Bucle que itera en nuestros atributos y los crea y añade a su etiqueta nomina correspondiente
                for (j in listaAtrib.indices) {
                    val atributo = doc.createElement(listaAtrib[j].tagName)
                    nominaElm.appendChild(atributo)

                    //bucle que utilizaremos para asignar los textcontent, dependiento del tagName que recibamos
                    when (atributo.tagName) {
                        "nombEmp" -> atributo.textContent = listaNominas[i].nombEmp
                        "apeEmp" -> atributo.textContent = listaNominas[i].apeEmp
                        "nEmp" -> atributo.textContent = listaNominas[i].nEmp.toString()
                        "salBase" -> atributo.textContent = listaNominas[i].salBase.toString()
                        "hsTrab" -> atributo.textContent = listaNominas[i].hsTrab.toString()
                        "deducc" -> atributo.textContent = listaNominas[i].deducc.toString()
                        "fechPag" -> atributo.textContent = listaNominas[i].fechPag
                    }
                }
            }
            guardarDocumentoXML(doc, "Modelo.Nomina.xml")
        }
    }
}
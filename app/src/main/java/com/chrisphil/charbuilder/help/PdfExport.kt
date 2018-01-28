package com.chrisphil.charbuilder.help

import android.os.Environment
import com.chrisphil.charbuilder.Player
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream
import com.itextpdf.text.Paragraph




/**
 * Created by Christopher on 28.01.2018.
 */
class PdfExport {
    companion object {

        @Throws(DocumentException::class)
        fun exportPlayerPdf(exportPlayer: Player) {
            val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val file = File(dir, exportPlayer.name)

            try {
                val document = Document()
                PdfWriter.getInstance(document, FileOutputStream(file))
                document.open()

                // Left
                var leftParagraph = Paragraph("Spezies")
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                leftParagraph = Paragraph("Beruf")
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                leftParagraph = Paragraph("Spezialisierung")
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                // Center
                var centerParagraph = Paragraph(exportPlayer.species)
                centerParagraph.alignment = Element.ALIGN_CENTER
                document.add(centerParagraph)

                centerParagraph = Paragraph(exportPlayer.career)
                centerParagraph.alignment = Element.ALIGN_CENTER
                document.add(centerParagraph)

                centerParagraph = Paragraph(exportPlayer.specialization)
                centerParagraph.alignment = Element.ALIGN_CENTER
                document.add(centerParagraph)

                document.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
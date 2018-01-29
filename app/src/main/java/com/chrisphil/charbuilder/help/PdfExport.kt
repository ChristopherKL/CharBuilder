package com.chrisphil.charbuilder.help

import android.os.Environment
import com.chrisphil.charbuilder.Player
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.Chunk
import com.itextpdf.text.pdf.draw.VerticalPositionMark

/**
 * Created by Christopher on 28.01.2018.
 */
class PdfExport {
    companion object {

        private val boldFont = Font(Font.FontFamily.TIMES_ROMAN, 12f, Font.BOLD)
        private val normalFont = Font(Font.FontFamily.TIMES_ROMAN, 12f, Font.NORMAL)

        @Throws(DocumentException::class)
        fun exportPlayerPdf(exportPlayer: Player) {
            val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val file = File(dir, exportPlayer.name + ".pdf")

            try {
                val document = Document()
                PdfWriter.getInstance(document, FileOutputStream(file))
                document.open()

                // Left
                var leftParagraph = Paragraph("Name: " + exportPlayer.name)
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                leftParagraph = Paragraph("Spezies: " + exportPlayer.species)
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                leftParagraph = Paragraph("Beruf: " + exportPlayer.career)
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                leftParagraph = Paragraph("Spezialisierung: " + exportPlayer.specialization)
                leftParagraph.alignment = Element.ALIGN_LEFT
                document.add(leftParagraph)

                val glue = Chunk(VerticalPositionMark())
                val p = Paragraph()
                p.add(Chunk(glue))
                document.add(p)
                var table = PdfPTable(4)
                table.widthPercentage = 100f

                table.addCell(getCell("Erste Pflicht: ", boldFont))
                table.addCell(getCell(exportPlayer.obligation, normalFont))
                table.addCell(getCell("Zweite Pflicht: ", boldFont))
                table.addCell(getCell(exportPlayer.obligation2, normalFont))
                table.addCell(getCell("Erste Motivation: ", boldFont))
                table.addCell(getCell(exportPlayer.motivation, normalFont))
                table.addCell(getCell("Zweite Motivation: ", boldFont))
                table.addCell(getCell(exportPlayer.motivation2, normalFont))
                document.add(table)

                table = PdfPTable(6)
                table.widthPercentage = 100f

                document.add(p)
                table.addCell(getCell("Stärke: ", boldFont))
                table.addCell(getCell(exportPlayer.brawn.toString(), normalFont))
                table.addCell(getCell("List: ", boldFont))
                table.addCell(getCell(exportPlayer.cunning.toString(), normalFont))
                table.addCell(getCell("Wundschwelle: ", boldFont))
                table.addCell(getCell(exportPlayer.woundThreshold.toString(), normalFont))
                table.addCell(getCell("Gewandheit: ", boldFont))
                table.addCell(getCell(exportPlayer.agility.toString(), normalFont))
                table.addCell(getCell("Willenskraft: ", boldFont))
                table.addCell(getCell(exportPlayer.willpower.toString(), normalFont))
                table.addCell(getCell("Erschöpfung: ", boldFont))
                table.addCell(getCell(exportPlayer.strainThreshold.toString(), normalFont))
                table.addCell(getCell("Intelligenz: ", boldFont))
                table.addCell(getCell(exportPlayer.intellect.toString(), normalFont))
                table.addCell(getCell("Charisma: ", boldFont))
                table.addCell(getCell(exportPlayer.presence.toString(), normalFont))
                table.addCell(getCell("Absorption: ", boldFont))
                table.addCell(getCell(exportPlayer.soakValue.toString(), normalFont))
                document.add(table)

                table = PdfPTable(6)
                table.widthPercentage = 100f

                document.add(p)
                table.addCell(getCell("Geschlecht: ", boldFont))
                table.addCell(getCell(exportPlayer.gender, normalFont))
                table.addCell(getCell("Höhe: ", boldFont))
                table.addCell(getCell(exportPlayer.height.toString(), normalFont))
                table.addCell(getCell("Augenfarbe: ", boldFont))
                table.addCell(getCell(exportPlayer.eyecolor, normalFont))
                table.addCell(getCell("Geburtstag: ", boldFont))
                table.addCell(getCell(exportPlayer.birthday, normalFont))
                table.addCell(getCell("Gewicht: ", boldFont))
                table.addCell(getCell(exportPlayer.weight.toString(), normalFont))
                table.addCell(getCell("Hautfarbe: ", boldFont))
                table.addCell(getCell(exportPlayer.skincolor, normalFont))
                table.addCell(getCell("Alter: ", boldFont))
                table.addCell(getCell(exportPlayer.age.toString(), normalFont))
                table.addCell(getCell("Haarfarbe: ", boldFont))
                table.addCell(getCell(exportPlayer.haircolor, normalFont))
                table.addCell(getCell("Merkmale: ", boldFont))
                table.addCell(getCell(exportPlayer.features, normalFont))
                document.add(table)

                document.add(p)
                document.add(Paragraph("Waffen:"))

                table = PdfPTable(2)
                table.widthPercentage = 100f
                table.addCell(getCell(exportPlayer.weapons[0], normalFont))
                table.addCell(getCell(exportPlayer.weaponDamage[0], normalFont))
                table.addCell(getCell(exportPlayer.weapons[1], normalFont))
                table.addCell(getCell(exportPlayer.weaponDamage[1], normalFont))
                table.addCell(getCell(exportPlayer.weapons[2], normalFont))
                table.addCell(getCell(exportPlayer.weaponDamage[2], normalFont))
                document.add(table)

                document.add(p)
                document.add(Paragraph("Ausrüstung:"))

                table = PdfPTable(2)
                table.widthPercentage = 100f
                table.addCell(getCell(exportPlayer.items[0], normalFont))
                table.addCell(getCell(exportPlayer.itemAnnotations[0], normalFont))
                table.addCell(getCell(exportPlayer.items[1], normalFont))
                table.addCell(getCell(exportPlayer.itemAnnotations[1], normalFont))
                table.addCell(getCell(exportPlayer.items[2], normalFont))
                table.addCell(getCell(exportPlayer.itemAnnotations[2], normalFont))
                table.addCell(getCell(exportPlayer.items[2], normalFont))
                table.addCell(getCell(exportPlayer.itemAnnotations[2], normalFont))
                table.addCell(getCell(exportPlayer.items[3], normalFont))
                table.addCell(getCell(exportPlayer.itemAnnotations[3], normalFont))
                table.addCell(getCell(exportPlayer.items[4], normalFont))
                table.addCell(getCell(exportPlayer.itemAnnotations[4], normalFont))
                document.add(table)

                document.add(p)
                document.add(Paragraph("Credits:   " + exportPlayer.credits.toString()))

                document.add(p)
                document.add(Paragraph("Skills:"))

                table = PdfPTable(2)
                table.widthPercentage = 100f
                table.addCell(getCell("Name", normalFont))
                table.addCell(getCell("Beschreibung", normalFont))
                for(i in exportPlayer.skills){
                    table.addCell(getCell(i.name, normalFont))
                    table.addCell(getCell(i.description, normalFont))
                }
                document.add(table)

                document.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        private fun getCell(text : String, font : Font) : PdfPCell {
            val cell = PdfPCell(Phrase(text, font))
            cell.setPadding(0f)
            cell.border = PdfPCell.NO_BORDER
            return cell
        }
    }
}